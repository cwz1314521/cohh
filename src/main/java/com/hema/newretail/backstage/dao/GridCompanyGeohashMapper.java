package com.hema.newretail.backstage.dao;

import com.hema.newretail.backstage.entry.BaseCompanyGeoHashData;
import com.hema.newretail.backstage.entry.grid.GridCompanyGeohashEntry;
import com.hema.newretail.backstage.model.grid.ServiceSonBo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface GridCompanyGeohashMapper {



    List<ServiceSonBo> selectGeoHash(Long id);

    int deleteByCompanyId(Long gridCompanyId);

    List<GridCompanyGeohashEntry> selectByCompanyId(Long id);

    int deleteByPrimaryKey(Long id);

    int insert(GridCompanyGeohashEntry record);

    int insertSelective(GridCompanyGeohashEntry record);

    GridCompanyGeohashEntry selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GridCompanyGeohashEntry record);

    int updateByPrimaryKey(GridCompanyGeohashEntry record);

    /**
     *
     * @param parameter
     * @return
     */
    List<String> freeGeoHash(@Param("mapGeoHash") List<String> parameter);

    List<String> findGridCompanyGeoHashByCompanyId(Long baseCompanyId);

    Long selectCountByIdAndHashcode(Map<String,Object> paramsMap);
}