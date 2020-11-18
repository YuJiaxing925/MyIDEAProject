package com.yuntu.servlet;

import com.yuntu.biz.PositionBiz;
import com.yuntu.biz.PositionBizImpl;
import com.yuntu.biz.TeacherBiz;
import com.yuntu.biz.TeacherBizImpl;
import com.yuntu.pojo.Position;
import com.yuntu.pojo.Teacher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name="TeacherServlet" ,value = "/TeacherServlet")
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
        PositionBiz positionBiz = new PositionBizImpl();
        if(type==null){
            type="index";
        }
        if("index".equals(type)){
            List<Teacher> teacherList = teacherBiz.getTeacherPositionById();
            request.setAttribute("teacherList",teacherList);
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }else if ("delTeacher".equals(type)){
            int id = Integer.parseInt(request.getParameter("id"));
            int num = teacherBiz.delTeacherById(id);
            if (num!=0){
                out.print("<script type='text/javascript'> alert('删除成功') ;open('index.jsp','_self')</script>");
            }else{
                out.print("<script type='text/javascript'> alert('删除失败')</script>");
            }
        }else if ("addTeacher".equals(type)){
            String t_no = request.getParameter("t_no");
            String t_name = request.getParameter("t_name");
            int position_id = Integer.parseInt(request.getParameter("position_id"));
            Teacher teacher = new Teacher(t_no,t_name,position_id);
            int num = teacherBiz.addTeacher(teacher);
            if (num!=0){
                out.print("<script type='text/javascript'> alert('添加成功');open('index.jsp','_self')</script>");
            }else{
                out.print("<script type='text/javascript'> alert('添加失败');open('index.jsp','_self')</script>");
            }
        }else if ("getPosition".equals(type)){
            List<Position> positionList = positionBiz.getAll();
            request.setAttribute("positionList",positionList);
            request.getRequestDispatcher("Regist.jsp").forward(request,response);
        }else if ("getTeacher".equals(type)){
            int id = Integer.parseInt(request.getParameter("id"));
            Teacher teacher = teacherBiz.getTeacherById(id);
            request.setAttribute("teacher",teacher);
            request.getRequestDispatcher("Modify.jsp").forward(request,response);
        }else if ("updTeacher".equals(type)){
            int id = Integer.parseInt(request.getParameter("id"));
            String t_no = request.getParameter("t_no");
            String t_name = request.getParameter("t_name");
            int position_id = Integer.parseInt(request.getParameter("position_id"));
            Teacher teacher = new Teacher(id,t_no,t_name,position_id);
            int num = teacherBiz.updTeacher(teacher);
            if (num!=0){
                out.print("<script type='text/javascript'> alert('修改成功');open('index.jsp','_self')</script>");
            }else{
                out.print("<script type='text/javascript'> alert('修改失败');open('index.jsp','_self')</script>");
            }
        }else{
            out.print("<script type='text/javascript'> alert('异常');open('index.jsp','_self')</script>");

        }
        out.flush();
        out.close();
    }
}
