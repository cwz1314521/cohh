package com.hema.newretail.backstage.dao;

import com.hema.newretail.backstage.common.queryparam.agent.AgentListCondition;
import com.hema.newretail.backstage.entry.agent.AgentUserEntry;
import com.hema.newretail.backstage.model.agent.AgentListBo;

import java.util.List;

public interface AgentUserMapper {

    /**逻辑删除*/
    int deleteById(Long id);

    /**代理列表查询*/
    List<AgentListBo> selectAgentList(AgentListCondition agentListCondition);

    /**查询全部信息*/
    List<AgentUserEntry> selectAll();


    int deleteByPrimaryKey(Long id);

    int insert(AgentUserEntry record);

    int insertSelective(AgentUserEntry record);

    AgentUserEntry selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AgentUserEntry record);

    int updateByPrimaryKey(AgentUserEntry record);
}