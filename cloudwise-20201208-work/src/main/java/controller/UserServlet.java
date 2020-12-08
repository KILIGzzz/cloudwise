package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import entity.ReturnBean;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
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
    final int PAGE_NO = 1;
    final int PAGE_SIZE = 5;
    Map map = new HashMap();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json");
        //将查询的所有数据转化成json回传到页面
        //需要进行分页
        int  pageNo=0;
        int pageSize=0;
        if(req.getParameter("page")!=null&&req.getParameter("limit")!=null){
            //如果前端页面传入分页参数，使用前端页面的分页参数
            pageNo= Integer.parseInt(req.getParameter("page"));
            pageSize=Integer.parseInt(req.getParameter("limit"));
        }else
        {
            //如果前端没有传入分页参数，使用系统默认
            pageNo= PAGE_NO;
            pageSize=PAGE_SIZE;
        }
        map.put("pageNo",pageNo);
        map.put("pageSize",pageSize);
        List<Map<String, Object>> allPerson = userService.findAllPersonPage(map);
        long count = userService.getRowCount();
        //将map转换成json字符串
        ReturnBean returnBean= new ReturnBean();
        returnBean.setCode(0);
        returnBean.setData(allPerson);
        returnBean.setCount((int)count);
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(resp.getWriter(),returnBean);
    }
}
