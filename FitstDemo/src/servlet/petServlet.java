package servlet;

import biz.impl.petBizImpl;
import biz.petBiz;
import entity.pet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "petServlet")
public class petServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String type = request.getParameter("type");
        petBiz pbiz = new petBizImpl();
        if ("getall".equals(type)){
           List<pet>  petList= pbiz.getall();
           request.setAttribute("p",petList);
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }
    }
}
