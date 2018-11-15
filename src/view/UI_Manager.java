package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.eltima.components.ui.DatePicker;

import entity.Table_Customer;
import entity.Table_Movie;
import entity.Table_Schedule;
import entity.dto.MovieDto;
import service.CustomerService;
import service.LevelService;
import service.MovieService;
import service.ScheduleService;
import service.Impl.CustomerServiceImpl;
import service.Impl.LevelServiceImpl;
import service.Impl.MovieServiceImpl;
import service.Impl.ScheduleServiceImpl;
import util.Time;
import util.castutil;

public class UI_Manager extends JFrame {

	private JLabel movie_label;
	private JTabbedPane ticket_manage;
	private JPanel customer_manage;
	private JTable table;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTable table_1;
	private JButton bt_love;
	private JButton bt_action;
	private JButton bt_comedy;
	private JButton bt_suspense;
	private JButton bt_thriller;
	private DefaultTableModel dtm3;
	private DefaultTableModel dtm;
	private DefaultTableModel dtm2;
	private JTable table_3;
	private JTable movie_table;

	private Dimension srcsize;
	private JTextField txt_cname;
	private JTextField txt_ccode;
	private JTable table_2;
	private SimpleDateFormat sdfTime;

	CustomerService cs = new CustomerServiceImpl();
	LevelService ls = new LevelServiceImpl();
	protected static Table_Customer customer;
	private JTextArea txtArea_rs;
	private JTextArea txtArea_desc;
	private String ccode;
	private List<Table_Customer> customerList;// �洢��ǰ������ʾ�����пͻ���Ϣ
	protected static Double nowMoney;
	protected int mid;
	

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {   
//					new UI_Manager().setVisible(true);;
//		//			frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public UI_Manager() {
		JFrame frame = new JFrame("��ӭ��������Ա����");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("img\\timg1.jpg"));
		Container container = frame.getContentPane();
		JTabbedPane tab = new JTabbedPane(JTabbedPane.TOP);
		tab.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		frame.setLocationRelativeTo(null);
		/**
		 * Ӱ����Դģ��
		 */
		JPanel panel_movie_resource = new JPanel();
		/**
		 * ��ӳ����ģ��
		 */
		JPanel panel_movie_manage = new JPanel();

		tab.addTab("Ӱ����Դ", panel_movie_resource);
		panel_movie_resource.setLayout(null);

		JPanel movie_resource_sort = new JPanel();
		movie_resource_sort.setForeground(new Color(0, 0, 0));
		movie_resource_sort.setBorder(new LineBorder(new Color(0, 0, 0)));
		movie_resource_sort.setBounds(10, 10, 823, 64);
		panel_movie_resource.add(movie_resource_sort);
		movie_resource_sort.setLayout(null);

		JLabel label = new JLabel("\u7535\u5F71\u5206\u7C7B");
		label.setForeground(new Color(255, 69, 0));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("΢���ź�", Font.BOLD, 15));
		label.setBounds(20, 5, 70, 20);
		movie_resource_sort.add(label);

		bt_love = new JButton("\u7231\u60C5");
		bt_love.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				showMovie(2);
				mid=2;

			}
		});
		bt_love.setFont(new Font("΢���ź�", Font.PLAIN, 13));
		bt_love.setForeground(new Color(0, 0, 255));
		bt_love.setBounds(20, 35, 97, 25);
		movie_resource_sort.add(bt_love);

		bt_action = new JButton("\u52A8\u4F5C");
		bt_action.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				showMovie(3);
				mid=3;
			}
		});
		bt_action.setFont(new Font("΢���ź�", Font.PLAIN, 13));
		bt_action.setForeground(new Color(0, 0, 255));
		bt_action.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		bt_action.setBounds(179, 35, 85, 25);
		movie_resource_sort.add(bt_action);

		bt_comedy = new JButton("\u559C\u5267");
		bt_comedy.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				showMovie(6);
				mid=6;
			}
		});
		bt_comedy.setForeground(new Color(0, 0, 255));
		bt_comedy.setFont(new Font("΢���ź�", Font.PLAIN, 13));
		bt_comedy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		bt_comedy.setBounds(341, 35, 85, 25);
		movie_resource_sort.add(bt_comedy);

		bt_suspense = new JButton("\u60AC\u7591");
		bt_suspense.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				showMovie(5);
				mid=5;
			}
		});
		bt_suspense.setForeground(new Color(0, 0, 255));
		bt_suspense.setFont(new Font("΢���ź�", Font.PLAIN, 13));
		bt_suspense.setBounds(505, 35, 97, 25);
		movie_resource_sort.add(bt_suspense);

		bt_thriller = new JButton("\u60CA\u609A");
		bt_thriller.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				showMovie(4);
				mid=4;
			}
		});
		bt_thriller.setForeground(new Color(0, 0, 255));
		bt_thriller.setFont(new Font("΢���ź�", Font.PLAIN, 13));
		bt_thriller.setBounds(689, 35, 97, 25);
		movie_resource_sort.add(bt_thriller);

		JPanel movie_resource_list = new JPanel();
		movie_resource_list.setBorder(new LineBorder(new Color(0, 0, 0)));
		movie_resource_list.setBounds(10, 77, 664, 407);
		panel_movie_resource.add(movie_resource_list);
		movie_resource_list.setLayout(null);

		movie_label = new JLabel("\u7535\u5F71\u4FE1\u606F\u5217\u8868");
		movie_label.setForeground(new Color(255, 69, 0));
		movie_label.setHorizontalAlignment(SwingConstants.CENTER);
		movie_label.setFont(new Font("΢���ź�", Font.BOLD, 15));
		movie_label.setBounds(20, 10, 100, 25);
		movie_resource_list.add(movie_label);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 40, 644, 271);
		movie_resource_list.add(scrollPane);

		table_3 = new JTable();
		table_3.setModel(new DefaultTableModel(new Object[][] { { null }, }, new String[] { "New column" }));
		table_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		dtm = new DefaultTableModel(new Object[][] {},
				new String[] { "\u7535\u5F71ID", "\u7535\u5F71\u540D\u79F0", "\u573A\u6B21ID",
						"\u573A\u6B21\u540D\u79F0", "\u4E0A\u6620\u65F6\u95F4", "\u4E0B\u67B6\u65F6\u95F4",
						"\u7968\u4EF7" });
		table_3.setModel(dtm);
		scrollPane.setViewportView(table_3);

		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(table_3, popupMenu);

		JMenuItem mntmNewMenuItem = new JMenuItem("\u4FEE\u6539");
		mntmNewMenuItem.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				int i = table_3.getSelectedRow();
				int i1 = (int) table_3.getValueAt(i, 0);
				MovieService ms = new MovieServiceImpl();
				Table_Movie tm = ms.getbyId(i1);
				UI_UpdateMovie upm = new UI_UpdateMovie(tm);
				upm.setVisible(true);
				upm.addWindowListener(new WindowAdapter() {
					public void WindowClosed(WindowEvent e) {
						showMovie(mid);
					}
				});
			}
		});
		popupMenu.add(mntmNewMenuItem);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u5220\u9664");
		mntmNewMenuItem_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				int i = table_3.getSelectedRow();
				int i1 = (int) table_3.getValueAt(i, 0);
				MovieService ms = new MovieServiceImpl();

				int num = JOptionPane.showConfirmDialog(null, "�Ƿ�ȷ��ɾ����Ӱ��" + table_3.getValueAt(i, 1) + "��?", "ɾ��������ʾ",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (num == 0) {
					if (ms.deleteMovie(i1)) {
						JOptionPane.showMessageDialog(null, "ɾ���ɹ�!");
						showMovie(mid);
					}
				} else {
					JOptionPane.showMessageDialog(null, "ȡ��ɾ��!");
				}

			}
		});
		popupMenu.add(mntmNewMenuItem_1);

//		movie_table = new JTable();
//		scrollPane.setViewportView(movie_table);
//		movie_table.setBorder(new LineBorder(new Color(0, 0, 0)));
//		dtm = new DefaultTableModel(new Object[][] {},
//				new String[] { "\u7535\u5F71ID", "\u7535\u5F71\u540D\u79F0", "\u573A\u6B21ID",
//						"\u573A\u6B21\u540D\u79F0", "\u4E0A\u6620\u65F6\u95F4", "\u4E0B\u67B6\u65F6\u95F4",
//						"\u7968\u4EF7" });
//		movie_table.setModel(dtm);

		JButton btnNewButton = new JButton("\u4E0A\u4E00\u9875");
		btnNewButton.setFont(new Font("΢���ź�", Font.BOLD, 15));
		btnNewButton.setBounds(182, 360, 100, 30);
		movie_resource_list.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("\u4E0B\u4E00\u9875");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				//
				// �����һҳ�����л� jpanel

			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setFont(new Font("΢���ź�", Font.BOLD, 15));
		btnNewButton_1.setBounds(386, 360, 100, 30);
		movie_resource_list.add(btnNewButton_1);

		JPanel movie_resource_manage = new JPanel();
		movie_resource_manage.setBorder(new LineBorder(new Color(25, 25, 112)));
		movie_resource_manage.setBounds(684, 77, 149, 407);
		panel_movie_resource.add(movie_resource_manage);
		movie_resource_manage.setLayout(null);

		JLabel label_2 = new JLabel("\u7535\u5F71\u7BA1\u7406");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(new Color(255, 69, 0));
		label_2.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		label_2.setBounds(10, 10, 129, 25);
		movie_resource_manage.add(label_2);

		JButton btnNewButton_2 = new JButton("\u7535\u5F71\u67E5\u8BE2");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				UI_findMovie uf = new UI_findMovie();
				uf.setVisible(true);

			}
		});
		btnNewButton_2.setBounds(10, 54, 129, 30);
		movie_resource_manage.add(btnNewButton_2);

		JButton button_6 = new JButton("\u7535\u5F71\u6DFB\u52A0");
	
			
		button_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				UI_AddMovie ui_add = new UI_AddMovie();
				ui_add.setVisible(true);

			}
		});
		button_6.setBounds(10, 109, 129, 30);
		movie_resource_manage.add(button_6);

		JButton button_7 = new JButton("\u7535\u5F71\u4FEE\u6539");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//System.out.println("***********");
			}
		});
		button_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				UI_UpDeMovie uum = new UI_UpDeMovie();
				uum.setVisible(true);
			}
		});
		button_7.setBounds(10, 161, 129, 30);
		movie_resource_manage.add(button_7);

		JButton button_8 = new JButton("\u7535\u5F71\u5220\u9664");
		button_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				UI_UpDeMovie uum = new UI_UpDeMovie();
				uum.setVisible(true);

			}
		});
		button_8.setBounds(10, 214, 129, 30);
		movie_resource_manage.add(button_8);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(5, 260, 134, 141);
		movie_resource_manage.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblNewLabel = new JLabel("\u5F53\u524D\u65F6\u95F4\uFF1A");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("΢���ź�", Font.PLAIN, 12));
		lblNewLabel.setBounds(20, 40, 70, 15);
		panel_3.add(lblNewLabel);

		JButton btnNewButton_3 = new JButton("\u9000\u51FA");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				frame.dispose();
			}
		});
		btnNewButton_3.setForeground(new Color(255, 69, 0));
		btnNewButton_3.setBounds(16, 110, 100, 25);
		panel_3.add(btnNewButton_3);

		String formatDate = "yyyy-MM-dd";
		JLabel lblNewLabel_1 = new JLabel();
		Time.setDT(formatDate, lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("΢���ź�", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(20, 65, 80, 15);
		panel_3.add(lblNewLabel_1);

		String formatTime = "HH:mm:ss";
		JLabel label_3 = new JLabel();
		Time.setDT(formatTime, label_3);
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("΢���ź�", Font.PLAIN, 12));
		label_3.setBounds(10, 90, 80, 15);
		panel_3.add(label_3);

		JLabel label_1 = new JLabel("\u6B22\u8FCE\u767B\u5F55\u7BA1\u7406\u5458\r\n");
		label_1.setBounds(10, 10, 114, 20);
		panel_3.add(label_1);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(new Color(255, 69, 0));
		label_1.setFont(new Font("΢���ź�", Font.ITALIC, 14));
		tab.addTab("��ӳ����", panel_movie_manage);
		panel_movie_manage.setLayout(null);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "��Ӱ��Ϣһ����", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBounds(10, 10, 671, 474);
		panel_movie_manage.add(panel_4);
		panel_4.setLayout(null);

		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(10, 55, 650, 325);
		panel_4.add(scrollPane_4);

		table_1 = new JTable();
		dtm2 = new DefaultTableModel(new Object[][] {},
				new String[] { "\u573A\u6B21ID", "\u573A\u5385\u540D\u79F0", "\u7535\u5F71\u540D\u79F0",
						"\u5F00\u59CB\u65F6\u95F4", "\u64AD\u653E\u65F6\u95F4", "\u7ED3\u675F\u65F6\u95F4",
						"\u5F71\u7968\u4EF7\u683C", "��ע" });
		Schule();
		table_1.setModel(dtm2);
		scrollPane_4.setViewportView(table_1);

		JLabel lblNewLabel_5 = new JLabel("\u9662\u7EBF\u70ED\u6620\uFF1A");
		lblNewLabel_5.setBounds(10, 25, 100, 25);
		lblNewLabel_5.setForeground(new Color(255, 69, 0));
		lblNewLabel_5.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		panel_4.add(lblNewLabel_5);

		JLabel label_16 = new JLabel("\u7535\u5F71\u7BA1\u7406\uFF1A");
		label_16.setForeground(new Color(255, 69, 0));
		label_16.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		label_16.setBounds(690, 35, 100, 25);
		panel_movie_manage.add(label_16);

		/**
		 * ������ӵ���
		 */
		JButton btnNewButton_5 = new JButton("\u573A\u6B21\u6DFB\u52A0");
		btnNewButton_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				JDialog add_dialog = new JDialog(new JFrame(), "�������", true);
				add_dialog.getContentPane().setLayout(null);

				JLabel label_name = new JLabel("�����볡�����:");
				label_name.setBounds(30, 10, 150, 20);
				JTextField text_name = new JTextField();
				text_name.setBounds(30, 45, 150, 20);

				JLabel label_phone = new JLabel("�������Ӱ����:");
				label_phone.setBounds(30, 75, 150, 20);
				JTextField text_phone = new JTextField();
				text_phone.setBounds(30, 110, 150, 20);

				JLabel label_birthday = new JLabel("��ѡ��ʼʱ��:");
				label_birthday.setBounds(30, 135, 150, 20);
				DatePicker date_birth = new DatePicker();
				date_birth.setBounds(30, 170, 150, 20);

				JLabel label_hms = new JLabel("��ѡ�����ʱ��:");
				label_hms.setBounds(30, 200, 160, 20);
				DatePicker text_time = new DatePicker();
				text_time.setBounds(30, 235, 150, 20);

				JLabel label_desc = new JLabel("��ע����:");
				label_desc.setBounds(30, 285, 150, 20);
				JTextArea area_desc = new JTextArea();
				area_desc.setLineWrap(true);
				JScrollPane sc = new JScrollPane(area_desc);
				sc.setBounds(30, 310, 150, 60);

				JButton update = new JButton("�ύ");
				update.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent arg0) {
						ScheduleService sc = new ScheduleServiceImpl();
						MovieServiceImpl ms = new MovieServiceImpl();
						Table_Schedule ts = new Table_Schedule();
						ts.setHid(castutil.castint(text_name.getText()));
						ts.setMid(ms.getbyName(text_phone.getText()).getMid());
						ts.setS_begindate(date_birth.getText());
						ts.setS_enddate(text_time.getText());
						ts.setS_price(0);
						ts.setSname(area_desc.getText());
						if (sc.addschule(ts)) {
							JOptionPane.showMessageDialog(null, "��ӳɹ�");
							Schule();
						} else {
							JOptionPane.showMessageDialog(null, "���ʧ��");
						}

					}
				});
				update.setBounds(30, 415, 60, 25);

				JButton reset = new JButton("����");
				reset.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent arg0) {
						text_name.setText(null);
						text_phone.setText(null);
						date_birth.getInnerTextField().setText(null);
						text_time.getInnerTextField().setText(null);
						area_desc.setText(null);
					}
				});
				reset.setBounds(120, 415, 60, 25);

				add_dialog.getContentPane().add(label_name);
				add_dialog.getContentPane().add(text_name);
				add_dialog.getContentPane().add(label_phone);
				add_dialog.getContentPane().add(text_phone);
				add_dialog.getContentPane().add(label_birthday);
				add_dialog.getContentPane().add(date_birth);
				add_dialog.getContentPane().add(label_hms);
				add_dialog.getContentPane().add(text_time);
				add_dialog.getContentPane().add(label_desc);
				add_dialog.getContentPane().add(sc);
				add_dialog.getContentPane().add(reset);
				add_dialog.getContentPane().add(update);
				add_dialog.getContentPane().add(reset);

				add_dialog.setBounds(200, 150, 220, 500);
				add_dialog.setVisible(true);
			}
		});
		btnNewButton_5.setBounds(694, 70, 100, 25);
		panel_movie_manage.add(btnNewButton_5);
		/**
		 * ɾ����Ƭ
		 */
		JButton btnNewButton_6 = new JButton("\u573A\u6B21\u5220\u9664");
		btnNewButton_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int index = table_1.getSelectedRow();
				System.out.println(index);

				int index2 = castutil.castint(table_1.getValueAt(index, 0));

				ScheduleService ss = new ScheduleServiceImpl();
				if (ss.deleteschule(index2)) {
					JOptionPane.showMessageDialog(null, "ɾ���ɹ�");
					Schule();
				} else {
					JOptionPane.showMessageDialog(null, "ɾ��ʧ��");
				}
			}
		});
		btnNewButton_6.setBounds(694, 173, 100, 25);
		panel_movie_manage.add(btnNewButton_6);
		/**
		 * �޸���Ƭ
		 */
		JButton btnNewButton_8 = new JButton("\u573A\u6B21\u4FEE\u6539");
		btnNewButton_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				JDialog add_dialog = new JDialog(new JFrame(), "�����޸�", true);
				add_dialog.getContentPane().setLayout(null);

				JLabel label_name = new JLabel("�����볡�����:");
				label_name.setBounds(30, 10, 150, 20);
				JTextField text_name = new JTextField();
				text_name.setBounds(30, 45, 150, 20);

				JLabel label_phone = new JLabel("�������Ӱ����:");
				label_phone.setBounds(30, 75, 150, 20);
				JTextField text_phone = new JTextField();
				text_phone.setBounds(30, 110, 150, 20);

				JLabel label_birthday = new JLabel("��ѡ��ʼʱ��:");
				label_birthday.setBounds(30, 135, 150, 20);
				DatePicker date_birth = new DatePicker();
				date_birth.setBounds(30, 170, 150, 20);

				JLabel label_hms = new JLabel("��ѡ�����ʱ��:");
				label_hms.setBounds(30, 200, 160, 20);
				DatePicker text_time = new DatePicker();
				text_time.setBounds(30, 235, 150, 20);

				JLabel label_desc = new JLabel("��ע����:");
				label_desc.setBounds(30, 285, 150, 20);
				JTextArea area_desc = new JTextArea();
				area_desc.setLineWrap(true);
				JScrollPane sc = new JScrollPane(area_desc);
				sc.setBounds(30, 310, 150, 60);

				int index = table_1.getSelectedRow();

				text_name.setText(table_1.getValueAt(index, 1).toString());
				text_phone.setText(table_1.getValueAt(index, 2).toString());
				date_birth.getInnerTextField().setText(table_1.getValueAt(index, 3).toString());
				text_time.getInnerTextField().setText(table_1.getValueAt(index, 5).toString());

				area_desc.setText(table_1.getValueAt(index, 7).toString());

				JButton update = new JButton("�ύ");
				update.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent arg0) {
						ScheduleService sc = new ScheduleServiceImpl();
						MovieServiceImpl ms = new MovieServiceImpl();
						Table_Schedule ts = new Table_Schedule();

						ts.setMid(ms.getbyName(text_phone.getText()).getMid());
						ts.setHid(castutil.castint(text_name.getText()));
						ts.setS_price(0);
						ts.setS_begindate(date_birth.getText());
						ts.setS_enddate(text_time.getText());
						ts.setSname(area_desc.getText());
						ts.setSid((int) table_1.getValueAt(index, 0));
						if (sc.updateschule(ts)) {
							JOptionPane.showMessageDialog(null, "�޸ĳɹ�");
							Schule();
						} else {
							JOptionPane.showMessageDialog(null, "�޸�ʧ��");
						}

					}
				});
				update.setBounds(30, 415, 60, 25);

				JButton reset = new JButton("����");
				reset.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent arg0) {
						text_name.setText(null);
						text_phone.setText(null);
						date_birth.getInnerTextField().setText(null);
						text_time.getInnerTextField().setText(null);
						area_desc.setText(null);
					}
				});
				reset.setBounds(120, 415, 60, 25);

				add_dialog.getContentPane().add(label_name);
				add_dialog.getContentPane().add(text_name);
				add_dialog.getContentPane().add(label_phone);
				add_dialog.getContentPane().add(text_phone);
				add_dialog.getContentPane().add(label_birthday);
				add_dialog.getContentPane().add(date_birth);
				add_dialog.getContentPane().add(label_hms);
				add_dialog.getContentPane().add(text_time);
				add_dialog.getContentPane().add(label_desc);
				add_dialog.getContentPane().add(sc);
				add_dialog.getContentPane().add(reset);
				add_dialog.getContentPane().add(update);
				add_dialog.getContentPane().add(reset);

				add_dialog.setBounds(200, 150, 220, 500);
				add_dialog.setVisible(true);
			}
		});
		btnNewButton_8.setBounds(696, 270, 100, 25);
		panel_movie_manage.add(btnNewButton_8);

		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u5F53\u524D\u65F6\u95F4\uFF1A",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 69, 0)));
		panel_7.setBounds(690, 325, 100, 158);
		panel_movie_manage.add(panel_7);
		panel_7.setLayout(null);

		String formateDate = "yyyy-MM-dd";
		JLabel lblNewLabel_8 = new JLabel();
		Time.setDT(formateDate, lblNewLabel_8);
		lblNewLabel_8.setFont(new Font("Consolas", Font.PLAIN, 13));
		lblNewLabel_8.setBounds(10, 34, 80, 15);
		panel_7.add(lblNewLabel_8);

		String formateTime = "HH:mm:ss";
		JLabel lblNewLabel_9 = new JLabel("");
		Time.setDT(formateTime, lblNewLabel_9);
		lblNewLabel_9.setFont(new Font("Consolas", Font.PLAIN, 13));
		lblNewLabel_9.setBounds(10, 70, 80, 15);
		panel_7.add(lblNewLabel_9);

		/**
		 * �ͻ�����ģ��
		 */
		JPanel panel_customer = new JPanel();
		tab.addTab("�ͻ�����", panel_customer);
		panel_customer.setLayout(null);

		ticket_manage = new JTabbedPane(JTabbedPane.TOP);
		ticket_manage.setBounds(10, 10, 227, 466);
		panel_customer.add(ticket_manage);
		JPanel panel_back = new JPanel();
		ticket_manage.addTab("��Ʊ����", null, panel_back, null);
		panel_back.setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 222, 450);
		panel_back.add(panel);

		JLabel label_10 = new JLabel("\u9000\u7968\u987B\u77E5\uFF1A");
		label_10.setBounds(15, 27, 150, 25);
		panel.add(label_10);
		// �����ѯ�ͻ���ӰƱ
		JButton button_15 = new JButton("\u5F71\u7968\u67E5\u8BE2");
		button_15.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				new UI_Manager_MyMovie(customer).setVisible(true);

			}
		});
		button_15.setBounds(25, 367, 170, 25);
		panel.add(button_15);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 55, 222, 212);
		panel.add(scrollPane_1);

		JTextArea textArea_1 = new JTextArea();
		textArea_1.setForeground(Color.BLACK);
		textArea_1.setFont(new Font("΢���ź�", Font.PLAIN, 13));
		textArea_1.setText("\r\n��Ʊ����������������\r\n" + " \r\n1����Ʊ����û�г�����Ӱ��ӳ����\r\n" + " \r\n2����Ʊ��۳�Ʊ��20%����������\r\n"
				+ " \r\n3��Ժ����ӳ������Ʊ��Ʊǰ��ȷ������˵����һ����Ʊ���Ų��˿лл�ͻ�������֧�֡�");
		textArea_1.setRows(5);
		textArea_1.setLineWrap(true);
		scrollPane_1.setViewportView(textArea_1);

		String discount[] = { "0.9", "0.8", "0.7", "0.5" };
		DefaultComboBoxModel<String> dcm = new DefaultComboBoxModel<>(discount);

//		JPanel panel_update = new JPanel();
//		ticket_manage.addTab("ӰƱ��ǩ", null, panel_update, null);
//		panel_update.setLayout(null);
//
//		JLabel label_5 = new JLabel("\u8BF7\u9009\u62E9\u6539\u7B7E\u6298\u6263\uFF1A");
//		label_5.setBounds(10, 260, 150, 20);
//		panel_update.add(label_5);
//		JComboBox<String> comboBox = new JComboBox<>();
//		comboBox.setModel(dcm);
//		comboBox.setBounds(10, 285, 200, 25);
//		panel_update.add(comboBox);
//
//		JButton button_13 = new JButton("\u786E\u8BA4");
//		button_13.setBounds(10, 346, 90, 25);
//		panel_update.add(button_13);
//
//		JButton button_14 = new JButton("\u91CD\u7F6E");
//		button_14.setBounds(120, 346, 90, 25);
//		panel_update.add(button_14);

		customer_manage = new JPanel();
		customer_manage.setBounds(249, 10, 580, 466);
		panel_customer.add(customer_manage);
		customer_manage.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("\u4F1A\u5458\u4FE1\u606F");
		lblNewLabel_2.setFont(new Font("΢���ź�", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(10, 10, 54, 15);
		customer_manage.add(lblNewLabel_2);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 35, 561, 424);
		customer_manage.add(panel_1);
		panel_1.setLayout(null);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(5, 4, 547, 154);
		panel_1.add(scrollPane_2);

		table = new JTable();
		// Ϊ�ͻ�չʾ����������Դ
		dtm3 = new DefaultTableModel(
				new String[] { "\u7F16\u53F7", "\u4F1A\u5458\u5361\u53F7", "\u7528\u6237\u540D", "\u6027\u522B",
						"\u624B\u673A\u53F7", "\u751F\u65E5", "\u4F1A\u5458\u7EA7\u522B", "\u4F1A\u5458\u6298\u6263" },
				0);
		List<Table_Customer> list = cs.findAll();
		for (Table_Customer customer : list) {
			dtm3.addRow(new Object[] { customer.getCid(), customer.getCcode(), customer.getCname(),
					customer.getCgender(), customer.getCphone(), customer.getCbirthday(),
					ls.getLevelById((customer.getClid())).getLname(),
					ls.getLevelById((customer.getClid())).getLdiscount() });
		}
		table.setModel(dtm3);
		scrollPane_2.setViewportView(table);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "��Ա����", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(5, 264, 230, 160);
		panel_1.add(panel_2);
		panel_2.setLayout(null);

		JScrollPane scrollPane_6 = new JScrollPane();
		scrollPane_6.setBounds(15, 27, 200, 118);
		panel_2.add(scrollPane_6);

		txtArea_desc = new JTextArea();
		txtArea_desc.setForeground(Color.GRAY);
		txtArea_desc.setRows(5);
		txtArea_desc.setLineWrap(true);
		txtArea_desc.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		scrollPane_6.setViewportView(txtArea_desc);

		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(null, "��Ա����", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_5.setBounds(257, 264, 295, 160);
		panel_1.add(panel_5);
		panel_5.setLayout(null);
		// ��ѯ��ť���������뿨�Ż��û�����ѯ
		JButton btnNewButton_4 = new JButton("\u67E5\u8BE2");
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (!txt_cname.getText().equals("")) {
					try {
						customer = cs.getCustomerByCname(txt_cname.getText());
						txtArea_rs.setText("�û�����" + customer.getCname() + "   " + "�ֻ���" + customer.getCphone() + "   "
								+ "��ַ��" + customer.getCaddress() + "\r\n��Ա���ţ�" + customer.getCcode() + "   " + "��Ա����"
								+ ls.getLevelById(customer.getClid()).getLname() + "   " + "��"
								+ customer.getCmoney());
						UI_Manager.nowMoney = customer.getCmoney();
						if (customer.getCdesc() == null) {
							txtArea_desc.setFont(new Font("΢���ź�", Font.ITALIC, 14));
							txtArea_desc.setText("��һ������ʲô��û����~~");
						} else {
							txtArea_desc.setFont(new Font("΢���ź�", Font.PLAIN, 14));
							txtArea_desc.setText(customer.getCdesc());
						}
					} catch (NullPointerException e1) {
						JOptionPane.showMessageDialog(null, "�û���������ѱ�ע��", "��ѯ��ʾ", JOptionPane.ERROR_MESSAGE);
					}
				} else if (!txt_ccode.getText().equals("")) {
					try {
						customer = cs.getCustomerByCcode(txt_ccode.getText());
						txtArea_rs.setText("�û�����" + customer.getCname() + "   " + "�ֻ���" + customer.getCphone() + "   "
								+ "��ַ��" + customer.getCaddress() + "\r\n��Ա���ţ�" + customer.getCcode() + "   " + "��Ա����"
								+ ls.getLevelById(customer.getClid()).getLname() + "   " + "��"
								+ customer.getCmoney());
						if (customer.getCdesc() == null) {
							txtArea_desc.setFont(new Font("΢���ź�", Font.ITALIC, 14));
							txtArea_desc.setText("��һ������ʲô��û����~~");
						} else {
							txtArea_desc.setFont(new Font("΢���ź�", Font.PLAIN, 14));
							txtArea_desc.setText(customer.getCdesc());
						}
					} catch (NullPointerException e1) {
						JOptionPane.showMessageDialog(null, "��Ա���Ŵ�����ѱ�ע����", "��ѯ��ʾ", JOptionPane.ERROR_MESSAGE);

					}
				} else {
					JOptionPane.showMessageDialog(null, "������Ҫ��ѯ���û������Ա���ţ�");
				}
			}
		});
		btnNewButton_4.setBounds(180, 38, 100, 25);
		panel_5.add(btnNewButton_4);
		// ע����ťɾ���ͻ�
		JButton button_17 = new JButton("\u6CE8\u9500");
		button_17.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {

				if (!txt_cname.getText().equals("")) {
					try {
						customer = cs.getCustomerByCname(txt_cname.getText());
						if (cs.deleteCustomer(customer.getCid())) {
							JOptionPane.showMessageDialog(null, "ע���ɹ���");
							initCustomer();
						} else {
							JOptionPane.showMessageDialog(null, "ע��ʧ�ܣ�", "��ѯ��ʾ", JOptionPane.ERROR_MESSAGE);
						}

					} catch (NullPointerException e1) {
						JOptionPane.showMessageDialog(null, "�û���������ѱ�ע����", "ע����ʾ", JOptionPane.ERROR_MESSAGE);
					}
				} else if (!txt_ccode.getText().equals("")) {
					try {
						customer = cs.getCustomerByCcode(txt_ccode.getText());
						if (cs.deleteCustomer(customer.getCid())) {
							initCustomer();
							JOptionPane.showMessageDialog(null, "ע���ɹ���");
						} else {
							JOptionPane.showMessageDialog(null, "ע��ʧ�ܣ�", "��ѯ��ʾ", JOptionPane.ERROR_MESSAGE);
						}
					} catch (NullPointerException e1) {
						JOptionPane.showMessageDialog(null, "��Ա���Ŵ�����ѱ�ע����", "��ѯ��ʾ", JOptionPane.ERROR_MESSAGE);

					}
				} else {
					JOptionPane.showMessageDialog(null, "������Ҫע���Ŀͻ����Ż��û�����");
				}

			}
		});
		button_17.setBounds(180, 80, 100, 25);
		panel_5.add(button_17);
		// ��ֵ��ť
		JButton button_19 = new JButton("\u5145\u503C");
		button_19.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (!txt_cname.getText().equals("")) {
					try {
						customer = cs.getCustomerByCname(txt_cname.getText());
						UI_Manager.nowMoney = customer.getCmoney();
						new UI_Addmoney().setVisible(true);
						customer.setCmoney(nowMoney);
						updateLevel();
						cs.updateCustomer(customer);
						initCustomer();

					} catch (NullPointerException e1) {
						JOptionPane.showMessageDialog(null, "�û���������ѱ�ע����", "��ֵ��ʾ", JOptionPane.ERROR_MESSAGE);
					}
				} else if (!txt_ccode.getText().equals("")) {
					try {
						customer = cs.getCustomerByCcode(txt_ccode.getText());
						UI_Manager.nowMoney = customer.getCmoney();
						customer.setCmoney(nowMoney);
						new UI_Addmoney().setVisible(true);
						updateLevel();
						cs.updateCustomer(customer);
						initCustomer();

					} catch (NullPointerException e1) {
						JOptionPane.showMessageDialog(null, "��Ա���Ŵ�����ѱ�ע����", "��ֵ��ʾ", JOptionPane.ERROR_MESSAGE);

					}
				} else {
					JOptionPane.showMessageDialog(null, "������Ҫ��ֵ�Ŀͻ����Ż��û�����");
				}
			}
		});
		button_19.setBounds(180, 125, 100, 25);
		panel_5.add(button_19);

		JLabel label_12 = new JLabel("\u8BF7\u8F93\u5165\u7528\u6237\u540D\uFF1A");
		label_12.setBounds(10, 26, 120, 22);
		panel_5.add(label_12);

		txt_cname = new JTextField();
		txt_cname.setBounds(10, 55, 100, 25);
		panel_5.add(txt_cname);
		txt_cname.setColumns(10);

		JLabel label_13 = new JLabel("\u8BF7\u8F93\u5165\u4F1A\u5458\u5361\u53F7\uFF1A");
		label_13.setBounds(10, 87, 120, 25);
		panel_5.add(label_13);

		txt_ccode = new JTextField();
		txt_ccode.setBounds(10, 122, 100, 25);
		panel_5.add(txt_ccode);
		txt_ccode.setColumns(10);

		JLabel label_15 = new JLabel("\u67E5\u8BE2\u7ED3\u679C\uFF1A");
		label_15.setFont(new Font("΢���ź�", Font.PLAIN, 12));
		label_15.setBounds(5, 165, 75, 22);
		panel_1.add(label_15);

		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(9, 191, 543, 47);
		panel_1.add(scrollPane_3);

		JPanel panel_6 = new JPanel();
		scrollPane_3.setViewportView(panel_6);
		panel_6.setLayout(null);

		JScrollPane scrollPane_7 = new JScrollPane();
		scrollPane_7.setBounds(0, 0, 541, 45);
		panel_6.add(scrollPane_7);

		txtArea_rs = new JTextArea();
		txtArea_rs.setForeground(Color.BLACK);
		txtArea_rs.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		scrollPane_7.setViewportView(txtArea_rs);
		container.add(tab);
		srcsize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setSize(860, 566);
		frame.setLocation(200, 100);
		frame.setVisible(true);
	}

	public void showMovie(int id) {


		int count = dtm.getRowCount();
		for (int i = 0; i < count; i++) {
			dtm.removeRow(0);
		}
	
		MovieService MS=new MovieServiceImpl();

		ScheduleService ss = new ScheduleServiceImpl();
		List<Table_Movie> lists=MS.findMovieByType(id);
		for (Table_Movie list: lists) {
			
			List<Table_Schedule> Schedule = ss.getmid1(list.getMid());
			
			for (Table_Schedule ts : Schedule) {
				
				dtm.addRow(new Object[] { 
						list.getMid(),list.getM_name(),
						ts.getSid(),ts.getSname(),
						ts.getS_begindate(),ts.getS_enddate(),
						list.getM_price(),
				});
			}
		}
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});

	}

	/**
	 * ��ʼ���ͻ�
	 */
	public void initCustomer() {
		int count = dtm3.getRowCount();
		for (int i = 0; i < count; i++) {
			dtm3.removeRow(0);
		}
		// ���ò�ѯȫ�����������ӵĻ��Գ���
		List<Table_Customer> list = cs.findAll();
		customerList = list;
		for (Table_Customer customer : list) {
			dtm3.addRow(new Object[] { customer.getCid(), customer.getCcode(), customer.getCname(),
					customer.getCgender(), customer.getCphone(), customer.getCbirthday(),
					ls.getLevelById((customer.getClid())).getLname(),
					ls.getLevelById((customer.getClid())).getLdiscount() });
		}

	}

	/**
	 * ���ݿͻ����������¿ͻ���Ա����
	 */
	public void updateLevel() {
		if (UI_Manager.nowMoney >= 1000) {
			customer.setClid(5);
		} else if (UI_Manager.nowMoney >= 600) {
			customer.setClid(4);
		} else if (UI_Manager.nowMoney >= 400) {
			customer.setClid(3);
		} else if (UI_Manager.nowMoney >= 200) {
			customer.setClid(2);
		} else {
			customer.setClid(1);
		}
	}
	// ��Ʊ����������������1����Ʊ����û�г�����Ӱ��ӳ����2����Ʊ��۳�Ʊ��20%����������3��Ժ����ӳ������Ʊ��Ʊǰ��ȷ������˵����һ����Ʊ���Ų��˿лл�ͻ�

	/**
	 * ��Ӱչʾ
	 * 
	 * @param id ��Ӱ����
	 */

	/**
	 * ��Ӱ��Ƭ
	 */
	public void Schule() {
		int count = dtm2.getRowCount();
		for (int i = 0; i < count; i++) {
			dtm2.removeRow(0);
		}

		MovieService ms = new MovieServiceImpl();
		List<Table_Movie> lists = ms.findAAll();

		ScheduleService ss = new ScheduleServiceImpl();
//		List<Table_Schedule> Schedule;
		for (Table_Movie list : lists) {

			List<Table_Schedule> Schedule = ss.getmid1(list.getMid());

			for (Table_Schedule ts : Schedule) {

				dtm2.addRow(new Object[] { ts.getSid(), ts.getHid(), list.getM_name(), ts.getS_begindate(),
						list.getM_duration(), ts.getS_enddate(), list.getM_price(), ts.getSname() });
			}
		}

	}

}
