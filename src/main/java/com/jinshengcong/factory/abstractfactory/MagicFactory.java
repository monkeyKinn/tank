package com.jinshengcong.factory.abstractfactory;

/**
 * description
 *
 * @author 金聖聰
 * @version v1.0
 * @email jinshengcong@163.com
 */
public class MagicFactory extends AbstractFactory{
    @Override
    AbstractFood createFood() {
        return new MushRoom();
    }

    @Override
    AbstractWeapon createWeapon() {
        return new MagicStick();
    }

    @Override
    AbstractVehicle createVehicle() {
        return new Broom();
    }
}
