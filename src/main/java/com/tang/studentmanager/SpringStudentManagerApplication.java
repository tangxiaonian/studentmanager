package com.tang.studentmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Classname SpringStudentManagerApplication
 * @Description [ TODO ]
 * @Author Tang
 * @Date 2020/2/21 13:57
 * @Created by ASUS
 */
@MapperScan(basePackages = {"com.tang.studentmanager.mapper"})
@SpringBootApplication
public class SpringStudentManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringStudentManagerApplication.class, args);
    }

}