package service;

import entity.Dogs;

/**
 * @Author: XIYAN
 * @Date: 2023/2/16 10:10
 * @注释:判断sql是否执行成功
 */
public interface DogsService {
    /**
     * 通过查询id返回执行结果
     *
     * @param dogs 传入dogs的id
     * @return 返回执行结果
     */
    Dogs getDogsById(Dogs dogs);
}
