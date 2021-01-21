package com.xuyan.dao;

import com.github.pagehelper.PageInfo;
import com.xuyan.entity.Emp;
import com.xuyan.entity.Page;

import java.util.List;

/**
 * @author xu yan
 * @version V1.0.0
 * @projectName SSM_OA
 * @package com.xuyan.dao
 * @description
 * @date 2020/12/7 16:58
 */
public interface IBaseMapper<T> {

    int add(T t);

    int update(T t);

    int deleteById(Integer id);

    List<T> getList();//分页

    T selectById(Integer id);

    Integer batchDel(Integer[] id);
}
