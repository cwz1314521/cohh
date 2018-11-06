package com.hema.newretail.backstage.common.queryparam.agent;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * @Department 新零售
 * @ClassName PushCondition
 * @Description 消息推送参数类
 * @Author ---CWZ
 * @Date 2018/10/26 17:47
 * @Version 1.0
 **/
@ApiModel(value = "PushCondition",description = "消息推送参数类")
public class PushCondition {



    @ApiModelProperty(value = "消息类型")
    private String type;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "消息体")
    private String content;

    @ApiModelProperty(value = "接受者ids")
    private String gridIds;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getGridIds() {
        return gridIds;
    }

    public void setGridIds(String gridIds) {
        this.gridIds = gridIds;
    }
}
