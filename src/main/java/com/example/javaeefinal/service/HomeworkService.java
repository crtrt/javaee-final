package com.example.javaeefinal.service;

import com.example.javaeefinal.mapper.*;
import com.example.javaeefinal.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class HomeworkService  {
    @Autowired
    private HomeworkMapper mapper;

    @Transactional
    public List<Homework> selectHomework(){
        return mapper.selectHomework();
    }

    @Transactional
    public void addStudentHomework(Homework hw){
        mapper.addStudentHomework(hw);
    }
}
