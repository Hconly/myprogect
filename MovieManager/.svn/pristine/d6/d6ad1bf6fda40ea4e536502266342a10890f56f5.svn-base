package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import entity.Table_Order;
import service.OrderService;
import service.Impl.OrderServiceImpl;

public class UI_PingJia extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextArea text_comment;
	private JButton commit;
	private JButton cancel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UI_PingJia dialog = new UI_PingJia();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public UI_PingJia() {
		setModalityType(ModalityType.APPLICATION_MODAL);
		setTitle("\u8BC4\u4EF7");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		setIconImage(Toolkit.getDefaultToolkit().getImage("img\\timg1.jpg"));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel label = new JLabel("\u5C0F\u4E3B\u7ED9\u70B9\u8BC4\u4EF7\u5427");
			label.setFont(new Font("微软雅黑", Font.PLAIN, 13));
			label.setBounds(10, 10, 99, 22);
			contentPanel.add(label);
		}
		{
			text_comment = new JTextArea();
			text_comment.setRows(5);
			text_comment.setLineWrap(true);
			text_comment.setBounds(20, 42, 393, 147);
			contentPanel.add(text_comment);
			text_comment.setText(UI_MyMovie.selectOrder.getComment());
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				commit = new JButton("\u53D1\u5E03");
				commit.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						//提交评价
						String comm=text_comment.getText();
						Table_Order order=UI_MyMovie.selectOrder;
						order.setComment(comm);
						OrderService orderService=new OrderServiceImpl();
						if(orderService.updateOrder(order)==true) {
							JOptionPane.showMessageDialog(null, "评论成功");
							dispose();
						}
					}
				});
				commit.setActionCommand("OK");
				buttonPane.add(commit);
				getRootPane().setDefaultButton(commit);
			}
			{
				cancel = new JButton("\u53D6\u6D88");
				cancel.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent arg0) {
						//取消评价
						text_comment.setText("");
						dispose();
					}
				});
				cancel.setActionCommand("Cancel");
				buttonPane.add(cancel);
			}
		}
	}
}
