/**
 * @author ：IvanZ
 * @version :
 * @date ：Created in 2020/11/20 11:41
 * @description ：
 * @modified By：
 */
public /*final*/ class Person {
    /**
     * 名字
     */
    String name;
    /**
     * 年龄
     */
    int age;
    /**
     * 性别
     */
    String sex;
    /**
     * 身高
     */
    int height;
    /**
     * 体重
     */
    int weight;

    public Person(String name, int age, String sex, int height, int weight) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.height = height;
        this.weight = weight;
    }


    public boolean marry(Person person){
        if (person.age> 18 && person.age< 27 && "女".equals(person.sex) && person.height > 165 && person.weight<120){
            return true;
        }
        return false;
    }

    public final void test(){
        System.out.println("Person...");
    }

    public static void main(String[] args) {
        Person person1 = new Person("a", 30, "男", 178, 130);
        Person person2 = new Person("b", 25, "女", 170, 110);

        System.out.println("person1:"+person1.marry(person1));
        System.out.println("person2:"+person2.marry(person2));
    }
}
