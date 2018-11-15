package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;

import entity.Table_Movie;
import entity.Table_MovieType;
import service.MovieService;
import service.MovietypeService;
import service.Impl.MovieServiceImpl;
import service.Impl.MovietypeServiceImpl;
import util.castutil;

public class UI_UpdateMovie extends JDialog {

	private JPanel contentPane;
	private JTextField txt_mname;
	private JTextField txt_direction;
	private JTextField txt_mainactor;
	private JTextField txt_duration;
	private JSpinner sp_soces;
	private JComboBox cb_type;
	private JSpinner sp_price;
	private JTextPane txt_desc;
	private JLabel lb_image;
	private JRadioButton rb_yes;
	private JRadioButton rb_no;
	private DefaultComboBoxModel dcb;
	File selectImgFile=null;
	protected Table_Movie tmd;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI_UpdateMovie frame = new UI_UpdateMovie();
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
	public UI_UpdateMovie() {
		setModalityType(ModalityType.APPLICATION_MODAL);
	//	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 669, 627);
		contentPane = new JPanel();
		setIconImage(Toolkit.getDefaultToolkit().getImage("img\\timg1.jpg"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u7535\u5F71\u540D\u79F0:");
		label.setBounds(40, 51, 70, 15);
		contentPane.add(label);
		
		txt_mname = new JTextField();
		txt_mname.setBounds(120, 48, 120, 21);
		contentPane.add(txt_mname);
		txt_mname.setColumns(10);
		
		JLabel label_1 = new JLabel("\u5BFC\u6F14:");
		label_1.setBounds(328, 51, 54, 15);
		contentPane.add(label_1);
		
		txt_direction = new JTextField();
		txt_direction.setBounds(392, 48, 142, 21);
		contentPane.add(txt_direction);
		txt_direction.setColumns(10);
		
		JLabel label_2 = new JLabel("\u4E3B\u6F14:");
		label_2.setBounds(40, 115, 54, 15);
		contentPane.add(label_2);
		
		txt_mainactor = new JTextField();
		txt_mainactor.setColumns(10);
		txt_mainactor.setBounds(120, 112, 120, 21);
		contentPane.add(txt_mainactor);
		
		JLabel label_3 = new JLabel("\u65F6\u957F:");
		label_3.setBounds(328, 115, 54, 15);
		contentPane.add(label_3);
		
		txt_duration = new JTextField();
		txt_duration.setBounds(392, 112, 142, 21);
		contentPane.add(txt_duration);
		txt_duration.setColumns(10);
		
		JLabel label_4 = new JLabel("\u7535\u5F71\u7C7B\u578B:");
		label_4.setBounds(40, 168, 70, 29);
		contentPane.add(label_4);
		
		cb_type = new JComboBox();
		dcb=new DefaultComboBoxModel<>();
		MovietypeService mts1=new MovietypeServiceImpl();
		List<Table_MovieType> lists=mts1.findAll();
		for (Table_MovieType list : lists) {
			dcb.addElement(list.getTname());
		}
		
		
		cb_type.setBounds(120, 172, 120, 21);
		cb_type.setModel(dcb);
		contentPane.add(cb_type);
		
		JLabel lblNewLabel = new JLabel("\u8BC4\u5206:");
		lblNewLabel.setBounds(328, 175, 54, 15);
		contentPane.add(lblNewLabel);
		
		SpinnerNumberModel model= new SpinnerNumberModel(0, 0, 10, 0.5);
		sp_soces = new JSpinner(model);
		sp_soces.setBounds(392, 172, 142, 22);
		contentPane.add(sp_soces);
		
		JLabel label_5 = new JLabel("\u4EF7\u683C:");
		label_5.setBounds(40, 247, 54, 15);
		contentPane.add(label_5);
		
		sp_price = new JSpinner();
		sp_price.setBounds(120, 244, 120, 22);
		contentPane.add(sp_price);
		
		JLabel label_6 = new JLabel("\u70ED\u95E8\u7535\u5F71:");
		label_6.setBounds(328, 245, 76, 19);
		contentPane.add(label_6);
		
		rb_yes = new JRadioButton("\u662F");
		rb_yes.setSelected(true);
		rb_yes.setBounds(410, 243, 48, 23);
		contentPane.add(rb_yes);
		
		rb_no = new JRadioButton("\u5426");
		rb_no.setBounds(480, 243, 54, 23);
		contentPane.add(rb_no);
		
		ButtonGroup group =new ButtonGroup();
		group.add(rb_yes);
		group.add(rb_no);
		
		JLabel label_7 = new JLabel("\u7535\u5F71\u7B80\u4ECB:");
		label_7.setBounds(40, 327, 70, 15);
		contentPane.add(label_7);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(120, 327, 130, 127);
		contentPane.add(scrollPane);
		
		txt_desc = new JTextPane();
		scrollPane.setViewportView(txt_desc);
		
		JLabel label_8 = new JLabel("\u6D77\u62A5:");
		label_8.setBounds(328, 327, 54, 15);
		contentPane.add(label_8);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(392, 327, 161, 127);
		contentPane.add(scrollPane_1);
		
		lb_image = new JLabel("");
		scrollPane_1.setViewportView(lb_image);
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
							JOptionPane.showMessageDialog(null, "请选择图片");
						}else {
						InputStream is = new FileInputStream(selectImgFile);
						lb_image.setIcon(new ImageIcon(getIcon(is)));}
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}

				}
				
				
			}
		});
		
		JButton button = new JButton("\u4FEE\u6539");
		button.addMouseListener(new MouseAdapter() {
			
			public void mousePressed(MouseEvent e) {
				Table_Movie tm2=new Table_Movie();
				tm2.setM_name(txt_mname.getText());
				tm2.setM_desc(txt_desc.getText());
				if(rb_yes.isSelected()) {
					tm2.setHot(0);
					
				}else{
					tm2.setHot(1);
				}
				tm2.setM_director(txt_direction.getText());
				tm2.setM_mainactor(txt_mainactor.getText());
				tm2.setM_duration(txt_duration.getText());
				tm2.setM_price(castutil.castDouble(sp_price.getValue()));
				tm2.setMid(tmd.getMid());
				tm2.setM_score(castutil.castDouble(sp_soces.getValue()));
				if(selectImgFile!=null) {
					tm2.setM_image(selectImgFile.toString());
					
				}else {
					tm2.setM_image(tmd.getM_image());
				}
				tm2.setTid(cb_type.getSelectedIndex()+1);
				MovieService mts2=new MovieServiceImpl();
				if(mts2.updateMovie(tm2)) {
					JOptionPane.showMessageDialog(null,"修改成功!");
				}else {
					JOptionPane.showMessageDialog(null,"修改失败!");
				}
				}
			});
		
		button.setBounds(120, 531, 130, 29);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				initMovie(tmd);
				//TODO
			}
		});
		button_1.setBounds(370, 531, 130, 29);
		contentPane.add(button_1);
	}

	public UI_UpdateMovie(Table_Movie tm) {
		this();
		UI_UpdateMovie.this.tmd=tm;
		initMovie(tm);
		
		
	}
	public void initMovie(Table_Movie tm) {
		txt_mname.setText(tm.getM_name());
		txt_mainactor.setText(tm.getM_mainactor());
		txt_direction.setText(tm.getM_director());
		txt_duration.setText(tm.getM_duration());
		txt_desc.setText(tm.getM_desc());
		sp_price.setValue(tm.getM_price());
		sp_soces.setValue(tm.getM_score());
		if(tm.getHot()==0) {
			rb_yes.setSelected(true);
			
		}else {
			rb_no.setSelected(true);
		}
		
	
		InputStream is;
		try {
			if(tm.getM_image()==null) {
				lb_image.setIcon(null);
				
			}else {
			is = new FileInputStream(tm.getM_image());
			
			lb_image.setIcon(new ImageIcon(getIcon(is)));}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		MovietypeService mts=new MovietypeServiceImpl();
		dcb.setSelectedItem(mts.getById(tm.getTid()).getTname());
	//	dcb.addElement(mts.getById(tm.getTid()).getTname());
		
		
		 
		
	}
	
	
	public BufferedImage getIcon(InputStream is) {
		BufferedImage bufferedImage = null;
		try {
			Image image = ImageIO.read(is);
			bufferedImage = new BufferedImage(161, 127, BufferedImage.TYPE_INT_RGB);
			bufferedImage.getGraphics().drawImage(image,0,0, 161, 127, null);

		}catch(Exception e){
			JOptionPane.showMessageDialog(null,"没有找到指定路径图片");
			
			
		} 
		return bufferedImage;
	}
	
	
	
}
