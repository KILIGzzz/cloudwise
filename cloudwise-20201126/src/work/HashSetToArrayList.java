package work;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/**
 * @author ：IvanZ
 * @version : 1.0
 * @date ：Created in 2020/11/26 17:23
 * @description ：将一组商品对象放入到HashSet中，用迭代器将其转入到ArrayList中，并输出每个商品的Id、名称、价格。
 * @modified By：
 */
public class HashSetToArrayList {
    public static void main(String[] args) {
        HashSet<Commodity> hashSet = new HashSet<>();
        //添加数据
        hashSet.add(new Commodity(1,"面包",10.0f));
        hashSet.add(new Commodity(2,"面包",15.0f));
        hashSet.add(new Commodity(3,"酸奶",20.0f));
        hashSet.add(new Commodity(4,"洗发水",35.0f));
        //创建ArrayList集合
        List<Commodity> list = new ArrayList<>();
        //迭代器遍历
        Iterator<Commodity> iterator = hashSet.iterator();
        while (iterator.hasNext()){
            //将内容放入list中
            list.add(iterator.next());
        }
        //遍历输出
        for (Commodity commodity : list) {
            System.out.println(commodity);
        }
    }
}
