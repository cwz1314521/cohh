package com.hema.newretail.backstage.service.impl;

import com.hema.newretail.backstage.common.utils.StringReplace;
import com.hema.newretail.backstage.common.utils.ossutil.AliyunOSSClientUtil;
import com.hema.newretail.backstage.dao.*;
import com.hema.newretail.backstage.entry.*;
import com.hema.newretail.backstage.model.index.*;
import com.hema.newretail.backstage.service.IIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * hema-newetaril-com.hema.newretail.backstage.service.impl
 *
 * @Description:
 * @Author: ZhangHaiSheng
 * @Date: 2018-08-20 18:09
 */
@Service("indexService")
public class IndexServiceImpl implements IIndexService {
    @Autowired
    private IndexpageConfigEntryMapper indexpageConfigEntryMapper;
    @Autowired
    private IndexpageCssEntryMapper indexpageCssEntryMapper;
    @Autowired
    private IndexpageDetailEntryMapper indexpageDetailEntryMapper;
    @Autowired
    private IndexpageContentTypeEntryMapper indexpageContentTypeEntryMapper;
    @Autowired
    private IngredientMenuEntryMapper ingredientMenuEntryMapper;
    @Autowired
    private AliyunOSSClientUtil aliyunOSSClientUtil;

    @Override
    public List<IndexConfigBo> queryIndexConfig() {
        return indexpageConfigEntryMapper.selectIndexConfig();
    }

    @Override
    public List<IndexpageCssEntry> queryAllCss() {
        return indexpageCssEntryMapper.selectAllData();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertIndexConfig(List<IndexSaveParamBo> paramBo) {
        System.out.println("in insert...");
        if (null == paramBo || paramBo.size() == 0) {
            System.out.println("bo is null...");
        } else {
            indexpageConfigEntryMapper.deleteAll();
            indexpageDetailEntryMapper.deleteAll();
            for (IndexSaveParamBo bo : paramBo) {
                IndexpageConfigEntry config = new IndexpageConfigEntry();
                config.setCssId(bo.getCssId());
                config.setOrder(bo.getOrder());
                indexpageConfigEntryMapper.insert(config);
                List<IndexSaveDetailParamBo> detailBo = bo.getDetails();
                for (IndexSaveDetailParamBo detailParamBo : detailBo) {
                    IndexpageDetailEntry detail = new IndexpageDetailEntry();
                    detail.setConfigId(config.getId());
                    detail.setContentType(detailParamBo.getContentType());
                    detail.setGridNo(detailParamBo.getGridNo());
                    indexpageDetailEntryMapper.insert(detail);
                }
            }
        }
    }

    @Override
    public List<IndexpageContentTypeEntry> queryAllContentType() {
        return indexpageContentTypeEntryMapper.selectAllData();
    }


    /**
     * 饮品
     */
    public static final int MENU = 0;

    /**
     * 卡券
     */
    public static final int CARD = 1;

    /**
     * 活动
     */
    public static final int ACTIVITY = 2;

    /**
     * 猜你喜欢
     */
    public static final int GUESS_YOU_LIKE = 3;
    /**
     * diy
     */
    public static final int DIY = 4;

    /**
     * 购买历史
     */
    public static final int BUY_HISTORY = 5;

    @Override
    public String preview(List<IndexSaveParamBo> list) {
        List<IngredientMenuEntry> menuList = ingredientMenuEntryMapper.getList();
        StringBuffer content = new StringBuffer();
        IngredientMenuEntry menu = null;
        for (IndexSaveParamBo config : list) {
            List<Map<String, String>> mapList = new LinkedList<>();
            Long cssId = config.getCssId();
            IndexpageCssEntry indexpageCssEntry = indexpageCssEntryMapper.selectByPrimaryKey(cssId);
            String html = indexpageCssEntry.getCssContent();
            List<IndexSaveDetailParamBo> detailList = config.getDetails();
            for (IndexSaveDetailParamBo detail : detailList) {
                Map<String, String> map = new HashMap<>(64);
                Integer type = detail.getContentType();
                if (type == MENU) {
                    if (menuList.size() > 0) {
                        menu = menuList.get(0);
                    }
                    if (null != menu) {
                        //组装数据
                        handleMenuData(map, menu, type);
                        menuList.remove(menu);
                    } else {
                        manageData(map);
                    }
                } else if (type == GUESS_YOU_LIKE) {
                    //组装数据
                    handleGuessYouLikeData(map, type);
                } else if (type == DIY) {
                    //组装数据
                    handleDiyData(map, type);
                } else if (type == BUY_HISTORY) {
                    //组装数据
                    handleBuyHistoryData(map, type);
                } else {
                    //组装数据
                    manageData(map);
                }

                mapList.add(map);
            }
            html = replaceString(mapList, html);
            content.append(html);
        }
        System.out.println(content.toString());
        return content.toString();
    }


    /**
     * 处理默认数据
     *
     * @param map
     */
    private void manageData(Map<String, String> map) {
        map.put("##id##", "&nbsp;");
        map.put("##small_pic##", "https://newretail.hemaapp.com/img/default_small_pic.png");
        map.put("##middle_pic##", "https://newretail.hemaapp.com/img/default_middle_pic.png");
        map.put("##big_pic##", "https://newretail.hemaapp.com/img/default_big_pic.png");
        map.put("##name##￥##price##", "&nbsp;");
    }

    /**
     * 组装模板格子饮品数据
     *
     * @param map
     * @param menu
     * @param type
     */
    private void handleMenuData(Map<String, String> map,
                                IngredientMenuEntry menu, Integer type) {
        map.put("##type##_##id##", MENU + "_" + menu.getId() + "");
        map.put("##ioc##", "&nbsp;");

        handleMapDefafultData(map, type);

        map.put("##small_pic##", menu.getSmallPic()
                == null ? aliyunOSSClientUtil.getPicUrl("default_small_pic", "png")
                : menu.getSmallPic());
        map.put("##middle_pic##", menu.getMiddlePic()
                == null ? aliyunOSSClientUtil.getPicUrl("default_middle_pic", "png")
                : menu.getMiddlePic());
        map.put("##big_pic##", menu.getBigPic()
                == null ? aliyunOSSClientUtil.getPicUrl("default_big_pic", "png")
                : menu.getBigPic());

        map.put("##name##", menu.getMenuName()
                == null ? "&nbsp;" : menu.getMenuName());
        map.put("￥##price##", menu.getPrice()
                == null ? "&nbsp;" : "￥" + menu.getPrice());
    }

    /**
     * 组装模板格子猜你喜欢数据
     *
     * @param map
     * @param type
     */
    private void handleGuessYouLikeData(Map<String, String> map, Integer type) {
        map.put("##type##_##id##", GUESS_YOU_LIKE + "_" + "guessYouLikeData");
        map.put("##ioc##", aliyunOSSClientUtil.getGuessYouLikeUrl());

        map.put("##small_pic##", aliyunOSSClientUtil.getPicUrl("guess_you_like_small_default", "png")
                == null ? aliyunOSSClientUtil.getPicUrl("default_small_pic", "png")
                : aliyunOSSClientUtil.getPicUrl("guess_you_like_small_default", "png"));
        map.put("##middle_pic##", aliyunOSSClientUtil.getPicUrl("guess_you_like_middle_default", "png")
                == null ? aliyunOSSClientUtil.getPicUrl("default_middle_pic", "png")
                : aliyunOSSClientUtil.getPicUrl("guess_you_like_middle_default", "png"));
        map.put("##big_pic##", aliyunOSSClientUtil.getPicUrl("guess_you_like_big_default", "png")
                == null ? aliyunOSSClientUtil.getPicUrl("default_big_pic", "png")
                : aliyunOSSClientUtil.getPicUrl("guess_you_like_big_default", "png"));

        handleMapDefafultData(map, type);

    }

    /***
     * diy数据
     * @param map
     * @param type
     */
    private void handleDiyData(Map<String, String> map, Integer type) {
        map.put("##ioc##", "&nbsp;");
        map.put("##type##_##id##", DIY + "_" + "diy");

        map.put("##small_pic##", aliyunOSSClientUtil.getSmallPicDiyUrl()
                == null ? aliyunOSSClientUtil.getPicUrl("default_small_pic", "png")
                : aliyunOSSClientUtil.getSmallPicDiyUrl());
        map.put("##middle_pic##", aliyunOSSClientUtil.getMiddlePicDiyUrl()
                == null ? aliyunOSSClientUtil.getPicUrl("default_middle_pic", "png")
                : aliyunOSSClientUtil.getMiddlePicDiyUrl());
        map.put("##big_pic##", aliyunOSSClientUtil.getBigPicDiyUrl()
                == null ? aliyunOSSClientUtil.getPicUrl("default_big_pic", "png")
                : aliyunOSSClientUtil.getBigPicDiyUrl());

        handleMapDefafultData(map, type);

    }

    /**
     * 购买历史
     *
     * @param map
     * @param type
     */
    private void handleBuyHistoryData(Map<String, String> map, Integer type) {
        map.put("##ioc##", aliyunOSSClientUtil.getBuyHistoryUrl());
        map.put("##type##_##id##", BUY_HISTORY + "_" + "buyHistory");

        map.put("##small_pic##", aliyunOSSClientUtil.getSmallPicBuyHistoryUrl()
                == null ? aliyunOSSClientUtil.getPicUrl("default_small_pic", "png")
                : aliyunOSSClientUtil.getSmallPicBuyHistoryUrl());
        map.put("##middle_pic##", aliyunOSSClientUtil.getMiddlePicBuyHistoryUrl()
                == null ? aliyunOSSClientUtil.getPicUrl("default_middle_pic", "png")
                : aliyunOSSClientUtil.getMiddlePicBuyHistoryUrl());
        map.put("##big_pic##", aliyunOSSClientUtil.getBigPicBuyHistoryUrl()
                == null ? aliyunOSSClientUtil.getPicUrl("default_big_pic", "png")
                : aliyunOSSClientUtil.getBigPicBuyHistoryUrl());

        handleMapDefafultData(map, type);
    }

    /**
     * 组装模板中一些共同字段值
     *
     * @param map
     * @param type
     */
    private void handleMapDefafultData(Map<String, String> map, Integer type) {
        map.put("##name##", "&nbsp;");
        map.put("￥##price##", "&nbsp;");
        map.put("##small_type##", "small_" + type + "");
        map.put("##middle_type##", "middle_" + type + "");
        map.put("##big_type##", "big_" + type + "");
    }

    /**
     * 替换模板中的参数
     *
     * @param mapList
     * @param templateContent
     * @return
     */
    private static String replaceString(List<Map<String, String>> mapList,
                                        String templateContent) {
        String[] contents = templateContent.split("&&&&&&");
        StringBuilder temStr = new StringBuilder();
        for (int i = 0; i < contents.length; i++) {
            Map<String, String> map = mapList.get(i);
            Set keys = map.keySet();
            Iterator iter = keys.iterator();
            String tempHtml = contents[i];
            while (iter.hasNext()) {
                String key = (String) iter.next();
                String value = map.get(key);
                tempHtml = StringReplace.getReplaceString(tempHtml, key, value);
            }
            temStr.append(tempHtml);
        }
        templateContent = temStr.toString().replaceAll("&&&&&&", "&nbsp;");

        return templateContent;
    }

}
