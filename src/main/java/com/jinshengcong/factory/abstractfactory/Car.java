package com.jinshengcong.factory.abstractfactory;

/**
 * description
 *
 * @author 金聖聰
 * @version v1.0
 * @email jinshengcong@163.com
 */
public class Car extends AbstractVehicle{
    @Override
    public void go() {
        System.out.println("车在跑");
    }
}
