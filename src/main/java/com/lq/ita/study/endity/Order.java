package com.lq.ita.study.endity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    public static final int MAX_VAL = 3;
    public static final int MIN_VAL = 1;
    private int id;
    private String status;
    private int payType;
    private Date createTime;
    private Date updateTime;
}
