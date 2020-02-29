package com.tang.studentmanager.controller;

import com.tang.studentmanager.domain.SysAdmin;
import com.tang.studentmanager.dto.ResponseResult;
import com.tang.studentmanager.service.SysAdminService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Classname AdminController
 * @Description [ TODO ]
 * @Author Tang
 * @Date 2020/2/22 10:04
 * @Created by ASUS
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Resource
    private SysAdminService sysAdminServiceImpl;

    @PostMapping("/login")
    public ResponseResult<SysAdmin> login(@RequestBody SysAdmin sysAdmin) {
        return ResponseResult.Ok(200, "成功!", sysAdminServiceImpl.login(sysAdmin));
    }

}