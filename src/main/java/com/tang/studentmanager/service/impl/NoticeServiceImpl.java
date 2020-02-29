package com.tang.studentmanager.service.impl;

import com.tang.studentmanager.domain.Notice;
import com.tang.studentmanager.mapper.NoticeMapper;
import com.tang.studentmanager.service.NoticeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Classname NoticeServiceImpl
 * @Description [ TODO ]
 * @Author Tang
 * @Date 2020/2/27 15:48
 * @Created by ASUS
 */
@Service
public class NoticeServiceImpl extends BaseServiceImpl<Notice, NoticeMapper> implements NoticeService {

    @Resource
    private NoticeMapper noticeMapper;

    @Override
    public Integer addNotice(String content) {

        Notice notice = new Notice();

        notice.setContent(content);

        return noticeMapper.insert(notice);
    }

    @Override
    public Notice getNotice() {
        return noticeMapper.getNotice();
    }

}