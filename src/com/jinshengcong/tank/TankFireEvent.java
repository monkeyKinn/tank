package com.jinshengcong.tank;

/**
 * 坦克开火事件,事件里面包含事件源,即谁发出的这个事件
 *
 * @author 金聖聰
 * @version v1.0
 * @email jinshengcong@163.com
 * @date Created in 2021/03/06 16:14
 */
public class TankFireEvent {
    Tank tank;
    public Tank getSource(){
        return tank;
    }
    public TankFireEvent(Tank tank){
        this.tank = tank;
    }
}
