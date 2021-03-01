package com.jinshengcong.dp.factory.abstractfactory;

/**
 * description
 *
 * @author 金聖聰
 * @version v1.0
 * @email jinshengcong@163.com
 */
public class Main {
    public static void main(String[] args) {
        AbstractFactory factory = new MagicFactory();

        AbstractVehicle vehicle = factory.createVehicle();
        vehicle.go();
        AbstractWeapon weapon = factory.createWeapon();
        weapon.shoot();
        AbstractFood food = factory.createFood();
        food.printName();
    }
}
