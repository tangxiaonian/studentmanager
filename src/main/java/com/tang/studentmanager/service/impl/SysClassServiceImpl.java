package com.tang.studentmanager.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tang.studentmanager.domain.SysClass;
import com.tang.studentmanager.domain.SysElective;
import com.tang.studentmanager.domain.SysTeacher;
import com.tang.studentmanager.dto.PageBean;
import com.tang.studentmanager.mapper.SysClassMapper;
import com.tang.studentmanager.mapper.SysElectiveMapper;
import com.tang.studentmanager.service.SysClassService;
import com.tang.studentmanager.service.SysElectiveService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Classname SysClassServiceImpl
 * @Description [ TODO ]
 * @Author Tang
 * @Date 2020/2/25 15:05
 * @Created by ASUS
 */
@Service
public class SysClassServiceImpl implements SysClassService {

    @Resource
    public SysClassMapper sysClassMapper;


    @Resource
    SysElectiveService sysElectiveServiceImpl;


    @Override
    public List<SysClass> getCourseIdClass(Integer courseId) {
        return sysClassMapper.getCourseIdClass(courseId);
    }

    @Override
    public List<SysClass> getClassTeacher() {
        return sysClassMapper.getClassTeacher();
    }

    @Override
    public List<SysClass> getStudentClass(Integer studentId) {
        return sysClassMapper.getStudentClass(studentId);
    }

    @Override
    public PageBean<SysClass> getStudentNoSelectedClass(Integer studentId,Integer currentPage) {

        PageHelper.startPage(currentPage, 5);

        List<SysClass> list = sysClassMapper.getStudentNoSelectedClass(studentId);

        PageInfo<SysClass> pageInfo = new PageInfo<>(list);

        PageBean<SysClass> pageBean = new PageBean<>();

        pageBean.setData(pageInfo.getList());

        pageBean.setTotal(Long.valueOf(pageInfo.getTotal()).intValue());

        pageBean.setPages( pageInfo.getPages() );

        return pageBean;
    }

    @Override
    public PageBean<SysClass> getClassAll(Integer currentPage) {

        PageHelper.startPage(currentPage, 5);

        List<SysClass> list = sysClassMapper.getClassAll(currentPage);

        PageInfo<SysClass> pageInfo = new PageInfo<>(list);

        PageBean<SysClass> pageBean = new PageBean<>();

        pageBean.setData(pageInfo.getList());

        pageBean.setTotal(Long.valueOf(pageInfo.getTotal()).intValue());

        pageBean.setPages( pageInfo.getPages() );

        return pageBean;
    }

    @Override
    public Boolean updateInfo(SysClass sysClass) {

        Example example = new Example(SysClass.class);

        example.createCriteria().andEqualTo("id", sysClass.getId());

        return sysClassMapper.updateByExampleSelective(sysClass,example) > 0;
    }

    @Override
    public Boolean addClass(SysClass sysClass) {
        return sysClassMapper.insert(sysClass) > 0;
    }

    @Override
    public Boolean deleteClass(Integer classId) {

        // 先删除选修这门课的成绩
        sysElectiveServiceImpl.deleteElectiveScoreByClassId(classId);

        return sysClassMapper.deleteByPrimaryKey(classId) > 0;
    }

    @Override
    public List<SysClass> getClassByTeacherId(Integer id) {

        return sysClassMapper.getClassByTeacherId(id);
    }
}