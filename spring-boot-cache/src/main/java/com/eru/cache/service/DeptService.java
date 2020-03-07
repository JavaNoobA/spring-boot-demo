package com.eru.cache.service;

import com.eru.cache.bean.Department;

/**
 * Created by eru on 2020/3/7.
 */
public interface DeptService {

    /**
     * 根据id查询部门
     * @param id 部门id
     * @return 结果
     */
    Department get(Integer id);
}
