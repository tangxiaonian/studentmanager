package com.tang.studentmanager.service;

import com.tang.studentmanager.domain.SysClass;
import com.tang.studentmanager.dto.PageBean;

import java.util.List;

/**
 * @Classname SysClassService
 * @Description [ TODO ]
 * @Author Tang
 * @Date 2020/2/25 15:05
 * @Created by ASUS
 */
public interface SysClassService extends BaseService<SysClass>{

    public List<SysClass> getCourseIdClass(Integer courseId);

    public List<SysClass> getClassTeacher();

    public List<SysClass> getStudentClass(Integer studentId);

    PageBean<SysClass> getStudentNoSelectedClass(Integer studentId, Integer currentPage);

    public Boolean addClass(SysClass sysClass);

    public Boolean deleteClass(Integer classId);

    /**
     * 根据教师id 获取对应的教师课程
     * @param id
     * @return
     */
    public List<SysClass> getClassByTeacherId(Integer id);

    public PageBean<SysClass> getClassAll(Integer currentPage);

    Boolean updateInfo(SysClass sysClass);
}
