package com.yuntu.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class UserFilter implements Filter {
    String uncheckurls="";
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String value = filterConfig.getInitParameter("uncheckurls");
        if(value != null && (value=value.trim()).length() != 0){
            uncheckurls = value;
        }else{
            uncheckurls = "/Login.jsp";
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpreq = (HttpServletRequest) servletRequest;
        HttpServletResponse httpres = (HttpServletResponse) servletResponse;
        //获取当前请求的路径
        String urlpath = httpreq.getServletPath();
        //分割不需要过滤的路径  字符串数组
        List<String> urls = Arrays.asList(uncheckurls.split(","));
        //判断当前的路径是否需要过滤
        if(!urls.contains(urlpath)){//true    不需要过滤    直接放行
            //判断用户是否登录
            Object user = httpreq.getSession().getAttribute("u");
            if(user==null){
                httpres.sendRedirect("Login.jsp");
                return;
            }
        }
        //继续
        filterChain.doFilter(httpreq, httpres);
    }

    public void destroy() {

    }
}
