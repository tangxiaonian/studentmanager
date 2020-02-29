package com.tang.studentmanager.service.impl;

import com.tang.studentmanager.domain.SysCourse;
import com.tang.studentmanager.mapper.SysCourseMapper;
import com.tang.studentmanager.service.SysCourseService;
import com.tang.studentmanager.service.SysElectiveService;
import com.tang.studentmanager.service.SysStudentService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Classname SysCourseServiceImpl
 * @Description [ TODO ]
 * @Author Tang
 * @Date 2020/2/27 10:05
 * @Created by ASUS
 */
@Service
public class SysCourseServiceImpl extends BaseServiceImpl<SysCourse,SysCourseMapper> implements SysCourseService {

    @Resource
    public SysCourseMapper sysCourseMapper;

    @Resource
    private SysElectiveService sysElectiveServiceImpl;

    @Resource
    private SysTheacherServiceImpl sysTheacherServiceImpl;

    @Resource
    private SysStudentService sysStudentServiceImpl;

    @Override
    public List<SysCourse> getAllList() {
        return sysCourseMapper.selectAll();
    }

    @Override
    public Boolean courseAdd(SysCourse sysCourse) {
        return sysCourseMapper.insert(sysCourse) > 0;
    }

    @Override
    public Boolean deleteCourse(Integer id) {

        sysElectiveServiceImpl.deleteElectiveScoreByClassId(id);
        // 删除班级下面的老师
        sysTheacherServiceImpl.deleteTeacherByCourseId(id);

        sysStudentServiceImpl.deleteStudentByCourseId(id);

        return sysCourseMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public Boolean updateInfo(SysCourse sysCourse) {

        Example example = new Example(SysCourse.class);

        example.createCriteria().andEqualTo("id", sysCourse.getId());

        return sysCourseMapper.updateByExampleSelective(sysCourse,example) > 0;
    }
}