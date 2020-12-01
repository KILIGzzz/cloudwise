package test;

/**
 * @author ：IvanZ
 * @version : 1.0
 * @date ：Created in 2020/11/25 11:48
 * @description ：宠物
 * @modified By：
 */
public abstract class Pet {

    private String name;
    private int age;

    public Pet() {
    }

    public Pet(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
