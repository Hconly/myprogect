package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.eltima.components.ui.DatePicker;

import dao.MovieTypeDao;
import dao.Impl.MovieTypeDaoImpl;
import entity.Table_Movie;
import entity.Table_MovieType;
import service.MovieService;
import service.MovietypeService;
import service.Impl.MovieServiceImpl;
import service.Impl.MovietypeServiceImpl;
import util.DBUtil;
import util.castutil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import javax.swing.JSpinner;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JRadioButton;

public class UI_AddMovie extends JDialog {

	private JPanel contentPane;
	private JTextField txt_mname;
	private JTextField txt_mainactor;
	private JTextField txt_director;
	private JTextField txt_begindate;
	private JTextField txt_enddate;
	private JTextField txt_price;
	private JTextPane txt_mdesc;
	private DatePicker dp;
	private JSpinner sp_duration;
	private JSpinner sp_score;
	private JLabel lb_image;
	File selectImgFile; 
	private JComboBox cb_type;
	boolean isimg = true;
	private JRadioButton rb_yes;
	private JRadioButton rb_no;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI_AddMovie frame = new UI_AddMovie();
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
	public UI_AddMovie() {
	//	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 844, 751);
		contentPane = new JPanel();
		setIconImage(Toolkit.getDefaultToolkit().getImage("img\\timg1.jpg"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u7535\u5F71\u540D\u79F0:");
		label.setBounds(33, 38, 74, 29);
		contentPane.add(label);
		
		txt_mname = new JTextField();
		txt_mname.setBounds(112, 42, 186, 21);
		contentPane.add(txt_mname);
		txt_mname.setColumns(10);
		
		JLabel label_1 = new JLabel("\u4E3B\u6F14:");
		label_1.setBounds(443, 45, 54, 15);
		contentPane.add(label_1);
		
		txt_mainactor = new JTextField();
		txt_mainactor.setBounds(507, 42, 186, 21);
		contentPane.add(txt_mainactor);
		txt_mainactor.setColumns(10);
		
		JLabel label_2 = new JLabel("\u5BFC\u6F14:");
		label_2.setBounds(33, 119, 54, 15);
		contentPane.add(label_2);
		
		txt_director = new JTextField();
		txt_director.setBounds(112, 116, 186, 21);
		contentPane.add(txt_director);
		txt_director.setColumns(10);
		
		JLabel label_3 = new JLabel("\u7535\u5F71\u7C7B\u578B:");
		label_3.setBounds(443, 119, 64, 15);
		contentPane.add(label_3);
		
//		txt_enddate = new JTextField();
//		txt_enddate.setBounds(507, 185, 186, 21);
//		contentPane.add(txt_enddate);
//		txt_enddate.setColumns(10);
		
		
		JLabel label_6 = new JLabel("\u4EF7\u683C:");
		label_6.setBounds(33, 203, 54, 15);
		contentPane.add(label_6);
		
		txt_price = new JTextField();
		txt_price.setBounds(112, 200, 186, 21);
		contentPane.add(txt_price);
		txt_price.setColumns(10);
		
		JLabel label_7 = new JLabel("\u5F71\u7247\u63CF\u8FF0:");
		label_7.setBounds(33, 357, 77, 21);
		contentPane.add(label_7);
		
		txt_mdesc = new JTextPane();
		txt_mdesc.setBounds(112, 386, 197, 171);
		contentPane.add(txt_mdesc);
		
		JButton button = new JButton("\u786E\u8BA4");
		button.addMouseListener(new MouseAdapter() {
			//添加电影!
			public void mousePressed(MouseEvent e) {
				Table_Movie tm=new Table_Movie();
				tm.setM_name(txt_mname.getText());
				tm.setM_mainactor(txt_mainactor.getText());
				tm.setM_director(txt_director.getText());
				tm.setM_desc(txt_mdesc.getText());
				if(rb_yes.isSelected()) {
					tm.setHot(1);
				}else {
					tm.setHot(0);
				}
				
				
				
				
				tm.setM_price(castutil.castint(txt_price.getText()));
				
				tm.setM_score(castutil.castDouble(sp_score.getValue()));
				
				
				
				if(cb_type.getSelectedIndex()<=0) {
					JOptionPane.showMessageDialog(null, "请选择添加电影类型!");
					return;
					
				}else {
					tm.setTid(cb_type.getSelectedIndex());}
				
				
				
				if(isimg ==true) {
					try {
						if(selectImgFile==null) {
							
							tm.setM_image("");
							
						}else {
						
						tm.setM_image(selectImgFile.toString());}
					}  catch (Exception e1) {
						e1.printStackTrace();
					}

				}
				
				tm.setM_duration(castutil.castString(sp_duration.getValue()));
			
				MovieService ms=new MovieServiceImpl();
				if(ms.addMovie(tm)) {
					JOptionPane.showMessageDialog(null, "添加成功!");
					
					
				}else {
					JOptionPane.showMessageDialog(null, "添加失败!");
				}
					
				
				
				
			}
		});
		button.setBounds(188, 601, 143, 40);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				 txt_mname.setText(null);
					txt_mainactor.setText(null);
					txt_director.setText(null);
					
					txt_price.setText(null);
					txt_mdesc.setText(null);
					rb_yes.setSelected(true);
					lb_image.setText(null);
					cb_type.setSelectedIndex(0);
					
				
			}
		});
		button_1.setBounds(474, 601, 137, 40);
		contentPane.add(button_1);
		
		JLabel label_8 = new JLabel("\u65F6\u957F:");
		label_8.setBounds(443, 203, 54, 15);
		contentPane.add(label_8);
		
		
		SpinnerNumberModel model1= new SpinnerNumberModel(0, 0, 240, 10);
		sp_duration = new JSpinner(model1);
		sp_duration.setBounds(507, 200, 93, 22);
		contentPane.add(sp_duration);
		
		JLabel label_9 = new JLabel("\u8BC4\u5206:");
		label_9.setBounds(33, 270, 54, 15);
		contentPane.add(label_9);
		
		SpinnerNumberModel model= new SpinnerNumberModel(0, 0, 10, 0.5);
		sp_score = new JSpinner(model);
		sp_score.setBounds(112, 267, 62, 22);
		contentPane.add(sp_score);
		
		JLabel lblNewLabel = new JLabel("\u662F\u5426\u70ED\u95E8:");
		lblNewLabel.setBounds(443, 267, 74, 18);
		contentPane.add(lblNewLabel);
		
		JLabel label_10 = new JLabel("\u6D77\u62A5\u56FE\u7247:");
		label_10.setBounds(433, 353, 84, 29);
		contentPane.add(label_10);
		
		lb_image = new JLabel("");
		lb_image.setForeground(Color.RED);
		lb_image.setBackground(Color.RED);
		lb_image.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(e.getClickCount()==2) {
					JFileChooser chooser = new JFileChooser();
					chooser.showOpenDialog(null);
					selectImgFile= chooser.getSelectedFile();
					try {
						if(selectImgFile==null) {
							JOptionPane.showMessageDialog(null,"请选择图片!");
							
							
						}else {
						InputStream is = new FileInputStream(selectImgFile);
						
						lb_image.setIcon(new ImageIcon(getIcon(is)));}
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}

				}
			}
		});
		lb_image.setBounds(485, 386, 208, 155);
		contentPane.add(lb_image);
		
		
		
		
		
		
		
		cb_type = new JComboBox();
		cb_type.setModel(new DefaultComboBoxModel(new String[] {"-\u8BF7\u9009\u62E9\u7535\u5F71\u7C7B\u578B-"}));
		DefaultComboBoxModel dcb=new DefaultComboBoxModel<>();
		MovieService ms=new MovieServiceImpl();
		List<Table_Movie> lists=  ms.findAAll();
		MovieTypeDao mtd=new MovieTypeDaoImpl();
		dcb.addElement("-请选择类型-");
		MovietypeService mts=new MovietypeServiceImpl();
		List<Table_MovieType> tm1=mts.findAll();
		for (Table_MovieType table_MovieType : tm1) {
			dcb.addElement(table_MovieType.getTname());
		}
		cb_type.setModel(dcb);
		
		cb_type.setBounds(507, 116, 186, 21);
		contentPane.add(cb_type);
		
		rb_yes = new JRadioButton("\u662F");
		rb_yes.setSelected(true);
		rb_yes.setBounds(538, 266, 54, 23);
		contentPane.add(rb_yes);
		
		rb_no = new JRadioButton("\u5426");
		rb_no.setBounds(639, 266, 54, 23);
		contentPane.add(rb_no);
		ButtonGroup group =new ButtonGroup();
		group.add(rb_yes);
		group.add(rb_no);
	}
	
	
	public BufferedImage getIcon(InputStream is) {
		BufferedImage bufferedImage = null;
		try {
			Image image = ImageIO.read(is);
			bufferedImage = new BufferedImage(169, 174, BufferedImage.TYPE_INT_RGB);
			bufferedImage.getGraphics().drawImage(image,0,0, 208, 155, null);

		} catch (IOException e) {
			e.printStackTrace(); 
		}
		return bufferedImage;
	}
}
