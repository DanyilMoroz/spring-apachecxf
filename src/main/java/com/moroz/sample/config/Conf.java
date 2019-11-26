package com.moroz.sample.config;

import com.moroz.sample.SoutService;
import com.moroz.sample.service.Hello;
import com.moroz.sample.service.HelloPortImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Conf {

    @Bean
    public Hello helloPortImpl(){
        return new HelloPortImpl();
    }

    @Bean
    public SoutService soutService(){
        return new SoutService();
    }
}
