package com.hema.newretail.backstage.dao;

import com.hema.newretail.backstage.entry.agent.AgentAccountEntry;

public interface AgentAccountMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AgentAccountEntry record);

    int insertSelective(AgentAccountEntry record);

    AgentAccountEntry selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AgentAccountEntry record);

    int updateByPrimaryKey(AgentAccountEntry record);
}