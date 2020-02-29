package com.tang.studentmanager.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tang.studentmanager.domain.SysStudent;
import com.tang.studentmanager.domain.SysTeacher;
import com.tang.studentmanager.dto.PageBean;
import com.tang.studentmanager.mapper.SysStudentMapper;
import com.tang.studentmanager.service.SysElectiveService;
import com.tang.studentmanager.service.SysStudentService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.time.LocalDate;
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
public class SysStudentServiceImpl extends BaseServiceImpl<SysStudent, SysStudentMapper> implements SysStudentService {

    @Resource
    private SysStudentMapper sysStudentMapper;

    @Resource
    private SysElectiveService sysElectiveServiceImpl;

    @Override
    public SysStudent login(SysStudent sysStudent) {

        Example example = new Example(SysStudent.class);

        example.createCriteria().andEqualTo("username", sysStudent.getUsername())
                .andEqualTo("password", sysStudent.getPassword());

        return sysStudentMapper.selectOneByExample(example);

    }

    @Override
    public Boolean deleteStudent(Integer id) {

        sysElectiveServiceImpl.deleteStudentScoreByStudentId(id);

        return sysStudentMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public Boolean deleteStudentByCourseId(Integer id) {

        Example example = new Example(SysTeacher.class);

        example.createCriteria().andEqualTo("courseId", id);

        return sysStudentMapper.deleteByExample(example) > 0;
    }

    @Override
    public Boolean updateInfo(SysStudent sysStudent) {

        Example example = new Example(SysStudent.class);

        example.createCriteria().andEqualTo("id", sysStudent.getId());

        return sysStudentMapper.updateByExampleSelective(sysStudent,example) > 0;
    }

    @Override
    public PageBean <SysStudent> getStudentAll(Integer currentPage,Integer courseId,
                                               String username, String startDate,String endDate) {

        PageHelper.startPage(currentPage, 5);

        List<SysStudent> list = sysStudentMapper.getStudentAll(courseId,username,startDate,endDate);

        PageInfo<SysStudent> pageInfo = new PageInfo<>(list);

        PageBean<SysStudent> pageBean = new PageBean<>();

        pageBean.setData(pageInfo.getList());

        pageBean.setTotal(Long.valueOf(pageInfo.getTotal()).intValue());

        pageBean.setPages( pageInfo.getPages() );

        return pageBean;

    }

    @Override
    public Boolean studentAdd(SysStudent sysStudent) {

        sysStudent.setAvatar("https://element.eleme.cn/static/resource.a72b8f8.png");

        sysStudent.setCreatetime(new Date());

        sysStudent.setMake("暂无...");

        return sysStudentMapper.insert(sysStudent) > 0;
    }
}