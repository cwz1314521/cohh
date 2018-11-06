package com.hema.newretail.backstage.controller;

import com.hema.newretail.backstage.common.utils.Response;
import com.hema.newretail.backstage.common.utils.UploadFileUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author Created by jiahao
 * @Date 2018/8/27 17:43
 */
@RestController
@RequestMapping("/base")
public class BaseController {

    @ApiOperation("上传图片服务")
    @PostMapping("/uploadFile")
    public String uploadFile(@RequestParam(required = false) Integer proportionType, MultipartFile file) {
        String uploadImageOss = UploadFileUtil.uploadImageOss(file, proportionType);
        return uploadImageOss;
    }
}
