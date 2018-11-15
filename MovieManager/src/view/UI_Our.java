package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import java.awt.Dialog.ModalityType;

public class UI_Our extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UI_Our dialog = new UI_Our();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public UI_Our() {
		setModalityType(ModalityType.APPLICATION_MODAL);
		setIconImage(Toolkit.getDefaultToolkit().getImage("img\\timg1.jpg"));
		setTitle("\u5173\u4E8E\u6211\u4EEC");
		setBounds(100, 100, 324, 474);
		getContentPane().setLayout(new BorderLayout());
		setIconImage(Toolkit.getDefaultToolkit().getImage("img\\timg1.jpg"));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("\u5F53\u524D\u7248\u672C");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel.setBounds(25, 39, 78, 26);
		contentPanel.add(lblNewLabel);

		JLabel lblV = new JLabel("v.1.0");
		lblV.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblV.setBounds(200, 39, 78, 26);
		contentPanel.add(lblV);

		JLabel label = new JLabel("\u9690\u79C1\u6743\u653F\u7B56");
		label.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		label.setBounds(25, 82, 98, 26);
		contentPanel.add(label);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 118, 251, 125);
		contentPanel.add(scrollPane);

		JTextArea textArea = new JTextArea();
		textArea.setText("提示条款\r\n"
				+ "您的信任对我们非常重要，我们深知个人信息对您的重要性，我们将按法律法规要求，采取相应安全保护措施，尽力保护您的个人信息安全可控。鉴此，淘票票服务提供者（或简称“我们”）制定本隐私权政策（下称“本政策/本隐私权政策”）并提醒您：本政策适用于淘票票产品或服务。\r\n"
				+ "需要特别说明的是，本政策不适用于其他第三方向您提供服务的情形。例如淘票票上的影院或第三方服务商依托淘票票向您提供服务时，您向其提供的个人信息不适用本政策。");
		textArea.setRows(5);
		textArea.setLineWrap(true);
		scrollPane.setViewportView(textArea);

		JLabel label_1 = new JLabel("\u7528\u6237\u534F\u8BAE");
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		label_1.setBounds(26, 247, 98, 26);
		contentPanel.add(label_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(37, 270, 249, 123);
		contentPanel.add(scrollPane_1);

		JTextArea textArea_1 = new JTextArea();
		scrollPane_1.setViewportView(textArea_1);
		textArea_1.setText("提示条款：\r\n" + "欢迎您与淘票票经营者（详见定义条款）共同签署本《淘票票用户服务协议》（下称“本协议”）并使用淘票票服务。\r\n"
				+ "【审慎阅读】您在点击确认同意本协议之前，应当认真阅读本协议。请您务必审慎阅读、充分理解各条款内容，特别是免除或者限制责任的条款、法律适用和争议解决条款。\r\n" + "");
		textArea_1.setRows(5);
		textArea_1.setLineWrap(true);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(25, 77, 249, -12);
		contentPanel.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(25, 75, 253, 2);
		contentPanel.add(separator_1);
	}
}
