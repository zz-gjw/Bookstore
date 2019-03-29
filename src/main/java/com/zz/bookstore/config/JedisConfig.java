package com.zz.bookstore.config;



import com.zz.bookstore.common.util.JedisUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *@Author feri
 *@Date Created in 2019/1/16 10:13
 */
@Configuration
public class JedisConfig {
    @Bean
    public JedisUtil creareJedis(){
        return new JedisUtil("120.78.179.189",6379,"960000");
    }
}
