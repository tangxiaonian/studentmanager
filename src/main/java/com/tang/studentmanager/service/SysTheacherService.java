package com.tang.studentmanager.service;

import com.tang.studentmanager.domain.SysTeacher;
import com.tang.studentmanager.dto.PageBean;

/**
 * @Classname SysStudentService
 * @Description [ TODO ]
 * @Author Tang
 * @Date 2020/2/22 9:42
 * @Created by ASUS
 */
public interface SysTheacherService extends BaseService<SysTeacher> {

    PageBean<SysTeacher> getTheacherAll(Integer currentPage, Integer courseId, String username);

    Boolean updateInfo(SysTeacher sysTeacher);

    Boolean teacherAdd(SysTeacher sysTeacher);

    Boolean deleteTeacher(Integer id);

    Boolean deleteTeacherByCourseId(Integer id);

    SysTeacher login(SysTeacher sysTeacher);
}
