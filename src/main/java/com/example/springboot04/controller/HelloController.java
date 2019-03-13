package com.example.springboot04.controller;

import com.example.springboot04.bean.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
public class HelloController {

//    @RequestMapping({"/","/index.html"})
//    public String index(){
//        return "index";
//    }



    @RequestMapping("/success")
    public String success(Map<String,Object> map){

        map.put("success","成功了！！！！！");
        Person p1 = new Person("齐天大圣孙悟空","1",23);
        Person p2 = new Person("孙悟空","1",23);
        Person p3 = new Person("大圣孙悟空","1",23);
        Person p4 = new Person("齐天","1",23);

        List<Person> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);

        map.put("p",p1);
        map.put("ulist",list);

        map.put("strarr", Arrays.asList("张三","李四","王五","这哈六"));






        return  "success";
    }
}
