package com.hema.newretail.backstage.dao;

import com.hema.newretail.backstage.entry.grid.GridReplenishmentTaskEntry;

public interface GridReplenishmentTaskMapper {
    int insert(GridReplenishmentTaskEntry record);

    int insertSelective(GridReplenishmentTaskEntry record);
}