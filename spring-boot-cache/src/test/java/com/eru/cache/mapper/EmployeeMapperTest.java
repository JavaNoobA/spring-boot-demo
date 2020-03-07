package com.eru.cache.mapper;

import com.eru.cache.bean.Employee;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class EmployeeMapperTest {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Test
    public void queryById() {
        Employee emp = employeeMapper.queryById(1);
        Assert.assertEquals("zhao", emp.getLastName());
    }

    @Test
    public void deleteById() {
        employeeMapper.deleteById(1);
    }

    @Test
    public void insert() {
        Employee employee = new Employee();
        employee.setEmail("erudev@gmail.com");
        employee.setGender(1);
        employee.setLastName("zhao");
        employee.setdId(1);
        employeeMapper.insert(employee);
    }

    @Test
    public void update() {
        Employee emp = employeeMapper.queryById(1);
        emp.setEmail("erudev2@gmail.com");
        emp.setGender(2);
        emp.setLastName("zhao2");
        emp.setdId(2);
        employeeMapper.update(emp);
        Employee empDb = employeeMapper.queryById(1);
        Assert.assertEquals(empDb.getLastName(), emp.getLastName());
    }
}
