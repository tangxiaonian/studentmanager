package com.tang.studentmanager.controller;

import com.tang.studentmanager.domain.Notice;
import com.tang.studentmanager.dto.ResponseResult;
import com.tang.studentmanager.service.NoticeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Classname NoticeController
 * @Description [ TODO ]
 * @Author Tang
 * @Date 2020/2/27 15:46
 * @Created by ASUS
 */
@RestController
@RequestMapping("/notice")
public class NoticeController {

    @Resource
    public NoticeService noticeServiceImpl;

    @GetMapping("add")
    public ResponseResult<Boolean> addNotice(String content) {

        return ResponseResult.Ok(200, "success!", noticeServiceImpl.addNotice(content) > 0);
    }

    @GetMapping("/get")
    public ResponseResult<Notice> getNotice() {
        return ResponseResult.Ok(200, "success!", noticeServiceImpl.getNotice());
    }

}