package com.eru.cache.service.impl;

import com.eru.cache.bean.Department;
import com.eru.cache.mapper.DeptMapper;
import com.eru.cache.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by eru on 2020/3/7.
 */
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Cacheable(value = {"dept"})
    @Override
    public Department get(Integer id) {
        return deptMapper.get(id);
    }
}
