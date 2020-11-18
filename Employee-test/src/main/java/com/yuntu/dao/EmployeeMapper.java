package com.yuntu.dao;

import com.yuntu.pojo.Employee;
import com.yuntu.util.PageUtil;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapper {
    public List<Employee> getEmployees();
    public int delEmployeeById(int e_id);
    public int updEmployee(Employee employee);
    public int addEmployee(Employee employee);
    public Employee getEmployeeById(int e_id);
    public List<Employee> getEmployeeByPageUtil(@Param("index") int index,@Param("size") int size);
    public int getCount();
}

