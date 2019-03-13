package com.example.springboot04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LongController {


    @PostMapping("/login")
    public String login(@RequestParam("username") String  username, @RequestParam("password") String password, Map<String,Object> maps, HttpSession session){

        String str = "";
        //用户名不为空，并且密码为123456 则登陆成功，否则登陆失败
        if(!StringUtils.isEmpty(username) && "123456".equals(password)){

            //登陆成功后把用户名存入session中
            session.setAttribute("user",username);

            //为了防止表单重复 提交需要使用重定向
            str = "redirect:main";
        }else{
            maps.put("msg","用户名或密码错误");
            str = "index";
        }

        return str ;
    }
}
