package cloudwise.controller;


import cloudwise.entity.PageBean;
import cloudwise.entity.ReturnBean;
import cloudwise.service.PersonService;
import cloudwise.service.impl.PersonServiceImpl;
import cloudwise.util.MyConstants;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：Teacher陈
 * @date ：Created in 2020/11/19 9:24
 * @description：人员信息业务控制器
 * @modified By：
 * @version: 1
 */
@WebServlet(name = "PersonServlet", urlPatterns = "/person")
public class PersonServlet extends HttpServlet {
    PersonService personService = new PersonServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       req.setCharacterEncoding("utf-8");
       resp.setCharacterEncoding("utf-8");
       resp.setContentType("application/json");
        //区分查询所有和编辑,null对象+“”====》"null"
        String method = req.getParameter("method") + "";
        HttpSession session = req.getSession();
        String jsonString="";
        Map map = new HashMap();
        switch (method) {
            //去修改页面
            case "toUpdate":
                //根据id查询单个人员信息
                String personid = req.getParameter("personid");
                //根据id查询详细信息
                Map<String, Object> person = personService.findPersonById(personid);
                //查询所有的户口所在地信息。填充编辑页面的下拉框
                List<Map<String, Object>> allArea = personService.findAllArea();
                session.setAttribute("updatePerson", person);
                session.setAttribute("allArea", allArea);
                req.getRequestDispatcher("updatePerson.jsp").forward(req, resp);
                break;
            //在修改页面点击修改按钮的时候执行修改
            case "update":
                //接收页面传入的参数，开始修改数据库
                String updatePersonid = req.getParameter("personid");
                String updatePersonname = req.getParameter("personname");
                String updatePersonareaid = req.getParameter("personareaid");
                String updatePersonage = req.getParameter("personage");
                String updatePersonaddress = req.getParameter("personaddress");
                //判断用户名不能重复
                boolean checkPersonName = personService.checkPersonName(updatePersonname);
                //如果可以用，继续更新，查询所有的页面
                if(checkPersonName){
                    personService.updatePersonInfo(updatePersonid, updatePersonname, updatePersonareaid, updatePersonage, updatePersonaddress);
                    showAllPerson(session,req,resp);
                }else
                {
                    //如果不可用，提示用户名不可以用，继续返回到编辑页面
                    session.setAttribute("check_personName_message", updatePersonname+":重复不可用");
                    req.getRequestDispatcher("updatePerson.jsp").forward(req, resp);
                }

                break;
            //点击删除按钮，执行删除操作
            case "delete":
                String deletePersonid = req.getParameter("personid");
                //根据id删除数据
                personService.deletePersonById(deletePersonid);
                //删除之后去查询所有页面
                showAllPerson(session,req,resp);
                break;
            case "checkPersonName":
                //判断用户名不能重复
                String personname = req.getParameter("personname");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                boolean checkName = personService.checkPersonName(personname);
                //如果可以用，提示用户名可以用

                if(checkName){
                    map.put("message","可用");

                }else
                {
                    //如果不可用，提示用户名不可以用，
                    map.put("message","不可用");

                }

                ObjectMapper mapper1 = new ObjectMapper();
                String json = mapper1.writeValueAsString(map);
                resp.getWriter().print(json);
                break;
            case "layui":
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
                    pageNo= MyConstants.PAGE_NO;
                    pageSize=MyConstants.PAGE_SIZE;
                }
                map.put("pageNo",pageNo);
                map.put("pageSize",pageSize);
                List<Map<String, Object>> allPerson = personService.findAllPersonPage(map);
                long count = personService.getRowCount();
                //共几页
               /* int  pageTotal=0;
                if(count%pageSize==0){
                    pageTotal=(int)count/pageSize;
                }else{
                    pageTotal=(int)count/pageSize+1;
                }*/
                //将map转换成json字符串
                ReturnBean returnBean= new ReturnBean();
                returnBean.setCode(0);
                returnBean.setData(allPerson);
                returnBean.setCount((int)count);

                ObjectMapper mapper = new ObjectMapper();
                mapper.writeValue(resp.getWriter(),returnBean);
                break;
            default:
                showAllPerson(session,req,resp);
        }

    }

    public void showAllPerson( HttpSession session,HttpServletRequest req, HttpServletResponse resp){
        //需要进行分页
        int  pageNo=0;
        int pageSize=0;
        if(req.getParameter("pageNo")!=null&&req.getParameter("pageSize")!=null){
            //如果前端页面传入分页参数，使用前端页面的分页参数
              pageNo= Integer.parseInt(req.getParameter("pageNo"));
             pageSize=Integer.parseInt(req.getParameter("pageSize"));
        }else
        {
            //如果前端没有传入分页参数，使用系统默认
              pageNo= MyConstants.PAGE_NO;
             pageSize=MyConstants.PAGE_SIZE;
        }
        Map map= new HashMap();
        map.put("pageNo",pageNo);
        map.put("pageSize",pageSize);
        List<Map<String, Object>> allPerson = personService.findAllPersonPage(map);

        long count = personService.getRowCount();

        //共几页
        int  pageTotal=0;
        if(count%pageSize==0){
            pageTotal=(int)count/pageSize;
        }else{
            pageTotal=(int)count/pageSize+1;
        }
        session.setAttribute("allPerson", allPerson);
        //将分页参数放入session，显示在页面上
        PageBean pageBean= new PageBean(pageNo,pageSize,count,pageTotal);
        session.setAttribute("pageBean",pageBean);
        //页面调转
        try {
            req.getRequestDispatcher("showPerson.jsp").forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
