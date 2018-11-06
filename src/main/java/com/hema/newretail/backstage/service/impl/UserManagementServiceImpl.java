package com.hema.newretail.backstage.service.impl;

import com.hema.newretail.backstage.common.mongodbpage.MongoDBPageModel;
import com.hema.newretail.backstage.common.mongodbpage.SpringbootMongoDBPageable;
import com.hema.newretail.backstage.common.utils.Response;
import com.hema.newretail.backstage.entry.usermanger.UserManagementData;
import com.hema.newretail.backstage.common.queryparam.usermanagementparameter.UserManaCondition;
import com.hema.newretail.backstage.service.IUserManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Auther: 程文政
 * @Date: 2018/8/21 15:39
 * @Description: 用户管理 Service实现类
 * @Version: 1.0
 */
@Service
public class UserManagementServiceImpl implements IUserManagementService {

    @Autowired
    private MongoTemplate mongoTemplate;

    private static final Double WEEKRENTAL = 2000.0;//默认终止金额
    private static final Double PREWEEKRENTAL = 0.0;//默认初始金额
    private static final String FROZEN = "1";//默认冻结状态码
    private static final String UNFREEZE = "0";//默认解冻状态码
    SimpleDateFormat sdf =   new SimpleDateFormat( "yyyy-MM-dd" );
    /**
     *
     * 功能描述: 分页数据展示
     *
     * @param: 分页信息 条件信息
     * @return: 分页数据展示
     * @auther: cwz
     * @date: 2018/8/22 13:46
     */
    @Override
    public Response paginationQuery(UserManaCondition userManaCondition)  throws Exception{
        SpringbootMongoDBPageable pageable = new SpringbootMongoDBPageable();
        MongoDBPageModel pm=new MongoDBPageModel();
        pm.setPagenumber(userManaCondition.getPageNum());
        pm.setPagesize(userManaCondition.getPageSize());
        List<Order> orders = new ArrayList<>();  //排序
        orders.add(new Order(Direction.DESC, "age"));
        Sort sort = new Sort(orders);
        pm.setSort(sort);
        pageable.setPage(pm);
        //开始拼装查询数据
        Query query = assembleQueryData(userManaCondition);
        //查询总条数 total
        Long count = mongoTemplate.count(query, UserManagementData.class);

        List<UserManagementData> list = mongoTemplate.find(query.with(pageable), UserManagementData.class);
        return Response.success(list,count,userManaCondition.getPageSize(),userManaCondition.getPageNum());
    }
    /**
     *
     * 功能描述:批量冻结
     *
     * @param: ids
     * @return: success
     * @auther: cwz
     * @date: 2018/8/22 16:59
     */
    @Override
    public Response batchFreeze(String ids) {
        List<String> idList = Arrays.asList(ids.split(","));
        String[] strs1=idList.toArray(new String[idList.size()]);
        Update update = new Update();
        Query query = new Query(Criteria.where("id").in(strs1));
        update.set("status",FROZEN);
        mongoTemplate.updateMulti(query, update, UserManagementData.class);
        return Response.success();
    }
    /**
     *
     * 功能描述:批量解冻
     *
     * @param: ids
     * @return: success
     * @auther: cwz
     * @date: 2018/8/22 16:59
     */
    @Override
    public Response batchRelease(String ids) {
        List<String> idList = Arrays.asList(ids.split(","));
        String[] strs1=idList.toArray(new String[idList.size()]);
            Update update = new Update();
            Query query = new Query(Criteria.where("id").in(strs1));
            update.set("status",UNFREEZE);
            mongoTemplate.updateMulti(query, update, UserManagementData.class);
        return Response.success();
    }

    /**
     *
     * 功能描述: 查询条件拼接----------------辅助方法
     *
     * @param: CentralBillListCondition
     * @return: Query
     * @auther: cwz
     * @date: 2018/8/27 11:48
     */
    private Query assembleQueryData(UserManaCondition userManaCondition)throws Exception{
        Query query = new Query();
        //开始拼装查询数据
        //判断标签是否为空
        if(userManaCondition.getTag() != null && !"".equals(userManaCondition.getTag())){
            //门户查询   标签查询
            query.addCriteria(Criteria.where("tag").regex(userManaCondition.getTag()));
        }
        //判断昵称是否为空String str = "";
        if(userManaCondition.getNickname() != null && !"".equals(userManaCondition.getNickname())){
            boolean isNum = userManaCondition.getNickname().matches("[0-9]+");
            if(isNum == true){
                query.addCriteria(Criteria.where("phoneNumber").is(userManaCondition.getNickname()));
            }else{
                query.addCriteria(Criteria.where("nickname").is(userManaCondition.getNickname()));
            }
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
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.DATE, -30);
            query.addCriteria(Criteria.where("registrationDate").gte(calendar.getTime()).lte(date));
        }
        //后为空
        if(userManaCondition.getPreRegistrationDate()!=null && userManaCondition.getRegistrationDate()==null){
            Date preDate = sdf.parse(userManaCondition.getPreRegistrationDate());
            //注册时间查询
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(preDate);
            calendar.add(Calendar.DATE, 30);
            query.addCriteria(Criteria.where("registrationDate").gte(preDate).lte(calendar.getTime()));
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
        if(userManaCondition.getStatus()!=null && !"".equals(userManaCondition.getStatus())){
            //状态查询
            query.addCriteria(Criteria.where("status").is(userManaCondition.getStatus()));
        }
        return query;
    }

}
