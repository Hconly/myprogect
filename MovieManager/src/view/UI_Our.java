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
		lblNewLabel.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		lblNewLabel.setBounds(25, 39, 78, 26);
		contentPanel.add(lblNewLabel);

		JLabel lblV = new JLabel("v.1.0");
		lblV.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		lblV.setBounds(200, 39, 78, 26);
		contentPanel.add(lblV);

		JLabel label = new JLabel("\u9690\u79C1\u6743\u653F\u7B56");
		label.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		label.setBounds(25, 82, 98, 26);
		contentPanel.add(label);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 118, 251, 125);
		contentPanel.add(scrollPane);

		JTextArea textArea = new JTextArea();
		textArea.setText("��ʾ����\r\n"
				+ "�������ζ����Ƿǳ���Ҫ��������֪������Ϣ��������Ҫ�ԣ����ǽ������ɷ���Ҫ�󣬲�ȡ��Ӧ��ȫ������ʩ�������������ĸ�����Ϣ��ȫ�ɿء����ˣ���ƱƱ�����ṩ�ߣ����ơ����ǡ����ƶ�����˽Ȩ���ߣ��³ơ�������/����˽Ȩ���ߡ���������������������������ƱƱ��Ʒ�����\r\n"
				+ "��Ҫ�ر�˵�����ǣ������߲����������������������ṩ��������Ρ�������ƱƱ�ϵ�ӰԺ�������������������ƱƱ�����ṩ����ʱ���������ṩ�ĸ�����Ϣ�����ñ����ߡ�");
		textArea.setRows(5);
		textArea.setLineWrap(true);
		scrollPane.setViewportView(textArea);

		JLabel label_1 = new JLabel("\u7528\u6237\u534F\u8BAE");
		label_1.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		label_1.setBounds(26, 247, 98, 26);
		contentPanel.add(label_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(37, 270, 249, 123);
		contentPanel.add(scrollPane_1);

		JTextArea textArea_1 = new JTextArea();
		scrollPane_1.setViewportView(textArea_1);
		textArea_1.setText("��ʾ���\r\n" + "��ӭ������ƱƱ��Ӫ�ߣ�������������ͬǩ�𱾡���ƱƱ�û�����Э�顷���³ơ���Э�顱����ʹ����ƱƱ����\r\n"
				+ "�������Ķ������ڵ��ȷ��ͬ�ⱾЭ��֮ǰ��Ӧ�������Ķ���Э�顣������������Ķ�����������������ݣ��ر�����������������ε�����������ú����������\r\n" + "");
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
