package com.tang.studentmanager.domain;

import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "sys_admin")
public class SysAdmin extends BaseDomain{
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "`password`")
    private String password;

    @Column(name = "sex")
    private Integer sex;

    @Column(name = "createTime")
    private Date createtime;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "make")
    private String make;

    @Column(name = "birthday")
    private Date birthday;

}