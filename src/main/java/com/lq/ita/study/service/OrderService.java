package com.lq.ita.study.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lq.ita.study.dto.OrderDTO;
import com.lq.ita.study.endity.Order;
import com.lq.ita.study.exception.BussinessException;
import com.lq.ita.study.mapper.OrderMapper;
import com.lq.ita.study.req.AddOrderReq;
import com.lq.ita.study.req.UpdateOrderReq;

@Service
public class OrderService {
    @Autowired
    private OrderMapper orderMapper;

    public OrderDTO add(AddOrderReq addOrderReq) {
        Order order = addOrderReq.toOrder();
        Order exist = innerQuery(order.getId());
        if (null != exist) {
            throw new BussinessException("order have bean created");
        }
        orderMapper.insert(order);
        return OrderDTO.from(innerQuery(order.getId()));
    }

    public boolean del(Integer id) {
        orderMapper.delete(id);
        return true;
    }

    public OrderDTO modify(UpdateOrderReq updateOrderReq) {
        Order order = updateOrderReq.toOrder();
        Order exist = innerQuery(order.getId());
        if (null == exist) {
            throw new BussinessException("invalid order id");
        }
        orderMapper.update(order);
        return OrderDTO.from(innerQuery(order.getId()));
    }

    public OrderDTO query(Integer id) {
        return OrderDTO.from(innerQuery(id));
    }

    private Order innerQuery(Integer id) {
        return orderMapper.selectById(id);
    }
}
