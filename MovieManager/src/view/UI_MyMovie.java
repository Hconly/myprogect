
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;

import entity.Table_Customer;
import entity.Table_Hall;
import entity.Table_Movie;
import entity.Table_Order;
import entity.Table_Schedule;
import entity.Table_Seat;
import service.CustomerService;
import service.HallService;
import service.MovieService;
import service.OrderService;
import service.ScheduleService;
import service.SeatService;
import service.Impl.CustomerServiceImpl;
import service.Impl.HallServiceImpl;
import service.Impl.MovieServiceImpl;
import service.Impl.OrderServiceImpl;
import service.Impl.ScheduleServiceImpl;
import service.Impl.SeatServiceImpl;
import util.ImgUtil;
import util.castutil;

public class UI_MyMovie extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JLabel lb_img;
	private JLabel lb_cname;
	Table_Customer customer;
	DefaultTableModel tableModel;
	CustomerService customerService=new CustomerServiceImpl();
	private JLabel lb_desc;
	OrderService orderService=new OrderServiceImpl();
	public static Table_Order selectOrder;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UI_MyMovie dialog = new UI_MyMovie();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public UI_MyMovie(Table_Customer c) {
	this();
	customer=c;
	//窗口初始化

	if (customer.getCphoto() == null) {
		try {
			Image img = ImgUtil.getIcon(new FileInputStream("img/人物.png"), 82, 73);
			lb_img.setIcon(new ImageIcon(img));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	} else {
		try {
			Image img = ImgUtil.getIcon(new FileInputStream(customer.getCphoto()), 82, 73);
			lb_img.setIcon(new ImageIcon(img));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	lb_cname.setText(customer.getCname());
	lb_desc.setText(customer.getCdesc());      
	
	List<Table_Order> orderList=orderService.getOrderByCid(customer.getCid());
	
	initTable(orderList);
	
	}
	/**
	 * Create the dialog.
	 */
	public UI_MyMovie() {
		setTitle("\u6211\u7684");
		setBounds(100, 100, 406, 483);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					UI_GeRen ui=new UI_GeRen(customer);
					ui.setVisible(true);
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
			panel.setBounds(10, 10, 370, 90);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JPanel panel_1 = new JPanel();
				panel_1.setToolTipText("");
				panel_1.setBounds(10, 8, 75, 72);
				panel.add(panel_1);
				panel_1.setLayout(null);

				lb_img = new JLabel("");
				lb_img.setBounds(0, 0, 75, 72);
				panel_1.add(lb_img);
			}
			{
				lb_cname = new JLabel("\u6635\u79F0");
				lb_cname.setFont(new Font("微软雅黑", Font.PLAIN, 13));
				lb_cname.setBounds(127, 23, 54, 15);
				panel.add(lb_cname);
			}
			{
				JLabel lblNewLabel = new JLabel("");
				try {
					Image img = ImgUtil.getIcon(new FileInputStream("img/kuohao1.png"), 13, 13);
					lblNewLabel.setIcon(new ImageIcon(img));
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				lblNewLabel.setBounds(304, 36, 28, 15);
				panel.add(lblNewLabel);
			}
			{
				lb_desc = new JLabel("");
				lb_desc.setBounds(127, 48, 233, 32);
				panel.add(lb_desc);
			}
		}
		{
			JSeparator separator = new JSeparator();
			separator.setBounds(20, 110, 370, 2);
			contentPanel.add(separator);
		}
		{
			JPanel panel = new JPanel();
			panel.setBounds(10, 122, 370, 334);
			contentPanel.add(panel);
			panel.setLayout(null);

			JScrollPane scrollPane = new JScrollPane();

			scrollPane.setBounds(10, 43, 360, 237);
			panel.add(scrollPane);

			/**
			 * 添加评价
			 * 比较放映时间与当前时间判断是否失效
			 * 如果没看就弹出提示窗口
			 * 如果看了就弹出评价窗口
			 */
			table = new JTable();
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					if(e.getClickCount()==2) {
						int index=table.getSelectedRow();
						Object orderId=tableModel.getValueAt(index, 0);
						 selectOrder=orderService.getOrderById(castutil.castint(orderId));
						Object time=tableModel.getValueAt(index, 2);
						DateFormat df=new SimpleDateFormat("yyyy-MM-dd hh:mm");
						//Object mid=order.getMid();
							try {
								Date dt1=df.parse(castutil.castString(time));
								Date dt2=df.parse(df.format( new Date()));
								if(dt1.getTime()>dt2.getTime()) {
									//System.out.println("未播出");
									
									UI_ShowMove showMove=new UI_ShowMove(selectOrder);
									showMove.setVisible(true);
									showMove.addWindowListener(new WindowAdapter() {
										@Override
										public void windowClosed(WindowEvent e) {
											//退票窗体销毁
											List<Table_Order> orderList=orderService.getOrderByCid(customer.getCid());
											initTable(orderList);
										}});
								}else {
									//System.out.println("已播出");
									UI_PingJia uip=new UI_PingJia();
									uip.setLocationRelativeTo(table);
									uip.setVisible(true);
								}
							} catch (ParseException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						
						
						//这里进行判断
					}
				}

			});
			tableModel=new DefaultTableModel(
					new Object[][] {
						{null, null, null, null},
					},
					new String[] {
							"\u7968\u53F7","\u5F71\u7247\u540D\u79F0", "\u653E\u6620\u65F6\u95F4", "\u5730\u70B9", "\u5EA7\u4F4D"
					}
					);
			table.setModel(tableModel);
			table.setFont(new Font("微软雅黑", Font.PLAIN, 13));
			scrollPane.setViewportView(table);

			JLabel label = new JLabel("\u6211\u7684\u7535\u5F71\u7968");
			label.setBounds(10, 10, 69, 23);
			panel.add(label);

			btn_exit = new JButton("\u9000\u51FA");
			btn_exit.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					dispose();
				}
			});
			btn_exit.setBounds(267, 290, 93, 23);
			panel.add(btn_exit);
		}
	

	}

	//图片缩放
	public BufferedImage getIcon(InputStream is) {
		BufferedImage bufferedImage=null;
		try {
			Image image=ImageIO.read(is);
			bufferedImage=new BufferedImage(54,44,BufferedImage.TYPE_INT_RGB);
			bufferedImage.getGraphics().drawImage(image,0,0, 54, 44, null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bufferedImage;
		//initTable(List<Table_Order> list);

	}
	MovieService movieSertvice=new MovieServiceImpl();
	HallService hallService=new HallServiceImpl();
	SeatService SeatService=new SeatServiceImpl();
	ScheduleService scheduleService=new ScheduleServiceImpl();
	private JButton btn_exit;
	//表格初始化
	public void initTable(List<Table_Order> list) {
		
		int count=tableModel.getRowCount();
		for (int i = 0; i < count; i++) {
			tableModel.removeRow(0);
		}
		for (Table_Order  order: list) {
			Table_Movie movie=movieSertvice.getbyId(order.getMid());
			
			Table_Schedule schedule=scheduleService.getScheduleBySid(order.getSid());
			
			Table_Seat seat=SeatService.getSeatBySid(order.getSeat_id());
			Table_Hall hall=hallService.getHallById(seat.getHid());
			tableModel.addRow(new Object[] {
					order.getOid(),
					movie.getM_name(),
					schedule.getS_begindate(),
					hall.getHdesc(),
					seat.getSeat_row()+"排"+seat.getSeat_column()+"座"
			});
		}

	}
}
