package entity;
/**
 * ��Ӱ������
 * @author Administrator
 *
 */
public class Table_MovieType {
	private int tid;//��Ӱ���ͱ��
	private String tname;//��Ӱ��������

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	@Override
	public String toString() {
		
		return tname;
	}
}
