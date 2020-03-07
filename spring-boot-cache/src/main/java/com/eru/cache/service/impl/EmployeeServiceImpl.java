package com.eru.cache.service.impl;

import com.eru.cache.bean.Employee;
import com.eru.cache.mapper.EmployeeMapper;
import com.eru.cache.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

/**
 * cache 相关注解的使用
 * Created by eru on 2020/3/7.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Cacheable(value = {"emp"} /*keyGenerator = "myKeyGenerator"*/)
    @Override
    public Employee get(Integer id) {
        System.out.println("查询" + id + "员工");
        return employeeMapper.queryById(id);
    }

    /**
     * CachePut 更新缓存、也更新数据库, 先调用方法
     * @param employee 员工
     * @return 结果
     */
    @CachePut(value = {"emp"}, key = "#result.id")
    @Override
    public Employee update(Employee employee) {
        System.out.println("update Emp:" + employee);
        employeeMapper.update(employee);
        return employeeMapper.queryById(employee.getId());
    }

    /**
     * CacheEvict: 缓存清楚
     * allEntries: true 清空该键内的 所有缓存
     * beforeInvocation: false 在方法调用之后清除缓存; true，在方法调用之前清除, 比如发生异常
     * @param id 员工id
     */
    @CacheEvict(value = {"emp"}, key = "#id", /*allEntries = true,*/ beforeInvocation = false)
    @Override
    public void delete(Integer id) {
        System.out.println("delete emp:" + id);
        int res = 10/0;
        //employeeMapper.deleteById(id);
    }

    /**
     * caching: 组合注解, 比如调用了这个方法，那么会同时往 emp，塞入key员工id,员工邮箱，
     * 那么下次根据id或者邮箱查询时，直接会从缓存中取
     * @param lastName 姓名
     * @return
     */
    @Caching(
            cacheable = {
                @Cacheable(value = {"emp"}, key="#lastName")
            },
            put = {
                    @CachePut(value = {"emp"}, key = "#result.id"),
                    @CachePut(value = {"emp"}, key = "#result.email"),
            }
    )
    @Override
    public Employee getByLastName(String lastName) {
        System.out.println("query by lastName:" + lastName);
        return employeeMapper.queryByLastName(lastName);
    }

}
