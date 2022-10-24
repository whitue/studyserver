package com.lq.ita.study.req;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.lq.ita.study.endity.Student;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateStudentReq {
    @NotNull
    private Integer id;
    @NotNull
    private String name;
    @NotNull
    @Max(Student.MAX_AGE)
    @Min(Student.MIN_AGE)
    private Integer age;
    @NotNull
    private String address;

    public Student toStudent() {
        return Student.builder().id(id).name(name).age(age).address(address).build();
    }
}
