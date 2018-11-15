package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.apache.poi.hssf.record.cf.BorderFormatting;

import entity.Table_Customer;
import util.ImgUtil;

import java.awt.Toolkit;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JSeparator;
import java.awt.Dialog.ModalityType;

public class UI_Setup extends JDialog {

	private final JPanel contentPanel = new JPanel();
	Table_Customer customer;
	private JLabel lb_img;
	private JLabel lb_name;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UI_Setup dialog = new UI_Setup();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public UI_Setup(Table_Customer c) {
		this();
		
//		try {
//			Image img = ImgUtil.getIcon(new FileInputStream(c.getCphoto()), 94,88);
//			lb_img.setIcon(new ImageIcon(img));
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//		
		if (c.getCphoto()==null) {
			try {
				Image img = ImgUtil.getIcon(new FileInputStream("img/人物.png"),  94,88);
				lb_img.setIcon(new ImageIcon(img));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		} else {
			try {
				Image img = ImgUtil.getIcon(new FileInputStream(c.getCphoto()), 94,88);
				lb_img.setIcon(new ImageIcon(img));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		lb_name.setText(c.getCname());
		
	}
	/**
	 * Create the dialog.
	 */
	public UI_Setup() {
		setModalityType(ModalityType.APPLICATION_MODAL);
		setTitle("\u8BBE\u7F6E");
		setIconImage(Toolkit.getDefaultToolkit().getImage("img\\timg1.jpg"));
		setBounds(100, 100, 311, 393);
		getContentPane().setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		/**
		 * 照片用户名
		 */
		JPanel panel = new JPanel();
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				UI_GeRen uig=new UI_GeRen(UI_Login.customer);
				uig.setLocationRelativeTo(null);
				uig.setVisible(true);
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				panel.setBackground(new Color(224, 255, 255));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panel.setBackground(new Color(240, 240, 240));
			}
		});
		panel.setBounds(10, 28, 273, 88);
		contentPanel.add(panel);
		panel.setLayout(null);

		lb_img = new JLabel("");
		lb_img.setBackground(new Color(255, 250, 205));
		//lb_img.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		lb_img.setBounds(0, 0, 94, 88);
		panel.add(lb_img);

		lb_name = new JLabel("");
		lb_name.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lb_name.setBounds(118, 28, 119, 25);
		panel.add(lb_name);

		JLabel label_7 = new JLabel();
		try {
			Image img = ImgUtil.getIcon(new FileInputStream("img/kuohao1.png"), 13, 13);
			label_7.setIcon(new ImageIcon(img));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		label_7.setBounds(244, 40, 29, 15);
		panel.add(label_7);
		/**
		 * 意见反馈
		 */
		JPanel panel_1 = new JPanel();
		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				JPanel contentPanel = new JPanel();
				JDialog add_dialog = new JDialog(new JDialog(), "意见反馈", true);
				add_dialog.setIconImage(Toolkit.getDefaultToolkit().getImage("img\\timg1.jpg"));
				add_dialog.getContentPane().setLayout(null);
				add_dialog.setBounds(600, 200, 250, 300);

				JLabel label_name = new JLabel("请输入您的意见或建议:");
				label_name.setBounds(30, 10, 150, 20);

				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(30, 60, 180, 120);
				contentPanel.add(scrollPane);

				JTextArea textArea = new JTextArea();
				scrollPane.setViewportView(textArea);
				textArea.setLineWrap(true);
				textArea.setRows(3);

				JButton update = new JButton("提交");
				update.setBounds(30, 210, 60, 25);
				JButton reset = new JButton("重置");
				reset.setBounds(150, 210, 60, 25);

				add_dialog.getContentPane().add(label_name);
				add_dialog.getContentPane().add(scrollPane);
				add_dialog.getContentPane().add(update);
				add_dialog.getContentPane().add(reset);
				update.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						JOptionPane.showMessageDialog(null, "感谢您的建议,我们会不断改进");
						add_dialog.dispose();
					}
				});
				reset.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						textArea.setText(null);
					}
				});
				add_dialog.setVisible(true);

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				panel_1.setBackground(new Color(224, 255, 255));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panel_1.setBackground(new Color(240, 240, 240));
			}
		});

		panel_1.setBounds(10, 135, 273, 54);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);

		JLabel label_1 = new JLabel("\u7ED9\u6211\u4EEC\u8BC4\u4EF7");
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		label_1.setBounds(10, 10, 89, 31);
		panel_1.add(label_1);

		JLabel label_2 = new JLabel();
		try {
			Image img = ImgUtil.getIcon(new FileInputStream("img/kuohao1.png"), 13, 13);
			label_2.setIcon(new ImageIcon(img));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		label_2.setBounds(234, 19, 29, 15);
		panel_1.add(label_2);
		/**
		 * 版本更新
		 */
		JPanel panel_2 = new JPanel();
		panel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "已是最新版本");
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				panel_2.setBackground(new Color(224, 255, 255));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panel_2.setBackground(new Color(240, 240, 240));
			}
		});
		panel_2.setLayout(null);
		panel_2.setBounds(10, 210, 273, 54);
		contentPanel.add(panel_2);

		JLabel label_3 = new JLabel("\u7248\u672C\u66F4\u65B0");
		label_3.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		label_3.setBounds(10, 10, 89, 31);
		panel_2.add(label_3);

		JLabel label_4 = new JLabel();
		try {
			Image img = ImgUtil.getIcon(new FileInputStream("img/kuohao1.png"), 13, 13);
			label_4.setIcon(new ImageIcon(img));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		label_4.setBounds(234, 19, 29, 15);
		panel_2.add(label_4);

		JLabel lblNewLabel_1 = new JLabel("v_1.0");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(151, 10, 73, 31);
		panel_2.add(lblNewLabel_1);
		/**
		 * 关于我们
		 */
		JPanel panel_3 = new JPanel();
		panel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				UI_Our our=new UI_Our();
				our.setLocationRelativeTo(null);
				our.setVisible(true);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				panel_3.setBackground(new Color(224, 255, 255));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panel_3.setBackground(new Color(240, 240, 240));
			}
		});
		panel_3.setLayout(null);
		panel_3.setBounds(10, 283, 273, 54);
		contentPanel.add(panel_3);

		JLabel label_5 = new JLabel("\u5173\u4E8E\u6211\u4EEC");
		label_5.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		label_5.setBounds(10, 10, 89, 31);
		panel_3.add(label_5);

		JLabel label_6 = new JLabel();
		try {
			Image img = ImgUtil.getIcon(new FileInputStream("img/kuohao1.png"), 13, 13);
			label_6.setIcon(new ImageIcon(img));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		label_6.setBounds(234, 19, 29, 15);
		panel_3.add(label_6);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 123, 275, 2);
		contentPanel.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 196, 275, 2);
		contentPanel.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(8, 270, 275, 2);
		contentPanel.add(separator_2);
	}
}
