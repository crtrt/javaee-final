package com.example.javaeefinal.service;

import com.example.javaeefinal.mapper.*;
import com.example.javaeefinal.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TeacherService {
    @Autowired
    private TeacherMapper mapper;
    @Transactional
    public List<Teacher> teacherLogin(Teacher t){
        return mapper.teacherLogin(t);
    }
}
