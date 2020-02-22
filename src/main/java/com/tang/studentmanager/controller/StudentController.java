package com.tang.studentmanager.controller;

import com.tang.studentmanager.domain.SysStudent;
import com.tang.studentmanager.dto.ResponseResult;
import com.tang.studentmanager.service.SysStudentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Classname StudentController
 * @Description [ TODO ]
 * @Author Tang
 * @Date 2020/2/22 10:04
 * @Created by ASUS
 */
@RestController
@RequestMapping("/student")
public class StudentController {


    @Resource
    private SysStudentService sysStudentServiceImpl;

    @PostMapping("/login")
    public ResponseResult<SysStudent> login(String username, String password) {
        return ResponseResult.Ok(200, "成功!", sysStudentServiceImpl.login(username, password));
    }

}