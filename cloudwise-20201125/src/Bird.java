/**
 * @author ：IvanZ
 * @version : 1.0
 * @date ：Created in 2020/11/25 11:11
 * @description ：鸟
 * @modified By：
 */
public class Bird /*implements MyPetInterface,FlyPetInterface*/{
//    @Override
    public void fly() {
        System.out.println("飞...");
    }

//    @Override
    public void eat() {
        System.out.println("吃...");
    }

//    @Override
//    public void sleep() {
//        System.out.println("鸟睡觉...");
//    }

    public static void main(String[] args) {
        Bird bird = new Bird();
        bird.eat();
        bird.fly();
        int i = 1;
//        bird.sleep();
    }
}
