package com.tang.studentmanager.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tang.studentmanager.domain.SysElective;
import com.tang.studentmanager.dto.PageBean;
import com.tang.studentmanager.mapper.SysElectiveMapper;
import com.tang.studentmanager.service.SysElectiveService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Classname SysElectiveServiceImpl
 * @Description [ TODO ]
 * @Author Tang
 * @Date 2020/2/25 15:37
 * @Created by ASUS
 */
@Service
public class SysElectiveServiceImpl extends BaseServiceImpl<SysElective, SysElectiveMapper> implements SysElectiveService {

    @Resource
    SysElectiveMapper sysElectiveMapper;

    @Override
    public PageBean<SysElective> getStudentScoreById(Integer studentId, Integer currentPage,
                                                     String className,Integer startScore,Integer endScore) {

        PageHelper.startPage(currentPage, 5);

        List<SysElective> list = sysElectiveMapper.getStudentScoreById(studentId,className,startScore,endScore);

        PageInfo<SysElective> pageInfo = new PageInfo<>(list);

        PageBean<SysElective> pageBean = new PageBean<>();

        pageBean.setData(pageInfo.getList());

        pageBean.setTotal(Long.valueOf(pageInfo.getTotal()).intValue());

        pageBean.setPages( pageInfo.getPages() );

        return pageBean;
    }


    @Override
    public PageBean<SysElective> getStudentScoreByTeacherId(Integer teacherId, Integer currentPage, String studentName,
                                                        String courseName, Integer startScore, Integer endScore) {

        PageHelper.startPage(currentPage, 5);

        List<SysElective> list = sysElectiveMapper.getStudentScoreByTeacherId(teacherId,studentName,courseName,startScore,endScore);

        PageInfo<SysElective> pageInfo = new PageInfo<>(list);

        PageBean<SysElective> pageBean = new PageBean<>();

        pageBean.setData(pageInfo.getList());

        pageBean.setTotal(Long.valueOf(pageInfo.getTotal()).intValue());

        pageBean.setPages( pageInfo.getPages() );

        return pageBean;
    }

    @Override
    public PageBean<SysElective> getStudentScoreByCourseId(Integer courseId, Integer currentPage,
                                                           String studentName, String courseName,
                                                           Integer startScore, Integer endScore) {

        PageHelper.startPage(currentPage, 5);

        List<SysElective> list = sysElectiveMapper.getStudentScoreByCourseId(courseId,studentName,courseName,startScore,endScore);

        PageInfo<SysElective> pageInfo = new PageInfo<>(list);

        PageBean<SysElective> pageBean = new PageBean<>();

        pageBean.setData(pageInfo.getList());

        pageBean.setTotal(Long.valueOf(pageInfo.getTotal()).intValue());

        pageBean.setPages( pageInfo.getPages() );

        return pageBean;
    }

    @Override
    public Boolean studentJoinClass(SysElective sysElective) {
        return sysElectiveMapper.insert(sysElective) > 0;
    }

    @Override
    public Boolean updateStudentScore(SysElective sysElective) {

        Example example = new Example(SysElective.class);

        example.createCriteria().andEqualTo("id", sysElective.getId());

        return sysElectiveMapper.updateByExampleSelective(sysElective,example) > 0;

    }

    @Override
    public Boolean deleteStudentScore(Integer id) {
        return sysElectiveMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public Boolean deleteStudentScoreCourseId(Integer id) {

        Example example = new Example(SysElective.class);

        example.createCriteria().andEqualTo("courseId", id);

        return sysElectiveMapper.deleteByExample(example) > 0;
    }

    @Override
    public Boolean deleteStudentScoreByStudentId(Integer studentId) {

        Example example = new Example(SysElective.class);

        example.createCriteria().andEqualTo("studentId", studentId);

        return sysElectiveMapper.deleteByExample(example) > 0;
    }

    @Override
    public Boolean addStudentScore(SysElective sysElective) {
        return sysElectiveMapper.insert(sysElective) > 0;
    }

    @Override
    public Boolean deleteElectiveScoreByClassId(Integer classId) {

        return sysElectiveMapper.deleteElectiveScoreByClassId(classId) > 0;
    }
}