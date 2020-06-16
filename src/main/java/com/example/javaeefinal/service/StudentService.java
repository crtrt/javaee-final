package com.example.javaeefinal.service;

import com.example.javaeefinal.mapper.*;
import com.example.javaeefinal.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class StudentService {
    @Autowired
    private StudentMapper mapper;
    @Transactional
    public List<Student> studentLogin(Student s){
        return mapper.studentLogin(s);
    }
    @Transactional
    public List<Student> selectStudent(){
        return mapper.selectStudent();
    }
    @Transactional
    public void addStudent(Student s){
        mapper.addStudent(s);
    }
}
