package xxc.util;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * ��ҳ��װ��
 * @author Administrator
 *
 */
public class Page<T> {
	@Getter
	@Setter
	private int pageIndex;//��ǰҳ��
	@Getter
	@Setter
	private int pageSize;//ÿҳ��ʾ������
	@Getter
	@Setter
	private List<T> data;//����
	@Getter
	@Setter
	private int totalCount; //������

	private int totalPage; //��ҳ��
	/**
	 * ��ȡ��ҳ��
	 * @return
	 */
	public int getTotalPage() {
		return totalCount%pageSize ==0? totalCount/pageSize : totalCount/pageSize+1;
	}
	
	
	
	
	
	
	
}
