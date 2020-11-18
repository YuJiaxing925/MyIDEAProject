package com.yuntu;

import com.yuntu.biz.StudentBiz;
import com.yuntu.biz.StudentBizImpl;
import com.yuntu.pojo.Student;
import com.yuntu.util.PageUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(name = "StudentServlet",value = "/StudentServlet")
public class StudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

                response.setContentType("text/html;charset=utf-8");
                PrintWriter out = response.getWriter();
                request.setCharacterEncoding("utf-8");
                response.setCharacterEncoding("utf-8");
                String type = request.getParameter("type");
                StudentBiz studentBiz = new StudentBizImpl();
                if ("getPageAll".equals(type)){
                    String index = request.getParameter("pageindex");
                    if (index==null){
                        index="1";
                    }
                    int pageindex = Integer.parseInt(index);
                    if (pageindex<1){
                        pageindex=1;
                    }
                    PageUtil<Student> pageUtil = new PageUtil<Student>();
                    pageUtil.setPageindex(pageindex);
                    pageUtil.setPagesize(4);
                    studentBiz.getPageAll(pageUtil);
                    request.setAttribute("pageUtil",pageUtil);
                    request.getRequestDispatcher("index.jsp").forward(request,response);
                }else if("delStudentById".equals(type)){
                    int num = studentBiz.delStudent(Integer.parseInt(request.getParameter("id")));
                    if (num!=0){
                        out.print("<script type='text/javascript'>alert('删除成功') ;open('index.jsp','_self')</script>");
                    }else{
                        out.print("<script type='text/javascript'>alert('删除失败') ;open('index.jsp','_self')</script>");
                    }
                }else if("addStudent".equals(type)) {
                    String name = request.getParameter("stu_name");
                    int age = Integer.parseInt(request.getParameter("stu_age"));
                    int num = studentBiz.addStudent(new Student(name, age, new Date()));
                    if (num != 0) {
                        out.print("<script type='text/javascript'>alert('添加成功') ;open('index.jsp','_self')</script>");
                    } else {
                        out.print("<script type='text/javascript'>alert('添加失败') ;open('index.jsp','_self')</script>");
                    }
                }else if("getStudent".equals(type)){
                    int id = Integer.parseInt(request.getParameter("id"));
                    Student student= studentBiz.getStudent(id);
                    request.setAttribute("s",student);
                    request.getRequestDispatcher("Modify.jsp").forward(request,response);
                }else if("updStudent".equals(type)){
                    int id = Integer.parseInt(request.getParameter("id"));
                    String name = request.getParameter("stu_name");
                    int age = Integer.parseInt(request.getParameter("stu_age"));
                    int num = studentBiz.updStudent(new Student(id,name, age));
                    if (num != 0) {
                        out.print("<script type='text/javascript'>alert('修改成功') ;open('index.jsp','_self')</script>");
                    } else {
                        out.print("<script type='text/javascript'>alert('修改失败') ;open('index.jsp','_self')</script>");
                    }
                }

    }
}
