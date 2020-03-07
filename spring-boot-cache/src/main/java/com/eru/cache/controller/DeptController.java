package com.eru.cache.controller;

import com.eru.cache.bean.Department;
import com.eru.cache.bean.Employee;
import com.eru.cache.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by eru on 2020/3/7.
 */
@RequestMapping("dept")
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @GetMapping("{id}")
    public Department get(@PathVariable("id")Integer id){
        return deptService.get(id);
    }
}
