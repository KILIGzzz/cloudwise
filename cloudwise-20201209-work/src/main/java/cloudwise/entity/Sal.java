package cloudwise.entity;

import cloudwise.dao.PersonDao;
import cloudwise.util.MysqlSessionFactory;

import java.util.List;
import java.util.Map;

/**
 * @author ：IvanZ
 * @version : 1.0
 * @date ：Created in 2020/12/10 9:21
 * @description ：
 * @modified By：
 */
public class Sal {
    double a;
    double b;

    public Sal(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public Sal() {
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public static void main(String[] args) {
        PersonDao mapper = MysqlSessionFactory.getSQLSession().getMapper(PersonDao.class);
        Sal sal = new Sal(1000,2000);

        List<Map<String, Object>> emp = mapper.findEmp(sal);
        for (Map<String, Object> stringObjectMap : emp) {
            System.out.println(stringObjectMap);
        }
    }
}
