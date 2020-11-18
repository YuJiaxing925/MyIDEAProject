package com.yuntu.servlet;

import com.yuntu.biz.TeacherBiz;
import com.yuntu.biz.TeacherBizImpl;
import com.yuntu.pojo.Teacher;
import com.yuntu.util.PageUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(name = "TeacherServlet" ,value = "/TeacherServlet")
public class TeacherServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String type = request.getParameter("type");
        TeacherBiz teacherBiz = new TeacherBizImpl();
        if ("getPageAll".equals(type)){//分页
            String index = request.getParameter("pageindex");
            if (index==null){
                index="1";
            }
            int pageindex = Integer.parseInt(index);
            if (pageindex<1){
                pageindex=1;
            }
            PageUtil<Teacher> pageUtil = new PageUtil<Teacher>();
            pageUtil.setPageindex(pageindex);
            pageUtil.setPagesize(2);
            teacherBiz.getPageAll(pageUtil);
            request.setAttribute("pageUtil",pageUtil);
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }else if("delTeacher".equals(type)){//删除
            int num = teacherBiz.delTeacher(Integer.parseInt(request.getParameter("id")));
            if (num!=0){
                out.print("<script type='text/javascript'>alert('删除成功') ;open('index.jsp','_self')</script>");
            }else{
                out.print("<script type='text/javascript'>alert('删除失败') ;open('index.jsp','_self')</script>");
            }
        }else if("getTeacher".equals(type)){//获取单个老师
            int id = Integer.parseInt(request.getParameter("id"));
            Teacher teacher= teacherBiz.getTeacher(id);
            request.setAttribute("t",teacher);
            request.getRequestDispatcher("Modify.jsp").forward(request,response);
        }else if("updTeacher".equals(type)){//修改
            int id = Integer.parseInt(request.getParameter("id"));
            String t_name = request.getParameter("t_name");
            String t_subject = request.getParameter("t_subject");
            String t_sex = request.getParameter("t_sex");
            int num = teacherBiz.updTeacher(new Teacher(id,t_name, new Date(),t_subject,t_sex));
            if (num != 0) {
                out.print("<script type='text/javascript'>alert('修改成功') ;open('index.jsp','_self')</script>");
            } else {
                out.print("<script type='text/javascript'>alert('修改失败') ;open('index.jsp','_self')</script>");
            }
        }else if("addTeacher".equals(type)) {//添加
            String t_name = request.getParameter("t_name");
            String t_subject = request.getParameter("t_subject");
            String t_sex = request.getParameter("t_sex");
            int num = teacherBiz.addTeacher(new Teacher(t_name, new Date(),t_subject,t_sex));
            if (num != 0) {
                out.print("<script type='text/javascript'>alert('添加成功') ;open('index.jsp','_self')</script>");
            } else {
                out.print("<script type='text/javascript'>alert('添加失败') ;open('index.jsp','_self')</script>");
            }
        }

    }
}
