package entity;

/**
 * 客户类
 * 
 * @author Administrator
 *
 */
public class Table_Customer {
	private int cid;// 客户id
	private String cname;// 客户昵称
	private String cphone;// 客户电话
	private double cmoney;// 客户余额
	private String cpwd;// 客户密码
	private String cbirthday;// 客户生日
	private String cpy;// 客户姓名拼音
	private String cgender;// 客户性别
	private String caddress;// 客户地址
	private String ccode;// 会员卡号
	private int clid;// 会员等级
	private String cdesc;//描述
	private String cphoto;//头像
	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCphone() {
		return cphone;
	}

	public void setCphone(String cphone) {
		this.cphone = cphone;
	}

	public double getCmoney() {
		return cmoney;
	}

	public void setCmoney(double cmoney) {
		this.cmoney = cmoney;
	}

	public String getCpwd() {
		return cpwd;
	}

	public void setCpwd(String cpwd) {
		this.cpwd = cpwd;
	}

	public String getCbirthday() {
		return cbirthday;
	}

	public void setCbirthday(String cbirthday) {
		this.cbirthday = cbirthday;
	}

	public String getCpy() {
		return cpy;
	}

	public void setCpy(String cpy) {
		this.cpy = cpy;
	}

	public String getCgender() {
		return cgender;
	}

	public void setCgender(String cgender) {
		this.cgender = cgender;
	}

	public String getCaddress() {
		return caddress;
	}

	public void setCaddress(String caddress) {
		this.caddress = caddress;
	}

	public String getCcode() {
		return ccode;
	}

	public void setCcode(String ccode) {
		this.ccode = ccode;
	}

	public int getClid() {
		return clid;
	}

	public void setClid(int clid) {
		this.clid = clid;
	}

	public String getCdesc() {
		return cdesc;
	}

	public void setCdesc(String cdesc) {
		this.cdesc = cdesc;
	}

	public String getCphoto() {
		return cphoto;
	}

	public void setCphoto(String cphoto) {
		this.cphoto = cphoto;
	}

}
