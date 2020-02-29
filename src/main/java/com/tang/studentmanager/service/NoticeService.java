package com.tang.studentmanager.service;

import com.tang.studentmanager.domain.Notice;

/**
 * @Classname NoticeService
 * @Description [ TODO ]
 * @Author Tang
 * @Date 2020/2/27 15:47
 * @Created by ASUS
 */
public interface NoticeService extends BaseService<Notice> {

    public Integer addNotice(String content);

    Notice getNotice();
}
