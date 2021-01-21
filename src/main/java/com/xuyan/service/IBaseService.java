package com.xuyan.service;

import com.github.pagehelper.PageInfo;
import com.xuyan.entity.Page;

/**
 * @author xu yan
 * @version V1.0.0
 * @projectName SSM_OA
 * @package com.xuyan.service
 * @description
 * @date 2020/12/7 16:43
 */
public interface IBaseService<T> {

    public Integer save(T t);

    public Integer update(T t);

    public Integer delete(Integer id);

    public T selectById(Integer id);

    public PageInfo<T> getPage(Page page);

    public Integer batchDel(Integer[] id);

}
