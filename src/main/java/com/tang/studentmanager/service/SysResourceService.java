package com.tang.studentmanager.service;

import com.tang.studentmanager.domain.SysResource;

import java.util.List;

/**
 * @Classname SysResourceService
 * @Description [ TODO ]
 * @Author Tang
 * @Date 2020/2/22 17:29
 * @Created by ASUS
 */
public interface SysResourceService extends BaseService<SysResource> {
    /***
     *@methodName getResourceList
     *@description [ 获取菜单 ]
     *@date 2020/2/22 17:54
     *@param [type]
     *@return
     **/
    List<SysResource> getResourceList(Integer type);
}
