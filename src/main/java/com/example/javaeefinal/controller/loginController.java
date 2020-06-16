package com.example.javaeefinal.controller;

import com.example.javaeefinal.service.*;
import com.example.javaeefinal.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.Timestamp;
import java.util.Date;


@Controller
public class loginController {
    @Autowired
    private final StudentHomeworkService studentHomeworkService;
    @Autowired
    private final StudentService studentService;
    @Autowired
    private final HomeworkService homeworkService;
    @Autowired
    private final TeacherService teacherService;


    public loginController(StudentHomeworkService studentHomeworkService, StudentService studentService, HomeworkService homeworkService, TeacherService teacherService) {
        this.studentHomeworkService = studentHomeworkService;
        this.studentService = studentService;
        this.homeworkService = homeworkService;
        this.teacherService = teacherService;
    }

    @RequestMapping("/index")
    public String index(){
        return "index";
    }


    @RequestMapping(value="/teacherLogin", method = RequestMethod.POST)
    public String teacherLogin(@ModelAttribute Teacher t){
        System.out.println(teacherService.teacherLogin(t));
        if(!teacherService.teacherLogin(t).isEmpty()){
            System.out.println("login successfully");
            return  "redirect:/readHomework";
        }else{
            System.out.println("login fail");
            return  "redirect:/index";
        }
    }


    @RequestMapping(value="/studentLogin", method = RequestMethod.POST)
    public String studentLogin(@ModelAttribute Student s, RedirectAttributes redirectAttributes){

        System.out.println(studentService.studentLogin(s));

        if(!studentService.studentLogin(s).isEmpty()){

            System.out.println("login successfully");

            redirectAttributes.addFlashAttribute("stuId", s.getId());

            return  "redirect:/subHomework";
        }else{

            System.out.println("login fail");

            return  "redirect:/index";
        }

    }
    /**
     * 学生注册
     * @param sh
     * @return
     */

    @RequestMapping(value = "studentRegister",method = RequestMethod.POST)
    public String addStudent(@ModelAttribute Student sh){
        //获取当前时间
        Timestamp now = new Timestamp(new Date().getTime());

        sh.setCreate_time(now);

        studentService.addStudent(sh);

        return  "redirect:/index";
    }
    /**
     * 教师注册
     * @param t
     * @return
     */

    @RequestMapping(value = "teacherRegister",method = RequestMethod.POST)
    public String teacherRegister(@ModelAttribute Teacher t){
        //获取当前时间
        Timestamp now = new Timestamp(new Date().getTime());

        t.setCreate_time(now);

        teacherService.teacherRegister(t);

        return  "redirect:/index";
    }

    @RequestMapping("/register")
    public String register(){
        return "register";
    }



}
