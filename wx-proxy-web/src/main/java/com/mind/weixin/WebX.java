package com.mind.weixin;

import ch.qos.logback.classic.ViewStatusMessagesServlet;
import org.springframework.boot.autoconfigure.web.MultipartProperties;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.filter.CharacterEncodingFilter;

import java.nio.charset.Charset;

/**
 * Created by serv on 2014/11/19.
 */
@Configuration
public class WebX extends SpringBootServletInitializer{

    @Bean
    public MultipartProperties multipartProperties(){
        MultipartProperties multipartProperties = new MultipartProperties();
        multipartProperties.setMaxFileSize("10Mb");
        multipartProperties.setMaxRequestSize("15Mb");
        return multipartProperties;
    }


    @Bean(name = "charsetEncodingFilter")
    public FilterRegistrationBean charsetEncodingFilter(){
        FilterRegistrationBean filterRegistrationBean =  new FilterRegistrationBean();
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        filterRegistrationBean.setFilter(characterEncodingFilter);
        return filterRegistrationBean;
    }

    @Bean
    public StringHttpMessageConverter stringHttpMessageConverter(){
        return new StringHttpMessageConverter(Charset.forName("utf-8"));
    }

    @Bean
    public ServletRegistrationBean logServlet() {
        ServletRegistrationBean registration = new ServletRegistrationBean();
        registration.setServlet(new ViewStatusMessagesServlet());
        registration.addUrlMappings("/logback");
        registration.setName("ViewStatusMessages");
        return registration;
    }


    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }
}
