package com.hema.newretail.backstage.dao;

import com.hema.newretail.backstage.entry.BasePushMessageEntry;
import com.hema.newretail.backstage.model.agent.PushListBo;

import java.util.List;

public interface BasePushMessageMapper {




    List<PushListBo> selectByAgent();

    int insertBatch(List<BasePushMessageEntry> list);
    
}