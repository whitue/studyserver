package com.lq.ita.study.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lq.ita.study.dto.StudentDTO;
import com.lq.ita.study.endity.Student;
import com.lq.ita.study.exception.BussinessException;
import com.lq.ita.study.mapper.StudentMapper;
import com.lq.ita.study.req.AddStudentReq;
import com.lq.ita.study.req.UpdateStudentReq;

@Service
public class StudentService {
    @Autowired
    private StudentMapper studentMapper;

    public StudentDTO add(AddStudentReq addStudentReq) {
        Student student = addStudentReq.toStudent();
        studentMapper.insert(student);
        return StudentDTO.from(student);
    }

    public boolean del(Integer id) {
        studentMapper.delete(id);
        return true;
    }

    public StudentDTO modify(UpdateStudentReq updateStudentReq) {
        Student student = updateStudentReq.toStudent();
        Student exist = innerQuery(student.getId());
        if (null == exist) {
            throw new BussinessException("invalid student id");
        }
        studentMapper.update(student);
        return StudentDTO.from(student);
    }

    public StudentDTO query(Integer id) {
        return StudentDTO.from(innerQuery(id));
    }

    public List<StudentDTO> queryAll() {
        return innerQueryAll().stream().map(student -> StudentDTO.from(student)).collect(Collectors.toList());
    }

    private Student innerQuery(Integer id) {
        return studentMapper.selectById(id);
    }

    private List<Student> innerQueryAll() {
        return studentMapper.selectAll();
    }
}
