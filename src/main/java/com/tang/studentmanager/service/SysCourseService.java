package com.tang.studentmanager.service;

import com.tang.studentmanager.domain.SysCourse;

import java.util.List;

/**
 * @Classname SysCourseService
 * @Description [ TODO ]
 * @Author Tang
 * @Date 2020/2/27 10:05
 * @Created by ASUS
 */
public interface SysCourseService extends BaseService<SysCourse> {

    public List<SysCourse> getAllList();

    Boolean courseAdd(SysCourse sysCourse);

    Boolean deleteCourse(Integer id);

    Boolean updateInfo(SysCourse sysCourse);


}