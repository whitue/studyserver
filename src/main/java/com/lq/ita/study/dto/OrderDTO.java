package com.lq.ita.study.dto;

import java.util.Date;

import com.lq.ita.study.endity.Order;
import com.lq.ita.study.exception.BussinessException;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private Integer id;
    private String status;
    private Integer payType;
    private Date createTime;
    private Date updateTime;

    public static OrderDTO from(Order order) {
        if (null == order) {
            throw new BussinessException("empty order info");
        }
        return OrderDTO.builder().id(order.getId()).status(order.getStatus()).payType(order.getPayType())
            .createTime(order.getCreateTime()).updateTime(order.getUpdateTime()).build();
    }
}
