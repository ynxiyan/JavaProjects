package com.wisezone.oop.two;

/**
 * @Author: XIYAN
 * @Date: 2022/12/20 11:04
 * @注释:
 */
public class ArrayParam {
    /**
     * 计算平均分
     *
     * @param scores
     * @return
     */
    public double avg(int[] scores) {
        double sum = 0;
        for (int i = 0; i < scores.length; i++) {
            sum += scores[i];
        }
        return sum / scores.length;
    }

    /**
     * 计算最大值
     *
     * @param scores
     * @return
     */
    public int max(int[] scores) {
        int max = 0;
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] > max) {
                max = scores[i];
            }
        }
        return max;
    }
}
