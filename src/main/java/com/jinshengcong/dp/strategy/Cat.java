package com.jinshengcong.dp.strategy;

/**
 * description
 *
 * @author 金聖聰
 * @version v1.0
 * @email jinshengcong@163.com
 */
public class Cat {
    int weight, height;

    public Cat(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "weight=" + weight +
                ", height=" + height +
                '}';
    }

    public int compareToCat(Cat cat) {
        if (this.weight < cat.weight) {
            // 当前的小
            return -1;
        }
        if (this.weight > cat.weight) {
            return 1;
        }
        // 相等
        return 0;
    }
}