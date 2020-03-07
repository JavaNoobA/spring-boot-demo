package com.eru.cache.controller;

import com.eru.cache.bean.Employee;
import com.eru.cache.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by eru on 2020/3/7.
 */
@RequestMapping("emp")
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public Employee update(Employee employee){
        Employee emp = employeeService.update(employee);
        return emp;
    }

    @GetMapping("{id}")
    public Employee get(@PathVariable("id")Integer id){
        return employeeService.get(id);
    }

    @GetMapping("/del/{id}")
    public void delete(@PathVariable("id")Integer id){
        employeeService.delete(id);
    }

    @GetMapping("get")
    public Employee getByLastName(String lastName){
        Employee emp = employeeService.getByLastName(lastName);
        return emp;
    }
}
