package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;

import service.CustomerService;
import service.Impl.CustomerServiceImpl;
import util.castutil;
import javax.swing.event.ChangeEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Dialog.ModalityType;
import java.awt.Font;

public class UI_Addmoney extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField text_nowMoney;
	CustomerService cs = new CustomerServiceImpl();
	private JTextField txt_addmoney;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UI_Addmoney dialog = new UI_Addmoney();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public UI_Addmoney() {
		setTitle("\u5145\u503C\u9875\u9762");
		setModalityType(ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 380, 377);
		setLocationRelativeTo(null);// 居中
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel label = new JLabel("\u5F53\u524D\u4F59\u989D:");
		label.setBounds(78, 34, 87, 29);
		contentPanel.add(label);

		text_nowMoney = new JTextField();
		text_nowMoney.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		text_nowMoney.setEnabled(false);
		text_nowMoney.setText(castutil.castString(UI_Manager.nowMoney));
		text_nowMoney.setBounds(168, 31, 77, 32);
		contentPanel.add(text_nowMoney);
		text_nowMoney.setColumns(10);

		JLabel label_1 = new JLabel("\u5145\u503C\u91D1\u989D:");
		label_1.setBounds(78, 117, 87, 29);
		contentPanel.add(label_1);

		txt_addmoney = new JTextField();
		txt_addmoney.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		txt_addmoney.setBounds(168, 117, 77, 32);
		contentPanel.add(txt_addmoney);
		txt_addmoney.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{ // 确认充值按钮
				JButton okButton = new JButton("\u786E\u8BA4");
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						if(txt_addmoney.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "请输入充值金额！");	
						}else {							
							UI_Manager.nowMoney = castutil.castDouble(txt_addmoney.getText()) + UI_Manager.nowMoney;
							JOptionPane.showMessageDialog(null, "充值成功！\r\n"+"您的当前余额为："+UI_Manager.nowMoney);
							dispose();
						}
					}
				});
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{	//取消按钮
				JButton cancelButton = new JButton("\u91CD\u7F6E");
				cancelButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						txt_addmoney.setText("");
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
