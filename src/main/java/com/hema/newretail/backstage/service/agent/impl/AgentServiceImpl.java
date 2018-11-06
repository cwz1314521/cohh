package com.hema.newretail.backstage.service.agent.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hema.newretail.CloudBohhApplication;
import com.hema.newretail.backstage.common.queryparam.CommomPageCondition;
import com.hema.newretail.backstage.common.queryparam.agent.AddAgentCondition;
import com.hema.newretail.backstage.common.queryparam.agent.AgentListCondition;
import com.hema.newretail.backstage.common.queryparam.agent.EditAgentCondition;
import com.hema.newretail.backstage.common.queryparam.agent.PushCondition;
import com.hema.newretail.backstage.common.utils.*;
import com.hema.newretail.backstage.common.utils.rongyun.RongCloudMethodUtil;
import com.hema.newretail.backstage.dao.AgentCooperationModeMapper;
import com.hema.newretail.backstage.dao.AgentUserMapper;
import com.hema.newretail.backstage.dao.BasePushMessageMapper;
import com.hema.newretail.backstage.dao.BusiCompanyAccountMapper;
import com.hema.newretail.backstage.entry.BasePushMessageEntry;
import com.hema.newretail.backstage.entry.BusiCompanyAccountEntry;
import com.hema.newretail.backstage.entry.agent.AgentCooperationMode;
import com.hema.newretail.backstage.entry.agent.AgentUserEntry;
import com.hema.newretail.backstage.model.agent.AgentListBo;
import com.hema.newretail.backstage.model.agent.PushListBo;
import com.hema.newretail.backstage.service.agent.AgentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Department 新零售
 * @ClassName AgentServiceImpl
 * @Description 代理公司各接口service接口实现类
 * @Author ---CWZ
 * @Date 2018/9/21 10:32
 * @Version 1.0
 **/
@Service
public class AgentServiceImpl implements AgentService {



    @Value(value = "${excelModel.agentFileName}")
    private String agentFileName;

    @Autowired
    private AgentUserMapper agentUserMapper;
    @Autowired
    private BasePushMessageMapper basePushMessageMapper;
    @Autowired
    private BusiCompanyAccountMapper busiCompanyAccountMapper;

    private static final Logger logger = LoggerFactory.getLogger(CloudBohhApplication.class);
    /**
     * 功能描述:展示代理公司列表
     *
     * @param:
     * @return: list
     * @author: cwz
     * @date: 2018/9/21 10:50
     */
    @Override
    public Response list(AgentListCondition agentListCondition) {
        /*判断名字编号是否为空   不为空判断是否为数字  若为数字转化为id 清空name*/
        logger.info("判断名字编号是否为空......");
        if(agentListCondition.getName() != "" && agentListCondition.getName() !=null){
            logger.info("判断名字编号是否为数字......");
        if(isInteger(agentListCondition.getName())){
            logger.info("如果是数字的话转成id......");
            agentListCondition.setId(Long.parseLong(agentListCondition.getName()));
            agentListCondition.setName(null);
        }
        }
        logger.info("查询数据库并且加入分页......");
        Page<AgentListBo> page =PageHelper.startPage(agentListCondition.getPageNum(),agentListCondition.getPageSize());
        agentUserMapper.selectAgentList(agentListCondition);
        logger.info("查询完成......");
        return Response.success(page.getResult(),page.getTotal(),page.getPageSize(),page.getPageNum());
    }

    /**
     * 功能描述:添加代理公司
     *
     * @param:
     * @return: list
     * @author: cwz
     * @date: 2018/9/21 10:50
     */
    @Override
    @Transactional
    public Response add(AddAgentCondition AddAgentCondition) {

        logger.info("参数处理......");
        AgentUserEntry agentUserEntry = addAssembly(AddAgentCondition);
        logger.info("代理主表存入......");
        agentUserMapper.insert(agentUserEntry);
        logger.info("代理合作模式拼装......");
        logger.info("代理账户拼装......");
        BusiCompanyAccountEntry busiCompanyAccountEntry = new BusiCompanyAccountEntry();
        busiCompanyAccountEntry.setType("1");
        busiCompanyAccountEntry.setRefId(agentUserEntry.getId());
        busiCompanyAccountEntry.setGmtModified(new Date());
        busiCompanyAccountEntry.setGmtCreate(new Date());
        busiCompanyAccountEntry.setBank(AddAgentCondition.getBank());
        busiCompanyAccountEntry.setAccountName(AddAgentCondition.getAccountName());
        busiCompanyAccountEntry.setAccountNumber(AddAgentCondition.getAccountNumber());
        logger.info("代理账户存入......");
        busiCompanyAccountMapper.insert(busiCompanyAccountEntry);
        logger.info("二表存储完成......");
        return Response.success();
    }

    /**
     * 功能描述:修改代理公司
     *
     * @param:
     * @return: list
     * @author: cwz
     * @date: 2018/9/21 10:50
     */
    @Override
    @Transactional
    public Response edit(EditAgentCondition editAgentCondition) {
        logger.info("参数处理......");
        AgentUserEntry agentUserEntry = editAssembly(editAgentCondition);
        logger.info("更新主表......");
        agentUserMapper.updateByPrimaryKeySelective(agentUserEntry);

        logger.info("根据主键查询分成明细......");
        BusiCompanyAccountEntry busiCompanyAccountEntry = new BusiCompanyAccountEntry();
        busiCompanyAccountEntry.setType("1");
        busiCompanyAccountEntry.setRefId(agentUserEntry.getId());
        busiCompanyAccountEntry.setGmtModified(new Date());
        busiCompanyAccountEntry.setBank(editAgentCondition.getBank());
        busiCompanyAccountEntry.setAccountName(editAgentCondition.getAccountName());
        busiCompanyAccountEntry.setAccountNumber(editAgentCondition.getAccountNumber());
        logger.info("更新账户信息......");
        busiCompanyAccountMapper.updateByRefIdSelective(busiCompanyAccountEntry);

        logger.info("代理更新完毕......");
        return Response.success();
    }

    /**
     * 功能描述:删除代理公司
     *
     * @param:
     * @return: list
     * @author: cwz
     * @date: 2018/9/21 10:50
     */
    @Override
    @Transactional
    public Response delete(Long id) {
        int i = agentUserMapper.deleteById(id);
        if(i>0){
            logger.info("id为"+id+"的代理公司数据逻辑删除成功.....");
            return Response.success();
        }
        logger.info("id为"+id+"的代理公司数据逻辑删除失败.....");
        return Response.failure("操作失败");
    }

    /**
     * 功能描述:代理数据统计
     *
     * @param:
     * @return: list
     * @author: cwz
     * @date: 2018/9/21 10:50
     */
    @Override
    public Response listStatistics() {
        return null;
    }

    @Override
    public Response excle(HttpServletRequest request, HttpServletResponse response, AgentListCondition agentListCondition) throws   Exception{

        logger.info("判断名字编号是否为空......");
        if(agentListCondition.getName() != "" && agentListCondition.getName() !=null){
            logger.info("判断名字编号是否为数字......");
            if(isInteger(agentListCondition.getName())){
                logger.info("如果是数字的话转成id.......");
                agentListCondition.setId(Long.parseLong(agentListCondition.getName()));
                agentListCondition.setName(null);
            }
        }
        logger.info("检索即将存储在excel的数据......");
        List<AgentListBo> list = agentUserMapper.selectAgentList(agentListCondition);
        logger.info("设置ContentType......");
        response.setContentType("application/octet-stream");
        logger.info("设置文件名......");
        StringBuilder fileName = new StringBuilder();
        fileName.append(new Date()).append(".xlsx");
        String time = TimeUtil.getStringByDate(new Date());
        logger.info("设置Header......");
        response.setHeader("Content-Disposition", "attachment;filename="+ URLEncoder.encode(fileName.toString(), "utf-8"));
        response.flushBuffer();
        logger.info("调用AgentExcelUtils拼装类......");
        AgentExcelUtils.exportExcel(agentFileName,list,response.getOutputStream(),time);
        return Response.success();
    }

    /**
     *
     * 功能描述: 消息推送
     *
     * @param: PushCondition
     * @return: success
     * @author: cwz
     * @date: 2018/10/26 17:37
     */
    @Override
    public Response push(PushCondition pushCondition){
        logger.info("创建参数类list......");
        List<BasePushMessageEntry> list = new ArrayList<>();
        logger.info("转化ids为list数组......");
        List<Long> longs = StringUtil.StringsToLong(pushCondition.getGridIds());
        for (Long l:longs
             ) {
            logger.info("循环拼装参数类......");
            BasePushMessageEntry basePushMessageEntry = new BasePushMessageEntry();
            basePushMessageEntry.setContent(pushCondition.getContent());
            basePushMessageEntry.setGridId(l);
            basePushMessageEntry.setReadFlag("0");
            basePushMessageEntry.setReceiveType("0");
            basePushMessageEntry.setTitle(pushCondition.getTitle());
            basePushMessageEntry.setType(pushCondition.getType());
            basePushMessageEntry.setCreateDate(new Date());
            basePushMessageEntry.setCreateBy("运营后台");
            list.add(basePushMessageEntry);
        }
        basePushMessageMapper.insertBatch(list);
        logger.info("调用融云循环发送信息");
        for (BasePushMessageEntry b:list
             ) {
            logger.info("推送"+"  内容："+b.getContent()+"   接收人："+b.getGridId().toString()+"   标题："+b.getTitle()+"......");
            Map map = new HashMap(1);
            map.put("content",b.getContent());
            RongCloudMethodUtil.pushSystemMessage(
                    JSON.toJSONString(map),b.getCreateBy(),b.getGridId().toString(),"RC:TxtMsg",b.getTitle(),"");
        }
        return Response.success();
    }

    /**
     *
     * 功能描述: 推送历史
     *
     * @param: commomPageCondition
     * @return: list
     * @author: cwz
     * @date: 2018/10/26 17:37
     */
    @Override
    public Response pushHistory(CommomPageCondition commomPageCondition){
        logger.info("执行分页页码："+commomPageCondition.getPageNum()+"每页数："+commomPageCondition.getPageSize());
        Page<PushListBo> page =PageHelper.startPage(commomPageCondition.getPageNum(),commomPageCondition.getPageSize());
        basePushMessageMapper.selectByAgent();
        return Response.success(page.getResult(),page.getTotal(),commomPageCondition.getPageSize(),commomPageCondition.getPageNum());
    }


    /**
    *
    * 功能描述: 判断传入的name是否由数字构成
    *
    * @param: str
    * @return: boolean
    * @author: cwz
    * @date: 2018/9/25 12:00
    */
    private static boolean isInteger(String str) {
        logger.info("验证传入的字符串是否由数字构成......");
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }
    /**
     *
     * 功能描述: 添加代理参数类拼装
     *
     * @param: AddAgentCondition
     * @return: AgentUserEntry
     * @author: cwz
     * @date: 2018/10/8 13:38
     */
    private AgentUserEntry addAssembly(AddAgentCondition AddAgentCondition){
        AgentUserEntry agentUserEntry = new AgentUserEntry();
        agentUserEntry.setGmtModified(new Date());
        agentUserEntry.setStatus(AddAgentCondition.getStatus());
        agentUserEntry.setIsDeleted(Byte.valueOf("0"));
        agentUserEntry.setGmtCreate(new Date());
        agentUserEntry.setAddr(AddAgentCondition.getAddr());
        agentUserEntry.setArea(AddAgentCondition.getArea());
        agentUserEntry.setCity(AddAgentCondition.getCity());
        agentUserEntry.setCompanyCode(null);
        agentUserEntry.setCompanyName(AddAgentCondition.getCompanyName());
        agentUserEntry.setContact(AddAgentCondition.getContact());
        agentUserEntry.setContactWay(AddAgentCondition.getContactWay());
        agentUserEntry.setEmail(null);
        agentUserEntry.setProvince(AddAgentCondition.getProvince());
        agentUserEntry.setRemark(AddAgentCondition.getRemark());
        agentUserEntry.setTel(AddAgentCondition.getTel());
        logger.info("参数处理完成");
        return agentUserEntry;
    }

    /**
     *
     * 功能描述:
     *
     * @param: AddAgentCondition
     * @return: AgentUserEntry
     * @author: cwz
     * @date: 2018/10/8 13:38
     */
    private AgentUserEntry editAssembly(EditAgentCondition editAgentCondition){

        AgentUserEntry agentUserEntry = new AgentUserEntry();
        agentUserEntry.setId(editAgentCondition.getId());
        agentUserEntry.setGmtModified(new Date());
        agentUserEntry.setStatus(editAgentCondition.getStatus());
        agentUserEntry.setAddr(editAgentCondition.getAddr());
        agentUserEntry.setArea(editAgentCondition.getArea());
        agentUserEntry.setCity(editAgentCondition.getCity());
        agentUserEntry.setCompanyCode(null);
        agentUserEntry.setContact(editAgentCondition.getContact());
        agentUserEntry.setContactWay(editAgentCondition.getContactWay());
        agentUserEntry.setEmail(null);
        agentUserEntry.setProvince(editAgentCondition.getProvince());
        agentUserEntry.setRemark(editAgentCondition.getRemark());
        logger.info("参数处理完成");
        return agentUserEntry;
    }

}
