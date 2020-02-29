package com.tang.studentmanager.domain;

import java.util.Date;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
@Table(name = "sys_student")
public class SysStudent {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "`password`")
    private String password;

    @Column(name = "phone")
    private String phone;

    @Column(name = "sex")
    private Integer sex;


    @Column(name = "createTime")
    private Date createtime;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "make")
    private String make;

    /**
     * 班级id
     */
    @Column(name = "course_id")
    private Integer courseId;

    private SysCourse sysCourse;

}