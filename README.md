**项目名称**：RBAC通用权限设计-权限管理系统

**项目时间**：2020/12/15 ~ 2020/12/22

**使用技术**：后端：SpringMVC+Spring+MyBatis+MybatisPlus+BCrypt 

前端: h-ui.admin,layer,ztree,validateform,my97DatePicker,JquerySession,webupload

数据库采用 MySQL

**项目描述**：项目包含数据管理和权限管理两部分，数据管理实现员工与部门的增加、删除、查找、修改操作，权限管理实现超级管理员对目标员工授予相应的角色，以及角色权限的授予、取消以及修改

**授权管理**

**授权菜单（用户点击）**
```1.判断用户是否选择了角色
a)如果没有选择提示用户，程序不能往下执行
		//1.获取用户选择的菜单
        var roleId = $("#role").val();

        //2.非空判断
        if(!roleId){
            layer.msg("请选择菜单",{time:1000,icon:3});
            return;
        }
2.打开一个页面
    //3.弹出一个框，显示所有的菜单
        layer_show("选择权限","authController/toAuthMenuTreePage/" + roleId,"800","600");

a)最终显示两个信息
    1）所有的菜单
    2）如果当前角色有某个菜单的权限，自动选中
b)树插件中的逻辑_>初始化树的时候把所有的菜单全部显示出来
    a)获取所有的菜单以及当前角色拥有的菜单权限
    
    1）ID:菜单ID
    2)name:菜单的名字
     3）pid当前菜单的父ID（简单JSON转标准的时候会用到）
      4）checked：表示当前角色是否有该菜单权限
        a）true:有
        b)false:无
   	b)把简单的JSON接口转成标准的JSON结构
        a)format
    c)把转后的标准的JSON赋值给znodes数组
    e)初始化树插件 
