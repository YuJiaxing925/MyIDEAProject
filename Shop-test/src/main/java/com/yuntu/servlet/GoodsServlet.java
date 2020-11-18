package com.yuntu.servlet;

import com.yuntu.biz.GoodsBiz;
import com.yuntu.biz.GoodsBizImpl;
import com.yuntu.pojo.Goods;
import com.yuntu.util.PageUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(name = "GoodsServlet",value = "/GoodsServlet")
public class GoodsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String type = request.getParameter("type");
        GoodsBiz goodsBiz = new GoodsBizImpl();
        if ("getGoods".equals(type)){
            String index = request.getParameter("pageindex");
            if (index==null){
                index="1";
            }
            int pageindex = Integer.parseInt(index);
            if (pageindex<1){
                pageindex=1;
            }
            PageUtil<Goods> pageUtil = new PageUtil<Goods>();
            pageUtil.setPageindex(pageindex);
            pageUtil.setPagesize(3);
            goodsBiz.getGoodsByPage(pageUtil);
            request.setAttribute("pageUtil",pageUtil);
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }else if("delGoodsById".equals(type)){
            int num = goodsBiz.delGoodsById(Integer.parseInt(request.getParameter("id")));
            if (num!=0){
                out.print("<script type='text/javascript'>alert('删除成功') ;open('index.jsp','_self')</script>");
            }else{
                out.print("<script type='text/javascript'>alert('删除失败') ;open('index.jsp','_self')</script>");
            }
        }else if("selGoods".equals(type)){
            int id = Integer.parseInt(request.getParameter("id"));
            Goods goods = goodsBiz.getGoodsById(id);
            request.setAttribute("goods",goods);
            request.getRequestDispatcher("Modify.jsp").forward(request,response);
        }else if("updGoods".equals(type)){
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            int s_id = Integer.parseInt(request.getParameter("s_id"));
            String money = request.getParameter("money");
            String color = request.getParameter("color");
            int num = goodsBiz.updGoods(new Goods(id,name,s_id,color,money));
            if (num!=0){
                out.print("<script type='text/javascript'>alert('修改成功') ;open('index.jsp','_self')</script>");
            }else{
                out.print("<script type='text/javascript'>alert('修改失败') ;open('index.jsp','_self')</script>");
            }
        }else if("addGoods".equals(type)){
            String name = request.getParameter("name");
            int s_id = Integer.parseInt(request.getParameter("s_id"));
            String money = request.getParameter("money");
            String color = request.getParameter("color");
            int num = goodsBiz.addGoods(new Goods(name,s_id,color,money));
            if (num!=0){
                out.print("<script type='text/javascript'>alert('添加成功') ;open('index.jsp','_self')</script>");
            }else{
                out.print("<script type='text/javascript'>alert('添加失败') ;open('index.jsp','_self')</script>");
            }
        }
    }
}
