package com.example.javaeefinal.mapper;

import com.example.javaeefinal.mapper.*;
import com.example.javaeefinal.model.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TeacherMapper {

    /*
    教师登录
     */
    @Select("SELECT * FROM s_teacher where id=#{id} and psw=#{psw}" )
    public  List<Teacher> teacherLogin(Teacher sh);

}
