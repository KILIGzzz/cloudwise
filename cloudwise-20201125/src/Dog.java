import java.awt.*;

/**
 * @author ：IvanZ
 * @version : 1.0
 * @date ：Created in 2020/11/25 9:14
 * @description ：狗狗
 * @modified By：
 */
public class Dog extends MyPet{
    String species;

    public Dog() {
    }

    public Dog(String species) {
        this.species = species;
    }

    public Dog(String name, int age, Color color) {
        super(name, age, color);
    }

    public Dog(String name, int age, Color color, String species) {
        super(name, age, color);
        this.species = species;
    }


    public void watchDoor(){
        System.out.println("看门...");
    }

    @Override
    public void eat() {
        super.eat();
        System.out.println("吃骨头");
    }
}
