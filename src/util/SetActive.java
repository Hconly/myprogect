package util;

public class SetActive {
	public static void reset(long begin,long end,int hallId) {
		String sql = "update table_seat set seat_isactive=0 where hid="+hallId;
		if(begin < end) {
			DBUtil.executeupdate(sql);
		}
	};
	
}
