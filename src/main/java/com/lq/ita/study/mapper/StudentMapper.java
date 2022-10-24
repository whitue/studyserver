package com.lq.ita.study.mapper;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import com.lq.ita.study.endity.Student;

@Mapper
@Repository
public interface StudentMapper {

    @Insert("insert into t_student(name,age,address) values(#{name},#{age},#{address})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Student student);

    @Delete("delete from t_student where id=#{id}")
    int delete(Integer id);

    @Update("update t_student set name=#{name},age=#{age},address=#{address} where id=#{id}")
    int update(Student student);

    @Select("select * from t_student where id=#{id}")
    Student selectById(Integer id);
}
