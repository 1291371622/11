package com.xuyan.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xuyan.dao.IBaseMapper;
import com.xuyan.entity.Page;
import com.xuyan.service.IBaseService;

import java.util.List;

/**
 * @author xu yan
 * @version V1.0.0
 * @projectName SSM_OA
 * @package com.xuyan.service.impl
 * @description
 * @date 2020/12/7 16:54
 */
public abstract class BaseServiceImpl<T> implements IBaseService<T> {

    //service中调用Mapper层,该属性需要子类实例化
    protected abstract IBaseMapper<T> baseMapper();//这里只是声明,并没有实例化



    public Integer save(T t) {
        return baseMapper().add(t);
    }

    public Integer update(T t) {
        return baseMapper().update(t);
    }

    public Integer delete(Integer id) {
        return baseMapper().deleteById(id);
    }

    public T selectById(Integer id) {
        return baseMapper().selectById(id);
    }

    public PageInfo<T> getPage(Page page) {

        PageHelper.startPage(page.getPageNum(),page.getPageSize());
        List list = baseMapper().getList();

        return new PageInfo<T>(list);
    }

    public Integer batchDel(Integer[] id){
        return baseMapper().batchDel(id);
    }
}
