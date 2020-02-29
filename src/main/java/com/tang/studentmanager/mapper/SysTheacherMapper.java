package com.tang.studentmanager.mapper;

import com.tang.studentmanager.domain.SysTeacher;
import tk.mybatis.mapper.MyMapper;

import java.util.List;

public interface SysTheacherMapper extends MyMapper<SysTeacher> {

    List<SysTeacher> getTheacherAll(Integer courseId, String username);

}