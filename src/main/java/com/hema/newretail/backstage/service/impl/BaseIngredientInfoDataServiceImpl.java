package com.hema.newretail.backstage.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hema.newretail.backstage.common.utils.Response;
import com.hema.newretail.backstage.dao.BaseIngredientInfoEntryMapper;
import com.hema.newretail.backstage.entry.BaseIngredientInfoEntry;
import com.hema.newretail.backstage.service.IBaseIngredientInfoDataService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 配料字典管理接口实现类
 * @author
 */
@Service("baseIngredientInfoDataService")
@Primary
public class BaseIngredientInfoDataServiceImpl implements IBaseIngredientInfoDataService {


    @Resource
    private BaseIngredientInfoEntryMapper mapper;

    /**
     * 保存配料信息
     * @param data
     * @return
     */
    @Override
    public boolean save(BaseIngredientInfoEntry data) {
        int n=0;
        if (mapper.selectByPrimaryKey(data.getId())==null){
            data.setGmtCreate(new Date());
            n = mapper.insertSelective(data);
        }else{
            data.setGmtModified(new Date());
            n = mapper.updateByPrimaryKey(data);
        }
        if(n == 1){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 根据id查询配料详情
     * @param id
     * @return
     */
    @Override
    public BaseIngredientInfoEntry findOneById(long id) {
        return mapper.selectByPrimaryKey(id);
    }

    /**
     * 查询配料列表，带分页信息
     * @param params
     * @return
     */
    @Override
    public Response findAll(Map<String, Object> params) {
        int pageSize = (int)params.get("pageSize");
        int pageNum = (int)params.get("pageNum");
        PageHelper.startPage(pageNum, pageSize);
        List<BaseIngredientInfoEntry> data = mapper.findAll(params);
        PageInfo<BaseIngredientInfoEntry> pageInfo = new PageInfo<>(data);
        return Response.success(data,pageInfo.getTotal(),pageInfo.getPageSize(),pageInfo.getPageNum());
    }

    /**
     * 删除配料字典
     * @param id
     * @return
     */
    @Override
    public String deleteById(long id) {

        int ref = mapper.countByRefMenuIngredient(id);
        int pro = mapper.countByBasePropertiesType(id);
        if(ref==0&&pro==0){
            int count = mapper.deleteByPrimaryKey(id);
            if(count>0){
                return "删除成功";
            }else{
                return "删除失败";
            }
        }else{
            return "此配料信息已有饮品或配料配置信息引用，不可删除";
        }

    }
}
