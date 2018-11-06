package com.hema.newretail.backstage.controller.authority;

import com.github.pagehelper.Page;
import com.hema.newretail.backstage.common.utils.Response;
import com.hema.newretail.backstage.entry.BasePost;
import com.hema.newretail.backstage.service.authority.IPostService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * hema-newRetail-crm-com.hema.newretail.backstage.controller.userfunc
 *
 * @author ZhangHaiSheng
 * @link
 * @date 2018-09-11 10:34
 */
@Api(description = "权限管理->岗位接口")
@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    private IPostService postService;

    @ApiOperation("岗位列表，分页展示")
    @PostMapping(value = "/list")
    public Response list(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                         @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        Map<String, Object> map = new HashMap<>(6);
        map.put("pageNum", pageNum);
        map.put("pageSize", pageSize);
        try {
            List<BasePost> list = postService.queryDataByCondition(map);
            if (null == list || list.size() == 0) {
                return Response.success();
            }
            return Response.success(list, ((Page) list).getTotal(), pageSize, pageNum);
        } catch (Exception e) {
            e.printStackTrace();
            return Response.failure();
        }
    }

    @ApiOperation("添加岗位")
    @PostMapping(value = "/add")
    public Response add(@RequestBody @Valid BasePost data) {
        try {
            return postService.insertData(data);
        } catch (Exception e) {
            e.printStackTrace();
            return Response.failure();
        }
    }

    @ApiOperation("编辑岗位")
    @PostMapping(value = "/update")
    public Response update(@RequestBody @Valid BasePost data) {
        try {
            return postService.updateData(data);
        } catch (Exception e) {
            e.printStackTrace();
            return Response.failure();
        }
    }

    @ApiOperation("删除岗位")
    @PostMapping(value = "/delete")
    public Response delete(@RequestParam(required = false) @NotBlank(message = "参数postId不能为空") String postId) {
        try {
            postService.deleteData(postId);
            return Response.success();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.failure();
        }
    }
}
