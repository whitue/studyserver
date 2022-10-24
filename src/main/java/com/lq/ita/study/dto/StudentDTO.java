package com.lq.ita.study.dto;

import com.lq.ita.study.endity.Student;
import com.lq.ita.study.exception.BussinessException;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
    private Integer id;
    private String name;
    private Integer age;
    private String address;

    public static StudentDTO from(Student student) {
        if (null == student) {
            throw new BussinessException("empty student info");
        }
        return StudentDTO.builder().id(student.getId()).name(student.getName()).age(student.getAge())
            .address(student.getAddress()).build();
    }
}
