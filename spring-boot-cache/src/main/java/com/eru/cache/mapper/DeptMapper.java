package com.eru.cache.mapper;

import com.eru.cache.bean.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * Created by eru on 2020/3/7.
 */
@Mapper
public interface DeptMapper {

    @Select("SELECT * FROM department WHERE id=#{id}")
    Department get(Integer id);
}
