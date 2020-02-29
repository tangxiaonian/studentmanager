package com.tang.studentmanager.service;

import com.tang.studentmanager.domain.SysAdmin;

/**
 * @Classname SysStudentService
 * @Description [ TODO ]
 * @Author Tang
 * @Date 2020/2/22 9:42
 * @Created by ASUS
 */
public interface SysAdminService extends BaseService<SysAdmin> {

    SysAdmin login(SysAdmin sysAdmin);

}
