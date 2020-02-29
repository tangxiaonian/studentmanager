package com.tang.studentmanager.service;

import com.tang.studentmanager.domain.SysElective;
import com.tang.studentmanager.dto.PageBean;

/**
 * @Classname SysElectiveService
 * @Description [ TODO ]
 * @Author Tang
 * @Date 2020/2/25 15:37
 * @Created by ASUS
 */
public interface SysElectiveService extends BaseService<SysElective> {

    public PageBean<SysElective> getStudentScoreById(Integer studentId, Integer currentPage,
                                                     String className,Integer startScore,
                                                     Integer endScore);

    public Boolean studentJoinClass(SysElective sysElective);

    public PageBean<SysElective> getStudentScoreByCourseId(Integer courseId, Integer currentPage,String studentName,
                                                           String courseName,Integer startScore, Integer endScore);

    public PageBean<SysElective> getStudentScoreByTeacherId(Integer teacherId, Integer currentPage,String studentName,
                                                        String courseName, Integer startScore, Integer endScore);

    Boolean updateStudentScore(SysElective sysElective);

    Boolean deleteStudentScore(Integer id);

    Boolean deleteStudentScoreByStudentId(Integer id);

    Boolean deleteStudentScoreCourseId(Integer id);

    Boolean addStudentScore(SysElective sysElective);

    /**
     * 删除选修成绩通过课程Id
     * @param classId
     * @return
     */
    Boolean deleteElectiveScoreByClassId(Integer classId);
}