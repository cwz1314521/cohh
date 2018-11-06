package com.hema.newretail.backstage.controller.drinkmanagement;

import com.github.pagehelper.PageInfo;
import com.hema.newretail.backstage.common.utils.Response;
import com.hema.newretail.backstage.entry.BaseIngredientInfoEntry;
import com.hema.newretail.backstage.entry.BasePropertiesTypeEntry;
import com.hema.newretail.backstage.service.drinkmanagement.OptionManagementService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Size;
import java.util.List;

/**
 * Created by jiahao on 2018-08-22
 */
@Api(description = "选项管理接口")
@RestController
@RequestMapping("/optionManagement")
public class OptionManagementController {

    @Autowired
    OptionManagementService optionManagementService;

    @ApiOperation("查询对应配料")
    @PostMapping("/selectIngredientInfo")
    private Response selectIngredientInfo() {
        List<BaseIngredientInfoEntry> baseIngredientInfoEntries = optionManagementService.selectIngredientInfo();
        return Response.success(baseIngredientInfoEntries);
    }

    @ApiOperation("选项添加与编辑")
    @PostMapping("/insertAndUpdateOption")
    public Response insertAndUpdateOption(@RequestParam(value = "id", required = false) Long id ,
                                          @RequestParam @Size(min = 1,max = 16,message = "1~16个字符") String typeName,
                                          @RequestParam Long ingredientId,
                                          @RequestParam @Size(min = 1,max = 10,message = "1~10个字符") String propertiesName,
                                          @RequestParam boolean status) {
        String addOption = optionManagementService.insertAndUpdateOption(id, typeName, ingredientId, propertiesName, status);
        return Response.success(addOption);
    }

    @ApiOperation("查询选项列表")
    @PostMapping("/selectOptionList")
    public Response selectOptionList(@RequestParam(value = "pageNum", required = false) Integer pageNum,
                                     @RequestParam(value = "pageSize", required = false) Integer pageSize) {
        PageInfo<BasePropertiesTypeEntry> basePropertiesTypeEntryPageInfo =
                optionManagementService.selectOptionList(pageNum, pageSize);
        return Response.success(basePropertiesTypeEntryPageInfo);
    }
}
