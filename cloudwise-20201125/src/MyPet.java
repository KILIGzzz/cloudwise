import java.awt.*;

/**
 * @author ：IvanZ
 * @version : 1.0
 * @date ：Created in 2020/11/25 9:11
 * @description ：我的宠物
 * @modified By：
 */
public class MyPet {
    private String name;
    private int age;
    private Color color;

    public MyPet() {
        System.out.println("宠物构造方法执行了");
    }

    public MyPet(String name, int age, Color color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    public String getName() {
        return name;
    }


    public int getAge() {
        return age;
    }


    public Color getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "MyPet{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color=" + color +
                '}';
    }

    public void playWithOwner(){
        System.out.println("陪自己玩...");
    }

    public void eat(){
        System.out.println("吃饭饭");
    }
}
