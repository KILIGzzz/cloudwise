/**
 * @author ：IvanZ
 * @version : 1.0
 * @date ：Created in 2020/11/26 11:21
 * @description ：泛型接口实现类
 * @modified By：
 */
public class MyInterfaceImpl implements MyInterface<Person>{

    @Override
    public void test(Person person) {
        System.out.println(person);
    }

    public static void main(String[] args) {
        MyInterface<Person> myInterface = new MyInterfaceImpl();
        myInterface.test(new Person(1,"Ivan"));
    }
}
