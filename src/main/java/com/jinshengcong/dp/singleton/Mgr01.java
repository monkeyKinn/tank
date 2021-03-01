package com.jinshengcong.dp.singleton;

/**
 * 饿汉式
 * 类加载到内存后,就实例化一个单例,JVM保证线程安全
 *  简单实用,推荐使用
 *  缺点: 不管用到没有,类加载的时候就完成实例化
 *  (不用加载他干吗?)
 * @author 金聖聰
 * @version v1.0
 * @email jinshengcong@163.com
 */
public class Mgr01 {
    private final static Mgr01 INSTANCE = new Mgr01();
    // 私有化构造器
    private Mgr01() { }
    public static Mgr01 getInstance() {
        return INSTANCE;
    }

    public void  test() {
        System.out.println("m");
    }

    public static void main(String[] args) {
        Mgr01 instance = Mgr01.getInstance();
        Mgr01 instance1 = Mgr01.getInstance();
        System.out.println(instance == instance1);
    }
}
