package com.yuntu.biz;

import com.yuntu.dao.EmployeeMapper;
import com.yuntu.pojo.Employee;
import com.yuntu.util.MybatisUtil;
import com.yuntu.util.PageUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

public class EmployeeBizImpl implements  EmployeeBiz{
    @Override
    public List<Employee> getEmployees() {
        SqlSession sqlSession = MybatisUtil.createSqlSession();
        List<Employee> employeeList =  sqlSession.getMapper(EmployeeMapper.class).getEmployees();
        MybatisUtil.closeSqlSession(sqlSession);
        return employeeList;
    }

    @Override
    public int delEmployeeById(int e_id) {
        SqlSession sqlSession = MybatisUtil.createSqlSession();
        int num  =  sqlSession.getMapper(EmployeeMapper.class).delEmployeeById(e_id);
        sqlSession.commit();
        MybatisUtil.closeSqlSession(sqlSession);
        return num;
    }

    @Override
    public int updEmployee(Employee employee) {
        SqlSession sqlSession = MybatisUtil.createSqlSession();
        int num  =  sqlSession.getMapper(EmployeeMapper.class).updEmployee(employee);
        sqlSession.commit();
        MybatisUtil.closeSqlSession(sqlSession);
        return num;
    }

    @Override
    public int addEmployee(Employee employee) {
        SqlSession sqlSession = MybatisUtil.createSqlSession();
        int num  =  sqlSession.getMapper(EmployeeMapper.class).addEmployee(employee);
        sqlSession.commit();
        MybatisUtil.closeSqlSession(sqlSession);
        return num;
    }

    @Override
    public Employee getEmployeeById(int e_id) {
        SqlSession sqlSession = MybatisUtil.createSqlSession();
        Employee employee =  sqlSession.getMapper(EmployeeMapper.class).getEmployeeById(e_id);
        MybatisUtil.closeSqlSession(sqlSession);
        return employee;
    }

    @Override
    public void getEmployeeByPageUtil(PageUtil<Employee> pageUtil) {
        SqlSession sqlSession = MybatisUtil.createSqlSession();
        int count = sqlSession.getMapper(EmployeeMapper.class).getCount();
        pageUtil.setCounts(count);
        if (count>0){
            if (pageUtil.getPageindex()>pageUtil.getPagecount()){
                pageUtil.setPageindex(pageUtil.getPagecount());
            }
            int index = (pageUtil.getPageindex()-1)*pageUtil.getPagesize();
            int size = pageUtil.getPagesize();
            pageUtil.setLists(sqlSession.getMapper(EmployeeMapper.class).getEmployeeByPageUtil(index,size));
        }else{
            pageUtil.setLists(new ArrayList<Employee>());
        }
        pageUtil.toString();
        MybatisUtil.closeSqlSession(sqlSession);
    }
}
