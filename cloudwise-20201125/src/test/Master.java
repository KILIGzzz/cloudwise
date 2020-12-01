package test;

/**
 * @author ：IvanZ
 * @version : 1.0
 * @date ：Created in 2020/11/25 11:48
 * @description ：主人
 * @modified By：
 */
public class Master extends Pet{
    String name;
    int age;
    Printer printer;


    public static void detail(Master master){
        master.printer.print("主人："+master.name+"，年龄："+master.age+"，宠物："+master.getName()+"，年龄："+master.getAge());
    }


    public Master(String name, int age, Printer printer,String petName,int petAge) {
        super(petName,petAge);
        this.name = name;
        this.age = age;
        this.printer = printer;
    }




}
