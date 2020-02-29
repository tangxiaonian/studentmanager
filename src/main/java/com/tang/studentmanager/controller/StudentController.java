package com.tang.studentmanager.controller;

import com.tang.studentmanager.domain.SysStudent;
import com.tang.studentmanager.dto.PageBean;
import com.tang.studentmanager.dto.ResponseResult;
import com.tang.studentmanager.service.SysStudentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

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

    @Value("${spring.upload.path}")
    private String uploadPath;

    @Resource
    private SysStudentService sysStudentServiceImpl;

    @PostMapping("/login")
    public ResponseResult<SysStudent> login(@RequestBody SysStudent sysStudent) {
        return ResponseResult.Ok(200, "成功!", sysStudentServiceImpl.login(sysStudent));
    }

    @PostMapping(value = "/update/info_")
    public ResponseResult<Boolean> updateInfo(@RequestBody SysStudent sysStudent) {

        System.out.println( sysStudent );

        return ResponseResult.Ok(200, "成功!", sysStudentServiceImpl.updateInfo(sysStudent));

    }


    @PostMapping(value = "/update/info")
    public ResponseResult<Boolean> updateInfo(@RequestPart("file")MultipartFile multipartFile,
                                              SysStudent sysStudent) {

        Optional<MultipartFile> multipartFileOptional = Optional.ofNullable(multipartFile);

        multipartFileOptional.ifPresent((multipartFile1 -> {

            System.out.println( "文件上传..." );

            String suffix = multipartFile.getOriginalFilename().split("\\.")[1];

            String fileName = UUID.randomUUID().toString().replaceAll("-", "") + "." + suffix;

            try {
                multipartFile.transferTo(new File(uploadPath + "/" + fileName));
            } catch (IOException e) {
                e.printStackTrace();
            }

            sysStudent.setAvatar("http://localhost:8081/upload/"+fileName);
        }));


        return ResponseResult.Ok(200, "成功!", sysStudentServiceImpl.updateInfo(sysStudent));
    }

    @GetMapping("/all")
    public ResponseResult<PageBean<SysStudent>> getStudentAll(Integer currentPage,
                                                              @RequestParam(value = "courseId",required = false) Integer courseId,
                                                              @RequestParam(value = "username",required = false) String username,
                                                              @RequestParam(value = "startBirthday",required = false) String startBirthday,
                                                              @RequestParam(value = "endBirthday",required = false) String endBirthday){

        return ResponseResult.Ok(200, "成功!", sysStudentServiceImpl.getStudentAll(currentPage,courseId,username,startBirthday,endBirthday));
    }

    @GetMapping("/delete")
    public ResponseResult<Boolean> deleteStudent(Integer id) {
        return ResponseResult.Ok(200, "成功!", sysStudentServiceImpl.deleteStudent(id));
    }

    @PostMapping("/add")
    public ResponseResult<Boolean> studentAdd(@RequestBody SysStudent sysStudent) {
        return ResponseResult.Ok(200, "成功!", sysStudentServiceImpl.studentAdd(sysStudent));
    }

}