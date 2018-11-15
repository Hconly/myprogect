package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import dao.Impl.CustomerDaoImpl;
import entity.Table_Customer;
import entity.Table_Manger;
import service.CustomerService;
import service.MangerService;
import service.MangerServiceImpl;
import service.Impl.CustomerServiceImpl;
import util.DBUtil;
import util.ImgUtil;

/**
 * 登录页面
 * @author 腾飞
 *@date 2018年10月3日下午5:15:57
 */
public class UI_Login extends JFrame {

	private JPanel contentPane;
	private JLabel lb_backgroung;
	private JLabel label_1;
	private JTextField txt_username;
	private JRadioButton rb_user;
	private JRadioButton rb_manager;
	private JPasswordField txt_pwd;
	private JLabel lblNewLabel_1;
	protected static String c_name;
	protected static int cid;
	static CustomerService cs;
	protected static Table_Customer customer;
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI_Login frame = new UI_Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UI_Login() {
		
		setResizable(false);
		setTitle("\u7535\u5F71\u8D2D\u7968\u7CFB\u7EDF");
		setBounds(500, 100, 959, 665);
		setLocationRelativeTo(null);// 居中
		contentPane = new JPanel();
		setIconImage(Toolkit.getDefaultToolkit().getImage("img\\timg1.jpg"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("\u6B22\u8FCE\u4F7F\u7528\u7535\u5F71\u8D2D\u7968\u7CFB\u7EDF");
		label.setFont(new Font("微软雅黑", Font.BOLD, 30));
		label.setBounds(313, 28, 322, 44);
		contentPane.add(label);

		label_1 = new JLabel("\u7528\u6237\u540D");
		label_1.setFont(new Font("微软雅黑", Font.BOLD, 20));
		label_1.setBounds(328, 121, 73, 34);
		contentPane.add(label_1);

		txt_username = new JTextField();
		txt_username.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		txt_username.setBounds(420, 120, 188, 37);
		contentPane.add(txt_username);
		txt_username.setColumns(10);

		JLabel label_2 = new JLabel("\u5BC6    \u7801");
		label_2.setFont(new Font("微软雅黑", Font.BOLD, 20));
		label_2.setBounds(328, 214, 82, 37);
		contentPane.add(label_2);

		txt_pwd = new JPasswordField();
		txt_pwd.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		txt_pwd.setBounds(420, 216, 188, 37);
		contentPane.add(txt_pwd);

		rb_user = new JRadioButton("\u7528\u6237");
		rb_user.setSelected(true);
		rb_user.setFont(new Font("微软雅黑", Font.BOLD, 20));
		rb_user.setBounds(334, 389, 104, 29);
		contentPane.add(rb_user);

		rb_manager = new JRadioButton("\u7BA1\u7406\u5458");
		rb_manager.setFont(new Font("微软雅黑", Font.BOLD, 20));
		rb_manager.setBounds(531, 389, 104, 29);
		contentPane.add(rb_manager);

		// 创建一个按钮分组实现单选
		ButtonGroup bg = new ButtonGroup();
		bg.add(rb_user);
		bg.add(rb_manager);

		// 注册按钮
		JButton btnNewButton = new JButton("\u6CE8    \u518C");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// 先判断注册身份
				if (rb_user.isSelected()) {
					dispose();
					// 注册窗体居中
					UI_Registe regist = new UI_Registe();
					regist.setVisible(true);
					regist.setLocationRelativeTo(null);
				} else if (rb_manager.isSelected()) {
					JOptionPane.showMessageDialog(null, "不能注册管理员！", "登录提示", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		btnNewButton.setFont(new Font("微软雅黑", Font.BOLD, 20));
		btnNewButton.setBounds(328, 486, 129, 44);
		contentPane.add(btnNewButton);

		// 登录按钮
		JButton button = new JButton("\u767B    \u5F55");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// 先判断登录身份
				if (rb_user.isSelected()) {
					if (txt_username.getText().equals("") || txt_pwd.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "用户名或密码不能为空！", "登录提示", JOptionPane.ERROR_MESSAGE);
					} else {
						cs = new CustomerServiceImpl();
						try {
							customer = cs.getCustomerByCname(txt_username.getText());
							UI_Login.this.c_name=txt_username.getText();
							UI_Login.this.cid=customer.getCid();
							if (customer.getCpwd().equals(txt_pwd.getText())) {
								dispose();
								UI_mainView uim=	new UI_mainView();
								uim.setVisible(true);
							} else {
								JOptionPane.showMessageDialog(null, "密码输入错误！", "登录提示", JOptionPane.ERROR_MESSAGE);
							}
						} catch (NullPointerException e1) {
							JOptionPane.showMessageDialog(null, "用户名或密码输入错误！", "登录提示", JOptionPane.ERROR_MESSAGE);

						}
					}
				} else if (rb_manager.isSelected()) {
					if (txt_username.getText().equals("") || txt_pwd.getText().equals("")) {
		 				JOptionPane.showMessageDialog(null, "用户名或密码不能为空！", "登录提示", JOptionPane.ERROR_MESSAGE);
					} else {
						MangerService cs = new MangerServiceImpl();
						try {
							Table_Manger manger = cs.getMangerByMuser(txt_username.getText());
							
							if (manger.getMpwd().equals(txt_pwd.getText())) {
								dispose();
								new UI_Manager();
							} else {
								JOptionPane.showMessageDialog(null, "密码输入错误！", "登录提示", JOptionPane.ERROR_MESSAGE);
							}
						} catch (NullPointerException e1) {
							JOptionPane.showMessageDialog(null, "用户名或密码输入错误！", "登录提示", JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			}

		});
		button.setFont(new Font("微软雅黑", Font.BOLD, 20));
		button.setBounds(519, 486, 129, 44);
		contentPane.add(button);

		lblNewLabel_1 = new JLabel(
				"\u8BF7\u9009\u62E9\u60A8\u7684\u767B\u5F55\u8EAB\u4EFD\uFF0C\u6CE8\u518C\u65B0\u8D26\u53F7\u8BF7\u70B9\u51FB\u6CE8\u518C\u6309\u94AE");
		lblNewLabel_1.setForeground(Color.GRAY);
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(276, 316, 443, 34);
		contentPane.add(lblNewLabel_1);

		lb_backgroung = new JLabel("");
		lb_backgroung.setBounds(0, 0, 953, 625);
		contentPane.add(lb_backgroung);

		try {
			// 设置背景图片，图片大小与窗体同大小
			ImageIcon icon = new ImageIcon(ImgUtil.getIcon(new FileInputStream("img/loginBackground.jpg"), 665, 959));
			lb_backgroung.setIcon(icon);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static Table_Customer getCustomer() {
		return customer;
	}
}
