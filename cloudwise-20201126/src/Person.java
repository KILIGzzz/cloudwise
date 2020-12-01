import java.util.Objects;

/**
 * @author ：IvanZ
 * @version : 1.0
 * @date ：Created in 2020/11/26 10:08
 * @description ：人类
 * @modified By：
 */
public class Person implements Comparable<Person>{
    int id;
    String name;

    public Person() {
    }

    public Person(int id) {
        this.id = id;
    }

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        //判断内存地址是否相同
        if (this == o) {
            return true;
        }
        //判断对象是否为空，并且两个对象是否是同一类
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        //判断对象的id是否相同
        Person person = (Person) o;
        return id == person.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }


    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Person o) {
        if (this.id<o.id){
            return -1;
        }
        if (this.id>o.id){
            return 1;
        }
        return 0;
    }
}
