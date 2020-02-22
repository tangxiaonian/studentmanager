package com.tang.studentmanager.service;

import com.tang.studentmanager.domain.SysStudent;
import com.tang.studentmanager.dto.ResponseResult;

/**
 * @Classname SysStudentService
 * @Description [ TODO ]
 * @Author Tang
 * @Date 2020/2/22 9:42
 * @Created by ASUS
 */
public interface SysStudentService extends BaseService<SysStudent> {
    SysStudent login(String username, String password);
}
