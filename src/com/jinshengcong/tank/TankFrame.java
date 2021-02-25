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
    Tank myTank = new Tank(200, 200, Dir.DOWN);

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
     * 画的方法,有动画,每次最小化后调用,repaint方法也会调用
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
        myTank.paint(g);
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
            setMainTankDir();
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
            setMainTankDir();
        }

        private void setMainTankDir() {
            // 什么都没按的时候静止
            if (!bU && !bD && !bL && !bR) {
                myTank.setMoving(false);
            } else {
                myTank.setMoving(true);
                if (bU) myTank.setDir(Dir.UP);
                if (bD) myTank.setDir(Dir.DOWN);
                if (bL) myTank.setDir(Dir.LEFT);
                if (bR) myTank.setDir(Dir.RIGHT);
            }
        }
    }
}
