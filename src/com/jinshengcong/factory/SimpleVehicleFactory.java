package com.jinshengcong.factory;

/**
 * 交通工具的工厂 简单工厂
 * 可扩展性不好
 *      当新加的时候得新加方法
 * @author 金聖聰
 * @version v1.0
 * @email jinshengcong@163.com
 */
public class SimpleVehicleFactory {
    public Car createCar(){
        return new Car();
    }
    public Plane createPlane() {
        return new Plane();
    }
    public Broom createBroom() {
        return new Broom();
    }
}
