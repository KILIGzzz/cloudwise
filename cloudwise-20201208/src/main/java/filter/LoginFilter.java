package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author ：IvanZ
 * @version : 1.0
 * @date ：Created in 2020/12/7 18:16
 * @description ：登录过滤器
 * @modified By：
 */
@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        //获取session
        HttpSession session = request.getSession();
        //获取页面uri地址
        String uri = request.getRequestURI();
        //判断是否包含loginServlet
        if (uri.contains("/loginServlet")){
            //放行
            filterChain.doFilter(servletRequest,servletResponse);
        }else {
            if (session.getAttribute("username")!=null){
                //放行
                filterChain.doFilter(servletRequest,servletResponse);
            }else {
                //转发到login.jsp
               request.getRequestDispatcher("/login.jsp").forward(servletRequest,servletResponse); }
        }
    }

    @Override
    public void destroy() {

    }
}
