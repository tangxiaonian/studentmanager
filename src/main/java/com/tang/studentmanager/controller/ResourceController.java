package com.tang.studentmanager.controller;

import com.tang.studentmanager.domain.SysResource;
import com.tang.studentmanager.dto.ResponseResult;
import com.tang.studentmanager.service.SysResourceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Classname ResourceController
 * @Description [ TODO ]
 * @Author Tang
 * @Date 2020/2/22 17:28
 * @Created by ASUS
 */
@RestController
@RequestMapping("/resources")
public class ResourceController {

    @Resource
    private SysResourceService sysResourceServiceImpl;

    @GetMapping("/get")
    public ResponseResult<List<SysResource>> getResourceList(@RequestParam("type") Integer type) {
        return ResponseResult.Ok(200, "success!", sysResourceServiceImpl.getResourceList(type));
    }

}