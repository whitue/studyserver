package com.lq.ita.study.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.lq.ita.study.audit.AuditOperation;
import com.lq.ita.study.req.AddOrderReq;
import com.lq.ita.study.req.UpdateOrderReq;
import com.lq.ita.study.rsp.BaseRsp;
import com.lq.ita.study.service.OrderService;

@RestController
@Validated
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping(method = RequestMethod.POST)
    @AuditOperation(operation = "addOrder")
    public BaseRsp addOrder(@RequestBody @Valid AddOrderReq addOrderReq) {
        return BaseRsp.builder().code(BaseRsp.SUCCESS_CODE).desc(BaseRsp.SUCCESS_DESC)
            .data(orderService.add(addOrderReq)).build();
    }

    @AuditOperation(operation = "delOrder")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public BaseRsp delOrder(@NotNull @PathVariable("id") Integer id) {
        return BaseRsp.builder().code(BaseRsp.SUCCESS_CODE).desc(BaseRsp.SUCCESS_DESC).data(orderService.del(id))
            .build();
    }

    @AuditOperation(operation = "updateOrder")
    @RequestMapping(method = RequestMethod.PATCH)
    public BaseRsp changeOrder(@RequestBody @Valid UpdateOrderReq updateOrderReq) {
        return BaseRsp.builder().code(BaseRsp.SUCCESS_CODE).desc(BaseRsp.SUCCESS_DESC)
            .data(orderService.modify(updateOrderReq)).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public BaseRsp getOrder(@NotNull @PathVariable("id") Integer id) {
        return BaseRsp.builder().code(BaseRsp.SUCCESS_CODE).desc(BaseRsp.SUCCESS_DESC).data(orderService.query(id))
            .build();
    }
}
