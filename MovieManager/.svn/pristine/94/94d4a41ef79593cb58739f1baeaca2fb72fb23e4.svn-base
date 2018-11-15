package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import dao.Impl.LevelDaoImpl;
import entity.Table_Customer;
import entity.Table_Level;
import entity.Table_Schedule;
import entity.Table_Seat;
import service.Impl.CustomerServiceImpl;
import util.DBUtil;

public class UI_Seat extends JFrame {

	private JPanel contentPane;
	private JButton btn_seat;
	private JLabel label_seat1;
	private JLabel label_seat2;
	private JLabel label_seat3;
	private JLabel label_seat4;
	public List<JButton> btn_list;
	public Table_Seat seat;
	public List<Integer> select_list;
	private JLabel label_money;
	private Table_Customer cs;
	private Table_Schedule sch;
	public static double s_price_discount;
	public static double s_price;
	public static double s_price_single;
	public static double s_price_single_discount;
	public static int  isactiveID;
	public List<String> bTime;
	public int i;
	public int j;
	public int size;
	static ResultSet rs;
	String upSql;
	String sql;
	
	/**
	 * Draw a sign Line
	 */
	@Override
    public void paint(Graphics g) {
        super.paint(g);
 
        Graphics2D g2d = (Graphics2D) g;
 
        g2d.setColor(Color.LIGHT_GRAY);
 
        BasicStroke stroke1 = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 10.0f, new float[] { 5,8}, 0);
        g2d.setStroke(stroke1);
        g2d.drawLine(403, 125, 403, 485);
        
        BasicStroke stroke2 = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 10.0f, new float[] { 3,6}, 1);
        g2d.setStroke(stroke2);
        g2d.setColor(Color.RED);
        g2d.drawRect(242,243, 322, 120);
        
        BasicStroke stroke3 = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 10.0f, new float[] { 3,2}, 1);
        g2d.setStroke(stroke3);
        g2d.drawRect(500, 83, 28, 18);
 
    }
	/**
	 * 通过座位ID获取座位的具体位置
	 */
	public String getSeat(int id) {
		String str = null;
		for(int seat_row = 0;seat_row < 9;seat_row++) {
			for(int seat_col = 0;seat_col<12;seat_col++) {
				if(id % 12 == seat_col && (int)(id / 12) == seat_row) {
					seat.setSeat_row(seat_row);
					seat.setSeat_column(seat_col);
					str = (seat_row+1)+"排"+(seat_col+1)+"座";
				}
			}
		}
		return str;
	}
	/**
	 * 返回一个用户选择座位Id的集合
	 */
	public List<Integer> select_seat(){
		return select_list;
	}
	/**
	 * 每次打开选票窗口展示座位信息
	 */
	
	public void showSeat(int hid) {
		/*
		获取当前时间时间戳,与电影结束时间进行比较 如果大于电影结束时间将所有座位状态进行重置
		long currentTime = System.currentTimeMillis();//当前时间的时间戳
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		try {
			Date schDate = df.parse(sch.getS_begindate());
			long time = schDate.getTime();
			System.out.println(currentTime>time);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		System.out.println("当前电影"+new MovieDaoImpl().getbyId(sch.getMid()).getM_name());
		System.out.println("开始时间-->"+sch.getS_begindate()+"结束时间-->"+sch.getS_enddate());
		传参数，将对应影厅座位进行重置
		SetActive.reset(1电影结束时间,2当前时间,影厅名称);
		*/
//		System.out.println(sch.getS_begindate());
//		System.out.println(bTime.get(0));
//		System.out.println(bTime.get(1));
//		System.out.println(bTime.get(2));
		
		String sql = "select seat_id,seat_isactive"+isactiveID+" from table_seat where hid=?";
//		System.out.println(sql);
		rs = DBUtil.executequery(sql,hid);
		try {
			while(rs.next()) {
				int sid = rs.getInt("seat_id");
				int isa = rs.getInt("seat_isactive"+isactiveID);
				if(isa == 1) {
					btn_list.get(sid-1).setBackground(Color.ORANGE);
					btn_list.get(sid-1).setEnabled(false);
				}else if(isa == 0) {
					btn_list.get(sid-1).setBackground(null);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeAll();
		}
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					UI_Seat ui_Seat = new UI_Seat();
					ui_Seat.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UI_Seat() {
		seat = new Table_Seat();
		select_list = new ArrayList<>();
		sch = UI_Schule.getMovieInfo();
		cs = UI_Login.getCustomer();
		getAllBegin();
		for(int i = 0;i < bTime.size();i++) {
			if(sch.getS_begindate().equals(bTime.get(0))) {
				//1System.out.println(sch.getS_begindate().equals(bTime.get(0)));
				isactiveID = 1;
			}else if(sch.getS_begindate().equals(bTime.get(1))){
				//2System.out.println(sch.getS_begindate().equals(bTime.get(1)));
				isactiveID = 2;
			}else if(sch.getS_begindate().equals(bTime.get(2))) {
				//3System.out.println(sch.getS_begindate().equals(bTime.get(2)));
				isactiveID = 3;
			}
		}
		sql = "insert into table_select (c_seat_id1,c_seat_id2,c_seat_id3,c_seat_id4,hid) values(?,?,?,?,?)";
		upSql = "update table_seat set seat_isactive"+isactiveID+"=? where seat_id=? and hid=?";
		//1System.out.println(upSql);
		setTitle("座位选择窗口");
		btn_list = new ArrayList<>();
		setBounds(100, 100,907, 524);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 255)));
		panel.setBounds(67, 41, 658, 39);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("最佳观影区");
		lblNewLabel_4.setForeground(new Color(255, 69, 0));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_4.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(460, 10, 85, 20);
		panel.add(lblNewLabel_4);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setEnabled(false);
		btnNewButton_1.setBounds(125, 10, 30, 20);
		panel.add(btnNewButton_1);
		
		JLabel label_12 = new JLabel("未选");
		label_12.setForeground(new Color(255, 69, 0));
		label_12.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		label_12.setBounds(163, 10, 42, 20);
		panel.add(label_12);
		
		JButton button = new JButton("");
		button.setEnabled(false);
		button.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		button.setBackground(Color.ORANGE);
		button.setForeground(new Color(255, 69, 0));
		button.setBounds(297, 10, 30, 20);
		panel.add(button);
		
		JLabel label_13 = new JLabel("已选");
		label_13.setForeground(new Color(255, 69, 0));
		label_13.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		label_13.setBounds(335, 10, 42, 20);
		panel.add(label_13);
		
		JPanel panel_seat = new JPanel();
		panel_seat.setBorder(new LineBorder(new Color(0, 0, 255)));
		panel_seat.setBounds(67, 90, 658, 368);
		contentPane.add(panel_seat);
		panel_seat.setLayout(null);
		
		JPanel panel_seat_inner = new JPanel();
		panel_seat_inner.setBounds(10, 10, 638, 348);
		panel_seat_inner.setLayout(new GridLayout(9, 12, 20, 15));
		panel_seat.add(panel_seat_inner);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 255)));
		panel_1.setBounds(21, 90, 42, 368);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("1");
		lblNewLabel_1.setForeground(new Color(0, 0, 255));
		lblNewLabel_1.setFont(new Font("幼圆", Font.BOLD, 18));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(5, 15, 30, 20);
		panel_1.add(lblNewLabel_1);
		
		JLabel label = new JLabel("2");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.BLUE);
		label.setFont(new Font("幼圆", Font.BOLD, 18));
		label.setBounds(5, 55, 30, 20);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("3");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.BLUE);
		label_1.setFont(new Font("幼圆", Font.BOLD, 18));
		label_1.setBounds(5, 95, 30, 20);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("4");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(Color.BLUE);
		label_2.setFont(new Font("幼圆", Font.BOLD, 18));
		label_2.setBounds(5, 135, 30, 20);
		panel_1.add(label_2);
		
		JLabel label_3 = new JLabel("5");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(Color.BLUE);
		label_3.setFont(new Font("幼圆", Font.BOLD, 18));
		label_3.setBounds(5, 175, 30, 20);
		panel_1.add(label_3);
		
		JLabel label_4 = new JLabel("6");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setForeground(Color.BLUE);
		label_4.setFont(new Font("幼圆", Font.BOLD, 18));
		label_4.setBounds(5, 215, 30, 20);
		panel_1.add(label_4);
		
		JLabel label_5 = new JLabel("7");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setForeground(Color.BLUE);
		label_5.setFont(new Font("幼圆", Font.BOLD, 18));
		label_5.setBounds(5, 255, 30, 20);
		panel_1.add(label_5);
		
		JLabel label_6 = new JLabel("8");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setForeground(Color.BLUE);
		label_6.setFont(new Font("幼圆", Font.BOLD, 18));
		label_6.setBounds(5, 295, 30, 20);
		panel_1.add(label_6);
		
		JLabel label_7 = new JLabel("9");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setForeground(Color.BLUE);
		label_7.setFont(new Font("幼圆", Font.BOLD, 18));
		label_7.setBounds(5, 335, 30, 20);
		panel_1.add(label_7);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(20, 622, 785, 117);
		contentPane.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 255)));
		panel_3.setBounds(735, 41, 134, 417);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("座位信息");
		lblNewLabel_2.setForeground(new Color(0, 0, 255));
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 58, 114, 35);
		panel_3.add(lblNewLabel_2);
		
		String dtSty = "yyyy-MM-dd";
		JLabel lab_date = new JLabel();
		lab_date.setHorizontalAlignment(SwingConstants.CENTER);
		util.Time.setDT(dtSty, lab_date);
		lab_date.setForeground(new Color(0, 0, 255));
		lab_date.setFont(new Font("Consolas", Font.PLAIN, 14));
		lab_date.setBounds(10, 10, 114, 20);
		panel_3.add(lab_date);
		
		String dtStyle = "HH:mm:ss";
		JLabel lab_time = new JLabel();
		lab_time.setHorizontalAlignment(SwingConstants.CENTER);
		util.Time.setDT(dtStyle, lab_time);
		lab_time.setForeground(new Color(0, 0, 255));
		lab_time.setFont(new Font("Consolas", Font.PLAIN, 14));
		lab_time.setBounds(10, 35, 114, 20);
		panel_3.add(lab_time);
		
		label_seat1 = new JLabel();
		label_seat1.setForeground(new Color(255, 69, 0));
		label_seat1.setHorizontalAlignment(SwingConstants.CENTER);
		label_seat1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		label_seat1.setBounds(20, 100, 100, 30);
		label_seat1.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		panel_3.add(label_seat1);
		
		label_seat2 = new JLabel();
		label_seat2.setForeground(new Color(255, 69, 0));
		label_seat2.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		label_seat2.setHorizontalAlignment(SwingConstants.CENTER);
		label_seat2.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		label_seat2.setBounds(20, 150, 100, 30);
		panel_3.add(label_seat2);
		
		label_seat3 = new JLabel();
		label_seat3.setForeground(new Color(255, 69, 0));
		label_seat3.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		label_seat3.setHorizontalAlignment(SwingConstants.CENTER);
		label_seat3.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		label_seat3.setBounds(20, 200, 100, 30);
		panel_3.add(label_seat3);
		
		label_seat4 = new JLabel();
		label_seat4.setForeground(new Color(255, 69, 0));
		label_seat4.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		label_seat4.setHorizontalAlignment(SwingConstants.CENTER);
		label_seat4.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		label_seat4.setBounds(20, 250, 100, 30);
		panel_3.add(label_seat4);
		
		JLabel lblNewLabel_3 = new JLabel("总计：");
		lblNewLabel_3.setForeground(new Color(0, 0, 255));
		lblNewLabel_3.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(20, 297, 54, 20);
		panel_3.add(lblNewLabel_3);
		
		label_money = new JLabel("\uFFE5\uFF1A0.00\u5143");
		label_money.setForeground(new Color(0, 0, 205));
		label_money.setHorizontalAlignment(SwingConstants.CENTER);
		label_money.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		label_money.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		label_money.setBounds(20, 319, 100, 31);
		panel_3.add(label_money);
		setVisible(true);
		
		JButton btn_commit = new JButton("请先选座");
		btn_commit.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(e.getSource() == btn_commit) {	
					
					Integer seat1 = 0;
					Integer seat2 = 0;
					Integer seat3 = 0;
					Integer seat4 = 0;
					if(select_list.size()==4) {
						seat1 = select_list.get(0);
						seat2 = select_list.get(1);
						seat3 = select_list.get(2);
						seat4 = select_list.get(3);
						DBUtil.executeupdate(sql, seat1,seat2,seat3,seat4,UI_Schule.hName);
						DBUtil.executeupdate(upSql,1,seat1+1,UI_Schule.hName);
						DBUtil.executeupdate(upSql,1,seat2+1,UI_Schule.hName);
						DBUtil.executeupdate(upSql,1,seat3+1,UI_Schule.hName);
						DBUtil.executeupdate(upSql,1,seat4+1,UI_Schule.hName);
					}
					if(select_list.size()==3) {
						seat1 = select_list.get(0);
						seat2 = select_list.get(1);
						seat3 = select_list.get(2);
						DBUtil.executeupdate(sql, seat1,seat2,seat3,108,UI_Schule.hName);
						DBUtil.executeupdate(upSql,1,seat1+1,UI_Schule.hName);
						DBUtil.executeupdate(upSql,1,seat2+1,UI_Schule.hName);
						DBUtil.executeupdate(upSql,1,seat3+1,UI_Schule.hName);
					}
					if(select_list.size()==2) {
						seat1 = select_list.get(0);
						seat2 = select_list.get(1);
						DBUtil.executeupdate(sql, seat1,seat2,108,108,UI_Schule.hName);
						DBUtil.executeupdate(upSql,1,seat1+1,UI_Schule.hName);
						DBUtil.executeupdate(upSql,1,seat2+1,UI_Schule.hName);
					}
					if(select_list.size()==1) {
						seat1 = select_list.get(0);
						DBUtil.executeupdate(sql, seat1,108,108,108,UI_Schule.hName);
						DBUtil.executeupdate(upSql,1,seat1+1,UI_Schule.hName);
					}
					if(select_list.size()==0) {
						JOptionPane.showMessageDialog(null, "您还没有选择座位！", "提示信息", JOptionPane.WARNING_MESSAGE);
					}else {
						int k = JOptionPane.showConfirmDialog(null, "是否提交？", "提示信息", JOptionPane.OK_CANCEL_OPTION);	
						if(k==0) {
							dispose();
							new UI_Order();
							cs.setCmoney(cs.getCmoney()-s_price_single_discount*select_list.size());
							CustomerServiceImpl csi = new CustomerServiceImpl();
							boolean b = csi.updateCustomer(cs);
							System.out.println(b);
						}else {
							JOptionPane.showMessageDialog(null, "取消提交");
						}
						
					}
					/**
					 * 展示用户清单
					 */
					//JOptionPane.showInputDialog(null, "请输入验证码");
					
				}
			}
		});
		btn_commit.setForeground(new Color(255, 69, 0));
		btn_commit.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		btn_commit.setBounds(20, 370, 100, 35);
		panel_3.add(btn_commit);
		
		JLabel lblNewLabel = new JLabel(UI_Schule.hName+" 号厅   银幕");
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setFont(new Font("幼圆", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(277, 5, 190, 31);
		contentPane.add(lblNewLabel);
		/**
		 * 创建座位分配ID
		 */
		for(;i<108;i++) {
			btn_seat = new JButton();
			btn_seat.setName(String.valueOf(i));
			btn_list.add(btn_seat);
			panel_seat_inner.add(btn_seat);
		}
		/**
		 * 展示座位信息
		 */
		showSeat(UI_Schule.hName);
		//1System.out.println("当前影厅名称"+UI_Schule.hName);
		/**
		 * 座位单击事件
		 */
		for(;j < 108;j++) {
			btn_list.get(j).addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					seat = new Table_Seat();
					for(int k = 0;k < 108;k++) {
						if(e.getSource()==btn_list.get(k)) {
							if(btn_list.get(k).getBackground() == Color.ORANGE) {
								if(btn_list.get(k).isEnabled()==false) {
									JOptionPane.showMessageDialog(null, "座位已选用！", "提示信息", JOptionPane.WARNING_MESSAGE);
								}else {
									btn_list.get(k).setBackground(null);
									seat.setSeat_isactive1(0);
									seat.setSeat_isactive2(0);
									seat.setSeat_isactive3(0);
									seat.setSeat_isactive4(0);
									select_list.remove(Integer.valueOf(btn_list.get(k).getName()));
								}
							}else {
								if(select_list.size()>=4) {
									JOptionPane.showMessageDialog(null, "最多可选择4个座位", "提示信息", JOptionPane.WARNING_MESSAGE);
									btn_list.get(k).setBackground(null);
								}else {
									btn_list.get(k).setBackground(Color.ORANGE);
									seat.setSeat_isactive1(1);
									seat.setSeat_isactive2(1);
									seat.setSeat_isactive3(1);
									seat.setSeat_isactive4(1);
									select_list.add(Integer.valueOf(btn_list.get(k).getName()));
								}
							}		
							/**
							 * 提交按钮
							 */
							if(select_list.size()>0) {
								/**
								 * 判断会员级别
								 */
								LevelDaoImpl level = new LevelDaoImpl();
								Table_Level levelById = level.getLevelById(cs.getClid());
								double ldiscount = levelById.getLdiscount();
								s_price = sch.getS_price()*select_list.size();
								s_price_single = sch.getS_price();
								s_price_single_discount = s_price_single*ldiscount;
								if(cs.getClid()==1) {
									s_price_discount = s_price*ldiscount;
								}else if(cs.getClid()==2) {
									s_price_discount = s_price*ldiscount;
								}else if(cs.getClid()==3) {
									s_price_discount = s_price*ldiscount;
								}else if(cs.getClid()==4) {
									s_price_discount = s_price*ldiscount;
								}else if(cs.getClid()==5) {
									s_price_discount = s_price*ldiscount;
								}
								label_money.setText("￥："+s_price+"元");
								btn_commit.setText("确认提交");
							}else {
								label_money.setText("￥：0.00元");
								btn_commit.setText("请先选座");
							}
						}
					}
					/**
					 * 座位选择信息
					 */
					for(int p = 0;p <= select_list.size();p++) {
						if(p == 1) {
							label_seat1.setText(getSeat(select_list.get(0)));
							if(label_seat4.getText()!="" || label_seat3.getText()!="" || label_seat2.getText()!="") {
								label_seat4.setText("");
								label_seat3.setText("");
								label_seat2.setText("");
							}
						}else if(p == 2) {
							label_seat1.setText(getSeat(select_list.get(0)));
							label_seat2.setText(getSeat(select_list.get(1)));
							if(label_seat4.getText()!="" || label_seat3.getText()!="") {
								label_seat4.setText("");
								label_seat3.setText("");
							}
						}else if(p == 3) {
							label_seat1.setText(getSeat(select_list.get(0)));
							label_seat2.setText(getSeat(select_list.get(1)));
							label_seat3.setText(getSeat(select_list.get(2)));
							if(label_seat4.getText()!="") {
								label_seat4.setText("");
							}
						}else if(p == 4) {
							label_seat1.setText(getSeat(select_list.get(0)));
							label_seat2.setText(getSeat(select_list.get(1)));
							label_seat3.setText(getSeat(select_list.get(2)));
							label_seat4.setText(getSeat(select_list.get(3)));
						}else if(p == 0) {
							label_seat1.setText("");
							label_seat2.setText("");
							label_seat3.setText("");
							label_seat4.setText("");
						}
					}
				}
			});
		}	
	}
	//获取开始时间
	public void getAllBegin() {
		String sql = "select begin1,begin2,begin3 from table_seat where hid="+UI_Schule.hName+" and seat_row=1 and seat_column=1";
		rs = DBUtil.executequery(sql);
		bTime = new ArrayList<>();
		try {
			while(rs.next()) {
				String b1 = rs.getDate("begin1").toString()+" "+rs.getTime("begin1");
				String b2 = rs.getDate("begin2").toString()+" "+rs.getTime("begin2");
				String b3 = rs.getDate("begin3").toString()+" "+rs.getTime("begin3");
				bTime.add(b1);
				bTime.add(b2);
				bTime.add(b3);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeAll();
		}
	}
}
