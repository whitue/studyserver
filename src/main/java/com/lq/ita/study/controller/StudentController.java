package com.lq.ita.study.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.lq.ita.study.req.AddStudentReq;
import com.lq.ita.study.req.UpdateStudentReq;
import com.lq.ita.study.rsp.BaseRsp;
import com.lq.ita.study.service.StudentService;

@RestController
@Validated
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping(method = RequestMethod.POST)
    public BaseRsp register(@RequestBody @Valid AddStudentReq addStudentReq) {
        return BaseRsp.builder().code(BaseRsp.SUCCESS_CODE).desc(BaseRsp.SUCCESS_DESC)
            .data(studentService.add(addStudentReq)).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public BaseRsp deRegister(@NotNull @PathVariable("id") Integer id) {
        return BaseRsp.builder().code(BaseRsp.SUCCESS_CODE).desc(BaseRsp.SUCCESS_DESC).data(studentService.del(id))
            .build();
    }

    @RequestMapping(method = RequestMethod.PATCH)
    public BaseRsp modifyInfo(@RequestBody @Valid UpdateStudentReq updateStudentReq) {
        return BaseRsp.builder().code(BaseRsp.SUCCESS_CODE).desc(BaseRsp.SUCCESS_DESC)
            .data(studentService.modify(updateStudentReq)).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public BaseRsp get(@NotNull @PathVariable("id") Integer id) {
        return BaseRsp.builder().code(BaseRsp.SUCCESS_CODE).desc(BaseRsp.SUCCESS_DESC).data(studentService.query(id))
            .build();
    }

    @RequestMapping(method = RequestMethod.GET)
    public BaseRsp list() {
        return BaseRsp.builder().code(BaseRsp.SUCCESS_CODE).desc(BaseRsp.SUCCESS_DESC).data(studentService.queryAll())
            .build();
    }
}
