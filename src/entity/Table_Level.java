package entity;
/**
 * �ͻ��ȼ���
 * @author Administrator
 *
 */
public class Table_Level {
	private int lid;//��Ա�ȼ����
	private String lname;//�ȼ�����
	private double ldiscount;//�ȼ��ۿ�
	private String ldesc;//�ȼ�����
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public double getLdiscount() {
		return ldiscount;
	}
	public void setLdiscount(double ldiscount) {
		this.ldiscount = ldiscount;
	}
	public String getLdesc() {
		return ldesc;
	}
	public void setLdesc(String ldesc) {
		this.ldesc = ldesc;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return lname;
	}

}
