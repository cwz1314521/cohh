package com.hema.newretail.backstage.controller.drinkmanagement;

import com.hema.newretail.backstage.common.requestparam.MenuParam;
import com.hema.newretail.backstage.common.utils.Response;
import com.hema.newretail.backstage.common.utils.UploadFileUtil;
import com.hema.newretail.backstage.entry.BusiIngredientMenuEntry;
import com.hema.newretail.backstage.enums.ResultCode;
import com.hema.newretail.backstage.service.drinkmanagement.StandardDrinkService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by jiahao on 2018-08-25
 */
@Api(description = "标准饮品")
@RestController
@RequestMapping("/standardDrink")
public class StandardDrinkController {

    private static final String ERROE_IMAGE_INFO = "请上传正确比例图片";

    @Autowired
    StandardDrinkService standardDrinkService;

    @ApiOperation("添加饮品名时，光标离开校验")
    @PostMapping("/verificationName")
    public Response verificationAddStandardDrinkMenuName(@RequestParam String menuName, @RequestParam Integer type, @RequestParam Long id) {
        String standardDrink = null;
        if (type == 1) {
            standardDrink = standardDrinkService.selectStandardDrink(menuName, id);
        } else {
            BusiIngredientMenuEntry busiIngredientMenuEntry = standardDrinkService.selectStandardDrink(menuName);
            if (busiIngredientMenuEntry != null) {
                return Response.failure(ResultCode.VALIDATION_ERROR_MENU_NAME_NOT_NULL);
            }
        }
        if ("OK".equals(standardDrink)) {
            return Response.success("自身相同修改");
        }
        if ("ERROR".equals(standardDrink)) {
            return Response.failure(ResultCode.VALIDATION_ERROR_MENU_NAME_NOT_NULL);
        }
        return Response.success("允许修改");
    }

    @ApiOperation("上传饮品图片")
    @PostMapping("/uploadFile")
    public Response uploadFile(@RequestParam(required = false) Integer proportionType, MultipartFile file) {
        String uploadImageOss = UploadFileUtil.uploadImageOss(file, proportionType);
        if (uploadImageOss == null) {
            return Response.failure();
        }
        if (ERROE_IMAGE_INFO.equals(uploadImageOss)) {
            return Response.failure(ResultCode.FAIL_VALIDATOR);
        }
        return Response.success(uploadImageOss);
    }

    @ApiOperation("添加与编辑标准饮品")
    @PostMapping("/addAndUpdateStandardDrink")
    public Response addStandardDrink(@RequestBody MenuParam menuParam) {
        if (menuParam == null) {
            return Response.failure(ResultCode.VALIDATION_ERROR_PARAM_CODE_EMPTY);
        }
        standardDrinkService.saveAndUpdateStandardDrink(menuParam);

        return Response.success();
    }



    /* @ApiOperation("编辑标准饮品")
    @PutMapping("/updateStandardDrink")
    public Response updateStandardDrink() {

        return Response.success();
    }*/
}
