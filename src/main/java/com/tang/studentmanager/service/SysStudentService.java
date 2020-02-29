package com.tang.studentmanager.service;

import com.tang.studentmanager.domain.SysStudent;
import com.tang.studentmanager.dto.PageBean;

import java.util.Date;

/**
 * @Classname SysStudentService
 * @Description [ TODO ]
 * @Author Tang
 * @Date 2020/2/22 9:42
 * @Created by ASUS
 */
public interface SysStudentService extends BaseService<SysStudent> {

    SysStudent login(SysStudent sysStudent);

    Boolean deleteStudent(Integer id);

    Boolean updateInfo(SysStudent sysStudent);

    /**
     *@methodName getStudentAll
     *@description [ 获取所有学生信息 ]
     *@date 2020/2/27 16:17
     *@return
     *
     * @param []
     * @param currentPage*/
    public PageBean<SysStudent> getStudentAll(Integer currentPage, Integer courseId,String username, String startDate,String endDate);

    Boolean studentAdd(SysStudent sysStudent);

    Boolean deleteStudentByCourseId(Integer id);

}
