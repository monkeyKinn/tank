package com.jinshengcong.tank;

import java.awt.*;
import java.awt.event.*;

/**
 * 之所以要继承,就是为了要重写paint方法(画)
 *
 * @author 金聖聰
 * @version v1.0
 * @email jinshengcong@163.com
 */
public class TankFrame extends Frame {
    private int x = 200, y = 200;

    public TankFrame() {
        this.setTitle("Tank War");
        this.setSize(800, 500);
        this.setVisible(true);
        this.addKeyListener(new MyKeyListener() {

        });
        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
    }

    /**
     * 画的方法,有动画,每次最小化后调用
     *
     * @param g 画笔
     * @return void
     * @author 金聖聰
     * @email jinshengcong@163.com
     * @version v1.0
     * @date 2021/02/25 21:01
     */
    @Override
    public void paint(Graphics g) {
        System.out.println(x + "," + y);
        // 画一个方块
        g.fillRect(x, y, 80, 80);
        // x += 10;
    }

    private class MyKeyListener extends KeyAdapter {
        private boolean bU = false;
        private boolean bD = false;
        private boolean bL = false;
        private boolean bR = false;

        @Override
        public void keyPressed(KeyEvent e) {
            // 按下什么键
            int keyCode = e.getKeyCode();
            switch (keyCode) {
                case KeyEvent.VK_UP:
                    bU = true;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = true;
                    break;
                case KeyEvent.VK_LEFT:
                    bL = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = true;
                    break;
                default:
                    break;
            }
            // x += 200;
            // 重画 会默认调用paint
        }

        @Override
        public void keyReleased(KeyEvent e) {
            // 按下什么键
            int keyCode = e.getKeyCode();
            switch (keyCode) {
                case KeyEvent.VK_UP:
                    bU = false;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = false;
                    break;
                case KeyEvent.VK_LEFT:
                    bL = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = false;
                    break;
                default:
                    break;
            }
        }
    }
}
