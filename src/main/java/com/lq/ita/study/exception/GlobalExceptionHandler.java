package com.lq.ita.study.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lq.ita.study.rsp.BaseRsp;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity handlerBusiness(BussinessException bussinessException) {
        return build(HttpStatus.BAD_REQUEST, bussinessException.getMessage());
    }

    @ExceptionHandler
    public ResponseEntity handlerException(Throwable throwable) {
        return build(HttpStatus.INTERNAL_SERVER_ERROR, throwable.getMessage());
    }

    private ResponseEntity build(HttpStatus httpStatus, String message) {
        return new ResponseEntity(BaseRsp.builder().code(httpStatus.value()).desc(message).build(), httpStatus);
    }
}
