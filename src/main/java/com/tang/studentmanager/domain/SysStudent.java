package com.tang.studentmanager.domain;

import java.util.Date;
import javax.persistence.*;
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

    @Column(name = "createTime")
    private Date createtime;

    @Column(name = "birthday")
    private Date birthday;

    /**
     * 班级id
     */
    @Column(name = "course_id")
    private Integer courseId;
}