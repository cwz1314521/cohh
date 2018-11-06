package com.hema.newretail.backstage.controller;

import com.github.pagehelper.Page;
import com.hema.newretail.backstage.common.utils.Response;
import com.hema.newretail.backstage.enums.ResultCode;
import com.hema.newretail.backstage.model.zonebase.AllZoneHashcodeBo;
import com.hema.newretail.backstage.model.zonebase.BoxGroupBo;
import com.hema.newretail.backstage.model.zonebase.ZoneBo;
import com.hema.newretail.backstage.model.zonebase.ZoneMapGridBo;
import com.hema.newretail.backstage.service.IZoneBaseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * hema-newetaril-com.hema.newretail.backstage.controller
 *
 * @Description:
 * @Author: ZhangHaiSheng
 * @Date: 2018-08-25 14:47
 */
@Api(description = "片区管理")
@RestController
@Validated
@RequestMapping("/zone")
public class ZoneBaseController {

    @Autowired
    private IZoneBaseService zoneBaseService;

    /**
     * 查询片区列表数据
     *
     * @param machineTypeId 机器类型编码
     * @param province      省
     * @param city          市
     * @param area          区
     * @param pageNum       页码
     * @param pageSize      每页数据条数
     * @return
     */
    @ApiOperation("查询片区列表数据")
    @PostMapping(value = "/zoneList")
    public Response zoneList(@RequestParam(required = false) @NotBlank(message = "参数machineTypeId不能为空") String machineTypeId,
                             String province, String city, String area,
                             @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                             @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        Map<String, Object> map = new HashMap<>(6);
        map.put("machineTypeId", machineTypeId);
        map.put("province", province);
        map.put("city", city);
        map.put("area", area);
        map.put("pageNum", pageNum);
        map.put("pageSize", pageSize);
        try {
            List<ZoneBo> zoneBaseList = zoneBaseService.queryZoneList(map);
            return Response.success(zoneBaseList, ((Page) zoneBaseList).getTotal(), pageSize, pageNum);
        } catch (Exception e) {
            e.printStackTrace();
            return Response.failure();
        }
    }

    /**
     * 添加片区
     *
     * @param machineTypeId 机器类型编码
     * @param zoneName      片区名称
     * @param province      省
     * @param city          市
     * @param area          区
     * @param hashcodes     geo hash code
     * @return
     */
    @ApiOperation("添加片区")
    @PostMapping(value = "/zoneAdd")
    public Response zoneAdd(@RequestParam(required = false) @NotBlank(message = "参数machineTypeId不能为空") String machineTypeId,
                            @RequestParam(required = false)
                            @NotBlank(message = "参数zoneName不能为空")
                            @Size(min = 2,max = 18,message = "2~18个字符")
                                    String zoneName,
                            String province, String city, String area, String[] hashcodes) {
        if (StringUtils.isEmpty(province)) {
            province = "";
            city = "";
            area = "";
        }
        if (StringUtils.isEmpty(city)) {
            city = "";
            area = "";
        }
        try {
            zoneBaseService.insertZoneData(zoneName, machineTypeId, province, city, area, hashcodes);
            return Response.success();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.failure();
        }
    }

    /**
     * 地图查看
     *
     * @param province 省
     * @param city     市
     * @param area     区
     * @return
     */
    @ApiOperation("地图查看")
    @PostMapping(value = "/lookOverMap")
    public Response lookOverMap(String province, String city, String area) {
        if (StringUtils.isEmpty(province)) {
            province = "";
            city = "";
            area = "";
        }
        if (StringUtils.isEmpty(city)) {
            city = "";
            area = "";
        }
        Map<String, Object> map = new HashMap<>(5);
        map.put("province", province);
        map.put("city", city);
        map.put("area", area);
        try {
            List<ZoneMapGridBo> zoneBaseList = zoneBaseService.queryZoneMap(map);
            return Response.success(zoneBaseList);
        } catch (Exception e) {
            e.printStackTrace();
            return Response.failure();
        }
    }

    /**
     * 检测未划分片区的设备
     *
     * @return
     */
    @ApiOperation("检测未划分片区的设备")
    @RequestMapping(value = "/checkZone", method = RequestMethod.POST)
    public Response checkZone(@RequestBody List<AllZoneHashcodeBo> hashcodeBoList) {
        if(null == hashcodeBoList) {
            return Response.failure();
        }
        try {
            Map<String, Object> map = new HashMap<>(1);
            List<String> hashList = new ArrayList<>(hashcodeBoList.size());
            for(AllZoneHashcodeBo hashcodeBo : hashcodeBoList) {
                if(null != hashcodeBo && null != hashcodeBo.getCode()) {
                    hashList.add(hashcodeBo.getCode());
                }
            }
            map.put("hashcodes", hashList);
            List<String> machineInfoList = zoneBaseService.getMachHashCode(map);
            return Response.success(machineInfoList);
        } catch (Exception e) {
            e.printStackTrace();
            return Response.failure();
        }
    }

    /**
     * 查询配料类型
     *
     * @param machineTypeId 机器类型编码
     * @param zoneId        片区编码
     * @param pageNum       页码
     * @param pageSize      每页记录条数
     * @return
     */
    @ApiOperation("查询配料类型")
    @PostMapping(value = "/groupList")
    public Response groupList(@RequestParam(required = false) @NotBlank(message = "参数machineTypeId不能为空") String machineTypeId,
                              String[] zoneId,
                              @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                              @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        try {
            if (null == zoneId || zoneId.length < 1) {
                return Response.failure();
            }
            List<BoxGroupBo> boxGroupBoList = zoneBaseService.queryBoxGroupList(Long.valueOf(machineTypeId), Long.valueOf(zoneId[0]), pageNum, pageSize);
            return Response.success(boxGroupBoList, ((Page) boxGroupBoList).getTotal(), pageSize, pageNum);
        } catch (Exception e) {
            e.printStackTrace();
            return Response.failure();
        }
    }

    /**
     * 保存并更新配料类型组合
     *
     * @param zoneId     片区编码
     * @param boxGroupId 配料类型组合编码
     * @return
     */
    @ApiOperation("保存并更新配料类型组合")
    @PostMapping(value = "/set")
    public Response set(@RequestParam String[] zoneId,
                        @RequestParam(required = false) @NotBlank(message = "参数boxGroupId不能为空") String boxGroupId) {
        try {
            zoneBaseService.updateBoxGroupId(zoneId, boxGroupId);
            return Response.success();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.failure();
        }
    }

    /**
     * 跳转到更新片区页面需要的初始数据接口
     *
     * @param zoneId 片区编码
     * @return
     */
    @ApiOperation("跳转到更新片区页面需要的初始数据接口")
    @PostMapping(value = "/toUpdate")
    public Response toUpdate(@RequestParam(required = false) @NotBlank(message = "参数zoneId不能为空") String zoneId) {
        try {
            return Response.success(zoneBaseService.queryOneByZoneId(Long.valueOf(zoneId)));
        } catch (Exception e) {
            e.printStackTrace();
            return Response.failure();
        }
    }

    /**
     * 选择网格接口
     *
     * @param zoneId 片区编码
     * @return
     */
    @ApiOperation("选择网格接口")
    @PostMapping(value = "/toMap")
    public Response toMap(@RequestParam(required = false) @NotBlank(message = "参数zoneId不能为空") String zoneId) {
        try {
            return Response.success(zoneBaseService.queryGeoHashcodeByZoneId(Long.valueOf(zoneId)));
        } catch (Exception e) {
            e.printStackTrace();
            return Response.failure();
        }
    }

    /**
     * 片区修改接口
     *
     * @param zoneId    片区编码
     * @param zoneName  片区名称
     * @param province  省
     * @param city      市
     * @param area      区
     * @param hashcodes geo hash code
     * @return
     */
    @ApiOperation("片区修改接口")
    @PostMapping(value = "/zoneUpdate")
    public Response zoneUpdate(@RequestParam(required = false) @NotBlank(message = "参数zoneId不能为空") String zoneId,
                               @RequestParam(required = false)
                               @NotBlank(message = "参数zoneName不能为空")
                               @Size(min = 2,max = 18,message = "2~18个字符")
                                       String zoneName,
                               String province, String city, String area, String[] hashcodes) {
        if (StringUtils.isEmpty(province)) {
            province = null;
            city = null;
            area = null;
        }
        if (StringUtils.isEmpty(city)) {
            city = null;
            area = null;
        }
        try {
            Integer num = zoneBaseService.updateZoneData(Long.valueOf(zoneId), zoneName, province, city, area, hashcodes);
            if(-2 == num ) {
                return Response.failure("检测到有交叉片区，更新失败。");
            }
            return Response.success();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.failure();
        }
    }

    /**
     * 一键选择本地区所有网格
     *
     * @param province 省
     * @param city     市
     * @param area     区
     * @return
     */
    @ApiOperation("一键选择本地区所有网格")
    @PostMapping(value = "/allGruid")
    public Response allGruid(String province, String city, String area) {
        if (StringUtils.isEmpty(province)) {
            return Response.failure(ResultCode.VALIDATION_ERROR_PARAM_EMPTY);
        }
        try {
            return Response.success(zoneBaseService.queryAllGruidByArea(province, city, area));
        } catch (Exception e) {
            e.printStackTrace();
            return Response.failure();
        }
    }

    @ApiOperation("查询选择网格的设备数")
    @PostMapping(value = "/queryMachineNum")
    public Response querySelectedMachineNum(String[] hashcodes) {
        try {
            return Response.success(zoneBaseService.queryMachineNumByGeoHash(hashcodes));
        } catch (Exception e) {
            e.printStackTrace();
            return Response.failure();
        }
    }

    @ApiOperation("查看配料信息")
    @PostMapping(value = "/ingredientInfo")
    public Response ingredientInfo(@RequestParam(required = false) @NotBlank(message = "参数boxGroupId不能为空") String boxGroupId) {
        try {
            return Response.success(zoneBaseService.ingredientInfo(Long.valueOf(boxGroupId)));
        } catch (Exception e) {
            e.printStackTrace();
            return Response.failure();
        }
    }

}
