package com.jinshengcong.tank.strategy;

import com.jinshengcong.tank.Tank;

/**
 * 开火的策略
 *
 * @author 金聖聰
 * @version v1.0
 * @email jinshengcong@163.com
 */
public interface FireStrategy {
    // 如果不穿就不知道在那个位置上
    void fire(Tank t);
}
