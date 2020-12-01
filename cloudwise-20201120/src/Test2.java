/**
 * @author ：IvanZ
 * @version :
 * @date ：Created in 2020/11/20 10:52
 * @description ：
 * @modified By：
 */
public class Test2 {
    public static void main(String[] args) {
        Person person = new Person(11);
        Person person1 = calcAge(person);
        System.out.println(person1);
    }
    public static Person calcAge(Person person){
        person.age+=1;
        return person;
    }

    static class Person{
        int age;

        public Person(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "age=" + age +
                    '}';
        }
    }
}
