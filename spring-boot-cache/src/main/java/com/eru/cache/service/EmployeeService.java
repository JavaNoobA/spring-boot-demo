package com.eru.cache.service;

import com.eru.cache.bean.Employee;

/**
 * 员工接口
 * Created by eru on 2020/3/7.
 */
public interface EmployeeService {

    /**
     * 查询
     * @param id 员工id
     * @return emp
     */
    Employee get(Integer id);

    /**
     * 更新员工信息
     * @param employee 员工
     * @return 结果
     */
    Employee update(Employee employee);

    /**
     * 删除员工
     * @param id 员工id
     */
    void delete(Integer id);

    /**
     * 根据lastName查询员工信息
     * @param lastName 姓名
     * @return 结果
     */
    Employee getByLastName(String lastName);
}
