package com.lq.ita.study.endity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    public static final int MAX_AGE = 60;
    public static final int MIN_AGE = 3;
    private int id;
    private String name;
    private int age;
    private String address;
}
