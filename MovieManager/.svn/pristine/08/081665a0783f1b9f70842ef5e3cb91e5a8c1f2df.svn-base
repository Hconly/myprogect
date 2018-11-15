package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import entity.dto.MovieDto;
import service.MovieService;
import service.Impl.MovieServiceImpl;
import util.ImgUtil;
import util.castutil;

import javax.swing.JTextArea;
import java.awt.SystemColor;

public class UI_LoveMovie extends JPanel {
	
	private Dimension srcsize;
	InputStream is;

	private JLabel pianming;
	private JLabel daoyan;
	private JLabel zhuyan;
	private JLabel shichang;
	private JLabel pingfen;
	private JLabel type;
	protected static int  mid;
	MovieServiceImpl ms=new MovieServiceImpl();
	/**
	 * Create the panel.
	 */
	public UI_LoveMovie() {
		
		setLayout(null);
		
		srcsize = Toolkit.getDefaultToolkit().getScreenSize();// 获取屏幕尺寸
		int y = 5;
		int x = 10;
		MovieService ms = new MovieServiceImpl();
		List<MovieDto> list = ms.getById(2);
		/**
		 * 遍历电影
		 */
		for (int i = 0; i < list.size(); i++) {
			
			try {
				is = new FileInputStream(list.get(i).getMovie().getM_image());
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		
		
		
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			
			// 判断如果越界就另起一行
			if (x + 260 > srcsize.getWidth() * 0.9) {
				y += 355;
				x = 10;
			}
			x += 270;
			panel.setBounds(x - 230, y, 260, 350);
			// System.out.println(x+"\t"+y);
			add(panel);
			panel.setLayout(null);
			/**
			 * 添加图片
			 */
			JLabel lblNewLabel = new JLabel();
			lblNewLabel.setIcon(new ImageIcon(ImgUtil.getIcon(is, 200, 150)));
			lblNewLabel.setBounds(50, -45, 200, 300);
			panel.add(lblNewLabel);


			JLabel label = new JLabel("片名:");
			label.setBounds(20, 219, 30, 15);
			panel.add(label);
			
			pianming = new JLabel(list.get(i).getMovie().getM_name());
			pianming.setBounds(62, 219, 70, 15);
			panel.add(pianming);
			
			JLabel label_1 = new JLabel("导演:");//导演
			label_1.setBounds(146, 219, 30, 15);
			panel.add(label_1);
			daoyan = new JLabel(list.get(i).getMovie().getM_director());
			daoyan.setBounds(185, 219, 90, 15);
			panel.add(daoyan);
			
			JLabel label_2 = new JLabel("主演:");//主演
			label_2.setBounds(20, 238, 30, 15);
			panel.add(label_2);
			zhuyan = new JLabel(list.get(i).getMovie().getM_mainactor());
			zhuyan.setBounds(62, 238, 83, 15);
			panel.add(zhuyan);
			
			JLabel label_3 = new JLabel("时长:");//时长
			label_3.setBounds(150, 238, 30, 15);
			panel.add(label_3);
			shichang = new JLabel(list.get(i).getMovie().getM_duration());
			shichang.setBounds(190, 238, 60, 15);
			panel.add(shichang);
			
			JLabel label_4 = new JLabel("评分:");//评分
			label_4.setBounds(20, 257, 30, 15);
			panel.add(label_4);
			pingfen = new JLabel(castutil.castString(list.get(i).getMovie().getM_score()));
			pingfen.setBounds(62, 257, 60, 15);
			panel.add(pingfen);
			
			JLabel label_6 = new JLabel("类型:");//类型
			label_6.setBounds(150, 257, 30, 15);
			panel.add(label_6);
			type = new JLabel(list.get(i).getMovietype().getTname());
			type.setBounds(190, 257, 60, 15);
			panel.add(type);
			
			JLabel label_5 = new JLabel("简介:");//简介
			label_5.setBounds(20, 276, 54, 15);
			panel.add(label_5);
			
			JTextArea textArea = new JTextArea();
			textArea.setBackground(SystemColor.control);
			textArea.setRows(5);
			textArea.setLineWrap(true);
			textArea.setText(list.get(i).getMovie().getM_desc());
			textArea.setBounds(56, 276, 195, 70);
			textArea.setEditable(false);
			panel.add(textArea);
			
			panel.setName(list.get(i).getMovie().getM_name());
			

			
			panel.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					panel.setBackground(new Color(224, 255, 255));
					textArea.setBackground(new Color(224, 255, 255));
					UI_LoveMovie.this.mid=ms.getbyName(panel.getName()).getMid();
					
					UI_Schule uis = new UI_Schule();
					uis.setLocationRelativeTo(null);
					uis.setVisible(true);
					panel.setBackground(getBackground());
					textArea.setBackground(SystemColor.control);
				}
				public void mouseEntered(MouseEvent e) {
					panel.setBackground(new Color(224, 255, 255));
					textArea.setBackground(new Color(224, 255, 255));
				}
				public void mouseExited(MouseEvent e) {
					panel.setBackground(getBackground());
					textArea.setBackground(SystemColor.control);
				}
			});
	
		}

		
	}
}
