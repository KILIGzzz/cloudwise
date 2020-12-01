package test;

import dao.BookDao;
import dao.impl.BookDaoImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static org.junit.Assert.*;

public class BookDaoImplTest {
    BookDao bookDao = new BookDaoImpl();

    @Test
    public void bookManage(){
        while (true){
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入1：查询所有，2：删除图书，3：查询少于库存上限的图书本数，4：查询出版社的图书，5：添加图书，q：退出");
            String s = sc.nextLine();
            switch (s){
                //查询所有
                case "1":
                    //获取查询到的所有图书
                    List<Map<String, Object>> all = bookDao.findAll();
                    //遍历输出
                    for (Map<String, Object> stringObjectMap : all) {
                        System.out.println(stringObjectMap);
                    }
                    System.out.println();
                    break;
                //删除图书
                case "2":
                    System.out.println("请输入你要删除的图书ISBN：");
                    int isbn = sc.nextInt();
                    bookDao.deleteByIsbn(isbn);
                    System.out.println();
                    break;
                //查询少于库存上限的图书本数
                case "3":
                    System.out.println("请输入你要查询的库存上限：");
                    int currcount = sc.nextInt();
                    int lessCurrcount = bookDao.findLessCurrcount(currcount);
                    System.out.println("库存在"+currcount+"以下的图书有："+lessCurrcount+"本");
                    System.out.println();
                    break;
                //查询出版社的图书
                case "4":
                    System.out.println("请输入你要查询的出版社：");
                    String publish1 = sc.nextLine();
                    //接收查询到的信息
                    List<Map<String, Object>> bookByPublish1 = bookDao.findBookByPublish(publish1);
                    System.out.println(publish1+"的图书有：");
                    //遍历输出
                    for (Map<String, Object> byPublish : bookByPublish1) {
                        System.out.println(byPublish);
                    }
                    System.out.println();
                    break;
                //添加图书
                case "5":
                    System.out.println("请按照name、author、publish、price、currcount输入图书信息，以中文“，”分割：");
                    //定义key值
                    String[] keys = {"name","author","publish","price","currcount"};
                    //接收value值
                    String[] values = sc.next().split("，");
                    Map<String,Object> map = new HashMap<>();
                    for (int i = 0; i < values.length; i++) {
                        //放入map
                        map.put(keys[i],values[i]);
                    }
                    int i = bookDao.insertBook(map);
                    System.out.println("添加的图书的isbn码为："+i);
                    System.out.println();
                    break;
                //退出
                case "q":
                    return;
                //重新输入
                default:
                    System.out.println("请重新输入：");
                    System.out.println();
                    break;
            }
        }
    }

    @Test
    public void findAll() {
        List<Map<String, Object>> all = bookDao.findAll();
        for (Map<String, Object> stringObjectMap : all) {
            System.out.println(stringObjectMap);

        }
    }

    @Test
    public void deleteByIsbn() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你要删除的图书ISBN：");
        int isbn = scanner.nextInt();
        bookDao.deleteByIsbn(isbn);
    }

    @Test
    public void findLessCurrcount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你要查询的库存上限：");
        int currcount = scanner.nextInt();
        int lessCurrcount = bookDao.findLessCurrcount(currcount);
        System.out.println("库存在"+currcount+"以下的图书有："+lessCurrcount+"本");
    }

    @Test
    public void findBookByPublish() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你要查询的出版社：");
        String publish = scanner.nextLine();
        List<Map<String, Object>> bookByPublish = bookDao.findBookByPublish(publish);
        System.out.println(publish+"的图书有：");
        for (Map<String, Object> byPublish : bookByPublish) {
            System.out.println(byPublish);
        }
    }
}