package controller;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @author ：IvanZ
 * @version : 1.0
 * @date ：Created in 2020/12/4 14:32
 * @description ：
 * @modified By：
 */
public class TestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        System.out.println("我的名字是："+name);

        //获取Servlet名
        String servletName = getServletName();
        System.out.println(servletName);

        //获取局部变量
        String localServletName = getInitParameter("localServletName");
        System.out.println(localServletName);

        //获取全局变量
        ServletContext servletContext = getServletContext();
        String encoding = servletContext.getInitParameter("encoding");
        System.out.println(encoding);

        //获取全局变量的name的枚举
        Enumeration<String> initParameterNames = servletContext.getInitParameterNames();
        System.out.println(initParameterNames.nextElement());


    }
}
