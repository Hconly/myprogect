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
			//��ͼƬ�ֽ���ת����һ��ͼƬ����
			Image image = ImageIO.read(is);
			//����һ�ſջ���,���ÿ��,�߶Ⱥ�ͼƬ����
			bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			//��ͼƬ����ָ��λ��
			bufferedImage.getGraphics().drawImage(image, 0, 0, width, height, null);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return bufferedImage;

	}
}
