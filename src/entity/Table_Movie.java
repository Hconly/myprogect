package entity;

import java.io.InputStream;
/**
 * ��Ӱ��
 * @author Administrator
 *
 */
public class Table_Movie {
	private int mid;//��Ӱid
	private String m_name;//��Ӱ����
	private String m_mainactor;//��Ӱ����
	private String m_director;//����
	private String m_duration;//��Ӱʱ��
	private String m_desc;//��Ӱ���
	private int tid;//��Ӱ����
	private String m_image;//��Ӱ����
	private double m_score;// ����
	private double m_price;// Ʊ��
	private int hot;// ����

	public double getM_price() {
		return m_price;
	}

	public void setM_price(double m_price) {
		this.m_price = m_price;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public String getM_mainactor() {
		return m_mainactor;
	}

	public void setM_mainactor(String m_mainactor) {
		this.m_mainactor = m_mainactor;
	}

	public String getM_director() {
		return m_director;
	}

	public void setM_director(String m_director) {
		this.m_director = m_director;
	}

	public String getM_duration() {
		return m_duration;
	}

	public void setM_duration(String m_duration) {
		this.m_duration = m_duration;
	}

	public String getM_desc() {
		return m_desc;
	}

	public void setM_desc(String m_desc) {
		this.m_desc = m_desc;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getM_image() {
		return m_image;
	}

	public void setM_image(String m_image) {
		this.m_image = m_image;
	}

	public double getM_score() {
		return m_score;
	}

	public void setM_score(double m_score) {
		this.m_score = m_score;
	}

	public int getHot() {
		return hot;
	}

	public void setHot(int hot) {
		this.hot = hot;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return m_name;
	}

}
