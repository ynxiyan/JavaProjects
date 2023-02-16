package entity;

import lombok.Data;

/**
 * @Author: XIYAN
 * @Date: 2023/2/16 10:00
 * @注释:
 */
@Data
public class Dogs {
    private Integer id;
    private String name;
    private String sex;
    private Integer age;

    @Override
    public String toString() {
        return "Dogs{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }
}
