package service;

import java.util.List;
import java.util.Map;

/**
 * @author ：IvanZ
 * @version : 1.0
 * @date ：Created in 2020/12/4 18:32
 * @description ：用户service接口
 * @modified By：
 */
public interface UserService {
    /**
     * @create by: IvanZ
     * @description : 查询所有
     * @create time: 2020/12/4 18:49
     * @param :
     * @return java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
     */
    List<Map<String,Object>> findAll();

    /**
     * @create by: IvanZ
     * @description : 根据用户名密码查询数据库
     * @create time: 2020/12/4 18:54
     * @param username:
     * @param password:
     * @return java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
     */
    List<Map<String,Object>> findByUser(String username,String password);

    /**
     * @create by: IvanZ
     * @description : 增
     * @create time: 2020/12/4 18:58
     * @return void
     */
    void insert(String insertUserName, String insertPassword, String insertPhone, String insertUserDeptId);

    /**
     * @create by: IvanZ
     * @description : 通过id查询user
     * @create time: 2020/12/4 22:13
     * @param personid:
     * @return java.util.Map<java.lang.String,java.lang.Object>
     */
    Map<String, Object> findPersonById(String personid);

    /**
     * @create by: IvanZ
     * @description : 删
     * @create time: 2020/12/4 18:58
     * @param id:
     * @return void
     */
    void delete(String id);

    /**
     * @create by: IvanZ
     * @description : 改
     * @create time: 2020/12/4 18:59
     * @return java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
     */
    void update(String updateUserId, String updateUserName, String updatePassword, String updatePhone, String updateUserDeptId);


    /**
     * @create by: IvanZ
     * @description : 查询部门表
     * @create time: 2020/12/4 20:24
     * @param :
     * @return java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
     */
    List<Map<String,Object>> findAllDept();

    /**
     * @create by: IvanZ
     * @description : 判断用户名是否重复
     * @create time: 2020/12/4 22:44
     * @param updateUserName:
     * @return boolean
     */
    boolean checkUserName(String updateUserName);
}
