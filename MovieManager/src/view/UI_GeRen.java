package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.eltima.components.ui.DatePicker;

import entity.Table_Customer;
import service.CustomerService;
import service.Impl.CustomerServiceImpl;
import util.ImgUtil;
import util.castutil;

import java.awt.Toolkit;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.SystemColor;
import java.awt.Dialog.ModalityType;

public class UI_GeRen extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tx_name;
	private JTextArea text_desc;
	private JComboBox cb_cenger;
	private JLabel lb_photo;
	private JLabel lb_code;
	private File file;
	private JLabel lb_rest;
	private JButton btn_addmoney;
	private JTextField tx_phone;
	DatePicker tx_bir;
	private JTextField pwd;
	protected static Table_Customer customer;

	/**
	 * 
	 * /** Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UI_GeRen dialog = new UI_GeRen();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public UI_GeRen(Table_Customer customer) {
		this();
		UI_GeRen.this.customer = customer;
		if (customer.getCphoto() == null) {
			try {
				Image img = ImgUtil.getIcon(new FileInputStream("img/ÈËÎï.png"), 82, 73);
				lb_photo.setIcon(new ImageIcon(img));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		} else {
			try {
				Image img = ImgUtil.getIcon(new FileInputStream(customer.getCphoto()), 82, 73);
				lb_photo.setIcon(new ImageIcon(img));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}

		tx_name.setText(customer.getCname());
		if (customer.getCgender().equals("ÄÐ")) {
			cb_cenger.setSelectedIndex(0);
		} else {
			cb_cenger.setSelectedIndex(1);
		}

		text_desc.setText(customer.getCdesc());
		lb_rest.setText(castutil.castString(customer.getCmoney()));
		lb_code.setText(customer.getCcode());
		tx_phone.setText(customer.getCphone());
		tx_bir.getInnerTextField().setText(customer.getCbirthday());
		pwd.setText(customer.getCpwd());
	}

	/**
	 * Create the dialog.
	 */
	public UI_GeRen() {
		setModalityType(ModalityType.APPLICATION_MODAL);
		setTitle("\u4E2A\u4EBA\u4FE1\u606F");
		setIconImage(Toolkit.getDefaultToolkit().getImage("img\\timg1.jpg"));
		setBounds(100, 100, 293, 558);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		/**
		 * Í·Ïñ
		 */
		JPanel panel = new JPanel();
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.showOpenDialog(null);
				file = chooser.getSelectedFile();
				try {
					InputStream is = new FileInputStream(file);
					lb_photo.setIcon(new ImageIcon(ImgUtil.getIcon(is, 73, 82)));

				} catch (Exception e1) {
					System.out.println("Ã»ÎÊÌâ");
				}

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

		panel.setBounds(0, 10, 274, 74);
		contentPanel.add(panel);
		panel.setLayout(null);
		{
			JLabel label = new JLabel("\u5934\u50CF");
			label.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					panel.setBackground(new Color(224, 255, 255));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					panel.setBackground(new Color(240, 240, 240));
				}
			});
			label.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 13));
			label.setBounds(10, 30, 54, 15);
			panel.add(label);
		}
		{
			lb_photo = new JLabel();
			lb_photo.setBounds(136, 1, 82, 73);
			panel.add(lb_photo);
		}
		{
			JLabel lblNewLabel_1 = new JLabel();
			try {
				Image img = ImgUtil.getIcon(new FileInputStream("img/kuohao1.png"), 13, 13);
				lblNewLabel_1.setIcon(new ImageIcon(img));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			lblNewLabel_1.setBounds(248, 30, 16, 15);
			panel.add(lblNewLabel_1);
		}

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 85, 254, 2);
		contentPanel.add(separator);
		{
			/**
			 * êÇ³Æ
			 */
			JPanel panel_1 = new JPanel();
			panel_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					panel_1.setBackground(new Color(224, 255, 255));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					panel_1.setBackground(new Color(240, 240, 240));
				}
			});
			panel_1.setBounds(0, 87, 274, 37);
			contentPanel.add(panel_1);
			panel_1.setLayout(null);
			{
				JLabel label = new JLabel("\u6635\u79F0");
				label.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 13));
				label.setBounds(21, 10, 54, 15);
				panel_1.add(label);
			}
			{
				JLabel label = new JLabel();
				try {
					Image img = ImgUtil.getIcon(new FileInputStream("img/kuohao1.png"), 13, 13);
					label.setIcon(new ImageIcon(img));
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				label.setBounds(248, 10, 16, 15);
				panel_1.add(label);
			}

			tx_name = new JTextField();
			tx_name.setBackground(SystemColor.menu);
			tx_name.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 13));
			tx_name.setBounds(114, 6, 89, 21);
			panel_1.add(tx_name);
			tx_name.setColumns(10);
		}
		{
			JSeparator separator_1 = new JSeparator();
			separator_1.setBounds(10, 126, 254, 2);
			contentPanel.add(separator_1);
		}
		{
			/**
			 * ÐÔ±ð
			 */
			JPanel panel_1 = new JPanel();
			panel_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					panel_1.setBackground(new Color(224, 255, 255));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					panel_1.setBackground(new Color(240, 240, 240));
				}
			});
			panel_1.setBounds(0, 130, 274, 37);
			contentPanel.add(panel_1);
			panel_1.setLayout(null);
			{
				JLabel label = new JLabel("\u6027\u522B");
				label.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 13));
				label.setBounds(20, 10, 54, 15);
				panel_1.add(label);
			}
			{
				JLabel label = new JLabel();
				try {
					Image img = ImgUtil.getIcon(new FileInputStream("img/kuohao1.png"), 13, 13);
					label.setIcon(new ImageIcon(img));
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				label.setBounds(248, 10, 16, 15);
				panel_1.add(label);
			}

			cb_cenger = new JComboBox();
			cb_cenger.setModel(new DefaultComboBoxModel(new String[] { "\u7537", "\u5973" }));
			CustomerService cs = new CustomerServiceImpl();
			List<Table_Customer> list = cs.getCustomerLikeByColumn("ccode", 12345);
			for (Table_Customer table_Customer : list) {
				if (table_Customer.getCgender().equals("ÄÐ")) {
					cb_cenger.setSelectedIndex(0);
				} else {
					cb_cenger.setSelectedIndex(1);
				}
			}
			cb_cenger.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 13));
			cb_cenger.setBounds(116, 7, 44, 21);
			panel_1.add(cb_cenger);
		}
		{
			/**
			 * ¼ò½é
			 */
			JPanel panel_1 = new JPanel();
			panel_1.addMouseListener(new MouseAdapter() {

				@Override
				public void mouseEntered(MouseEvent e) {
					panel_1.setBackground(new Color(224, 255, 255));
					text_desc.setBackground(new Color(224, 255, 255));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					panel_1.setBackground(new Color(240, 240, 240));
					text_desc.setBackground(new Color(240, 240, 240));
				}
			});
			panel_1.setBounds(0, 311, 274, 76);
			contentPanel.add(panel_1);
			panel_1.setLayout(null);
			{
				JLabel label = new JLabel("\u4E00\u53E5\u8BDD\u4ECB\u7ECD\u81EA\u5DF1");
				label.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 13));
				label.setBounds(20, 28, 95, 15);
				panel_1.add(label);
			}
			{
				JLabel label = new JLabel();
				try {
					Image img = ImgUtil.getIcon(new FileInputStream("img/kuohao1.png"), 13, 13);
					label.setIcon(new ImageIcon(img));
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				label.setBounds(248, 28, 16, 15);
				panel_1.add(label);
			}

			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(114, 10, 115, 54);
			panel_1.add(scrollPane);

			text_desc = new JTextArea();
			text_desc.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					panel_1.setBackground(new Color(224, 255, 255));
					text_desc.setBackground(new Color(224, 255, 255));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					panel_1.setBackground(new Color(240, 240, 240));
					text_desc.setBackground(new Color(240, 240, 240));
				}
			});
			text_desc.setBackground(SystemColor.menu);
			text_desc.setRows(2);
			text_desc.setLineWrap(true);
			scrollPane.setViewportView(text_desc);
		}
		{
			JSeparator separator_1 = new JSeparator();
			separator_1.setBounds(10, 390, 254, 2);
			contentPanel.add(separator_1);
		}
		{
			/**
			 * ¿¨ºÅ
			 */
			JPanel panel_1 = new JPanel();
			panel_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					panel_1.setBackground(new Color(224, 255, 255));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					panel_1.setBackground(new Color(240, 240, 240));
				}
			});
			panel_1.setBounds(0, 439, 274, 37);
			contentPanel.add(panel_1);
			panel_1.setLayout(null);
			{
				JLabel label = new JLabel("\u5361\u53F7");
				label.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 13));
				label.setBounds(21, 10, 54, 15);
				panel_1.add(label);
			}
			{
				lb_code = new JLabel("");
				lb_code.setEnabled(false);

				lb_code.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 13));
				lb_code.setBounds(119, 10, 125, 15);
				panel_1.add(lb_code);
			}
		}
		{
			JSeparator separator_1 = new JSeparator();
			separator_1.setBounds(10, 435, 254, 2);
			contentPanel.add(separator_1);
		}
		{
			/**
			 * ÕË»§Óà¶î
			 */
			JPanel panel_1 = new JPanel();
			panel_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {

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
			panel_1.setLayout(null);
			panel_1.setBounds(0, 394, 274, 37);
			contentPanel.add(panel_1);
			{
				JLabel label = new JLabel("\u8D26\u6237\u4F59\u989D:");
				label.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 13));
				label.setBounds(22, 10, 68, 15);
				panel_1.add(label);
			}
			{
				lb_rest = new JLabel("");
				lb_rest.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 13));
				lb_rest.setBounds(117, 10, 54, 15);
				panel_1.add(lb_rest);
			}
			{
				btn_addmoney = new JButton("\u5145\u503C");
				btn_addmoney.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent arg0) {
						UI_Customer_Addmoney addMoney = new UI_Customer_Addmoney();
						//dispose();
						addMoney.setVisible(true);
						addMoney.addWindowListener(new WindowAdapter() {
							public void windowClosed(WindowEvent e) {

								lb_rest.setText(castutil.castString(addMoney.newmoney));
								//(new UI_GeRen()).setVisible(true);
							}

						});

					}
				});

				btn_addmoney.setBounds(181, 10, 93, 23);
				panel_1.add(btn_addmoney);
			}
			{
				JSeparator separator_1 = new JSeparator();
				separator_1.setBounds(10, 170, 254, 2);
				contentPanel.add(separator_1);
			}
			{
				JPanel panel_2 = new JPanel();
				panel_2.addMouseListener(new MouseAdapter() {
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
				panel_2.setBounds(0, 172, 274, 37);
				contentPanel.add(panel_2);
				{
					JLabel lblShoujihao = new JLabel("\u624B\u673A\u53F7");
					lblShoujihao.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 13));
					lblShoujihao.setBounds(21, 10, 54, 15);
					panel_2.add(lblShoujihao);
				}
				{
					JLabel label = new JLabel();
					label.setBounds(248, 10, 16, 15);
					panel_2.add(label);
				}
				{
					tx_phone = new JTextField();
					tx_phone.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 13));
					tx_phone.setColumns(10);
					tx_phone.setBackground(SystemColor.menu);
					tx_phone.setBounds(114, 6, 89, 21);
					panel_2.add(tx_phone);
				}
			}
			{
				JSeparator separator_1 = new JSeparator();
				separator_1.setBounds(10, 213, 254, 2);
				contentPanel.add(separator_1);
			}
			{
				JPanel panel_2 = new JPanel();
				panel_2.addMouseListener(new MouseAdapter() {
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
				panel_2.setBounds(0, 218, 274, 37);
				contentPanel.add(panel_2);
				{
					JLabel label = new JLabel("\u751F\u65E5");
					label.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 13));
					label.setBounds(21, 10, 54, 15);
					panel_2.add(label);
				}
				{
					JLabel label = new JLabel();
					label.setBounds(248, 10, 16, 15);
					panel_2.add(label);
				}
				{
					tx_bir = new DatePicker();
					tx_bir.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 13));

					tx_bir.setBackground(SystemColor.menu);
					tx_bir.setBounds(114, 6, 89, 21);
					panel_2.add(tx_bir);
				}
			}
			{
				JSeparator separator_1 = new JSeparator();
				separator_1.setBounds(10, 260, 254, 2);
				contentPanel.add(separator_1);
			}
			{
				JPanel panel_2 = new JPanel();
				panel_2.addMouseListener(new MouseAdapter() {
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
				panel_2.setBounds(0, 264, 274, 37);
				contentPanel.add(panel_2);
				{
					JLabel label = new JLabel("\u5BC6\u7801");
					label.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 13));
					label.setBounds(21, 10, 54, 15);
					panel_2.add(label);
				}
				{
					JLabel label = new JLabel();
					label.setBounds(248, 10, 16, 15);
					panel_2.add(label);
				}
				{
					pwd = new JTextField();
					pwd.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 13));
					pwd.setColumns(10);
					pwd.setBackground(SystemColor.menu);
					pwd.setBounds(114, 6, 89, 21);
					panel_2.add(pwd);
				}
			}
			{
				JSeparator separator_1 = new JSeparator();
				separator_1.setBounds(10, 305, 254, 2);
				contentPanel.add(separator_1);
			}
			{
				try {
					Image img = ImgUtil.getIcon(new FileInputStream("img/kuohao1.png"), 13, 13);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			}

		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				/**
				 * Ìá½»
				 */
				JButton okButton = new JButton("\u63D0\u4EA4");
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {

						CustomerService cs = new CustomerServiceImpl();
						Table_Customer customer = new Table_Customer();
						customer.setCname(tx_name.getText());
						customer.setCphone(tx_phone.getText());
						customer.setCmoney(castutil.castDouble(lb_rest.getText()));
						customer.setCpwd(pwd.getText());
						customer.setCbirthday(tx_bir.getText().substring(0, 10));
						customer.setCpy("py");
						customer.setCgender(cb_cenger.getSelectedItem().toString());
						customer.setCaddress(cs.getCustomerByCcode(lb_code.getText()).getCaddress());
						int lid = 0;
						if (castutil.castDouble(lb_rest.getText()) >= 1000) {
							lid = 5;
						} else if (castutil.castDouble(lb_rest.getText()) >= 600) {
							lid = 4;
						} else if (castutil.castDouble(lb_rest.getText()) >= 400) {
							lid = 3;
						} else if (castutil.castDouble(lb_rest.getText()) >= 200) {
							lid = 2;
						} else if (castutil.castDouble(lb_rest.getText()) >= 0) {
							lid = 1;
						}
						customer.setClid(lid);

						customer.setCdesc(text_desc.getText());
						if (file == null) {
							customer.setCphoto(cs.getCustomerByCcode(lb_code.getText()).getCphoto());
						} else {
							customer.setCphoto(file.toString());
						}
						customer.setCcode(lb_code.getText());
						// System.out.println(cs.updateCustomer1(customer));
						if (cs.updateCustomer1(customer)) {
							JOptionPane.showMessageDialog(null, "ÐÅÏ¢¸ü¸Ä³É¹¦!");

						} else {
							JOptionPane.showMessageDialog(null, "ÐÅÏ¢¸ü¸ÄÊ§°Ü!");
						}
					}
				});
				okButton.setActionCommand("");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("\u9000\u51FA");
				cancelButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("");
				buttonPane.add(cancelButton);
			}
		}
	}
}
