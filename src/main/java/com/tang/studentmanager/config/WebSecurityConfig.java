package com.tang.studentmanager.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;

/**
 * @Classname WebSecurityConfig
 * @Description [ TODO ]
 * @Author Tang
 * @Date 2020/2/22 10:08
 * @Created by ASUS
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 认证
        auth.inMemoryAuthentication()
                .withUser("user")
                .password(bCryptPasswordEncoder.encode("user"))
                .and()
                .withUser("admin")
                .password(bCryptPasswordEncoder.encode("123456"));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // 关闭csrf防护
        http.csrf().disable();

        // 请求授权
        http.authorizeRequests().anyRequest()
                .authenticated();

    }
}