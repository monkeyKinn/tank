

import org.junit.Assert;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * description
 *
 * @author 金聖聰
 * @version v1.0
 * @email jinshengcong@163.com
 */
public class ImageTest {
    @Test
    public void testImg(){
        BufferedImage read = null;
        try {
            read = ImageIO.read(new File("F:/1.png"));
            Assert.assertNotNull(read);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
