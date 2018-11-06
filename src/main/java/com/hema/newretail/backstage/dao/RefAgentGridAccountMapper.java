package com.hema.newretail.backstage.dao;

import com.hema.newretail.backstage.entry.RefAgentGridAccount;

public interface RefAgentGridAccountMapper {
    int insert(RefAgentGridAccount record);

    int insertSelective(RefAgentGridAccount record);
}