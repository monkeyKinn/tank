package com.jinshengcong.tank;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * 之所以要继承,就是为了要重写paint方法(画)
 *
 * @author 金聖聰
 * @version v1.0
 * @email jinshengcong@163.com
 */
public class TankFrame extends Frame {
    public TankFrame() {
        this.setTitle("Tank War");
        this.setSize(800,500);
        this.setVisible(true);
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

    @Override
    public void paint(Graphics g) {
        g.fillRect(200,200,80,80);
    }
}
