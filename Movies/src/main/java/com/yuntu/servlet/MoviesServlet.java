package com.yuntu.servlet;

import com.yuntu.biz.MoviesBiz;
import com.yuntu.biz.MoviesBizImpl;
import com.yuntu.pojo.Movies;
import com.yuntu.util.PageUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(name = "MoviesServlet",value = "/MoviesServlet")
public class MoviesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String type = request.getParameter("type");
        MoviesBiz moviesBiz = new MoviesBizImpl();
        if ("getPageAll".equals(type)){
            String index = request.getParameter("pageindex");
            if (index==null){
                index="1";
            }
            int pageindex = Integer.parseInt(index);
            if (pageindex<1){
                pageindex=1;
            }
            PageUtil<Movies> pageUtil = new PageUtil<Movies>();
            pageUtil.setPageindex(pageindex);
            pageUtil.setPagesize(4);
            moviesBiz.getPageAll(pageUtil);
            request.setAttribute("pageUtil",pageUtil);
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }else if("delMoviesById".equals(type)){
            int num = moviesBiz.delMovies(Integer.parseInt(request.getParameter("id")));
            if (num!=0){
                out.print("<script type='text/javascript'>alert('删除成功') ;open('index.jsp','_self')</script>");
            }else{
                out.print("<script type='text/javascript'>alert('删除失败') ;open('index.jsp','_self')</script>");
            }
        }else if("addMovies".equals(type)) {
            String m_title = request.getParameter("m_title");
            Double m_score = Double.parseDouble(request.getParameter("m_score"));
            String m_content = request.getParameter("m_content");
            int num = moviesBiz.addMovies(new Movies(m_title,m_score,m_content,new Date()));
            if (num != 0) {
                out.print("<script type='text/javascript'>alert('添加成功') ;open('index.jsp','_self')</script>");
            } else {
                out.print("<script type='text/javascript'>alert('添加失败') ;open('index.jsp','_self')</script>");
            }
        }else if("getMovies".equals(type)){
            int id = Integer.parseInt(request.getParameter("id"));
            Movies movies= moviesBiz.getMovies(id);
            request.setAttribute("m",movies);
            request.getRequestDispatcher("Modify.jsp").forward(request,response);
        }else if("updMovies".equals(type)){
            int id = Integer.parseInt(request.getParameter("id"));
            String m_title = request.getParameter("m_title");
            Double m_score = Double.parseDouble(request.getParameter("m_score"));
            String m_content = request.getParameter("m_content");
            int num = moviesBiz.updMovies(new Movies(id,m_title,m_score,m_content,new Date()));
            if (num != 0) {
                out.print("<script type='text/javascript'>alert('修改成功') ;open('index.jsp','_self')</script>");
            } else {
                out.print("<script type='text/javascript'>alert('修改失败') ;open('index.jsp','_self')</script>");
            }
        }
    }
}
