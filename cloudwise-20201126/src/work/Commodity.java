package work;

import java.util.Objects;

/**
 * @author ：IvanZ
 * @version : 1.0
 * @date ：Created in 2020/11/26 17:24
 * @description ：商品类
 * @modified By：
 */
public class Commodity {
    int id;
    String name;
    float price;

    @Override
    public String toString() {
        return "Commodity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Commodity commodity = (Commodity) o;
        return id == commodity.id ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price);
    }

    public Commodity() {
    }

    public Commodity(int id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
