package entity;
/**
 * 影片放映安排类
 * @author Administrator
 *
 */
public class Table_Schedule {
	private int sid;//排片编号
	private int mid;//电影编号
	private int hid;//放映厅编号
	private double s_price;//票价
	private String s_begindate;//开始时间
	private String s_enddate;//结束时间
	private String sname;//排版名称
	
	
	
	
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public int getHid() {
		return hid;
	}
	public void setHid(int hid) {
		this.hid = hid;
	}
	public double getS_price() {
		return s_price;
	}
	public void setS_price(double s_price) {
		this.s_price = s_price;
	}
	public String getS_begindate() {
		return s_begindate;
	}
	public void setS_begindate(String s_begindate) {
		this.s_begindate = s_begindate;
	}
	public String getS_enddate() {
		return s_enddate;
	}
	public void setS_enddate(String s_enddate) {
		this.s_enddate = s_enddate;
	}
	
	
	

}
