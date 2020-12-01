/**
 * @author ：IvanZ
 * @version : 1.0
 * @date ：Created in 2020/11/25 11:09
 * @description ：宠物
 * @modified By：
 */
public interface MyPetInterface {
    /**
     * @create by: IvanZ
     * @description : 吃东西
     * @create time: 2020/11/25 11:10
     * @param :
     * @return void
     */
    void eat();

    default void sleep(){
        System.out.println("睡觉...");
    }

}
