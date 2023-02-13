package com.wisezone.five;

public class Training {
    /**
     * 2012年培养学员25万人，每年增长25%。请问按此增长速度，到哪一年培训学员人数将达到100万人？
     *
     * @param args
     */
    public static void main(String[] args) {
        int i = 1, year = 2012;
        double students = 25;
        while (students < 100) {
            students = students + students * 0.25;
            year++;
        }
        System.out.println(year + "年培训学员人数为" + Math.ceil(students) + "万人");
    }
}
