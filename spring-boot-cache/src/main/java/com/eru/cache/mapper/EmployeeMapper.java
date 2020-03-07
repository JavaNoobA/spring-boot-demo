package com.eru.cache.mapper;

import com.eru.cache.bean.Employee;
import org.apache.ibatis.annotations.*;

/**
 * Created by eru on 2020/3/7.
 */
@Mapper
public interface EmployeeMapper {

    @Select("SELECT * FROM employee WHERE id=#{id}")
    Employee queryById(Integer id);

    @Delete("DELETE FROM employee WHERE id=#{id}")
    void deleteById(Integer id);

    @Insert("INSERT INTO employee(lastName, email, gender, d_id) VALUES(#{lastName}, #{email}, #{gender}, #{dId})")
    void insert(Employee emp);

    @Update("UPDATE employee set lastName=#{lastName}, email=#{email}, gender=#{gender}, d_id=#{dId} WHERE id=#{id}")
    void update(Employee emp);

    @Select("SELECT * FROM employee WHERE lastName like concat('%', #{lastName}, '%')")
    Employee queryByLastName(String lastName);
}
