package test;
import util.DBUtil;

public class INSERT {
	public static void main(String[] args) {
		String sql;
		int count =0;
		for(int i = 1;i <= 9;i++) {
			for(int j =1 ;j <= 12;j++) {
				if(count <= 108) {
					count++;
				}
				sql = "insert into table_seat (seat_id,hid,seat_row,seat_column,seat_isactive) values (?,?,?,?,?)";
						
				DBUtil.executeupdate(sql,count,5,i,j,0);
			}
		}
	}
}
