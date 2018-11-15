package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import util.castutil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Dialog.ModalityType;

public class UI_Pay extends JDialog {

	private JPanel contentPane;
	private JTextField text_should;
	private JTextField text_pay;
	private JButton btn_sure;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI_Pay frame = new UI_Pay();
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
	public UI_Pay() {
		setModalityType(ModalityType.APPLICATION_MODAL);
		setTitle("\u652F\u4ED8\u754C\u9762");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 296, 300);
		contentPane = new JPanel();
		setIconImage(Toolkit.getDefaultToolkit().getImage("img\\timg1.jpg"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u5E94\u4ED8:");
		label.setBounds(10, 28, 54, 15);
		contentPane.add(label);
		
		text_should = new JTextField();
		text_should.setEditable(false);
		text_should.setBounds(80, 25, 126, 21);
		contentPane.add(text_should);
		text_should.setColumns(10);
		
		JLabel label_1 = new JLabel("\u652F\u4ED8:");
		label_1.setBounds(10, 82, 54, 15);
		contentPane.add(label_1);
		
		text_pay = new JTextField();
		text_pay.setBounds(80, 79, 126, 21);
		contentPane.add(text_pay);
		text_pay.setColumns(10);
		
		btn_sure = new JButton("\u786E\u5B9A");
		btn_sure.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(castutil.castDouble(text_pay.getText())>=castutil.castDouble(text_should.getText())) {
					JOptionPane.showMessageDialog(null, "成功付款"+text_pay.getText()+"元");
					dispose();
				}else {
					JOptionPane.showMessageDialog(null, "余额不足,充值失败!");
				}
			}
		});
		btn_sure.setBounds(80, 177, 93, 23);
		contentPane.add(btn_sure);
		text_should.setText(UI_Customer_Addmoney.addMoney+"");
		
	}
}
