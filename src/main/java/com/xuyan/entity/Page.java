package com.xuyan.entity;

import lombok.Data;

/**
 * @author xu yan
 * @version V1.0.0
 * @projectName SSM_OA
 * @package com.xuyan.entity
 * @description
 * @date 2020/12/12 20:14
 */
@Data
public class Page {

    private Integer pageNum = 1;

    private Integer pageSize = 10;

}
