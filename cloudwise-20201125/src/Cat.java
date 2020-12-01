import java.awt.*;

/**
 * @author ：IvanZ
 * @version : 1.0
 * @date ：Created in 2020/11/25 9:16
 * @description ：猫猫
 * @modified By：
 */
public class Cat extends MyPet{
    int weight;

    public Cat() {
    }

    public Cat(String name, int age, Color color, int weight) {
        super(name, age, color);
        this.weight = weight;
    }

    public Cat(String name, int age, Color color) {
        super(name, age, color);
    }

    public void catchMouse(){
        System.out.println("抓老鼠...");
    }

    @Override
    public void eat() {
        super.eat();
        System.out.println("吃鱼");
    }
}
