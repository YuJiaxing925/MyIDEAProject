package com.yuntu.servlet;

import com.yuntu.biz.UserBiz;
import com.yuntu.biz.UserBizImpl;
import com.yuntu.pojo.Friend;
import com.yuntu.pojo.User;
import com.yuntu.util.PageUtil;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@WebServlet(name = "UserServlet",value = "/UserServlet")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String type = request.getParameter("type");
        UserBiz userBiz = new UserBizImpl();
        if ("getPage".equals(type)){
            String index = request.getParameter("pageindex");
            if (index==null){
                index="1";
            }
            int pageindex = Integer.parseInt(index);
            if (pageindex<1){
                pageindex=1;
            }

            PageUtil<User> pageUtil = new PageUtil<User>();
            pageUtil.setPageindex(pageindex);
            pageUtil.setPagesize(3);
            userBiz.getUserByPage(pageUtil);
            request.setAttribute("pageUtil",pageUtil);
            int role = Integer.parseInt(request.getParameter("role"));
            if(role==1){
                request.getRequestDispatcher("index1.jsp").forward(request,response);
            }else if(role==2){
                request.getRequestDispatcher("index2.jsp").forward(request,response);
            }

        }else if("selUser".equals(type)){
            int id = Integer.parseInt(request.getParameter("id"));
            User user = userBiz.getUserById(id);
            request.setAttribute("user",user);
            request.getRequestDispatcher("Modify.jsp").forward(request,response);
        }else if("updUser".equals(type)){
            User user = new User();
            user.setU_id(Integer.parseInt(request.getParameter("id")));
            //通过io流将表单提交的文件传输到服务器中
            //判断请求信息中的内容是否是multipart类型
            boolean isMultipart = ServletFileUpload.isMultipartContent(request);
            //上传文件的存储路径
            String uploadFilePath = "D:\\MyIDea\\User-test\\src\\main\\webapp\\image";
            if(isMultipart){
                try {
                    DiskFileItemFactory factory = new DiskFileItemFactory();
//           设置缓冲区的大小  字节
//            factory.setSizeThreshold();
                    //临时文件保存的位置
//            factory.setRepository("路径");
                    ServletFileUpload upload = new ServletFileUpload(factory);
                    //解析form表单里的所有文件,并且拿到我想要的格式
                    List<FileItem> items = upload.parseRequest(request);
                    //设置单个文件最大限制   字节
                    upload.setSizeMax(1*1024*1024);
                    Iterator<FileItem> iter = items.iterator();
                    while(iter.hasNext()){ //迭代所有的文件
                        FileItem fileItem = (FileItem) iter.next();
                        if(fileItem.isFormField()){//判断是否是普通字段
                            //获取当前标签的name值
                            String fileName = fileItem.getFieldName();
                            if(fileName.equals("u_username")){
                                //getString:获取value值
                                user.setU_userName(fileItem.getString("utf-8"));
                            }else if(fileName.equals("u_password")){
                                user.setU_password(fileItem.getString("utf-8"));
                            }
                        }else{ //文件表单字段
                            String fileName = fileItem.getName();
                            String filename1 =fileName.substring(fileName.lastIndexOf("\\")+1);
                            System.out.println("----------------------"+filename1);
                            //规定文件上传的类型
                            //一般图片类型 jpg,gif,png
                            List<String> fileTypes = Arrays.asList("jpg","gif","png");
                            //substring:截取字符串 两个参数时,截取两个参数之间的字符(包头不包尾)
                            //                   一个参数,截取之后的所有内容
                            String  fileType = fileName.substring(fileName.lastIndexOf(".")+1);
                            //contains:判断集合中是否包含此数据
                            if(fileTypes.contains(fileType)){
                                if(fileName !=null && !fileName.equals("")){
                                    //保存的文件
                                    File savefile = new File(uploadFilePath,filename1);
                                    //将文件写到哪里去
                                    fileItem.write(savefile);
                                    user.setU_imgUrl(filename1);
                                    user.setU_updateTime(new Date());
                                    User olduser = (User) request.getSession().getAttribute("u");
                                    user.setU_createTime(olduser.getU_createTime());
                                    request.getSession().removeAttribute("u");
                                    request.getSession().setAttribute("u",user);
                                    int num = userBiz.updUser(user);
                                    if (num!=0){
                                        out.print("<script type='text/javascript'>alert('修改成功') ;open('index.jsp','_self')</script>");
                                    }else{
                                        out.print("<script type='text/javascript'>alert('修改失败') ;open('index.jsp','_self')</script>");
                                    }
                                }
                            }else {
                                System.out.println("格式不匹配");
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }else{
                System.out.println("表单提交不符合上传文件");
            }


        }else if("addUser".equals(type)){
            User user = new User();
            //通过io流将表单提交的文件传输到服务器中
            //判断请求信息中的内容是否是multipart类型
            boolean isMultipart = ServletFileUpload.isMultipartContent(request);
            //上传文件的存储路径
            String uploadFilePath = "D:\\MyIDea\\User-test\\src\\main\\webapp\\image";
            if(isMultipart){
                try {
                    DiskFileItemFactory factory = new DiskFileItemFactory();
//           设置缓冲区的大小  字节
//            factory.setSizeThreshold();
                    //临时文件保存的位置
//            factory.setRepository("路径");
                    ServletFileUpload upload = new ServletFileUpload(factory);
                    //解析form表单里的所有文件,并且拿到我想要的格式
                    List<FileItem> items = upload.parseRequest(request);
                    //设置单个文件最大限制   字节
                    upload.setSizeMax(1*1024*1024);
                    Iterator<FileItem> iter = items.iterator();
                    while(iter.hasNext()){ //迭代所有的文件
                        FileItem fileItem = (FileItem) iter.next();
                        if(fileItem.isFormField()){//判断是否是普通字段
                            //获取当前标签的name值
                            String fileName = fileItem.getFieldName();
                            if(fileName.equals("u_username")){
                                //getString:获取value值
                                user.setU_userName(fileItem.getString("utf-8"));
                            }else if(fileName.equals("u_password")){
                                user.setU_password(fileItem.getString("utf-8"));
                            }
                        }else{ //文件表单字段
                            String fileName = fileItem.getName();
                            String filename1 =fileName.substring(fileName.lastIndexOf("\\")+1);
                            System.out.println("----------------------"+filename1);
                            //规定文件上传的类型
                            //一般图片类型 jpg,gif,png
                            List<String> fileTypes = Arrays.asList("jpg","gif","png");
                            //substring:截取字符串 两个参数时,截取两个参数之间的字符(包头不包尾)
                            //                   一个参数,截取之后的所有内容
                            String  fileType = fileName.substring(fileName.lastIndexOf(".")+1);
                            //contains:判断集合中是否包含此数据
                            if(fileTypes.contains(fileType)){
                                 if(fileName !=null && !fileName.equals("")){
                                    //保存的文件
                                    File savefile = new File(uploadFilePath,filename1);
                                    //将文件写到哪里去
                                    fileItem.write(savefile);
                                    user.setU_imgUrl(filename1);
                                    user.setU_createTime(new Date());
                                    int num = userBiz.addUser(user);
                                     if (num!=0){
                                         out.print("<script type='text/javascript'>alert('添加成功') ;open('index.jsp','_self')</script>");
                                     }else{
                                         out.print("<script type='text/javascript'>alert('添加失败') ;open('index.jsp','_self')</script>");
                                     }
                                 }
                            }else {
                                System.out.println("格式不匹配");
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }else{
                System.out.println("表单提交不符合上传文件");
            }

        }else if("login".equals(type)){
            String u_userName = request.getParameter("username");
            String u_password = request.getParameter("password");

            User user = userBiz.Login(u_userName,u_password);
            request.getSession().setMaxInactiveInterval(60*5);
            System.out.println(user.toString());
            request.getSession().setAttribute("u",user);
            if (user.getU_role()==0){
                out.print("<script type='text/javascript'>alert('登录成功') ;open('index.jsp','_self')</script>");
            }else if (user.getU_role()==1){
                out.print("<script type='text/javascript'>alert('登录成功') ;open('index1.jsp','_self')</script>");
            }else if(user.getU_role()==2){
                out.print("<script type='text/javascript'>alert('登录成功') ;open('index2.jsp','_self')</script>");
            }
        }else if("getFriend".equals(type)){
            int id = Integer.parseInt(request.getParameter("id"));
            List<User> userList= userBiz.getUserFriendByUserFriendId(id);
            request.setAttribute("userList",userList);
            request.getRequestDispatcher("userFriend.jsp").forward(request,response);
        }else if ("addFriend".equals(type)){
            String remarks = request.getParameter("remarks");
            int id1 = Integer.parseInt(request.getParameter("id1"));
            int id2= Integer.parseInt(request.getParameter("id2"));
            Friend friend = new Friend(id1,id2,remarks,new Date());
            int num = userBiz.addFriend(friend);
            if (num!=0){
                out.print("<script type='text/javascript'>alert('添加成功') ;open('index.jsp','_self')</script>");
            }else{
                out.print("<script type='text/javascript'>alert('添加失败') ;open('index.jsp','_self')</script>");
            }
        }else if("delFriend".equals(type)){
            int id1 = Integer.parseInt(request.getParameter("id1"));
            int id2= Integer.parseInt(request.getParameter("id2"));
            int num1 = userBiz.delFriend(id1,id2);
            int num2 = userBiz.delFriend(id2,id1);
            if (num1!=0){
                if (num2!=0){
                    out.print("<script type='text/javascript'>alert('删除成功') ;open('userFriend.jsp','_self')</script>");
                }
            }else{
                out.print("<script type='text/javascript'>alert('删除失败') ;open('index.jsp','_self')</script>");
            }
        }

    }
}
