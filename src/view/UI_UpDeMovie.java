package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entity.Table_Movie;
import entity.dto.MovieDto;
import service.MovieService;
import service.MovietypeService;
import service.Impl.MovieServiceImpl;
import service.Impl.MovietypeServiceImpl;
import util.castutil;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JPopupMenu;
import java.awt.Component;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JDialog;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Dialog.ModalityType;

public class UI_UpDeMovie extends JDialog {

	private JPanel contentPane;
	private  DefaultTableModel dtm;
	public static Table_Movie tmo=new Table_Movie();
	private JPopupMenu popupMenu;
	private JMenuItem menuItem;
	private JTable table;
	private JPopupMenu popupMenu_1;
	private JMenuItem menuItem_1;
	private JMenuItem menuItem_2;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI_UpDeMovie  frame = new UI_UpDeMovie();
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
	public UI_UpDeMovie() {
		setModalityType(ModalityType.APPLICATION_MODAL);
		setTitle("\u7535\u5F71\u4FEE\u6539\u548C\u5220\u9664");
	//	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 804, 529);
		contentPane = new JPanel();
		setIconImage(Toolkit.getDefaultToolkit().getImage("img\\timg1.jpg"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u7535\u5F71\u5217\u8868:");
		label.setBounds(27, 30, 84, 25);
		contentPane.add(label);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(54, 78, 687, 289);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
				"\u7535\u5F71\u7F16\u53F7", "\u7535\u5F71\u540D", "\u4E3B\u6F14", "\u5BFC\u6F14", "\u65F6\u957F", "\u7535\u5F71\u63CF\u8FF0", "\u7535\u5F71\u7C7B\u578B", "\u8BC4\u5206", "\u4EF7\u683C"
			}
		));
		
		
		popupMenu_1 = new JPopupMenu();
		addPopup(table, popupMenu_1);
		
		menuItem_1 = new JMenuItem("\u4FEE\u6539");
		menuItem_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int i=table.getSelectedRow();
				int i1= castutil.castint( table.getValueAt(i, 0));
				MovieService mss=new MovieServiceImpl();
				Table_Movie tmo=mss.getbyId(i1);
				
				//TODO
				
				
				 UI_UpDeMovie.this.tmo=tmo;
				 
				UI_UpdateMovie uum=new UI_UpdateMovie(tmo);
				uum.setVisible(true);
				uum.addWindowListener(new WindowAdapter() {
					public void WindowClosed(WindowEvent e) {
						showMovie();
					}
				});
				
				
				
				
				
			}
		});
		popupMenu_1.add(menuItem_1);
		
		menuItem_2 = new JMenuItem("\u5220\u9664");
		menuItem_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int i=table.getSelectedRow();
				
				int i1=castutil.castint(table.getValueAt(i, 0));
				
				MovieService ms=new MovieServiceImpl();
				int num = JOptionPane.showConfirmDialog(null, "是否确定删除电影《"+table.getValueAt(i, 1)+"》?", "删除操作提示", 
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if(num==0) {
					if(ms.deleteMovie(i1)) {
						JOptionPane.showMessageDialog(null, "删除成功!");
						showMovie();
					}
				}else {
					JOptionPane.showMessageDialog(null, "取消删除!");
				}
				
				
			}
		});
		popupMenu_1.add(menuItem_2);
		dtm=new DefaultTableModel(
				new Object[][] {},
				new String[] {
					"\u7535\u5F71\u7F16\u53F7", "\u7535\u5F71\u540D", "\u4E3B\u6F14", "\u5BFC\u6F14", "\u65F6\u957F", "\u7535\u5F71\u63CF\u8FF0", "\u7535\u5F71\u7C7B\u578B", "\u8BC4\u5206", "\u4EF7\u683C", 
				}
			);
		showMovie();
		
		table.setModel(dtm);
		scrollPane.setViewportView(table);
		
		JButton button = new JButton("修改");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int i=table.getSelectedRow();
				int i1= castutil.castint( table.getValueAt(i, 0));
				MovieService mss=new MovieServiceImpl();
				Table_Movie tmo=mss.getbyId(i1);
				
				//TODO
				
				
				 UI_UpDeMovie.this.tmo=tmo;
				 
				UI_UpdateMovie uum=new UI_UpdateMovie(tmo);
				uum.setVisible(true);
				uum.addWindowListener(new WindowAdapter() {
					public void WindowClosed(WindowEvent e) {
						showMovie();
					}
				});
				
			}
		});
		button.setBounds(123, 420, 104, 34);
		contentPane.add(button);
		
		JButton button_1 = new JButton("删除");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int i=table.getSelectedRow();
				
				int i1=castutil.castint(table.getValueAt(i, 0));
				
				MovieService ms=new MovieServiceImpl();
			

				int num = JOptionPane.showConfirmDialog(null, "是否确定删除电影《"+table.getValueAt(i, 1)+"》?", "删除操作提示", 
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
						
				if(num==0) {
					if(ms.deleteMovie(i1)) {
						JOptionPane.showMessageDialog(null, "删除成功!");
						showMovie();
					}
				}else {
					JOptionPane.showMessageDialog(null, "取消删除!");
				}
			
			
			
			}
		});
		button_1.setBounds(528, 420, 104, 34);
		contentPane.add(button_1);
		
		
	}
	
	public void showMovie() {
		int count= dtm.getRowCount();
		for(int i = 0;i<count;i++) {
			dtm.removeRow(0);
		}
		
		MovieService MS=new MovieServiceImpl();
		List <MovieDto> moviedto=MS.findAll();
		MovietypeService mt=new MovietypeServiceImpl();
		for (MovieDto movieDto2 : moviedto) {
			dtm.addRow(new Object[] {movieDto2.getMovie().getMid(),
					movieDto2.getMovie().getM_name(),
					movieDto2.getMovie().getM_mainactor(),
					movieDto2.getMovie().getM_director(),
					movieDto2.getMovie().getM_duration(),
					movieDto2.getMovie().getM_desc(),
					 mt.getById(movieDto2.getMovie().getTid()).getTname(),
					movieDto2.getMovie().getM_score(),
					movieDto2.getMovie().getM_price(),
					
					
					});
			
			
			
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
}
