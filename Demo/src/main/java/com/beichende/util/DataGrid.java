package com.beichende.util;

import java.util.List;

/**
 * TODO
 * @author xxcxx
 * @version 1.0.0
 * @filename DataGrid.java
 * @time 2019年1月10日 上午11:09:57
 * @copyright(C) 2019 深圳市北辰德科技股份有限公司
 */
public class DataGrid {
	private Integer total;//总数
	private List<Object> rows;
	
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public List<Object> getRows() {
		return rows;
	}
	public void setRows(List<Object> rows) {
		this.rows = rows;
	}
	
	
}
