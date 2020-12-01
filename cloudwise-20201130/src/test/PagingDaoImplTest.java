package test;

import dao.PagingDao;
import dao.impl.PagingDaoImpl;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static org.junit.Assert.*;

public class PagingDaoImplTest {
    PagingDao dao = new PagingDaoImpl();

    @Test
    public void paging() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入页码：");
        int page = scanner.nextInt();
        System.out.println("请输入每页显示条数：");
        int count = scanner.nextInt();
        System.out.println("页码："+page+"，每页显示条数："+count);
        List<Map<String, Object>> paging = dao.paging(page, count);
        for (Map<String, Object> stringObjectMap : paging) {
            System.out.println(stringObjectMap);
        }
    }
}