package com.tang.studentmanager.service.impl;

import com.tang.studentmanager.domain.SysStudent;
import com.tang.studentmanager.dto.ResponseResult;
import com.tang.studentmanager.mapper.SysStudentMapper;
import com.tang.studentmanager.service.SysStudentService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;

/**
 * @Classname SysUserServiceImpl
 * @Description [ TODO ]
 * @Author Tang
 * @Date 2020/2/22 9:42
 * @Created by ASUS
 */
@Service
public class SysStudentServiceImpl extends BaseServiceImpl<SysStudent, SysStudentMapper> implements SysStudentService {

    @Resource
    private SysStudentMapper sysStudentMapper;

    @Override
    public SysStudent login(String username, String password) {

        Example example = new Example(SysStudent.class);

        example.createCriteria().andEqualTo("username", username)
                .andEqualTo("password", password);

        return sysStudentMapper.selectOneByExample(example);

    }
}