package com.example.springboot04.config;


import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;


public class MyLocaleResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        //获取参数列表的参数
        String lang = request.getParameter("lang");
        //获取默认的语言信息
        Locale locale = Locale.getDefault();
        //判断参数列表的数据是否为空
        if(!StringUtils.isEmpty(lang)){
            //把参数以_分割 前为 语言信息，后为国家信息
            String[] split = lang.split("_");
            locale = new Locale(split[0],split[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
