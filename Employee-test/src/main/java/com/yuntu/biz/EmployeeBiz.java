package com.yuntu.biz;

import com.yuntu.pojo.Employee;
import com.yuntu.util.PageUtil;

import java.util.List;

public interface EmployeeBiz {
    public List<Employee> getEmployees();
    public int delEmployeeById(int e_id);
    public int updEmployee(Employee employee);
    public int addEmployee(Employee employee);
    public Employee getEmployeeById(int e_id);
    public void getEmployeeByPageUtil(PageUtil<Employee> pageUtil);
}
