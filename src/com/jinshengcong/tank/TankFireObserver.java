package com.jinshengcong.tank;

/**
 * tank 开火观察者
 *
 * @author 金聖聰
 * @version v1.0
 * @email jinshengcong@163.com
 * @date Created in 2021/03/06 16:18
 */
public interface TankFireObserver {
    /**
     * 观察者开火,具体怎么开给具体的观察者
     * @param event
     * @return void
     * @author 金聖聰
     * @email jinshengcong@163.com
     * @version v1.0
     * @date 2021/03/06 16:24
     */
    void actionOnFire(TankFireEvent event);
}
