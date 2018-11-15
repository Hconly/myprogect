package view;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import entity.Table_Schedule;
import service.MovieService;
import service.ScheduleService;
import service.Impl.MovieServiceImpl;
import service.Impl.ScheduleServiceImpl;
import util.castutil;

public class UI_Schule extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private DefaultTableModel dtm;
	public static Table_Schedule sch;
	public static  ScheduleService sc;

	UI_ActionMovie uia = new UI_ActionMovie();
	UI_LoveMovie uil = new UI_LoveMovie();
	UI_Comedy uic = new UI_Comedy();
	UI_SuspenseMovie uis = new UI_SuspenseMovie();
	UI_ThrillerMovie uit = new UI_ThrillerMovie();
	UI_mainView main = new UI_mainView();
	UI_hotMovie hot = new UI_hotMovie();
	UI_Find uif=new UI_Find();
	ScheduleService ss = new ScheduleServiceImpl();
	static int num;
	static int hName;

	/**
	 * Launch the application.
	 */



	/**
	 * Create the dialog.
	 */
	public UI_Schule() {
		setModalityType(ModalityType.APPLICATION_MODAL);
		setTitle("\u573A\u6B21\u4FE1\u606F");
		setBounds(100, 100, 667, 369);
		getContentPane().setLayout(new BorderLayout());
		setIconImage(Toolkit.getDefaultToolkit().getImage("img\\timg1.jpg"));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setBounds(10, 10, 631, 316);
		contentPanel.add(scrollPane);

		table = new JTable();
		dtm = new DefaultTableModel(new Object[][] {}, new String[] { "场次", "场厅号", "开始时间", "结束时间", "票价" });
		table.setModel(dtm);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int index = table.getSelectedRow();
				hName = (int) table.getValueAt(index, 1);
				String obj=(String) table.getValueAt(index, 2);
				if(!obj.equals("暂无")) {
					dispose();
					UI_Seat uis=new UI_Seat();
					uis.setVisible(true);
					uis.setLocationRelativeTo(null);
					
				}else {
					JOptionPane.showMessageDialog(null, "抱歉暂时不放映");
				}			}
		});
		scrollPane.setViewportView(table);
		initschule();
	}

	/**
	 * 初始化表格
	 */

	public void initschule() {
		switch (main.tid) {
		case 2:
			num = uil.mid;
			break;
		case 3:
			num = uia.mid;
			break;
		case 4:
			num = uit.mid;
			break;
		case 5:
			num = uis.mid;
			break;
		case 6:
			num = uic.mid;
			break;
		case 1:
			num = hot.mid;
			break;
		default:
			num=uif.mid;
			break;
		}
		List<Table_Schedule> Schedule = ss.getmid(num);
		sc = new ScheduleServiceImpl();
		
		MovieService MS = new MovieServiceImpl();
		if (Schedule.size() > 0) {
			for (Table_Schedule m : Schedule) {
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm");
				Date dt2;
				Date dt1;
				try {
					dt1 = df.parse(castutil.castString(m.getS_begindate()));
					dt2 = df.parse(df.format(new Date()));
					if (dt1.getTime() > dt2.getTime()) {
						dtm.addRow(new Object[] { m.getSid(), m.getHid(), m.getS_begindate(), m.getS_enddate(),
								(MS.getbyId(m.getMid())).getM_price() });
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} else {
			dtm.addRow(new Object[] { "暂无", "暂无", "暂无", "暂无", "暂无" });
		}
	}
	public static Table_Schedule getMovieInfo() {
		return sc.getByMid(num);
	}
}
