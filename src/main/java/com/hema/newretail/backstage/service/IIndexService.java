package com.hema.newretail.backstage.service;

import com.hema.newretail.backstage.entry.IndexpageContentTypeEntry;
import com.hema.newretail.backstage.entry.IndexpageCssEntry;
import com.hema.newretail.backstage.model.index.IndexConfigBo;
import com.hema.newretail.backstage.model.index.IndexSaveParamBo;

import java.util.List;

/**
 * hema-newetaril-com.hema.newretail.backstage.service
 *
 * @Description:
 * @Author: ZhangHaiSheng
 * @Date: 2018-08-20 18:09
 */
public interface IIndexService {

    /**
     * 查询首页布局
     *
     * @return
     */
    List<IndexConfigBo> queryIndexConfig();

    /**
     * 查询所有模板数据
     *
     * @return
     */
    List<IndexpageCssEntry> queryAllCss();

    /**
     * @param paramBo
     */
    void insertIndexConfig(List<IndexSaveParamBo> paramBo);

    /**
     * @return
     */
    List<IndexpageContentTypeEntry> queryAllContentType();

    /**
     * 预览
     *
     * @param list 列表
     * @return s
     */
    String preview(List<IndexSaveParamBo> list);

}
