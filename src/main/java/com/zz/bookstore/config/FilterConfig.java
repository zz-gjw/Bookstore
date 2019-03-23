package com.zz.bookstore.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

/**
 * @Author : zz-gjw
 * @Date : 2019/3/21 17:05
 * @Description:
 */
@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean createFilter(){
        FilterRegistrationBean filterRegistrationBean=new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new CrosFilter());
        ArrayList<String> list=new ArrayList<>();
        list.add("/*");
        filterRegistrationBean.setUrlPatterns(list);
        return filterRegistrationBean;
    }
}
