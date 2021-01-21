package com.xuyan.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author xu yan
 * @version V1.0.0
 * @projectName SSM_OA
 * @package com.xuyan.entity
 * @description
 * @date 2020/12/5 16:22
 */

@Data
public class Emp {

    private Integer id;

    private String username;

    private String password;

    private Integer sex;

    private String email;

    private String mobile;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    private Integer deptno;//还没有Dept

    private Date createTime;

    private Emp createUser;

    private Date updateTime;

    private Emp updateUser;

    private String userpng;

    private String orderbyIndex;//排序索引

}
