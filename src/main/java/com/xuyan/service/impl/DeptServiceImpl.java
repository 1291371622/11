package com.xuyan.service.impl;

import com.github.pagehelper.PageInfo;
import com.xuyan.dao.IBaseMapper;
import com.xuyan.entity.Dept;
import com.xuyan.service.IDeptService;
import com.xuyan.service.IEmpService;
import org.springframework.stereotype.Service;

/**
 * @author xu yan
 * @version V1.0.0
 * @projectName SSM_OA
 * @package com.xuyan.service.impl
 * @description
 * @date 2020/12/7 16:52
 */
@Service
public class DeptServiceImpl extends BaseServiceImpl<Dept> implements IDeptService {

    //private DeptMapper


    protected IBaseMapper<Dept> baseMapper() {
        return null;
    }
}
