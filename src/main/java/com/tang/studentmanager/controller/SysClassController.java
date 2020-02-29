package com.tang.studentmanager.controller;

import com.tang.studentmanager.domain.SysClass;
import com.tang.studentmanager.dto.PageBean;
import com.tang.studentmanager.dto.ResponseResult;
import com.tang.studentmanager.service.SysClassService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @Classname SysClassController
 * @Description [ TODO ]
 * @Author Tang
 * @Date 2020/2/25 15:07
 * @Created by ASUS
 */
@RequestMapping("/class")
@RestController
public class SysClassController {


    @Value("${spring.upload.path}")
    private String uploadPath;

    @Resource
    private SysClassService sysClassServiceImpl;

    /**
     * 查询所有课程
     * @param currentPage
     * @return
     */
    @GetMapping("/all")
    public PageBean<SysClass> getClassAll(Integer currentPage){

        return sysClassServiceImpl.getClassAll(currentPage);
    }

    /***
     *@methodName updateInfo
     *@description [ 更新 ]
     *@date 2020/2/29 14:25
     *@param [sysClass]
     *@return
     **/
    @PostMapping(value = "/update/info")
    public ResponseResult<Boolean> updateInfo(@RequestBody SysClass sysClass) {

        return ResponseResult.Ok(200, "成功!", sysClassServiceImpl.updateInfo(sysClass));

    }


    /***
     *@methodName getCourseIdClass
     *@description [ 根据班级id,获取班级的课表 ]
     *@date 2020/2/25 17:29
     *@param [courseId]
     *@return
     **/
    @GetMapping("/coruseId")
    public ResponseResult<List<SysClass>> getCourseIdClass(@RequestParam("courseId") Integer courseId){
        return ResponseResult.Ok(200, "成功!", sysClassServiceImpl.getCourseIdClass(courseId));
    }
    /***
     *@methodName getClassTeacher
     *@description [ 获取课程对应的老师列表 ]
     *@date 2020/2/25 17:29
     *@param []
     *@return
     **/
    @GetMapping("/teacher")
    public ResponseResult<List<SysClass>> getClassTeacher() {
        return ResponseResult.Ok(200, "成功!", sysClassServiceImpl.getClassTeacher());
    }

    /***
     *@methodName getStudentClass
     *@description [ 根据学生id,获取学生的课程列表 ]
     *@date 2020/2/25 23:17
     *@param [studentId]
     *@return
     **/
    @GetMapping("/student")
    public ResponseResult<List<SysClass>> getStudentClass(Integer studentId) {
        return ResponseResult.Ok(200, "成功!", sysClassServiceImpl.getStudentClass(studentId));
    }

    /***
     *@methodName getStudentNoSelectedClass
     *@description [ 获取当前学生没有选择的课程 ]
     *@date 2020/2/25 23:56
     *@param [studentId]
     *@return
     **/
    @GetMapping("/noClass")
    public ResponseResult<PageBean<SysClass>> getStudentNoSelectedClass(Integer studentId, Integer currentPage) {
        return ResponseResult.Ok(200, "成功!", sysClassServiceImpl.getStudentNoSelectedClass(studentId,currentPage));
    }

    /***
     *@methodName addClass
     *@description [ 添加课程 ]
     *@date 2020/2/27 14:33
     *@param [sysClass]
     *@return
     **/
    @PostMapping("/add")
    public ResponseResult<Boolean> addClass(@RequestPart("file")MultipartFile multipartFile,
                                            SysClass sysClass){

        System.out.println( sysClass );

        Optional<MultipartFile> multipartFileOptional = Optional.ofNullable(multipartFile);

        // 默认图片
        sysClass.setCover("https://element.eleme.cn/static/resource.a72b8f8.png");

        multipartFileOptional.ifPresent((item -> {

            String suffix = multipartFile.getOriginalFilename().split("\\.")[1];

            String fileName = UUID.randomUUID().toString().replaceAll("-", "") + "." + suffix;

            try {
                multipartFile.transferTo(new File(uploadPath + "/" + fileName));
            } catch (IOException e) {
                e.printStackTrace();
            }

            sysClass.setCover("http://localhost:8081/upload/"+fileName);

        }));

        return ResponseResult.Ok(200, "成功!", sysClassServiceImpl.addClass(sysClass));
    }

    /***
     *@methodName deleteClass
     *@description [ 根据课程id,删除课程 ]
     *@date 2020/2/27 14:19
     *@param [classId]
     *@return
     **/
    @GetMapping("/delete")
    public ResponseResult<Boolean> deleteClass(Integer classId) {
        return ResponseResult.Ok(200, "成功!", sysClassServiceImpl.deleteClass(classId));
    }

    /**
     * 根据教师id 获取对应的教师课程
     * @param teacherId
     * @return
     */
    @GetMapping("/teacherId")
    public ResponseResult<List<SysClass>> getClassByTeacherId(Integer teacherId) {
        return ResponseResult.Ok(200, "成功!", sysClassServiceImpl.getClassByTeacherId(teacherId));
    }

}