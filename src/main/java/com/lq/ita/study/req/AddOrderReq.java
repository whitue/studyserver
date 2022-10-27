package com.lq.ita.study.req;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

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
public class AddOrderReq {
    @Positive
    @NotNull
    private Integer id;
    @NotNull
    @Length(min = 1, max = 10)
    private String status;
    @NotNull
    @Max(Order.MAX_VAL)
    @Min(Order.MIN_VAL)
    private Integer payType;

    public Order toOrder() {
        return Order.builder().id(id).status(status).payType(payType).build();
    }
}
