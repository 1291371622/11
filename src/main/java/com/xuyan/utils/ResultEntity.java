package com.xuyan.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xu yan
 * @version V1.0.0
 * @projectName SSM_OA
 * @package com.xuyan.utils
 * @description
 * @date 2020/12/14 19:58
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultEntity<T> {

    private static final String SUCCESS = "SUCCESS";
    private static final String FAILED = "FAILED";
    private static final String NO_MESSAGE = "操作成功";
    private static final String ERROR_MESSAGE = "操作失败";

    // 响应的标识
    private String state;

    // 响应信息
    private String message;

    // 响应数据
    private T data;

    public static <T> ResultEntity<T> success(T data) {
        return new ResultEntity<T>(SUCCESS, NO_MESSAGE, data);
    }

    public static <T> ResultEntity<T> success() {
        return new ResultEntity<T>(SUCCESS, NO_MESSAGE, null);
    }

    public static <T> ResultEntity<T> faild(String message) {
        return new ResultEntity<T>(FAILED, message, null);
    }
    public static <T> ResultEntity<T> faild(T data) {
        return new ResultEntity<T>(FAILED, ERROR_MESSAGE, data);
    }

    public static <T> ResultEntity<T> faild() {
        return new ResultEntity<T>(FAILED, ERROR_MESSAGE, null);
    }

}
