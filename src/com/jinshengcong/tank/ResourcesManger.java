package com.jinshengcong.tank;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * 加载资源
 *
 * @author 金聖聰
 * @version v1.0
 * @email jinshengcong@163.com
 */
public class ResourcesManger {
    public static BufferedImage tankU,tankD,tankL,tankR;
    static {
        try {
            tankL = ImageIO.read(ResourcesManger.class.getClassLoader().getResourceAsStream("images/tankL.gif"));
            tankD = ImageIO.read(ResourcesManger.class.getClassLoader().getResourceAsStream("images/tankD.gif"));
            tankR = ImageIO.read(ResourcesManger.class.getClassLoader().getResourceAsStream("images/tankR.gif"));
            tankU = ImageIO.read(ResourcesManger.class.getClassLoader().getResourceAsStream("images/tankU.gif"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
