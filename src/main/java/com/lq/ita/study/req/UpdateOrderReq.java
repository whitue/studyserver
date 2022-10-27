package com.lq.ita.study.req;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.lq.ita.study.endity.Order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateOrderReq {
    @NotNull
    private Integer id;

    @NotNull
    @Length(min = 1, max = 10)
    private String status;

    public Order toOrder() {
        return Order.builder().id(id).status(status).build();
    }
}
