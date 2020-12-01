package work;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IvanUtilsTest {

    @Before
    public void setUp() throws Exception {
        System.out.println("测试开始...");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("测试结束...");
    }

    @Test
    public void getRandomMin() {
        System.out.println("获取随机分钟数：");
        System.out.println(IvanUtils.getRandomMin());
    }

    @Test
    public void getLocalDateTime() {
        System.out.println("输入String时间，返回LocalDateTime");
        System.out.println(IvanUtils.getLocalDateTime("2020-11-25 12:25:37"));
    }
}