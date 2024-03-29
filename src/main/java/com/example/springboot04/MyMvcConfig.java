package com.example.springboot04;

import com.example.springboot04.config.LoginHandlerInterceptor;
import com.example.springboot04.config.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        //super.addViewControllers(registry);
//        registry.addViewController("/").setViewName("index");
//        registry.addViewController("index").setViewName("index");
//        registry.addViewController("main").setViewName("dashboard");
//    }
//
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//      //  super.addInterceptors(registry);
//                                                               //拦截所有请求
//        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
//                //除那些请求之外
//                .excludePathPatterns("/","index","login");
//    }


    //所有的WebMvcConfigurerAdapter组件都会一起起作用
    @Bean //将组件注册在容器
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                        registry.addViewController("/").setViewName("index");
                        registry.addViewController("index").setViewName("index");
                         registry.addViewController("main").setViewName("dashboard");
            }

            //注册拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                //super.addInterceptors(registry);
                //静态资源；  *.css , *.js
                //SpringBoot已经做好了静态资源映射
                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                        .excludePathPatterns("/index","/","/login");
            }
        };
        return adapter;
    }


    @Bean
    public LocaleResolver localeResolver(){
        return  new MyLocaleResolver();
    }


}
