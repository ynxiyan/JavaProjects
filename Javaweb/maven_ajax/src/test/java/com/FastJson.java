package com;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.model.Student;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: XIYAN
 * @Date: 2023/2/27 15:55
 * @注释:
 */
public class FastJson {
    @Test
    public void testJson() {
        Student student = new Student(1, "zs", "km");
        //Java对象 ==> JSON字符串
        String jsonString = JSON.toJSONString(student);
        String str = "{\"address\":\"km\",\"id\":1,\"name\":\"zs\"}";
        //JSON字符串 ==> java对象
        Student parseObject = JSON.parseObject(str, Student.class);
        System.out.println(jsonString);
        System.out.println(parseObject);
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("key1", "zs");
        map.put("key2", "zz");
        map.put("key3", "zq");
        map.put("key4", "za");
        String string = JSON.toJSONString(map);
        //System.out.println(string);
        JSONObject jsonObject = JSONObject.parseObject(string);
        //System.out.println(jsonObject);
        Map parse = (Map) JSON.parse(string);
        for (Object o : parse.keySet()) {
            System.out.println(parse.get(o).toString());
        }
    }
}
