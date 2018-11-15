package entity.dto;

import entity.Table_Level;
import entity.Table_Order;
/**
 * 会员拓展类
 * @author Administrator
 *
 */
public class CustomerDto {
	private Table_Level level;//会员等级对象
	private Table_Order order;//订单对象

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
