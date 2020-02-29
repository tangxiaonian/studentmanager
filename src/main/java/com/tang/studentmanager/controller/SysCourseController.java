package com.tang.studentmanager.controller;

import com.tang.studentmanager.domain.SysCourse;
import com.tang.studentmanager.domain.SysStudent;
import com.tang.studentmanager.dto.ResponseResult;
import com.tang.studentmanager.service.SysCourseService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Classname SysCourseController
 * @Description [ TODO ]
 * @Author Tang
 * @Date 2020/2/27 10:23
 * @Created by ASUS
 */
@RestController
@RequestMapping("/course")
public class SysCourseController {

    @Resource
    private SysCourseService sysCourseServiceImpl;

    @GetMapping("/all")
    public ResponseResult<List<SysCourse>> getAllList() {
        return ResponseResult.Ok(200, "success!", sysCourseServiceImpl.getAllList());
    }

    @PostMapping("/add")
    public ResponseResult<Boolean> courseAdd(@RequestBody SysCourse sysCourse) {
        return ResponseResult.Ok(200, "成功!", sysCourseServiceImpl.courseAdd(sysCourse));
    }

    @GetMapping("/delete")
    public ResponseResult<Boolean> deleteCourse(Integer id) {
        return ResponseResult.Ok(200, "成功!", sysCourseServiceImpl.deleteCourse(id));
    }

    @PostMapping(value = "/update/info")
    public ResponseResult<Boolean> updateInfo(@RequestBody SysCourse sysCourse) {

        return ResponseResult.Ok(200, "成功!", sysCourseServiceImpl.updateInfo(sysCourse));

    }


}