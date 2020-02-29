package com.tang.studentmanager.dto;

import lombok.Data;

import java.util.List;

/**
 * @Classname PageBean
 * @Description [ TODO ]
 * @Author Tang
 * @Date 2020/2/25 18:17
 * @Created by ASUS
 */
@Data
public class PageBean<T> {

    // 当前页
    private Integer currentPage;
    // 总记录数
    private Integer total;
    // 每页的大小
    private Integer pageSize;
    // 总页数
    private Integer pages;
    // 结果集
    private List<T> data;

    private String message;

    private Integer status;

}