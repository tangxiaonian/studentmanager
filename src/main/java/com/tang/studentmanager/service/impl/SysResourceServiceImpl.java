package com.tang.studentmanager.service.impl;

import com.tang.studentmanager.domain.SysResource;
import com.tang.studentmanager.mapper.SysResourceMapper;
import com.tang.studentmanager.service.SysResourceService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Classname SysResourceServiceImpl
 * @Description [ TODO ]
 * @Author Tang
 * @Date 2020/2/22 17:29
 * @Created by ASUS
 */
@Service
public class SysResourceServiceImpl extends BaseServiceImpl<SysResource, SysResourceMapper> implements SysResourceService {

    @Resource
    private SysResourceMapper sysResourceMapper;

    @Override
    public List<SysResource> getResourceList(Integer type) {

        Example example = new Example(SysResource.class);

        example.createCriteria().andEqualTo("type", type);

        return sysResourceMapper.selectByExample(example);

    }
}