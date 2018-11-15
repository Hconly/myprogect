package util;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;

import dao.Impl.MovieDaoImpl;
import entity.Table_Order;
import entity.Table_Schedule;
import view.UI_Order;
import view.UI_Schule;
import view.UI_Seat;
 
public class OrderPrint implements Printable {
	private Table_Order order = UI_Order.getCustomerOrder();
	private double s_p= UI_Seat.s_price_single;
	private double s_p_d= UI_Seat.s_price_single_discount;
	private Table_Schedule sch = UI_Schule.getMovieInfo();
	private int i;
	public OrderPrint(int i) {
		this.i = i;
	}
	@Override
	public int print(Graphics g, PageFormat pf, int page) throws PrinterException {
		
		if (page > 0) {
			return NO_SUCH_PAGE;
		}

		Graphics2D g2d = (Graphics2D) g;

		g2d.setFont(new Font("幼圆", Font.BOLD, 14));
		g2d.drawString("酷查查", 10, 12);

		
		g2d.setFont(new Font("幼圆", Font.PLAIN, 5));
		g2d.drawString("淘 出 新 生 活", 10, 21);

		g2d.drawString("---------------------------------------------", 10, 25);
		g2d.setFont(new Font("幼圆", Font.PLAIN, 7));
		g2d.drawString("星洲MoviePlus", 10, 34);
		g2d.drawString(new MovieDaoImpl().getbyId(order.getMid()).getM_name(), 10, 43);
		g2d.drawString(sch.getS_begindate(), 10, 52);
		g2d.drawString(sch.getHid()+" 号厅",10,61);
		g2d.drawString(getSeat(UI_Order.list.get(i)),40, 61);
		System.out.println("i"+i);
//		for (int i = 0; i <UI_Order.list.size(); i++) {
//			
//		}
		//g2d.drawString("-------------------------------------",10,79);
		g2d.drawString("票价 "+s_p,10,70);
		g2d.drawString("折扣价 "+s_p_d,10,80);
		g2d.drawString("服务费 "+" 3元",10,90);
		g2d.drawString("售票时间 "+getTime("MM-dd HH:mm"),10,100);
		g2d.drawString("售票渠道 "+" 酷查查", 10, 110);
		g2d.drawString("票号 "+order.getOrder_number(),10,120);
		ImageIcon icon = new ImageIcon("img/qrcode.png");
		Image img = icon.getImage();
		g2d.drawImage(img, 80, 45, 160, 125, 0, 0, 79, 79,null);
		g2d.drawString("客服电话 "+"0571-88157838", 10,130);
		return PAGE_EXISTS;

	}
	
	 public static String getTime(String style) {
		 SimpleDateFormat sdf = new SimpleDateFormat(style);
		 return sdf.format(new Date());
	 }
	 public String getSeat(int id) {
			String str = "";
			for(int seat_row = 0;seat_row < 9;seat_row++) {
				for(int seat_col = 0;seat_col<12;seat_col++) {
					if(id % 12 == seat_col && (int)(id / 12) == seat_row) {
						str = (seat_row+1)+"排"+(seat_col+1)+"座";
					}
				}
			}
			return str;
	}
}
