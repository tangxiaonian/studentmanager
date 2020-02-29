package com.tang.studentmanager.mapper;

import com.tang.studentmanager.domain.SysStudent;
import tk.mybatis.mapper.MyMapper;

import java.util.List;

public interface SysStudentMapper extends MyMapper<SysStudent> {

    public List<SysStudent> getStudentAll(Integer courseId,
                                          String username, String startDate,
                                          String endDate);

}