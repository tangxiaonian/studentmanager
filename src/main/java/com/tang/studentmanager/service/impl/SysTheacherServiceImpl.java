package com.tang.studentmanager.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tang.studentmanager.domain.SysTeacher;
import com.tang.studentmanager.dto.PageBean;
import com.tang.studentmanager.mapper.SysTheacherMapper;
import com.tang.studentmanager.service.SysTheacherService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @Classname SysUserServiceImpl
 * @Description [ TODO ]
 * @Author Tang
 * @Date 2020/2/22 9:42
 * @Created by ASUS
 */
@Service
public class SysTheacherServiceImpl extends BaseServiceImpl<SysTeacher, SysTheacherMapper> implements SysTheacherService {

    @Resource
    private SysTheacherMapper sysTheacherMapperImpl;

    @Override
    public PageBean<SysTeacher> getTheacherAll(Integer currentPage, Integer courseId, String username) {

        PageHelper.startPage(currentPage, 5);

        List<SysTeacher> list = sysTheacherMapperImpl.getTheacherAll(courseId,username);

        PageInfo<SysTeacher> pageInfo = new PageInfo<>(list);

        PageBean<SysTeacher> pageBean = new PageBean<>();

        pageBean.setData(pageInfo.getList());

        pageBean.setTotal(Long.valueOf(pageInfo.getTotal()).intValue());

        pageBean.setPages( pageInfo.getPages() );

        return pageBean;
    }


    @Override
    public SysTeacher login(SysTeacher sysTeacher) {

        Example example = new Example(SysTeacher.class);

        example.createCriteria().andEqualTo("username", sysTeacher.getUsername())
                .andEqualTo("password", sysTeacher.getPassword());

        return sysTheacherMapperImpl.selectOneByExample(example);
    }

    @Override
    public Boolean updateInfo(SysTeacher sysTeacher) {

        Example example = new Example(SysTeacher.class);

        example.createCriteria().andEqualTo("id", sysTeacher.getId());

        return sysTheacherMapperImpl.updateByExampleSelective(sysTeacher,example) > 0;
    }

    @Override
    public Boolean teacherAdd(SysTeacher sysTeacher) {

        sysTeacher.setAvatar("https://element.eleme.cn/static/resource.a72b8f8.png");

        sysTeacher.setCreatetime(new Date());

        sysTeacher.setMake("暂无...");

        return sysTheacherMapperImpl.insert(sysTeacher) > 0;
    }

    @Override
    public Boolean deleteTeacher(Integer id) {

        return sysTheacherMapperImpl.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public Boolean deleteTeacherByCourseId(Integer id) {

        Example example = new Example(SysTeacher.class);

        example.createCriteria().andEqualTo("courseId", id);

        return sysTheacherMapperImpl.deleteByExample(example) > 0;
    }
}