package com.itheima.pattern.factory.config;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @Author: XIYAN
 * @Date: 2023/2/7 18:28
 * @注释:加载配置文件，获取配置文件中配置的全类名并创建该类对象进行存储
 */
public class CoffeeFactory {
    //1.定义容器对象存储咖啡对象
    private static Map<String, Coffee> map = new HashMap<>();

    //2.加载配置文件（只需加载一次）
    static {
        //3.创建properties对象
        Properties properties = new Properties();
        //4.调用properties的load()方法进行配置文件的加载
        InputStream is = CoffeeFactory.class.getClassLoader().getResourceAsStream("bean.properties");
        try {
            properties.load(is);
            //5.从map集合中获取全类名并创建对象
            Set set = properties.keySet();
            for (Object o : set) {
                String className = properties.getProperty((String) o);
                //6.通过反射创建对象
                Class c = Class.forName(className);
                Coffee coffee = (Coffee) c.newInstance();
                //7.将名称和对象存储到容器里
                map.put((String) o, coffee);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //8.根据名称获取对象
    public static Coffee createCoffee(String name) {
        return map.get(name);
    }
}
