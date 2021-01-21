package com.xuyan.service.impl;

import com.github.pagehelper.PageInfo;
import com.xuyan.entity.Emp;
import com.xuyan.entity.Page;
import com.xuyan.service.IEmpService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @author xu yan
 * @version V1.0.0
 * @projectName SSM_OA
 * @package com.xuyan.service.impl
 * @description
 * @date 2020/12/8 15:15
 */
@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:applicationContext.xml")
public class EmpServiceImplTest {

    @Autowired
    private IEmpService empService;

    @Test
    public void testGetEmpList() {
        PageInfo<Emp> pageInfo = empService.getPage(new Page());
        System.out.println(pageInfo.getList());
        System.out.println(pageInfo.getPages());
    }
}