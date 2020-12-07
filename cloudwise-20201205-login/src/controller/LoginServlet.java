package controller;

import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author ：IvanZ
 * @version : 1.0
 * @date ：Created in 2020/12/4 18:33
 * @description ：用户登录servlet
 * @modified By：
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码
        req.setCharacterEncoding("utf-8");

        //获取表单的数据
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        List<Map<String, Object>> byUser = userService.findByUser(username, password);

        //判断有没有从数据库查到数据
        if (byUser == null || byUser.size() == 0){
            System.out.println("登录失败");
            req.setAttribute("msg","用户名或密码错误，请重新登录！");
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }else {
            System.out.println("登录成功");
//            String login = req.getParameter("login");
//            if (login!=null){
//                //将登陆的用户名存入cookie
//                Cookie cookie = new Cookie("username",username);
//                cookie.setMaxAge(60*60*24*7);
//                resp.addCookie(cookie);
//            }

            //将登陆的用户名存入session
            req.getSession().setAttribute("username",username);

            String usernameInfo = "欢迎您，"+username+"!";
            req.setAttribute("usernameInfo",usernameInfo);
//            req.getRequestDispatcher("/userServlet").forward(req,resp);
            //重定向
            resp.sendRedirect(req.getContextPath()+"/userServlet");
        }

    }
}
