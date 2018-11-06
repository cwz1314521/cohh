package com.hema.newretail.backstage.service;

import com.hema.newretail.backstage.entry.BaseMachineInfoEntry;
import com.hema.newretail.backstage.entry.RefZoneMachine;
import com.hema.newretail.backstage.entry.ZoneBase;
import com.hema.newretail.backstage.model.tag.BaseIngredientBoxInfoBo;
import com.hema.newretail.backstage.model.zonebase.BoxGroupBo;
import com.hema.newretail.backstage.model.zonebase.ZoneBo;
import com.hema.newretail.backstage.model.zonebase.ZoneMapGridBo;

import java.util.List;
import java.util.Map;

/**
 * hema-newetaril-com.hema.newretail.backstage.service
 *
 * @Description:
 * @Author: ZhangHaiSheng
 * @Date: 2018-08-25 14:44
 */
public interface IZoneBaseService {

    /**
     * 查询片区列表数据
     *
     * @param paramsMap
     * @return
     */
    public List<ZoneBo> queryZoneList(Map<String, Object> paramsMap);

    /**
     * 片区管理->地图查看->查询片区
     *
     * @param paramsMap
     * @return
     */
    List<ZoneMapGridBo> queryZoneMap(Map<String, Object> paramsMap);

    /**
     * 添加片区
     *
     * @param zoneName
     * @param machineTypeId
     * @param province
     * @param city
     * @param area
     * @param hashcodes
     */
    void insertZoneData(String zoneName, String machineTypeId, String province, String city, String area, String[] hashcodes);

    /**
     * 查询配料组合列表
     *
     * @param machineTypeId
     * @param zoneId
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<BoxGroupBo> queryBoxGroupList(Long machineTypeId, Long zoneId, Integer pageNum, Integer pageSize);

    /**
     * 更新配料组合
     *
     * @param zoneId
     * @param boxGroupId
     */
    void updateBoxGroupId(String[] zoneId, String boxGroupId);

    List<String> getHashCode(List<Long> list);

    List<String> getMachHashCode(Map<String, Object> paramsMap);


    /**
     * 根据片区ID查询一条片区记录
     *
     * @param zoneId
     * @return
     */
    ZoneBase queryOneByZoneId(Long zoneId);

    /**
     * 根据zoneId查询所有geohashcodes
     *
     * @param zoneId
     * @return
     */
    List<RefZoneMachine> queryGeoHashcodeByZoneId(Long zoneId);

    /**
     * 更新片区
     *
     * @param zoneId
     * @param zoneName
     * @param province
     * @param city
     * @param area
     * @param hashcodes
     */
    Integer updateZoneData(Long zoneId, String zoneName, String province, String city, String area, String[] hashcodes);

    /**
     * 一键查询所有网格
     *
     * @param province
     * @param city
     * @param area
     * @return
     */
    List<RefZoneMachine> queryAllGruidByArea(String province, String city, String area);

    /**
     * 查询给定网格的所有设备数
     *
     * @param hashcodes 网格
     * @return 设备数
     */
    Integer queryMachineNumByGeoHash(String[] hashcodes);

    /**
     * 查询配料方案明细
     *
     * @param boxGroupId
     * @return
     */
    List<BaseIngredientBoxInfoBo> ingredientInfo(Long boxGroupId);
}
