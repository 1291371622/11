package com.xuyan.utils;

/**
 * @author xu yan
 * @version V1.0.0
 * @projectName SSM_OA
 * @package com.xuyan.utils
 * @description
 * @date 2020/12/16 21:05
 */
public class ResponseUtils {

    public static ResultEntity responseClient(Integer state){
        if(state > 0){
            return ResultEntity.success();
        }else {
            return ResultEntity.faild();
        }
    }

}
