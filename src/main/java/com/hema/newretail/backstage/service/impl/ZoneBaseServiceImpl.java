package com.hema.newretail.backstage.service.impl;

import com.hema.newretail.backstage.dao.BaseIngredientBoxMapper;
import com.hema.newretail.backstage.dao.BoxGroupMapper;
import com.hema.newretail.backstage.dao.RefZoneMachineMapper;
import com.hema.newretail.backstage.dao.ZoneBaseMapper;
import com.hema.newretail.backstage.entry.BaseMachineInfoEntry;
import com.hema.newretail.backstage.entry.RefZoneMachine;
import com.hema.newretail.backstage.entry.ZoneBase;
import com.hema.newretail.backstage.model.tag.BaseIngredientBoxInfoBo;
import com.hema.newretail.backstage.model.zonebase.BoxGroupBo;
import com.hema.newretail.backstage.model.zonebase.ZoneBo;
import com.hema.newretail.backstage.model.zonebase.ZoneMapGridBo;
import com.hema.newretail.backstage.service.IZoneBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * hema-newetaril-com.hema.newretail.backstage.service.impl
 *
 * @Description:
 * @Author: ZhangHaiSheng
 * @Date: 2018-08-25 14:45
 */
@Service("zoneBaseService")
public class ZoneBaseServiceImpl implements IZoneBaseService {

    @Autowired
    private ZoneBaseMapper zoneBaseMapper;
    @Autowired
    private BoxGroupMapper boxGroupMapper;
    @Autowired
    private RefZoneMachineMapper refZoneMachineMapper;
    @Autowired
    private BaseIngredientBoxMapper baseIngredientBoxMapper;

    /**
     * @param paramsMap
     * @return
     */
    @Override
    public List<ZoneBo> queryZoneList(Map<String, Object> paramsMap) {
        return zoneBaseMapper.selectZoneListByCondition(paramsMap, (Integer) paramsMap.get("pageNum"), (Integer) paramsMap.get("pageSize"));
    }

    @Override
    public List<ZoneMapGridBo> queryZoneMap(Map<String, Object> paramsMap) {
        return zoneBaseMapper.selectZoneForMap(paramsMap);
    }

    @Override
    public List<String> getHashCode(List<Long> list) {
        return zoneBaseMapper.getHashCode(list);
    }

    @Override
    public List<String> getMachHashCode(Map<String, Object> paramsMap) {
        return zoneBaseMapper.getMachHashCode(paramsMap);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void insertZoneData(String zoneName, String machineTypeId, String province, String city, String area, String[] hashcodes) {
        Integer machineNum = 0;
        if (null != hashcodes && hashcodes.length > 0) {
            // 检测是否有交叉片区
            if (this.isHaveCrossZone(hashcodes, null)) {
                return;
            }
            machineNum = zoneBaseMapper.selectMachineNumByHashcode(hashcodes);
        }
        ZoneBase zoneBase = new ZoneBase();
        zoneBase.setArea(area);
        zoneBase.setCity(city);
        zoneBase.setGmtCreate(new Date());
        zoneBase.setGmtModified(new Date());
        zoneBase.setMachineNum(machineNum);
        zoneBase.setMachineTypeId(Long.valueOf(machineTypeId));
        zoneBase.setProvince(province);
        zoneBase.setZoneName(zoneName);
        zoneBaseMapper.insertSelective(zoneBase);

        if (null != hashcodes && hashcodes.length > 0) {
            refZoneMachineMapper.insertBatch(getZoneMachineList(hashcodes, zoneBase.getId()));
        }
    }

    @Override
    public List<BoxGroupBo> queryBoxGroupList(Long machineTypeId, Long zoneId, Integer pageNum, Integer pageSize) {
        Map<String, Object> map = new HashMap<>(2);
        map.put("machineTypeId", machineTypeId);
        map.put("zoneId", zoneId);
        return boxGroupMapper.selectBoxGroup(map, pageNum, pageSize);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateBoxGroupId(String[] zoneId, String boxGroupId) {
        if (null != zoneId && zoneId.length > 0) {
            for (String id : zoneId) {
                ZoneBase zoneBase = zoneBaseMapper.selectByPrimaryKey(Long.valueOf(id));
                if (null == zoneBase) {
                    return;
                }
                zoneBase.setBoxGroupId(Long.valueOf(boxGroupId));
                zoneBaseMapper.updateByPrimaryKeySelective(zoneBase);
            }
        }

    }

    /**
     * @param zoneId
     * @return
     */
    @Override
    public ZoneBase queryOneByZoneId(Long zoneId) {
        return zoneBaseMapper.selectByPrimaryKey(zoneId);
    }

    /**
     * @param zoneId
     * @return
     */
    @Override
    public List<RefZoneMachine> queryGeoHashcodeByZoneId(Long zoneId) {
        return refZoneMachineMapper.selectByZoneid(zoneId);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Integer updateZoneData(Long zoneId, String zoneName, String province, String city, String area, String[] hashcodes) {
        ZoneBase zoneBase = this.queryOneByZoneId(zoneId);
        if (null == zoneBase) {
            return -1;
        }
        Integer machineNum = zoneBase.getMachineNum();

        if (null != hashcodes && hashcodes.length > 0) {
            // 检测是否有交叉片区
            if (this.isHaveCrossZone(hashcodes, zoneId)) {
                return -2;
            }
            refZoneMachineMapper.deleteByZoneid(zoneId);
            machineNum = zoneBaseMapper.selectMachineNumByHashcode(hashcodes);
            List<RefZoneMachine> list = getZoneMachineList(hashcodes, zoneId);
            if (null != list) {
                refZoneMachineMapper.insertBatch(list);
            }
        } else {
            refZoneMachineMapper.deleteByZoneid(zoneId);
        }
        zoneBase.setArea(area);
        zoneBase.setCity(city);
        zoneBase.setGmtModified(new Date());
        zoneBase.setMachineNum(machineNum);
        zoneBase.setProvince(province);
        zoneBase.setZoneName(zoneName);
        return zoneBaseMapper.updateByPrimaryKeySelective(zoneBase);
    }

    /**
     * 一键查询所有网格
     *
     * @param province
     * @param city
     * @param area
     * @return
     */
    @Override
    public List<RefZoneMachine> queryAllGruidByArea(String province, String city, String area) {
        Map<String, Object> paramsMap = new HashMap<>(3);
        paramsMap.put("province", province);
        paramsMap.put("city", city);
        paramsMap.put("area", area);
        return refZoneMachineMapper.selectAllGruidByArea(paramsMap);
    }

    /**
     * 查询给定网格的所有设备数
     *
     * @param hashcodes 网格
     * @return 设备数
     */
    @Override
    public Integer queryMachineNumByGeoHash(String[] hashcodes) {
        Integer machineNum = 0;
        if (null != hashcodes && hashcodes.length > 0) {
            machineNum = zoneBaseMapper.selectMachineNumByHashcode(hashcodes);
        }
        return machineNum;
    }

    /**
     * 检测是否有交叉片区
     *
     * @return true 有 false 没有
     */
    private Boolean isHaveCrossZone(String[] hashcodes, Long zoneId) {
        List<String> hashCodeList = zoneBaseMapper.getHashCodeCross(hashcodes,zoneId);
        return null != hashCodeList && hashCodeList.size() > 0;
    }

    /**
     * @param hashcodes
     * @param zoneId
     * @return
     */
    private List<RefZoneMachine> getZoneMachineList(String[] hashcodes, Long zoneId) {
        List<RefZoneMachine> refZoneMachineList = new ArrayList<>();
        for (String geoHashcode : hashcodes) {
            RefZoneMachine refZoneMachine = new RefZoneMachine();
            refZoneMachine.setGeoHash(geoHashcode);
            refZoneMachine.setZoneId(zoneId);
            refZoneMachineList.add(refZoneMachine);
        }
        return refZoneMachineList;
    }

    @Override
    public List<BaseIngredientBoxInfoBo> ingredientInfo(Long boxGroupId) {
        return baseIngredientBoxMapper.selectBoxOrInfoByBoxGroupId(boxGroupId);
    }

}
