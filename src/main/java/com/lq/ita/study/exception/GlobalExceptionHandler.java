package com.lq.ita.study.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lq.ita.study.rsp.BaseRsp;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
    @ExceptionHandler
    public BaseRsp handlerBusiness(BussinessException bussinessException) {
        return build(400, bussinessException.getMessage());
    }

    @ExceptionHandler
    public BaseRsp handlerException(Throwable throwable) {
        return build(500, throwable.getMessage());
    }

    private BaseRsp build(int code, String message) {
        return BaseRsp.builder().code(code).desc(message).build();
    }
}
