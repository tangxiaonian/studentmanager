package com.tang.studentmanager.service.impl;

import com.tang.studentmanager.domain.SysAdmin;
import com.tang.studentmanager.domain.SysTeacher;
import com.tang.studentmanager.mapper.SysAdminMapper;
import com.tang.studentmanager.service.SysAdminService;
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
public class SysAdminServiceImpl extends BaseServiceImpl<SysAdmin, SysAdminMapper> implements SysAdminService {

    @Resource
    private SysAdminMapper sysAdminMapper;

    @Override
    public SysAdmin login(SysAdmin sysAdmin) {

        Example example = new Example(SysAdmin.class);

        example.createCriteria().andEqualTo("username", sysAdmin.getUsername())
                .andEqualTo("password", sysAdmin.getPassword());

        return sysAdminMapper.selectOneByExample(example);
    }
}