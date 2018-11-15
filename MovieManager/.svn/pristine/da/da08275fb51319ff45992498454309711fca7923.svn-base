package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDesktopPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.BoxLayout;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class UI_PersonalCenter extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField txtx;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI_PersonalCenter frame = new UI_PersonalCenter();
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
	public UI_PersonalCenter() {
		setTitle("\u6211\u7684");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 392, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		
		JPanel panel_1 = new JPanel();
		
		JPanel panel_2 = new JPanel();
		
		JPanel panel_3 = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 427, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 425, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 357, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 363, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE))
		);
		panel_3.setLayout(null);
		
		JButton button_3 = new JButton("\u60F3\u770B\u7684\u7535\u5F71");
		button_3.setBounds(10, 10, 93, 23);
		panel_3.add(button_3);
		
		JButton button_4 = new JButton("\u770B\u8FC7\u7684\u7535\u5F71");
		button_4.setBounds(113, 10, 93, 23);
		panel_3.add(button_4);
		
		JButton button_5 = new JButton("\u5E2E\u52A9\u4E0E\u53CD\u9988");
		button_5.setBounds(216, 10, 93, 23);
		panel_3.add(button_5);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(0, 47, 363, 168);
		panel_3.add(panel_4);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_4.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 363, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_4.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE))
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u5F71\u7247\u540D\u79F0", "\u5BFC\u6F14", "\u653E\u6620\u65F6\u95F4", "\u8BC4\u4EF7"
			}
		));
		scrollPane.setViewportView(table);
		panel_4.setLayout(gl_panel_4);
		panel_2.setLayout(null);
		
		JButton button = new JButton("\u7535\u5F71\u7968");
		button.setBounds(10, 20, 93, 23);
		panel_2.add(button);
		
		JButton button_1 = new JButton("\u4F18\u60E0\u5238");
		button_1.setBounds(116, 20, 93, 23);
		panel_2.add(button_1);
		
		JButton button_2 = new JButton("\u6743\u76CA\u5361");
		button_2.setBounds(219, 20, 93, 23);
		panel_2.add(button_2);
		panel_1.setLayout(null);
		
		JLabel label_1 = new JLabel("\u4F1A\u5458\u4E2D\u5FC3");
		label_1.setBounds(10, 10, 54, 15);
		panel_1.add(label_1);
		
		txtx = new JTextField();
		txtx.setEditable(false);
		txtx.setText("\u518D\u79EF\u7D2F\u6D88\u8D39\u82E5\u5E72\u5143\u53EF\u4EE5\u5347\u7EA7\u4E3AX\u7EA7\u4F1A\u5458-->");
		txtx.setBounds(119, 7, 222, 21);
		panel_1.add(txtx);
		txtx.setColumns(10);
		panel.setLayout(null);
		
		JLabel label = new JLabel("\u4F1A\u5458\u5934\u50CF");
		label.setBounds(10, 29, 54, 15);
		panel.add(label);
		
		textField = new JTextField();
		textField.setText("\u4F1A\u5458\u6635\u79F0");
		textField.setBounds(88, 26, 66, 21);
		panel.add(textField);
		textField.setColumns(10);
		contentPane.setLayout(gl_contentPane);
	}
}
