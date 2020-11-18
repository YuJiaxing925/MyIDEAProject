package com.yuntu.servlet;

import com.yuntu.biz.InformationBiz;
import com.yuntu.biz.InformationBizImpl;
import com.yuntu.pojo.Information;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

@WebServlet(name = "InformationServlet",value = "/InformationServlet")
public class InformationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String type = request.getParameter("type");
        InformationBiz informationBiz = new InformationBizImpl();
        if("sendMail".equals(type)){
            int receiveId = Integer.parseInt(request.getParameter("receiveId"));
            int sendId = Integer.parseInt(request.getParameter("sendId"));
            String title = request.getParameter("title");
            String content = request.getParameter("content");

            Information information = new Information(sendId,receiveId,content,0,title,new Date());
            int num = informationBiz.sendMail(information);
            if (num!=0){
                out.print("<script type='text/javascript'>alert('发送成功') ;open('index.jsp','_self')</script>");
            }else{
                out.print("<script type='text/javascript'>alert('发送失败') ;open('index.jsp','_self')</script>");
            }
        }else if("getInformationList".equals(type)){
            int id = Integer.parseInt(request.getParameter("id"));
            List<Information> informationList = informationBiz.getInformation(id);
            request.setAttribute("informationList",informationList);
            request.getRequestDispatcher("InformationList.jsp").forward(request,response);
        }else if("readInformation".equals(type)){
            int id = Integer.parseInt(request.getParameter("id"));
            int num = informationBiz.isRead(id);
            System.out.println(num);
            Information information = informationBiz.readInformation(id);
            request.setAttribute("information",information);
            request.getRequestDispatcher("ReadInformation.jsp").forward(request,response);
        }
    }
}
