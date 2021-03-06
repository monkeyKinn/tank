package com.jinshengcong.tank;

/**
 * 坦克开火处理 ,是一个具体的观察者
 *
 * @author 金聖聰
 * @version v1.0
 * @email jinshengcong@163.com
 * @date Created in 2021/03/06 16:17
 */
public class TankFireHandle implements TankFireObserver{


    @Override
    public void actionOnFire(TankFireEvent event) {
        // 得到事件源,是哪个坦克发出的事件
        Tank tank = event.getSource();
        // 事件源  具体的坦克开火
        tank.fire();
    }
}
