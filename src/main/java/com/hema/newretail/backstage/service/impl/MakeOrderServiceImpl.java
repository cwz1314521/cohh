package com.hema.newretail.backstage.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hema.newretail.backstage.common.mongodbpage.MongoDBPageModel;
import com.hema.newretail.backstage.common.mongodbpage.SpringbootMongoDBPageable;
import com.hema.newretail.backstage.common.utils.BillExcelUtils;
import com.hema.newretail.backstage.common.utils.Response;
import com.hema.newretail.backstage.dao.AgentUserMapper;
import com.hema.newretail.backstage.dao.BaseMachineInfoMapper;
import com.hema.newretail.backstage.dao.GridCompanyMapper;
import com.hema.newretail.backstage.entry.BaseMachineInfoEntry;
import com.hema.newretail.backstage.entry.grid.GridCompanyEntry;
import com.hema.newretail.backstage.entry.agent.AgentUserEntry;
import com.hema.newretail.backstage.entry.orderentry.*;
import com.hema.newretail.backstage.model.billdetailmodel.BillDataBo;
import com.hema.newretail.backstage.model.billdetailmodel.OrdersDataBo;
import com.hema.newretail.backstage.common.queryparam.usermanagementparameter.CentralBillListCondition;
import com.hema.newretail.backstage.common.queryparam.usermanagementparameter.MakeOrderCondition;
import com.hema.newretail.backstage.service.IMakeOrderService;
import com.mongodb.BasicDBObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.aggregation.LookupOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @auther: 程文政
 * @Date: 2018/8/23 11:55
 * @Description:
 * @Version: 1.0
 */
@Service
public class MakeOrderServiceImpl implements IMakeOrderService {

    @Value(value = "${excelModel.orderSrcFileName}")
    private String orderSrcFileName;

    @Autowired
    private AgentUserMapper agentUserMapper;

    @Autowired
    private GridCompanyMapper gridCompanyMapper;

    @Autowired
    private BaseMachineInfoMapper baseMachineInfoMapper;

    @Autowired
    private MongoTemplate mongoTemplate;
    private static final String EMPTY = "";
    private static final String WEEKRENTAL = "500";//默认终止金额
    private static final String PREWEEKRENTAL = "1";//默认初始金额
    private static final Integer MINLENGTH = 2;//拼装字符串最小长度

    SimpleDateFormat sdf =   new SimpleDateFormat( "yyyy-MM-dd" );
    SimpleDateFormat sdf1 =   new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
    SimpleDateFormat sdf2 =   new SimpleDateFormat( "yyyy-MM-dd HH:mm" );

    @Override
    public Response gridCompany() {
        List<GridCompanyEntry> list = gridCompanyMapper.selectAll();
        return Response.success(list);
    }

    @Override
    public Response agentCompany() {
        List<AgentUserEntry> list = agentUserMapper.selectAll();
        return Response.success(list);
    }

    @Override
    public Response pageOrders(MakeOrderCondition makeOrderCondition) throws Exception{
        makeOrderCondition = pageOrdersCondition(makeOrderCondition);
        SpringbootMongoDBPageable pageable = new SpringbootMongoDBPageable();
        MongoDBPageModel pm=new MongoDBPageModel();
        pm.setPagenumber(makeOrderCondition.getPageNum());
        pm.setPagesize(makeOrderCondition.getPageSize());
        List<Order> orders = new ArrayList<>();  //排序
        orders.add(new Order(Direction.DESC, "age"));
        Sort sort = new Sort(orders);
        pm.setSort(sort);
        pageable.setPage(pm);
        Query query = new Query();
        //开始拼装查询数据
        //判断id是否为空
        if(makeOrderCondition.getId() != null){
            query.addCriteria(Criteria.where("id").is(makeOrderCondition.getId()));//id查询 订单号
        }
        //判断机器编号是否为空
        if(makeOrderCondition.getDeviceNumber() != null){
            query.addCriteria(Criteria.where("deviceNumber").is(makeOrderCondition.getDeviceNumber()));//机器编号查询
        }
        //判断代理是否为空
        if(makeOrderCondition.getAgent() != null){
            query.addCriteria(Criteria.where("agent").is(makeOrderCondition.getAgent()));//机器编号查询
        }
        //判断网格是否为空
        if(makeOrderCondition.getGrid() != null){
            query.addCriteria(Criteria.where("grid").is(makeOrderCondition.getGrid()));//机器编号查询
        }
        //判断制作时间区间
        //前后都不为空
        if(makeOrderCondition.getPreOrderTime()!=null && makeOrderCondition.getOrderTime()!=null){
            Date preDate = sdf.parse(makeOrderCondition.getPreOrderTime());
            Date date = sdf.parse(makeOrderCondition.getOrderTime());
            query.addCriteria(Criteria.where("productionTime").gte(preDate).lte(date));//制作时间查询
        }
        //前为空
        if(makeOrderCondition.getPreOrderTime()==null && makeOrderCondition.getOrderTime()!=null){
            Date date = sdf.parse(makeOrderCondition.getOrderTime());
            query.addCriteria(Criteria.where("productionTime").gte(new Date(date.getTime()+30*3600*24*1000)).lte(date));//制作时间查询
        }
        //后为空
        if(makeOrderCondition.getPreOrderTime()!=null && makeOrderCondition.getOrderTime()==null){
            Date preDate = sdf.parse(makeOrderCondition.getPreOrderTime());
            query.addCriteria(Criteria.where("productionTime").gte(preDate).lte(new Date(preDate.getTime()-30*3600*24*1000)));//制作时间查询
        }
        //判断省市区
        if(makeOrderCondition.getProvince()!=null){
             query.addCriteria(Criteria.where("province").is(makeOrderCondition.getProvince())); // 省查询
            if(makeOrderCondition.getCity()!=null){
                 query.addCriteria(Criteria.where("city").is(makeOrderCondition.getCity()));  //// 市查询
                if(makeOrderCondition.getArea()!=null){
                     query.addCriteria(Criteria.where("area").is(makeOrderCondition.getArea())); // 区查询
                }
            }
        }
        //状态判断查询
        if(makeOrderCondition.getOrderStatus()!=null){
            query.addCriteria(Criteria.where("orderStatus").is(makeOrderCondition.getOrderStatus()));//状态查询
        }
        //查询总条数 total
        Long count = mongoTemplate.count(query, OrdersData.class);
        System.out.println(count);
        List<OrdersData> list = mongoTemplate.find(query.with(pageable), OrdersData.class);
        List<OrdersDataBo> lists = new ArrayList<>();
        for (OrdersData o :list
                ) {
            OrdersDataBo ordersDataBo = orderDetailUtil(o.getId());
            lists.add(ordersDataBo);
        }
        return Response.success(lists,count,makeOrderCondition.getPageSize(),makeOrderCondition.getPageNum());
    }

    @Override
    public Response orderDetail(String id) {
        //调用公共方法orderDetailUtil
        return Response.success(orderDetailUtil(id));
    }

    @Override
    public Response billDetail(String id) {
        //查询bill表
        Query query = new Query(Criteria.where("id").is(id));
        BillData billData = mongoTemplate.findOne(query,BillData.class);
        //查询user表
        //返回---对象创建
        BillDataBo bo  = new BillDataBo();
        //返回---二级对象创建
        List<OrdersDataBo> ordersDataBos = new ArrayList<>();
        //拼装返回值
        bo.setId(billData.getId());//订单编号
        bo.setTotalMoney(billData.getAmt().add(billData.getDiscount()));//订单总价=实收+优惠
        bo.setTotalNum(billData.getTotalNum());//总数
        bo.setBillTime(sdf1.format(billData.getBillTime()));//订单时间
        bo.setPaymentType(billData.getPaymentType());//支付方式（支付回调修改），001微信、002支付宝、默认000
        bo.setPaySerialNumbers(billData.getPaySerialNumbers());//支付流水号（支付回调修改）
        bo.setPaymentStatus(billData.getPaymentStatus());//支付状态 默认：000， 成功：001
        bo.setBillStatus(billData.getBillStatus());//账单状态：默认（001）未付款、002已付款、003退款中，004退款成功
        bo.setUserName(billData.getNickName());//购买用户
        bo.setTel(billData.getPhoneNumber());//手机号
        bo.setRemark(billData.getRemark());
        List<String> orders = billData.getOrders();
        for (String orderid:orders
             ) {
            OrdersDataBo ordersData = orderDetailUtil(orderid);
            ordersDataBos.add(ordersData);
        }

        bo.setList(ordersDataBos);

        return Response.success(bo);

    }

    @Override
    public Response saveRemark(String id, String remark) {
        Update update = new Update();
        Query query = new Query(Criteria.where("id").is(id));
        update.set("remarks",remark);
        mongoTemplate.updateFirst(query, update, BillData.class);
        return Response.success();
    }
    @Override
    public Response saveOrderRemark(String id, String remark) {
        Update update = new Update();
        Query query = new Query(Criteria.where("id").is(id));
        update.set("remarks",remark);
        mongoTemplate.updateFirst(query, update, OrdersData.class);
        return Response.success();
    }
    /**
     *
     * 功能描述: 拼装返回数据
     *
     * @param:
     * @return:
     * @auther: cwz
     * @date: 2018/8/31 9:01
     */
    private OrdersDataBo orderDetailUtil(String id){
        Query query = new Query(Criteria.where("id").is(id));
        OrdersData ordersData = mongoTemplate.findOne(query,OrdersData.class);
        OrdersDataBo ordersDataBo = new OrdersDataBo();
        if(ordersData.getMachineId() != null){
            BaseMachineInfoEntry baseMachineInfoEntry = baseMachineInfoMapper.
                    selectByPrimaryKey(ordersData.getMachineId());
            if(baseMachineInfoEntry != null) {
                ordersDataBo.setDeviceLocation(baseMachineInfoEntry.getProvince() + baseMachineInfoEntry.getCity() +
                        baseMachineInfoEntry.getArea() + baseMachineInfoEntry.getStreet());
            }
        }
        ordersDataBo.setOrderStatus(ordersData.getOrderStatus());
        ordersDataBo.setRemark(ordersData.getRemarks());
        ordersDataBo.setMenuName(ordersData.getMenuName());
        ordersDataBo.setId(ordersData.getId());
        ordersDataBo.setDeviceNumber(ordersData.getDeviceNumber());
        ordersDataBo.setAgent(ordersData.getAgent());
        ordersDataBo.setGrid(ordersData.getGrid());
        ordersDataBo.setProductionTime(ordersData.getOrderTime());
        ordersDataBo.setWaterTemperature(ordersData.getWaterTemperature());
        ordersDataBo.setMoney(ordersData.getAmt());
        ordersDataBo.setBillId(ordersData.getBillId());
        StringBuilder prope = new StringBuilder();
        if (ordersData.getProperties()!=null){
            for (Properties properties:ordersData.getProperties()) {
                prope.append("加").append(properties.getProName()).append(properties.getTypeName()).append(",");
            }
        }
        if(prope.length()>MINLENGTH){
            prope.substring(0,prope.length()-1);
        }
        ordersDataBo.setOptions(prope.toString());
        return ordersDataBo;
    }

    @Override
    public Response centralBillList(CentralBillListCondition centralBillListCondition) throws Exception{
        centralBillListCondition = centralBillListCondition(centralBillListCondition);
        //拼装分页信息
        SpringbootMongoDBPageable pageable = new SpringbootMongoDBPageable();
        MongoDBPageModel pm=new MongoDBPageModel();
        pm.setPagesize(centralBillListCondition.getPageSize());
        pm.setPagenumber(centralBillListCondition.getPageNum());
        //排序规则
        List<Order> orders = new ArrayList<>();
        orders.add(new Order(Direction.DESC, "billTime"));
        Sort sort = new Sort(orders);
        pm.setSort(sort);
        pageable.setPage(pm);

        //拼装关联信息
        LookupOperation lookupOperation = LookupOperation.newLookup().
                from("ordersData").
                localField("_id").
                foreignField("billId").
                as("orders111");
        //拼装具体查询信息
        Criteria order = Criteria.where("orders111").not().size(0);
        order = orderQueryData(order,centralBillListCondition);
        AggregationOperation match = Aggregation.match(order);

        Criteria bill= new Criteria();
        bill = billQueryData(bill,centralBillListCondition);

        AggregationOperation prematch = Aggregation.match(bill);
        //查询
        Aggregation aggregation = Aggregation.newAggregation(prematch,lookupOperation,match,
                //排序
                Aggregation.sort(pageable.getSort()),
                //pagenumber
                Aggregation.skip(pageable.getPageNumber()>1?(pageable.getPageNumber()-1)*pageable.getPageSize():0),
                //pagesize
                Aggregation.limit(pageable.getPageSize()));
        //总条数查询
        Aggregation count = Aggregation.newAggregation(prematch,lookupOperation,match);
        List<BasicDBObject> results = mongoTemplate.aggregate(aggregation, "billData", BasicDBObject.class).getMappedResults();
        List<BasicDBObject> counts = mongoTemplate.aggregate(count, "billData", BasicDBObject.class).getMappedResults();
        return Response.success(results,(long) counts.size(),pageable.getPageSize(),pageable.getPageNumber());
    }

    /**
     *
     * 功能描述: 查询bill条件拼接----------------辅助方法
     *
     * @param: CentralBillListCondition
     * @return: Query
     * @auther: admin
     * @date: 2018/8/27 11:48
     */
    private Criteria billQueryData(Criteria bill,CentralBillListCondition centralBillListCondition)throws Exception{
        //开始拼装bill查询数据
        //判断id是否为空
        if(centralBillListCondition.getId() != null){
            //id查询 订单号
            bill.andOperator(Criteria.where("_id").regex(centralBillListCondition.getId()));
        }
        //判断支付流水号是否为空
        if(centralBillListCondition.getPaySerialNumbers() != null){
            //机器编号查询
            bill.andOperator(Criteria.where("paySerialNumbers").is(centralBillListCondition.getPaySerialNumbers()));
        }
        //判断消费金额区间
        //初始终止存在
        if(centralBillListCondition.getPreAmt() != null && centralBillListCondition.getAmt() != null){
            //金额查询
            bill.andOperator(Criteria.where("amt").
                    gte(centralBillListCondition.getPreAmt()).lte(centralBillListCondition.getAmt()));
        }
        //初始存在
        if(centralBillListCondition.getPreAmt() != null && centralBillListCondition.getAmt() == null){
            //金额查询
            bill.andOperator(Criteria.where("amt").
                    gte(centralBillListCondition.getPreAmt()).lte(WEEKRENTAL));
        }
        //终止存在
        if(centralBillListCondition.getPreAmt() == null && centralBillListCondition.getAmt() != null){
            //金额查询
            bill.andOperator(Criteria.where("amt").
                    gte(PREWEEKRENTAL).lte(centralBillListCondition.getAmt()));
        }
        //判断订单时间区间
        //前后都不为空
        if(centralBillListCondition.getPreBillTime()!=null && centralBillListCondition.getBillTime()!=null){
            Date preDate = sdf.parse(centralBillListCondition.getPreBillTime());
            Date date = sdf.parse(centralBillListCondition.getBillTime());
            //订单时间查询
            bill.andOperator(Criteria.where("billTime").gte(preDate).lte(date));
        }
        //前为空
        if(centralBillListCondition.getPreBillTime()==null && centralBillListCondition.getBillTime()!=null){
            Date date = sdf.parse(centralBillListCondition.getBillTime());
            //订单时间查询
            bill.andOperator(Criteria.where("billTime").gte(new Date(date.getTime()+30*3600*24*1000)).lte(date));
        }
        //后为空
        if(centralBillListCondition.getPreBillTime()!=null && centralBillListCondition.getBillTime()==null){
            Date preDate = sdf.parse(centralBillListCondition.getPreBillTime());
            //订单时间查询
            bill.andOperator(Criteria.where("billTime").gte(preDate).lte(new Date(preDate.getTime()-30*3600*24*1000)));
        }
        //判断用户是否为空
        if(centralBillListCondition.getNickName() != null){
            //机器编号查询
            bill.andOperator(Criteria.where("nickName").is(centralBillListCondition.getNickName()));
        }
        //判断手机号是否为空
        if(centralBillListCondition.getPhoneNumber() != null){
            bill.andOperator(Criteria.where("phoneNumber").is(centralBillListCondition.getPhoneNumber()));
        }
        //判断支付方式是否为空
        if(centralBillListCondition.getPaymentType() != null){
            bill.andOperator(Criteria.where("paymentType").is(centralBillListCondition.getPaymentType()));
        }
        //判断状态是否为空
        if(centralBillListCondition.getBillStatus() != null){
            bill.andOperator(Criteria.where("billStatus").is(centralBillListCondition.getBillStatus()));
        }
        return bill;
    }

    /**
     *
     * 功能描述: 查询order条件拼接----------------辅助方法
     *
     * @param: CentralBillListCondition
     * @return: Query
     * @auther: admin
     * @date: 2018/8/27 11:48
     */
    private Criteria orderQueryData(Criteria order,CentralBillListCondition centralBillListCondition)throws Exception{

        //判断机器编号是否为空
        if(centralBillListCondition.getDeviceNumber() != null){
            order.elemMatch(Criteria.where("deviceNumber").is(centralBillListCondition.getDeviceNumber()));
        }
        //判断代理是否为空
        if(centralBillListCondition.getAgent() != null){
            order.elemMatch(Criteria.where("agent").is(centralBillListCondition.getAgent()));
        }
        //判断网格是否为空
        if(centralBillListCondition.getGrid() != null){
            order.elemMatch(Criteria.where("grid").is(centralBillListCondition.getGrid()));
        }
        //判断省市区
        if(centralBillListCondition.getProvince()!=null){
            order.elemMatch(Criteria.where("province").is(centralBillListCondition.getProvince()));
            if(centralBillListCondition.getCity()!=null){
                order.elemMatch(Criteria.where("city").is(centralBillListCondition.getCity()));
                if(centralBillListCondition.getArea()!=null){
                    order.elemMatch(Criteria.where("area").is(centralBillListCondition.getArea()));
                }
            }
        }
        //状态判断查询
        if(centralBillListCondition.getOrderStatus()!=null){
            order.elemMatch(Criteria.where("orderStatus").is(centralBillListCondition.getOrderStatus()));
        }
        return order;
    }

    /**
     *
     * 功能描述:
     *
     * @param:
     * @return:
     * @auther: admin
     * @date: 2018/8/28 15:10
     */
    @Override
    public Response excle(HttpServletRequest request, HttpServletResponse response, CentralBillListCondition centralBillListCondition) throws   Exception{
//拼装关联信息
        LookupOperation lookupOperation = LookupOperation.newLookup().
                from("ordersData").
                localField("_id").
                foreignField("billId").
                as("orders111");
        //拼装具体查询信息
        Criteria order = Criteria.where("orders111").not().size(0);
        order = orderQueryData(order,centralBillListCondition);
        AggregationOperation match = Aggregation.match(order);
        Criteria bill= new Criteria();
        bill = billQueryData(bill,centralBillListCondition);
        AggregationOperation prematch = Aggregation.match(bill);
        //查询
        Aggregation count = Aggregation.newAggregation(prematch,lookupOperation,match);
        List<BasicDBObject> counts = mongoTemplate.aggregate(count, "billData", BasicDBObject.class).getMappedResults();
        List<OrderExcleEntry> orderExcleEntries = new ArrayList<>();
        for (BasicDBObject b :counts
                ) {
            OrderExcleEntry orderExcleEntry = new OrderExcleEntry();
            JSONObject jsonObject = new JSONObject(b);
            String status = "";
            String type = "";
            if("001".equals(jsonObject.get("billStatus").toString())){
                status = "未付款";
            }else if("002".equals(jsonObject.get("billStatus").toString())){
                status = "已付款";
            }else if("003".equals(jsonObject.get("billStatus").toString())){
                status = "退款中";
            }else{
                status = "退款成功";
            }
            if("001".equals(jsonObject.get("paymentType").toString())){
                type = "微信";
            }else if("002".equals(jsonObject.get("paymentType").toString())){
                type = "支付宝";
            }else{
                type = "未支付";
            }
            JSONArray array1 = jsonObject.getJSONArray("orders111");
            StringBuilder name = new StringBuilder();
            String isover = "";
            if (array1.size() > 0) {
                for (int i = 0; i < array1.size(); i++) {
                    JSONObject job = array1.getJSONObject(i);
                    name.append(job.get("menuName").toString()).append(",");
                    if("2".equals(job.get("orderStatus").toString())){
                        isover="出货异常";
                    }else {
                        isover="正常";
                    }

                    JSONArray array2 = job.getJSONArray("properties");
                    if (array2.size() > 0) {
                        for (int j = 0; j < array2.size(); j++) {
                            JSONObject jo = array2.getJSONObject(j);
                            String typeName;
                            if(jo.get("typeName") == null){
                                typeName = "";
                            }else {
                                typeName = jo.get("typeName").toString();
                            }

                            name.append(typeName).append(jo.get("proName").toString()).append(",");
                        }
                        name.substring(0,name.length()-1);
                    }
                }
                name.append(";/");
            }
            name.substring(0,name.length()-1);
            orderExcleEntry.setBillId(jsonObject.get("_id").toString());
            orderExcleEntry.setBillTime(sdf2.format((Date) jsonObject.get("billTime")));
            orderExcleEntry.setNickName(jsonObject.get("nickName").toString()+"/"+jsonObject.get("phoneNumber").toString());
            orderExcleEntry.setAmt(jsonObject.get("amt").toString());
            orderExcleEntry.setBillStatus(status);
            orderExcleEntry.setPaymentType(type);
            orderExcleEntry.setPaySerialNumbers(jsonObject.get("paySerialNumbers").toString());
            //remark 未添加jsonObject.get("paySerialNumbers").toString()
            orderExcleEntry.setRemark("");
            orderExcleEntry.setDetails(name.toString());
            orderExcleEntry.setClearStatus(isover);

            orderExcleEntries.add(orderExcleEntry);
        }

        response.setContentType("application/octet-stream");

        StringBuilder fileName = new StringBuilder();
        StringBuilder time = new StringBuilder();
        if(centralBillListCondition.getPreBillTime() != null ) {
            time.append("(").append(centralBillListCondition.getPreBillTime()).append("-").append(centralBillListCondition.getBillTime()).append(")");
            fileName.append("订单数据导出(").append(centralBillListCondition.getPreBillTime()).append("-").
                    append(centralBillListCondition.getBillTime()).append(").xlsx");
        }else {
            time.append("(").append(sdf1.format(new Date())).append(")");
            fileName.append("订单数据导出(").append(sdf1.format(new Date())).append(").xlsx");
        }
        response.setHeader("Content-Disposition", "attachment;filename="+ URLEncoder.encode(fileName.toString(), "utf-8"));
/**       response.setHeader("Content-Disposition", "attachment;filename="+ new String(fileName.toString().getBytes(),"iso-8859-1")+".xlsx");*/
        response.flushBuffer();
        BillExcelUtils.exportExcel(orderSrcFileName,orderExcleEntries,response.getOutputStream(),time.toString());



        return Response.success();
    }
    /**
     *
     * 功能描述: 参数调整 ""  转  null
     *
     * @param:
     * @return:
     * @author: cwz
     * @date: 2018/10/12 14:32
     */
    private MakeOrderCondition pageOrdersCondition(MakeOrderCondition makeOrderCondition){
       if(EMPTY.equals(makeOrderCondition.getOrderTime())){
           makeOrderCondition.setOrderTime(null);
       }
        if(EMPTY.equals(makeOrderCondition.getPreOrderTime())){
            makeOrderCondition.setPreOrderTime(null);
        }
        if(EMPTY.equals(makeOrderCondition.getAgent())){
            makeOrderCondition.setAgent(null);
        }
        if(EMPTY.equals(makeOrderCondition.getArea())){
            makeOrderCondition.setArea(null);
        }
        if(EMPTY.equals(makeOrderCondition.getCity())){
            makeOrderCondition.setCity(null);
        }
        if(EMPTY.equals(makeOrderCondition.getDeviceNumber())){
            makeOrderCondition.setDeviceNumber(null);
        }
        if(EMPTY.equals(makeOrderCondition.getGrid())){
            makeOrderCondition.setGrid(null);
        }
        if(EMPTY.equals(makeOrderCondition.getId())){
            makeOrderCondition.setId(null);
        }
        if(EMPTY.equals(makeOrderCondition.getOrderStatus())){
            makeOrderCondition.setOrderStatus(null);
        }
        if(EMPTY.equals(makeOrderCondition.getProvince())){
            makeOrderCondition.setProvince(null);
        }
        return makeOrderCondition;
    }

    /**
     *
     * 功能描述: 参数调整 ""  转  null
     *
     * @param:
     * @return:
     * @author: cwz
     * @date: 2018/10/12 14:32
     */
    private CentralBillListCondition centralBillListCondition(CentralBillListCondition centralBillListCondition){
        if(EMPTY.equals(centralBillListCondition.getPreBillTime())){
            centralBillListCondition.setPreBillTime(null);
        }
        if(EMPTY.equals(centralBillListCondition.getBillTime())){
            centralBillListCondition.setBillTime(null);
        }
        if(EMPTY.equals(centralBillListCondition.getAmt())){
            centralBillListCondition.setAmt(null);
        }
        if(EMPTY.equals(centralBillListCondition.getPreAmt())){
            centralBillListCondition.setPreAmt(null);
        }
        if(EMPTY.equals(centralBillListCondition.getAgent())){
            centralBillListCondition.setAgent(null);
        }
        if(EMPTY.equals(centralBillListCondition.getArea())){
            centralBillListCondition.setArea(null);
        }
        if(EMPTY.equals(centralBillListCondition.getBillStatus())){
            centralBillListCondition.setBillStatus(null);
        }
        if(EMPTY.equals(centralBillListCondition.getCity())){
            centralBillListCondition.setCity(null);
        }
        if(EMPTY.equals(centralBillListCondition.getDeviceNumber())){
            centralBillListCondition.setDeviceNumber(null);
        }
        if(EMPTY.equals(centralBillListCondition.getGrid())){
            centralBillListCondition.setGrid(null);
        }
        if(EMPTY.equals(centralBillListCondition.getId())){
            centralBillListCondition.setId(null);
        }
        if(EMPTY.equals(centralBillListCondition.getNickName())){
            centralBillListCondition.setNickName(null);
        }
        if(EMPTY.equals(centralBillListCondition.getOrderStatus())){
            centralBillListCondition.setOrderStatus(null);
        }
        if(EMPTY.equals(centralBillListCondition.getPaymentType())){
            centralBillListCondition.setPaymentType(null);
        }
        if(EMPTY.equals(centralBillListCondition.getPaySerialNumbers())){
            centralBillListCondition.setPaySerialNumbers(null);
        }
        if(EMPTY.equals(centralBillListCondition.getPhoneNumber())){
            centralBillListCondition.setPhoneNumber(null);
        }
        if(EMPTY.equals(centralBillListCondition.getProvince())){
            centralBillListCondition.setProvince(null);
        }
        return centralBillListCondition;
    }
}
