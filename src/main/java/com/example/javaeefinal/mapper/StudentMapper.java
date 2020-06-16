package com.example.javaeefinal.mapper;

import com.example.javaeefinal.mapper.*;
import com.example.javaeefinal.model.*;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StudentMapper {

    /*
    学生登录
     */
    @Select("SELECT * FROM s_student where id=#{id} and psw=#{psw}" )
    List<Student> studentLogin(Student sh);

    /*
    查看学生列表student
     */
    @Select("SELECT * FROM s_student")
    List<Student> selectStudent();

    /*
   添加学生Student
    */
    @Insert("INSERT INTO s_student(id,name,create_time,psw) VALUES (#{id},#{name},#{create_time},#{psw})")
    void addStudent(Student sh);
}
