package com.hema.newretail.backstage.service.impl;

import com.hema.newretail.backstage.common.mongodbpage.MongoDBPageModel;
import com.hema.newretail.backstage.common.mongodbpage.SpringbootMongoDBPageable;
import com.hema.newretail.backstage.common.queryparam.usermanagementparameter.UserManaCondition;
import com.hema.newretail.backstage.common.utils.Response;
import com.hema.newretail.backstage.entry.UserManagerData;
import com.hema.newretail.backstage.entry.orderentry.BillData;
import com.hema.newretail.backstage.entry.OrderData;
import com.hema.newretail.backstage.service.IUserManagerService;
import com.mongodb.WriteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 用户管理消息推送和会员详情等接口实现类
 */
@Service("userManagerService")
public class UserManagerServiceImpl  implements IUserManagerService {

    @Autowired
    private MongoTemplate mongoTemplate;

    private final Double WEEKRENTAL = 2000.0;//默认终止金额
    private final Double PREWEEKRENTAL = 0.0;//默认初始金额
    private static final String ZERO = "0";
    private SimpleDateFormat sdf =   new SimpleDateFormat( "yyyy-MM-dd" );

    /**
     * 根据用户记录id获取该用户的详情信息
     * @param id
     * @return
     */
    @Override
    public UserManagerData queryOneById(String id) {
        UserManagerData data = mongoTemplate.findById(id, UserManagerData.class,"userManagementData");
        if(data!=null){
            String tag = data.getTag();
            List<String> tags = new ArrayList<String>();
            String[] tagArr = tag.split(",");
            tags = Arrays.asList(tagArr);
            data.setTags(tags);
        }
        return data;
    }

    /**
     * 根据用户openId获取用户消费记录
     * @param paramperters{openId:String,pageNum:int,pageSize:int}都是必填项
     * @return
     */
    @Override
    public Response getUserConsumptionsByOpenId(Map<String,Object> paramperters) {
        List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();

        SpringbootMongoDBPageable pageable = new SpringbootMongoDBPageable();
        MongoDBPageModel pm=new MongoDBPageModel();

        String openId = paramperters.get("openId").toString();
        int pageSize = (int)paramperters.get("pageSize");
        int pageNum = (int)paramperters.get("pageNum");

        pm.setPagenumber(pageNum);
        pm.setPagesize(pageSize);

        Sort sort = new Sort(Sort.Direction.ASC,"billTime");
        pm.setSort(sort);

        pageable.setPage(pm);

        Criteria criteria = Criteria.where("openId").is(openId);
        Query query = Query.query(criteria);
        long total = mongoTemplate.count(query,"billData");
        query.with(sort);
        query.skip(pageSize*(pageNum-1));
        query.limit(pageSize);
        List<BillData> bills = mongoTemplate.find(query,BillData.class,"billData");
        for (BillData bill:bills){
            Map<String,Object> billMap = new HashMap<String, Object>(5);
            billMap.put("billId",bill.getId());
            billMap.put("billTime",bill.getBillTimeStr());
            billMap.put("billMoney",bill.getAmt());
            billMap.put("billPayType",bill.getPaymentType());

            List<String> orderIds = bill.getOrders();
            StringBuilder strB = new StringBuilder();
            for (String orderId:orderIds){
                OrderData order= mongoTemplate.findById(orderId, OrderData.class,"ordersData");
                if(order!=null) {
                    strB.append(order.getMenuName()).append("*").append(order.getNum());
                }
            }
            billMap.put("orderDetail",strB.toString());
            data.add(billMap);
        }

        return Response.success(data,total,pageSize,pageNum);
    }

    /**
     * 修改用户账号状态
     * @param id
     * @return
     */
    @Override
    public boolean updateStatusById(String id) {
        UserManagerData user = mongoTemplate.findById(id,UserManagerData.class,"userManagementData");
        String status = "";
        Query query = new Query(Criteria.where("_id").is(id));
        Update update = new Update();
        WriteResult result = null;
        if (user.getStatus()!=null){
            status = user.getStatus();
            if (ZERO.equals(status)){
                status = "1";
            }else{
                status = "0";
            }
            update.set("status",status);
            result = mongoTemplate.updateFirst(query,update,"userManagementData");
        }else {
            status = "1";
            update.set("status",status);
            result = mongoTemplate.upsert(query,update,"userManagementData");
        }

        if(result.getN()>0){
            return true;
        }else{
            return false;
        }
    }

    /**
     * 获取导出Excel的数据
     * @param userManaCondition
     * @return
     */
    @Override
    public List<UserManagerData> findAll(UserManaCondition userManaCondition) {
        List<UserManagerData> list = new ArrayList<>();
        try {

            //开始拼装查询数据
            Query query = assembleQueryData(userManaCondition);

            list = mongoTemplate.find(query, UserManagerData.class,"userManagementData");

        }catch (Exception e){
            e.printStackTrace();
        }
        return  list;
    }

    /**
     *
     * 功能描述: 查询条件拼接----------------辅助方法
     *
     * @param: CentralBillListCondition
     */
    private Query assembleQueryData(UserManaCondition userManaCondition)throws Exception{
        Query query = new Query();
        //开始拼装查询数据
        //判断标签是否为空
        if(userManaCondition.getTag() != null){
            //门户查询   标签查询
            query.addCriteria(Criteria.where("tag").regex(userManaCondition.getTag()));
        }
        //判断昵称是否为空
        if(userManaCondition.getNickname() != null){
            //昵称  电话查询
            query.addCriteria(Criteria.where("nickname").is(userManaCondition.getNickname()));
        }
        if(userManaCondition.getNickname() != null){
            //昵称  电话查询
            query.addCriteria(Criteria.where("phoneNumber").is(userManaCondition.getPhoneNumber()));
        }

        //判断本周消费金额区间
        //初始终止存在
        if(userManaCondition.getPreWeekRental() != null && userManaCondition.getWeekRental() != null){
            //金额查询
            query.addCriteria(Criteria.where("weekRental").
                    gte(userManaCondition.getPreWeekRental()).lte(userManaCondition.getWeekRental()));
        }
        //初始存在
        if(userManaCondition.getPreWeekRental() != null && userManaCondition.getWeekRental() == null){
            //金额查询
            query.addCriteria(Criteria.where("weekRental").
                    gte(userManaCondition.getPreWeekRental()).lte(WEEKRENTAL));
        }
        //终止存在
        if(userManaCondition.getPreWeekRental() == null && userManaCondition.getWeekRental() != null){
            //金额查询
            query.addCriteria(Criteria.where("weekRental").
                    gte(PREWEEKRENTAL).lte(userManaCondition.getWeekRental()));
        }
        //判断注册时间区间
        //前后都不为空
        if(userManaCondition.getPreRegistrationDate()!=null && userManaCondition.getRegistrationDate()!=null){
            Date preDate = sdf.parse(userManaCondition.getPreRegistrationDate());
            Date date = sdf.parse(userManaCondition.getRegistrationDate());
            //注册时间查询
            query.addCriteria(Criteria.where("registrationDate").gte(preDate).lte(date));
        }
        //前为空
        if(userManaCondition.getPreRegistrationDate()==null && userManaCondition.getRegistrationDate()!=null){
            Date date = sdf.parse(userManaCondition.getRegistrationDate());
            //注册时间查询
            query.addCriteria(Criteria.where("registrationDate").gte(new Date(date.getTime()+30*3600*24*1000)).lte(date));
        }
        //后为空
        if(userManaCondition.getPreRegistrationDate()!=null && userManaCondition.getRegistrationDate()==null){
            Date preDate = sdf.parse(userManaCondition.getPreRegistrationDate());
            //注册时间查询
            query.addCriteria(Criteria.where("registrationDate").gte(preDate).lte(new Date(preDate.getTime()-30*3600*24*1000)));
        }
        //判断省市区
        if(userManaCondition.getProvince()!=null){
            //省查询
            query.addCriteria(Criteria.where("province").is(userManaCondition.getProvince()));
            if(userManaCondition.getCity()!=null){
                //市查询
                query.addCriteria(Criteria.where("city").is(userManaCondition.getCity()));
                if(userManaCondition.getArea()!=null){
                    //区查询
                    query.addCriteria(Criteria.where("area").is(userManaCondition.getArea()));
                }
            }
        }
        //状态判断查询
        if(userManaCondition.getStatus()!=null){
            //状态查询
            query.addCriteria(Criteria.where("status").is(userManaCondition.getStatus()));
        }
        return query;
    }


}
