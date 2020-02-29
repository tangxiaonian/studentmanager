package com.tang.studentmanager.controller;

import com.tang.studentmanager.domain.SysStudent;
import com.tang.studentmanager.domain.SysTeacher;
import com.tang.studentmanager.dto.PageBean;
import com.tang.studentmanager.dto.ResponseResult;
import com.tang.studentmanager.service.SysTheacherService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Classname TheacherController
 * @Description [ TODO ]
 * @Author Tang
 * @Date 2020/2/22 10:05
 * @Created by ASUS
 */
@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Resource
    private SysTheacherService sysTheacherServiceImpl;

    @PostMapping("/login")
    public ResponseResult<SysTeacher> login(@RequestBody SysTeacher sysTeacher) {
        return ResponseResult.Ok(200, "成功!", sysTheacherServiceImpl.login(sysTeacher));
    }

    @GetMapping("/all")
    public ResponseResult<PageBean<SysTeacher>> getTheacherAll(Integer currentPage,
                                                              @RequestParam(value = "courseId",required = false) Integer courseId,
                                                              @RequestParam(value = "username",required = false) String username){
        return ResponseResult.Ok(200, "成功!", sysTheacherServiceImpl.getTheacherAll(currentPage,courseId,username));
    }

    @GetMapping("/delete")
    public ResponseResult<Boolean> deleteTeacher(Integer id) {
        return ResponseResult.Ok(200, "成功!", sysTheacherServiceImpl.deleteTeacher(id));
    }

    @PostMapping("/add")
    public ResponseResult<Boolean> teacherAdd(@RequestBody SysTeacher sysTeacher) {
        return ResponseResult.Ok(200, "成功!", sysTheacherServiceImpl.teacherAdd(sysTeacher));
    }

    @PostMapping(value = "/update/info")
    public ResponseResult<Boolean> updateInfo(@RequestBody SysTeacher sysTeacher) {

        return ResponseResult.Ok(200, "成功!", sysTheacherServiceImpl.updateInfo(sysTeacher));

    }

}