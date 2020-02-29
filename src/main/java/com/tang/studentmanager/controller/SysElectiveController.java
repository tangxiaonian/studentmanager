package com.tang.studentmanager.controller;

import com.tang.studentmanager.domain.SysElective;
import com.tang.studentmanager.dto.PageBean;
import com.tang.studentmanager.dto.ResponseResult;
import com.tang.studentmanager.service.SysElectiveService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;

/**
 * @Classname SysElectiveController
 * @Description [ 选修表 ]
 * @Author Tang
 * @Date 2020/2/25 15:51
 * @Created by ASUS
 */
@RestController
@RequestMapping("/elective")
public class SysElectiveController {

    @Resource
    private SysElectiveService sysElectiveService;

    /**
     *@methodName getStudentScoreById
     *@description [ 根据学生id 获取学生成绩 ]
     *@date 2020/2/25 17:30
     *@param [studentId]
     *@return
     **/
    @GetMapping("/student_id")
    public ResponseResult<PageBean<SysElective>> getStudentScoreById(
            @RequestParam(value = "className",required = false) String className,
            @RequestParam(value="startScore",required = false) Integer startScore,
            @RequestParam(value = "endScore",required = false) Integer endScore,
            @RequestParam("studentId") Integer studentId,@RequestParam("currentPage") Integer currentPage) {

        return ResponseResult.Ok(200, "success!",
                sysElectiveService.getStudentScoreById(studentId,currentPage,className,startScore,endScore));

    }

    /***
     *@methodName studentJoinClass
     *@description [ 学生加入课程 ]
     *@date 2020/2/26 10:11
     *@param [sysElective]
     *@return
     **/
    @PostMapping("/joinClass")
    public ResponseResult<Boolean> studentJoinClass(@RequestBody SysElective sysElective){

        return  ResponseResult.Ok(200, "success!",sysElectiveService.studentJoinClass(sysElective));
    }

    /**
     * 根据班级 id,获取学生成绩
     * @param courseId
     * @param currentPage
     * @param studentName
     * @param courseName
     * @param startScore
     * @param endScore
     * @return
     */
    @GetMapping("/courseId")
    public ResponseResult<PageBean<SysElective>> getStudentScoreByCourseId(Integer courseId, Integer currentPage,
                                                                           @RequestParam(value = "studentName",required = false)String studentName,
                                                                           @RequestParam(value = "courseName",required = false) String courseName,
                                                                           @RequestParam(value = "startScore",required = false) Integer startScore,
                                                                           @RequestParam(value = "endScore",required = false) Integer endScore){
        return ResponseResult.Ok(200, "success!",
                sysElectiveService.getStudentScoreByCourseId(courseId,currentPage,
                        studentName,courseName,startScore,endScore));
    }

    /**
     * 根据老师id，获取老师教授课程的学生分数
     * @param teacherId
     * @param currentPage
     * @param studentName
     * @param courseName
     * @param startScore
     * @param endScore
     * @return
     */
    @GetMapping("/teacherId")
    public ResponseResult<PageBean<SysElective>> getStudentScoreByTeacherId(Integer teacherId, Integer currentPage,
                                                                            @RequestParam(value = "studentName",required = false) String studentName,
                                                                            @RequestParam(value = "courseName",required = false) String courseName,
                                                                            @RequestParam(value = "startScore",required = false) Integer startScore,
                                                                            @RequestParam(value = "endScore",required = false) Integer endScore) {
        return ResponseResult.Ok(200, "success!",
                sysElectiveService.getStudentScoreByTeacherId(teacherId,currentPage,
                        studentName,courseName,startScore,endScore));
    }

    /**
     * 更新成绩
     * @param sysElective
     * @return
     */
    @PostMapping("/updateScore")
    public ResponseResult<Boolean> updateStudentScore(@RequestBody SysElective sysElective) {

        return  ResponseResult.Ok(200, "success!",
                sysElectiveService.updateStudentScore(sysElective));
    }

    /**
     * 删除成绩 通过id
     * @param id
     * @return
     */
    @GetMapping("/deleteRecord")
    public ResponseResult<Boolean> deleteStudentScore(Integer id) {

        return ResponseResult.Ok(200, "success!",
                sysElectiveService.deleteStudentScore(id));
    }


    @PostMapping("/addScore")
    public ResponseResult<Boolean> addStudentScore(@RequestBody SysElective sysElective) {
        return ResponseResult.Ok(200, "success!",
                sysElectiveService.addStudentScore(sysElective));
    }

    /**
     * 删除成绩 通过classId
     * @param classId
     * @return
     */
    @GetMapping("/deleteRecordByClassId")
    public ResponseResult<Boolean> deleteElectiveScoreByClassId(Integer classId) {

        return ResponseResult.Ok(200, "success!",
                sysElectiveService.deleteElectiveScoreByClassId(classId));
    }

}