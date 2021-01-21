package com.xuyan.service.impl;

import com.github.pagehelper.PageInfo;
import com.xuyan.dao.IBaseMapper;
import com.xuyan.dao.IEmpMapper;
import com.xuyan.entity.Emp;
import com.xuyan.service.IEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xu yan
 * @version V1.0.0
 * @projectName SSM_OA
 * @package com.xuyan.service.impl
 * @description
 * @date 2020/12/7 16:51
 */
@Service
public class EmpServiceImpl extends BaseServiceImpl<Emp> implements IEmpService{

    @Autowired
    private IEmpMapper empMapper;


    protected IBaseMapper<Emp> baseMapper() {
        return empMapper;
    }
}
