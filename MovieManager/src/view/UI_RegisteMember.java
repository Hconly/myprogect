package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import entity.Table_Customer;
import entity.Table_Level;
import service.CustomerService;
import service.LevelService;
import service.Impl.CustomerServiceImpl;
import service.Impl.LevelServiceImpl;
import util.castutil;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 会员升级页面
 * @author 腾飞
 *@date 2018年10月6日上午10:12:25
 */
public class UI_RegisteMember extends JFrame {

	private JPanel contentPane;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_7;
	private JLabel label_8;
	private JLabel label_9;
	private JLabel label_10;
	private JLabel label_11;
	private JLabel label_12;
	private JLabel label_13;
	private JLabel label_14;
	private JLabel label_15;
	private JLabel label_16;
	private JPanel panel;
	private JComboBox cb_level;
	private JButton btnNewButton;
	private JButton button;
	DefaultComboBoxModel dcm = null;
	LevelService ls = new LevelServiceImpl();
	CustomerService cs = new CustomerServiceImpl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI_RegisteMember frame = new UI_RegisteMember();
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
	public UI_RegisteMember() {
		setResizable(false);
		setFont(new Font("微软雅黑", Font.PLAIN, 18));
		setTitle("\u6B22\u8FCE\u6765\u5230\u4F1A\u5458\u5347\u7EA7\u9875\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 762);
		contentPane = new JPanel();
		setIconImage(Toolkit.getDefaultToolkit().getImage("img\\timg1.jpg"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("\u4F1A\u5458\u7EA7\u522B");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(36, 72, 97, 31);
		contentPane.add(lblNewLabel_1);

		JLabel label = new JLabel("\u5145\u503C\u91D1\u989D");
		label.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		label.setBounds(278, 72, 90, 31);
		contentPane.add(label);

		JLabel label_1 = new JLabel("\u6298   \u6263");
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		label_1.setBounds(519, 72, 76, 31);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel("\u666E\u901A\u4F1A\u5458");
		label_2.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		label_2.setBounds(36, 143, 97, 31);
		contentPane.add(label_2);

		label_3 = new JLabel("\u5C0A\u8D35\u94C2\u91D1");
		label_3.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		label_3.setBounds(36, 208, 97, 31);
		contentPane.add(label_3);

		label_4 = new JLabel("\u6C38\u6052\u94BB\u77F3");
		label_4.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		label_4.setBounds(36, 261, 97, 31);
		contentPane.add(label_4);

		label_5 = new JLabel("\u81F3\u5C0A\u661F\u8000");
		label_5.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		label_5.setBounds(36, 324, 97, 31);
		contentPane.add(label_5);

		label_6 = new JLabel("\u6700\u5F3A\u738B\u8005");
		label_6.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		label_6.setBounds(36, 389, 97, 31);
		contentPane.add(label_6);

		label_13 = new JLabel("\u4E5D    \u6298");
		label_13.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		label_13.setBounds(519, 201, 97, 41);
		contentPane.add(label_13);

		label_14 = new JLabel("\u516B    \u6298");
		label_14.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		label_14.setBounds(519, 261, 97, 41);
		contentPane.add(label_14);

		label_15 = new JLabel("\u4E03    \u6298");
		label_15.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		label_15.setBounds(519, 324, 97, 41);
		contentPane.add(label_15);

		label_16 = new JLabel("\u516D    \u6298");
		label_16.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		label_16.setBounds(519, 379, 97, 41);
		contentPane.add(label_16);

		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u4F1A\u5458\u6CE8\u518C\u6982\u89C8", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel.setBounds(15, 29, 644, 400);
		contentPane.add(panel);
		panel.setLayout(null);

		label_7 = new JLabel("0");
		label_7.setBounds(275, 111, 97, 41);
		panel.add(label_7);
		label_7.setFont(new Font("微软雅黑", Font.PLAIN, 20));

		label_8 = new JLabel("200");
		label_8.setBounds(275, 175, 97, 41);
		panel.add(label_8);
		label_8.setFont(new Font("微软雅黑", Font.PLAIN, 20));

		label_9 = new JLabel("400");
		label_9.setBounds(275, 231, 97, 41);
		panel.add(label_9);
		label_9.setFont(new Font("微软雅黑", Font.PLAIN, 20));

		label_10 = new JLabel("600");
		label_10.setBounds(275, 292, 97, 41);
		panel.add(label_10);
		label_10.setFont(new Font("微软雅黑", Font.PLAIN, 20));

		label_11 = new JLabel("1000");
		label_11.setBounds(275, 348, 97, 41);
		panel.add(label_11);
		label_11.setFont(new Font("微软雅黑", Font.PLAIN, 20));

		label_12 = new JLabel("\u4E0D\u6253\u6298");
		label_12.setBounds(507, 111, 97, 41);
		panel.add(label_12);
		label_12.setFont(new Font("微软雅黑", Font.PLAIN, 20));

		cb_level = new JComboBox();
		cb_level.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		// 设置数据源
		dcm = new DefaultComboBoxModel();
		List<Table_Level> list = ls.findAll();
		dcm.addElement("--请选择您要升级的会员级别--");

		for (Table_Level level : list) {

			dcm.addElement(level);
		}
		cb_level.setModel(dcm);
		cb_level.setBounds(174, 515, 302, 41);
		contentPane.add(cb_level);
		// 确认提交按钮，设置会员等级
		btnNewButton = new JButton("\u786E\u8BA4\u63D0\u4EA4");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Table_Customer c = new Table_Customer();
				c = cs.getCustomerByMaxId();
				Table_Level item = (Table_Level) cb_level.getSelectedItem();
				// 获取客户选择级别的lid
				c.setClid(item.getLid());
				int num = JOptionPane.showConfirmDialog(null, "本次充值金额为" + item.getLdesc() + "元！是否充值？", "充值提示",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (num == 0) {
					// 记录充值金额
					c.setCmoney(castutil.castDouble(item.getLdesc()));
					cs.updateCustomer(c);
					JOptionPane.showMessageDialog(null, "充值成功！您已升级为" + item + "会员!");
				}
			}
		});
		btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		btnNewButton.setBounds(36, 642, 132, 41);
		contentPane.add(btnNewButton);
		// 返回登录按钮
		button = new JButton("\u8FD4\u56DE\u767B\u5F55");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				dispose();
				new UI_Login().setVisible(true);
			}
		});
		button.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		button.setBounds(492, 642, 132, 41);
		contentPane.add(button);
	}
}
