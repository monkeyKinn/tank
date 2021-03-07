package com.jinshengcong.templatemethod;

/**
 * 模板方法
 *
 * @author 金聖聰
 * @version v1.0
 * @email jinshengcong@163.com
 * @date Created in 2021/03/07 18:08
 */
public class Main {
    public static void main(String[] args) {
        F f = new c1();
        f.m();
    }
}

abstract class F {
    public void m() {
        op1();
        op2();
    }

    abstract void op1();

    abstract void op2();
}

class c1 extends F {

    @Override
    void op1() {
        System.out.println("op1");
    }

    @Override
    void op2() {
        System.out.println("op2");
    }
}