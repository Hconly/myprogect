package xxc.util;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * 分页包装类
 * @author Administrator
 *
 */
public class Page<T> {
	@Getter
	@Setter
	private int pageIndex;//当前页数
	@Getter
	@Setter
	private int pageSize;//每页显示的行数
	@Getter
	@Setter
	private List<T> data;//数据
	@Getter
	@Setter
	private int totalCount; //总行数

	private int totalPage; //总页数
	/**
	 * 获取总页数
	 * @return
	 */
	public int getTotalPage() {
		return totalCount%pageSize ==0? totalCount/pageSize : totalCount/pageSize+1;
	}
	
	
	
	
	
	
	
}
