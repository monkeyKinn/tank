package com.jinshengcong.dp.factory;

/**
 * 汽车工厂,只生产汽车
 *
 * @author 金聖聰
 * @version v1.0
 * @email jinshengcong@163.com
 */
public class CarFactory {
    public Car createCar(){
        System.out.println("日志操作,比如说car已经被创建");
        return new Car();
    }
}
