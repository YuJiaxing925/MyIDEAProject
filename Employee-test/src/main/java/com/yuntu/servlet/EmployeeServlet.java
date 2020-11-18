package com.yuntu.servlet;

import com.yuntu.biz.EmployeeBiz;
import com.yuntu.biz.EmployeeBizImpl;
import com.yuntu.pojo.Employee;
import com.yuntu.util.PageUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

@WebServlet(name = "EmployeeServlet", value="/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String type = request.getParameter("type");
        EmployeeBiz employeeBiz = new EmployeeBizImpl();
        if ("getEmployees".equals(type)){
            String index = request.getParameter("pageindex");
            if (index==null){
                index="1";
            }
            int pageindex = Integer.parseInt(index);
            if (pageindex<1){
                pageindex=1;
            }

            PageUtil<Employee> pageUtil = new PageUtil<Employee>();
            pageUtil.setPageindex(pageindex);
            pageUtil.setPagesize(3);
            employeeBiz.getEmployeeByPageUtil(pageUtil);
            request.setAttribute("pageUtil",pageUtil);
            request.getRequestDispatcher("index.jsp").forward(request,response);
        } else if("delEmployeeById".equals(type)){
            int num = employeeBiz.delEmployeeById(Integer.parseInt(request.getParameter("id")));
            if (num!=0){
                out.print("<script type='text/javascript'>alert('删除成功') ;open('index.jsp','_self')</script>");
            }else{
                out.print("<script type='text/javascript'>alert('删除失败') ;open('index.jsp','_self')</script>");
            }
        } else if("updEmployee".equals(type)){
            int id = Integer.parseInt(request.getParameter("e_id"));
            String e_name = request.getParameter("e_name");
            String e_edu = request.getParameter("e_edu");
            int e_r_id = Integer.parseInt(request.getParameter("e_r_id"));
            int e_money = Integer.parseInt(request.getParameter("e_money"));
            int num = employeeBiz.addEmployee(new Employee(id,e_name,e_edu,e_r_id,new Date(),e_money));
            if (num!=0){
                out.print("<script type='text/javascript'>alert('修改成功') ;open('index.jsp','_self')</script>");
            }else{
                out.print("<script type='text/javascript'>alert('修改失败') ;open('index.jsp','_self')</script>");
            }
        } else if("addEmployee".equals(type)){
            String e_name = request.getParameter("e_name");
            String e_edu = request.getParameter("e_edu");
            int e_r_id = Integer.parseInt(request.getParameter("e_r_id"));
            int e_money = Integer.parseInt(request.getParameter("e_money"));
            int num = employeeBiz.addEmployee(new Employee(e_name,e_edu,e_r_id,new Date(),e_money));
            if (num!=0){
                out.print("<script type='text/javascript'>alert('添加成功') ;open('index.jsp','_self')</script>");
            }else{
                out.print("<script type='text/javascript'>alert('添加失败') ;open('index.jsp','_self')</script>");
            }
        }else if("selEmployee".equals(type)){
            int id = Integer.parseInt(request.getParameter("e_id"));
            Employee employee= employeeBiz.getEmployeeById(id);
            request.setAttribute("employee",employee);
            request.getRequestDispatcher("Modify.jsp").forward(request,response);
        }else{


        }
        out.flush();
        out.close();
    }
}
