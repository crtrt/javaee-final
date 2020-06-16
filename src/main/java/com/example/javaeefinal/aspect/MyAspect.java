package com.example.javaeefinal.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;


import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;


/**
 * aspect:  切面 针对业务
 * Pointcut切点：表达式 execution（）  execution spring aop
 */
@Aspect
@EnableAspectJAutoProxy
@Component
public class MyAspect {

    /**
     * 横切所有controller下的方法
     */

    @Pointcut("execution(* com.example.javaeefinal.controller.*.*(..))")
    public void jdbcPointCut(){}




//    @Before("jdbcPointCut()" )
//    public void beforeJdbc(JoinPoint joinPoint) {
//        System.out.println("********前置通知********");
//        //获取目标方法的参数信息
//        Object[] obj = joinPoint.getArgs();
//        //AOP代理类的信息
//        joinPoint.getThis();
//        //代理的目标对象
//        joinPoint.getTarget();
//        //用的最多 通知的签名
//        Signature signature = joinPoint.getSignature();
//        //代理的是哪一个方法
//        System.out.println("代理的方法: "+signature.getName());
//        //AOP代理类的名字
//        System.out.println("AOP代理类: "+signature.getDeclaringTypeName());
//        //AOP代理类的类（class）信息
//        System.out.println("AOP代理类的类（class）信息: "+signature.getDeclaringType());
//        System.out.println("********前置结束********");
//    }

    //@AfterReturning注解可以获取方法的返回值，returning的值result代表的就是返回值,形参Object类表示
//    @AfterReturning(value="jdbcPointCut()",returning="result")
//    public void afterJdbc(Object result) {
//
//        System.out.println("********后置通知********");
//        System.out.println("result："+result.toString());
//        System.out.println("********后置结束********");
//    }


    @Around("jdbcPointCut()")
    public Object aroundService(ProceedingJoinPoint jp)  {


        Object object = null;

        try{

            System.out.println("#########环绕通知########");

            Signature signature = jp.getSignature();
            RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();//这个RequestContextHolder是Springmvc提供来获得请求的东西
            HttpServletRequest request = ((ServletRequestAttributes)requestAttributes).getRequest();


            System.out.println("目标方法名："+signature.getName());

            System.out.println("AOP代理类: "+signature.getDeclaringTypeName());
            //AOP代理类的类（class）信息
            System.out.println("AOP代理类的类（class）信息: "+signature.getDeclaringType());

            System.out.println("URL : " + request.getRequestURL().toString());

            System.out.println("IP : " + request.getRemoteAddr());

            System.out.println("HTTP_METHOD : " + request.getMethod());

            System.out.println("THE ARGS OF THE Controller : " + Arrays.toString(jp.getArgs()));



            object = jp.proceed();


            System.out.println("事务提交  √");//事务提交

        }catch (Throwable e) {
            e.printStackTrace();
            return null;
        }

        return object;
    }

}
