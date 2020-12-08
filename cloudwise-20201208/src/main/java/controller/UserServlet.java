package controller;

import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author ：IvanZ
 * @version : 1.0
 * @date ：Created in 2020/12/4 20:07
 * @description ：
 * @modified By：
 */
@WebServlet("/userServlet")
public class UserServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();
    String UpdateId;
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json");
        //区分查询所有和编辑,null对象+“”====》"null"
        String method = req.getParameter("method") + "";
        HttpSession session = req.getSession();
        switch (method) {
            //去修改页面
            case "toUpdate":
                //根据id查询单个人员信息
                String id = req.getParameter("id");
                UpdateId = id;
                //根据id查询详细信息
                Map<String, Object> user = userService.findPersonById(id);
                //查询所有的部门。填充编辑页面的下拉框
                List<Map<String, Object>> allDept = userService.findAllDept();
                session.setAttribute("updateUser", user);
                session.setAttribute("allDept", allDept);
                req.getRequestDispatcher("updateUser.jsp").forward(req, resp);
                break;
            //在修改页面点击修改按钮的时候执行修改
            case "update":
                //接收页面传入的参数，开始修改数据库
                String updateUserId = UpdateId;
                String updateUserName = req.getParameter("username");
                String updatePassword = req.getParameter("password");
                String updatePhone = req.getParameter("phone");
                String updateUserDeptId = req.getParameter("userDeptId");
                //判断用户名不能重复
                boolean checkPersonName = userService.checkUserName(updateUserName);
                //如果可以用，继续更新，查询所有的页面
                if(checkPersonName){
                    userService.update(updateUserId, updateUserName, updatePassword, updatePhone, updateUserDeptId);
                    showAllPerson(session,req,resp);
                }else
                {
                    //如果不可用，提示用户名不可以用，继续返回到编辑页面
                    session.setAttribute("check_userName_message1", updateUserName+":重复不可用");
                    req.getRequestDispatcher("updateUser.jsp").forward(req, resp);
                }

                break;
            //去添加页面
            case "toAdd":
                //查询所有的部门。填充添加页面的下拉框
                List<Map<String, Object>> allDept1 = userService.findAllDept();
                session.setAttribute("allDept", allDept1);
                req.getRequestDispatcher("insertUser.jsp").forward(req,resp);
                break;
            //在添加页面点击提交按钮的时候执行添加
            case "add":
                String insertUserName = req.getParameter("username");
                String insertPassword = req.getParameter("password");
                String insertPhone = req.getParameter("phone");
                String insertUserDeptId = req.getParameter("userDeptId");
                //判断用户名不能重复
                boolean checkPersonName1 = userService.checkUserName(insertUserName);
                //如果可以用，继续添加，查询所有的页面
                if(checkPersonName1){
                    userService.insert(insertUserName, insertPassword, insertPhone, insertUserDeptId);
                    showAllPerson(session,req,resp);
                }else
                {
                    //如果不可用，提示用户名不可以用，继续返回到编辑页面
                    session.setAttribute("check_userName_message", insertUserName+":重复不可用");
                    req.getRequestDispatcher("insertUser.jsp").forward(req, resp);
                }

                break;
            //点击删除按钮，执行删除操作
            case "delete":
                String id1 = req.getParameter("id");
                //根据id删除数据
                userService.delete(id1);
                //删除之后去查询所有页面
                showAllPerson(session,req,resp);
                break;
            default:
                showAllPerson(session,req,resp);
        }

    }

    public void showAllPerson( HttpSession session,HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Map<String, Object>> allUser = userService.findAll();
        session.setAttribute("allUser",allUser);
        req.getRequestDispatcher("/user.jsp").forward(req,resp);
    }
}