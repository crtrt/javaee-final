package com.example.javaeefinal.mapper;

import com.example.javaeefinal.mapper.*;
import com.example.javaeefinal.model.*;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TeacherMapper {

    /*
    教师登录
     */
    @Select("SELECT * FROM s_teacher where id=#{id} and psw=#{psw}" )
    List<Teacher> teacherLogin(Teacher sh);

    /*
   添加教师
 */
    @Insert("INSERT INTO s_teacher(id,name,create_time,psw) VALUES (#{id},#{name},#{create_time},#{psw})")
    void teacherRegister(Teacher sh);
}
