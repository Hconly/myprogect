package entity.dto;

import entity.Table_Level;
import entity.Table_Order;
/**
 * ��Ա��չ��
 * @author Administrator
 *
 */
public class CustomerDto {
	private Table_Level level;//��Ա�ȼ�����
	private Table_Order order;//��������

	public Table_Level getLevel() {
		return level;
	}

	public void setLevel(Table_Level level) {
		this.level = level;
	}

	public Table_Order getOrder() {
		return order;
	}

	public void setOrder(Table_Order order) {
		this.order = order;
	}

}
