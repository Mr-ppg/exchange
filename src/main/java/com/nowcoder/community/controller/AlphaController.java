package com.nowcoder.community.controller;

import com.nowcoder.community.dao.AlphaDao;
import com.nowcoder.community.service.AlphaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@Controller
@RequestMapping("/alpha")

public class AlphaController {
    @Autowired
    private AlphaService alphaService;

    @RequestMapping("/hello")
    @ResponseBody
    public String sayHello(){
        return "Hello Spring Boot";
    }

    @RequestMapping("/data")
    @ResponseBody
    public String getData(){
        return alphaService.find();
    }

    @RequestMapping("/http")
    public void http(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获取请求数据

        //请求行
        System.out.println(request.getMethod());
        System.out.println(request.getServletPath());

        // 请求的消息头
        Enumeration<String> enumeration = request.getHeaderNames();
        while(enumeration.hasMoreElements()){
            String name = enumeration.nextElement();
            String value = request.getHeader( name);
            System.out.println(name + " :   " + value);
        }
        //请求体 业务数据
        System.out.println(request.getParameter("code"));


        //responce 返回响应数据
        response.setContentType("text/html; charset = utf-8");
        PrintWriter writer = response.getWriter();
        writer.write("<h1>牛客网</h1>");
        writer.close();
    }

    //GET 请求
    // /students?current=1&limit=20

    @RequestMapping(path = "/students", method = RequestMethod.GET)
    @ResponseBody //响应返回

    public String getStudents(
            @RequestParam(name = "current", required = false, defaultValue = "1") int current,
            @RequestParam(name = "limit", required = false, defaultValue = "20") int limit){
        System.out.println("current\t\t\t" + current);
        System.out.println("limit\t\t\t" + limit);
        return "some students";
    }

    // /students/123
    @RequestMapping(path = "/student/{id}", method = RequestMethod.GET)
    @ResponseBody //响应返回
    public String getStudents(@PathVariable("id") int id){
        System.out.println("students   " + id);
        return "a student:  " + id;
    }


    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    //POST请求
    @RequestMapping(path = "/student", method = RequestMethod.POST)
    @ResponseBody
    public String saveStudent(String name, int age){
        System.out.println(name);
        System.out.println(age);
        return "success";
    }

    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    //响应HTML数据
    @RequestMapping(path = "/teacher", method = RequestMethod.GET)
    public ModelAndView getTeacher(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("name", "张三");
        mav.addObject("age", 30);
        mav.setViewName("/demo/view"); //view 指代的是view.html
        return mav;
    }

    @RequestMapping(path = "/school", method = RequestMethod.GET)
    public String getSchool(Model model){

        model.addAttribute("name", "北京大学");
        model.addAttribute("age", 80);

        return "/demo/view";
    }


    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    //响应JSON数据(异步请求) 网页不刷新，悄悄进行访问
    //Java对象 JSON字符串 -> Js对象
    @RequestMapping(path = "/emp", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getEmp(){
        Map<String, Object> emp = new HashMap<>();
        emp.put("name", "张三");
        emp.put("age", 30);
        emp.put("salary", 8000);
        return emp;
    }

    @RequestMapping(path = "/emps", method = RequestMethod.GET)
    @ResponseBody
    public List<Map<String, Object>> getEmps(){
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> emp = new HashMap<>();
        emp.put("name", "张三");
        emp.put("age", 30);
        emp.put("salary", 8000);
        list.add(emp);

        emp = new HashMap<>();
        emp.put("name", "han三");
        emp.put("age", 1230);
        emp.put("salary", 18000);
        list.add(emp);

        emp = new HashMap<>();
        emp.put("name", "de张三");
        emp.put("age", 20);
        emp.put("salary", 128000);
        list.add(emp);

        return list;
    }


}
