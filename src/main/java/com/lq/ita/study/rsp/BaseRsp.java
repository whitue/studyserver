package com.lq.ita.study.rsp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BaseRsp<T> {
    public static final int SUCCESS_CODE = 0;
    public static final String SUCCESS_DESC = "success";
    private int code = SUCCESS_CODE;
    private String desc = SUCCESS_DESC;
    private T data;
}
