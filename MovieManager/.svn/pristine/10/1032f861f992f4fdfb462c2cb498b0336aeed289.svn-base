package util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class ImgUtil {
	public static BufferedImage getIcon(InputStream is, int height, int width) {
		BufferedImage bufferedImage = null;
		try {
			//将图片字节流转换成一个图片对象
			Image image = ImageIO.read(is);
			//创建一张空画板,设置宽度,高度和图片类型
			bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			//将图片画到指定位置
			bufferedImage.getGraphics().drawImage(image, 0, 0, width, height, null);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return bufferedImage;

	}
}
