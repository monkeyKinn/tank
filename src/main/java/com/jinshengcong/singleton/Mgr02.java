package com.jinshengcong.singleton;

/**
 * 懒汉式 刚开始不初始化,在get的时候初始化(先判断是否为空)
 * 虽然达到了按需初始化的目的,但在多线程访问的时候有影响
 *
 * @author 金聖聰
 * @version v1.0
 * @email jinshengcong@163.com
 */
public class Mgr02 {
    private static Mgr02 INSTANCE;
    private Mgr02(){}
    public static Mgr02 getInstance(){
        if (INSTANCE == null) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE =  new Mgr02();
        }
        return INSTANCE;
    }
    public void test(){
        System.out.println("m");
    }
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            // hash相同也不一定是同一个对象
            new Thread(()-> System.out.println(Mgr02.getInstance().hashCode())).start();
        }
    }
}
