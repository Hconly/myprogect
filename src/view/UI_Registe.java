package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.eltima.components.ui.DatePicker;

import entity.Table_Customer;
import service.CustomerService;
import service.Impl.CustomerServiceImpl;

public class UI_Registe extends JDialog {

	private JPanel contentPane;
	private JTextField txt_name;
	private JTextField txt_address;
	private JRadioButton rb_m;
	private JPasswordField txt_pwd;
	private DatePicker date_birthday;
	private JButton btn_registe;
	private JButton btn_reset;
	private JLabel label_6;
	private JTextField txt_phone;
	private JLabel label_1;
	private JLabel label_5;
	private JLabel label_2;
	private JLabel label_7;
	private JRadioButton rb_w;
	private JPasswordField txt_pwd2;
	private JLabel lb_name;
	private JLabel lb_phone;
	private JLabel lb_pwd;
	String DefaultFormat = "yyyy-MM-dd";
	Table_Customer c;// ע��ͻ�����
	CustomerService cs = new CustomerServiceImpl();
	// �����õ�����
	Pattern p = null;
	Matcher m = null;
	boolean flg = true;
	boolean flg1 = true;
	boolean flg2 = true;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI_Registe frame = new UI_Registe();
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
	public UI_Registe() {
		setResizable(false);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setFont(new Font("΢���ź�", Font.BOLD, 12));
		setTitle("\u65B0\u7528\u6237\u6CE8\u518C");
		setBounds(100, 100, 397, 700);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		setIconImage(Toolkit.getDefaultToolkit().getImage("img\\timg1.jpg"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// �ر�ע�ᴰ���򷵻ص�¼
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				UI_Login login = new UI_Login();
				login.setVisible(true);
			}
		});

		JLabel label = new JLabel("\u7528\u6237\u540D\uFF1A");
		label.setFont(new Font("΢���ź�", Font.PLAIN, 20));
		label.setBounds(45, 15, 90, 34);
		contentPane.add(label);

		lb_name = new JLabel("\u6C49\u5B57\u3001\u5B57\u6BCD\u3001\u6570\u5B57\u7684\u7EC4\u5408");
		lb_name.setForeground(Color.LIGHT_GRAY);
		lb_name.setBounds(45, 64, 294, 21);
		contentPane.add(lb_name);

		lb_phone = new JLabel("\u8F93\u5165\u60A8\u7684\u5E38\u7528\u624B\u673A\u53F7");
		lb_phone.setForeground(Color.LIGHT_GRAY);
		lb_phone.setBounds(45, 161, 294, 21);
		contentPane.add(lb_phone);

		lb_pwd = new JLabel("6-16\u4F4D\u6570\u5B57\u548C\u5B57\u6BCD\u7684\u7EC4\u5408");
		lb_pwd.setForeground(Color.LIGHT_GRAY);
		lb_pwd.setBounds(45, 463, 294, 21);
		contentPane.add(lb_pwd);

		txt_name = new JTextField();
		// �������ı���ʧȥ������������֤
		txt_name.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (txt_name.getText().equals("")) {
					lb_name.setText("�������û�����");
					lb_name.setForeground(Color.RED);
				} else {
					String name = txt_name.getText();
					p = Pattern.compile("^(?!_)(?!.*?_$)[a-zA-Z0-9_\\u4e00-\\u9fa5]+$");
					m = p.matcher(name);
					flg = m.matches();
					if (flg == false) {
						lb_name.setText("�û����ĸ�ʽ����ȷ��");
						lb_name.setForeground(Color.RED);
					} else {
						List<Table_Customer> list = cs.findAll();
						for (Table_Customer table_Customer : list) {
							if (table_Customer.getCname().equals(txt_name.getText())) {
								JOptionPane.showMessageDialog(null, "���û����ѱ�ʹ�ã�");
								txt_name.setText(null);
							}
						}
						lb_name.setText("���֡���ĸ�����ֵ����");
						lb_name.setForeground(Color.LIGHT_GRAY);
					}
				}
			}
		});

		// ��������¼�
		txt_name.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				lb_name.setText("���֡���ĸ�����ֵ����");
				lb_name.setForeground(Color.LIGHT_GRAY);
			}
		});
		txt_name.setToolTipText("");
		txt_name.setFont(new Font("΢���ź�", Font.PLAIN, 20));
		txt_name.setBounds(159, 15, 180, 34);
		contentPane.add(txt_name);
		txt_name.setColumns(10);

		txt_phone = new JTextField();
		// ������֤�ֻ���
		txt_phone.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (txt_phone.getText().equals("")) {
					lb_phone.setText("����д�ֻ��ţ�");
					lb_phone.setForeground(Color.RED);
				} else {
					String phone = txt_phone.getText();
					// �ֻ��ſ�ͷ����Ϊ1
					p = Pattern.compile("[1]{1}[0-9]{10}");
					m = p.matcher(phone);
					flg1 = m.matches();
					if (flg1 == false) {
						lb_phone.setText("����д��ȷ���ֻ��ţ�");
						lb_phone.setForeground(Color.RED);
					} else {
						lb_phone.setText("�������ĳ����ֻ���");
						lb_phone.setForeground(Color.LIGHT_GRAY);
					}
				}
			}
		});
		// ��������¼�
		txt_phone.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				lb_phone.setText("�������ĳ����ֻ���");
				lb_phone.setForeground(Color.LIGHT_GRAY);
			}
		});
		txt_phone.setFont(new Font("΢���ź�", Font.PLAIN, 20));
		txt_phone.setColumns(10);
		txt_phone.setBounds(159, 112, 180, 34);
		contentPane.add(txt_phone);

		txt_pwd = new JPasswordField();
		// ������֤����
		txt_pwd.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (txt_pwd.getText().equals("")) {
					lb_pwd.setText("�����õ�¼���룡");
					lb_pwd.setForeground(Color.RED);
				} else {
					String pwd = txt_pwd.getText();
					p = Pattern.compile("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$");
					m = p.matcher(pwd);
					flg2 = m.matches();
					if (flg2 == false) {
						lb_pwd.setText("�밴��ȷ��ʽ�������룡");
						lb_pwd.setForeground(Color.RED);
					}
				}
			}
		});
		// ��������¼�
		txt_pwd.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				lb_pwd.setText("6-16λ���ֺ���ĸ�����");
				lb_pwd.setForeground(Color.LIGHT_GRAY);
			}
		});
		txt_pwd.setFont(new Font("΢���ź�", Font.PLAIN, 20));
		txt_pwd.setBounds(159, 412, 180, 34);
		contentPane.add(txt_pwd);

		txt_pwd2 = new JPasswordField();
		// ȷ������
		txt_pwd2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (!txt_pwd.getText().equals("")) {
					if (txt_pwd2.getText().equals("")) {
						lb_pwd.setText("��ȷ�����룡");
						lb_pwd.setForeground(Color.RED);
					} else if (!txt_pwd2.getText().equals(txt_pwd.getText())) {
						lb_pwd.setText("��¼������ȷ�����벻ͬ��");
						lb_pwd.setForeground(Color.RED);
					} else {
						lb_pwd.setText("6-16λ���ֺ���ĸ�����");
						lb_pwd.setForeground(Color.LIGHT_GRAY);
					}
				}
			}
		});
		txt_pwd2.setFont(new Font("΢���ź�", Font.PLAIN, 20));
		txt_pwd2.setBounds(159, 511, 180, 34);
		contentPane.add(txt_pwd2);

		// ע�ᰴť
		btn_registe = new JButton("\u6CE8 \u518C");
		btn_registe.setFont(new Font("΢���ź�", Font.PLAIN, 20));
		btn_registe.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// ע����ϢҪͨ��������֤�Ҳ���Ϊ�յ�¼����Ҫȷ����ͬ
				if (flg && flg1 && flg2 && !txt_name.getText().equals("") && !txt_phone.getText().equals("")
						&& !txt_address.getText().equals("") && !txt_pwd.getText().equals("")
						&& !txt_pwd2.getText().equals("") && !date_birthday.getText().equals("")
						&& txt_pwd.getText().equals(txt_pwd2.getText())) {
					c = new Table_Customer();
					c.setCaddress(txt_address.getText());
					c.setCname(txt_name.getText());
					c.setCgender(rb_m.isSelected() ? "��" : "Ů");
					c.setCbirthday(date_birthday.getText());
					c.setCphone(txt_phone.getText());
					c.setCpwd(txt_pwd.getText());
					c.setClid(1);
					c.setCcode(getCode());

					// �������ݿ����
					boolean bool = cs.addCustomer(c);

					// ����ҵ���,���ע��ɹ�����ѡ��������Ա�͹رյ�ǰ����
					if (bool == true) {
						int num = JOptionPane.showConfirmDialog(null,
								"ע��ɹ�!���ѳ�Ϊ��ͨ��Ա\r\n�뱣�ܺ����Ļ�Ա���ţ�" + getCode() + "\r\n�Ƿ��ֵ������Ա��", "ע����ʾ",
								JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
						// ע��ɹ����ñ��������һ����д���ļ��У��Ա��´�ע��ʹ��
						code_num++;
						writeCode();
						if (num == 0) {
							dispose();
							UI_RegisteMember registeMember = new UI_RegisteMember();
							registeMember.setLocationRelativeTo(null);// ������Ա�������
							registeMember.setVisible(true);
						} else {
							int num1 = JOptionPane.showConfirmDialog(null, "�Ƿ񷵻ص�¼��", "������ʾ", JOptionPane.YES_NO_OPTION,
									JOptionPane.QUESTION_MESSAGE);
							if (num1 == 0) {
								dispose();
								UI_Login login = new UI_Login();
								login.setVisible(true);
							} else {
								// ͣ����ע��ҳ�治���ص�¼������ע��ҳ��
								txt_address.setText(null);
								txt_name.setText(null);
								date_birthday.getInnerTextField().setText(null);
								txt_phone.setText(null);
								txt_pwd.setText(null);
								txt_pwd2.setText(null);
								txt_address.setText(null);
							}
						}

					} else {
						JOptionPane.showMessageDialog(null, "���ݿ��������ע��ʧ�ܣ�", "ע����ʾ", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, "��������ע����Ϣ�Ƿ���������ȷ��", "ע����ʾ", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		if (getFileCode() > 0) {
			code_num = getFileCode();
		}

		btn_registe.setBounds(45, 588, 123, 43);
		contentPane.add(btn_registe);

		rb_m = new JRadioButton("\u7537");
		rb_m.setFont(new Font("΢���ź�", Font.PLAIN, 20));
		rb_m.setSelected(true);
		rb_m.setBounds(159, 275, 65, 29);
		contentPane.add(rb_m);

		rb_w = new JRadioButton("\u5973");
		rb_w.setFont(new Font("΢���ź�", Font.PLAIN, 20));
		rb_w.setBounds(274, 275, 65, 29);
		contentPane.add(rb_w);

		// ����һ����ť����ʵ���Ա�ѡ
		ButtonGroup bg = new ButtonGroup();
		bg.add(rb_m);
		bg.add(rb_w);

		txt_address = new JTextField();
		txt_address.setFont(new Font("΢���ź�", Font.PLAIN, 20));
		txt_address.setBounds(159, 207, 180, 34);
		contentPane.add(txt_address);
		txt_address.setColumns(10);

		Date date = new Date();
		date_birthday = new DatePicker(date, DefaultFormat, new Font("΢���ź�", Font.PLAIN, 20), new Dimension(180, 34));
		date_birthday.getInnerTextField().setFont(new Font("΢���ź�", Font.PLAIN, 20));
		date_birthday.setBounds(159, 342, 180, 34);
		contentPane.add(date_birthday);

		// ���ð�ť
		btn_reset = new JButton("\u91CD \u7F6E");
		btn_reset.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// ���ô�������
				txt_address.setText(null);
				txt_name.setText(null);
				date_birthday.getInnerTextField().setText(null);
				txt_phone.setText(null);
				txt_pwd.setText(null);
				txt_pwd2.setText(null);
				txt_address.setText(null);
				lb_name.setText("���֡���ĸ�����ֵ����");
				lb_name.setForeground(Color.LIGHT_GRAY);
				lb_phone.setText("�������ĳ����ֻ���");
				lb_phone.setForeground(Color.LIGHT_GRAY);
				lb_pwd.setText("6-16λ���ֺ���ĸ�����");
				lb_pwd.setForeground(Color.LIGHT_GRAY);
			}
		});
		btn_reset.setFont(new Font("΢���ź�", Font.PLAIN, 20));
		btn_reset.setBounds(216, 588, 123, 43);
		contentPane.add(btn_reset);

		label_6 = new JLabel("\u624B    \u673A\uFF1A");
		label_6.setFont(new Font("΢���ź�", Font.PLAIN, 20));
		label_6.setBounds(45, 112, 90, 34);
		contentPane.add(label_6);

		label_1 = new JLabel("\u5730    \u5740\uFF1A");
		label_1.setFont(new Font("΢���ź�", Font.PLAIN, 20));
		label_1.setBounds(45, 205, 90, 34);
		contentPane.add(label_1);

		label_5 = new JLabel("\u6027    \u522B\uFF1A");
		label_5.setFont(new Font("΢���ź�", Font.PLAIN, 20));
		label_5.setBounds(45, 272, 90, 34);
		contentPane.add(label_5);

		label_2 = new JLabel("\u767B\u5F55\u5BC6\u7801\uFF1A");
		label_2.setFont(new Font("΢���ź�", Font.PLAIN, 20));
		label_2.setBounds(45, 412, 110, 34);
		contentPane.add(label_2);

		label_7 = new JLabel("\u751F    \u65E5\uFF1A");
		label_7.setFont(new Font("΢���ź�", Font.PLAIN, 20));
		label_7.setBounds(45, 342, 90, 34);
		contentPane.add(label_7);

		JLabel label_4 = new JLabel("\u786E\u8BA4\u5BC6\u7801\uFF1A");
		label_4.setFont(new Font("΢���ź�", Font.PLAIN, 20));
		label_4.setBounds(45, 511, 100, 34);
		contentPane.add(label_4);

	}

//����Ϊ����ע���������ɿͻ���Ա�������õķ���
	int code_num = 1001;

	public String getCode() {
		String code = "";
		DecimalFormat df = new DecimalFormat("0000");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

		code = sdf.format(new Date()) + df.format(code_num);
		return code;
	}

	private int getFileCode() {
		int num = 0;
		try {
			InputStream is = new FileInputStream("num.code");
			byte b[] = new byte[1024];
			int length = 0;
			StringBuffer sbf = new StringBuffer();
			while ((length = is.read(b)) != -1) {
				String code = new String(b, 0, length);
				sbf.append(code);
			}
			String arr[] = sbf.toString().split("@");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			if (arr[0].indexOf(sdf.format(new Date())) == -1) {
				num = 1001;
			} else {
				num = Integer.valueOf(arr[1].toString());
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
	}

	private void writeCode() {
		try {
			OutputStream os = new FileOutputStream("num.code");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			String code = new String(sdf.format(new Date()) + "@" + code_num);
			os.write(code.getBytes());
			os.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
