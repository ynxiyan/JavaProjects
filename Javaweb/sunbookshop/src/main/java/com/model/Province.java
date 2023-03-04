package com.model;

import lombok.Data;

/**
 * @Author: XIYAN
 * @Date: 2023/3/3 14:47
 * @注释:省份实体
 */
@Data
public class Province {
    //省份序号
    private Integer id;
    //省份名称
    private String province;

    public Province() {
    }

    public Province(Integer id, String province) {
        this.id = id;
        this.province = province;
    }
}
