package com.xuyan.controller;

import com.github.pagehelper.PageInfo;
import com.xuyan.entity.Emp;
import com.xuyan.entity.Page;
import com.xuyan.service.IEmpService;
import com.xuyan.utils.ResponseUtils;
import com.xuyan.utils.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

/**
 * @author xu yan
 * @version V1.0.0
 * @projectName SSM_OA
 * @package com.xuyan.controller
 * @description
 * @date 2020/12/8 15:45
 */
@Controller
@RequestMapping(value = "/empController")
public class EmpController {

    @Autowired
    private IEmpService empService;

    @RequestMapping(value = "/getEmpPage")
    public String getEmpPage(Page page, ModelMap map){
        System.out.println("EmpController.getEmpPage");
        PageInfo<Emp> pageInfo = empService.getPage(page);
        map.put("pageInfo",pageInfo);
        map.put("url","empController/getEmpPage");

        //views/emp/empList.jsp
        return "emp/empList";
    }

    @RequestMapping(value = "/toAddEmp")
    public String toAddEmp(){
        return "emp/addEmp";
    }

    @RequestMapping(value = "/addEmp")
    @ResponseBody
    public ResultEntity addEmp(Emp emp){

        //至于这个方法处理异常,全局异常会处理
        return ResponseUtils.responseClient(empService.save(emp));
    }

    @RequestMapping(value = "/deleteEmp/{id}")
    public String deleteEmp(@PathVariable Integer id){
        empService.delete(id);
        return "emp/updateEmp";
    }

    @RequestMapping(value = "/getEmpById/{id}")
    public String getById(@PathVariable Integer id, ModelMap modelMap){

        Emp emp = empService.selectById(id);
        modelMap.put("emp",emp);
        return "emp/updateEmp";

    }

    @RequestMapping(value = "/updateEmp")
    @ResponseBody
    public ResultEntity<? extends Object> updateEmp(Emp emp){
        return ResponseUtils.responseClient(empService.update(emp));
    }

    @RequestMapping(value = "/batchDelEmp")
    @ResponseBody
    public ResultEntity batchDelEmp(@RequestParam("ids[]") Integer[] ids){

        return  ResponseUtils.responseClient(empService.batchDel(ids));
    }

}

