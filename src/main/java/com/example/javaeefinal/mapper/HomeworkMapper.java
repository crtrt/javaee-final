package com.example.javaeefinal.mapper;

import com.example.javaeefinal.mapper.*;
import com.example.javaeefinal.model.*;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface HomeworkMapper {


    /*
     查看老师布置的的所有作业Homework
      */
    @Select("SELECT * FROM s_homework")
    List<Homework> selectHomework();

    /*
    添加作业Homework
    */
    @Insert("INSERT INTO s_homework(id,title,content,create_time,total_score) VALUES (null,#{title},#{content},#{create_time},#{total_score})")
    void addStudentHomework(Homework hw) ;


}
