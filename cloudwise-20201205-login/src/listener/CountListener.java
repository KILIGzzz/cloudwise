package listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * @author ：IvanZ
 * @version : 1.0
 * @date ：Created in 2020/12/7 18:41
 * @description ：当前在线人数
 * @modified By：
 */
@WebListener
public class CountListener implements HttpSessionAttributeListener {
    static String username = "username";
    public static int count = 0;

    @Override
    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
        //获取添加的session名称
        String name = httpSessionBindingEvent.getName();
        //如果添加的session名是username
        if (username.equals(name)){
            count++;
        }
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {
        //获取删除的session名称
        String name = httpSessionBindingEvent.getName();
        //如果删除的session名是username
        if (username.equals(name)){
            count--;
        }

    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {
    }
}
