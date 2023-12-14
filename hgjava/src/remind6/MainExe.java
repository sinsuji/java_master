package remind6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MainExe {
	static Connection conn;
	public static void main(String[] args) {
		// jdbc lib
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(url, "dev", "dev");
			System.out.println("연결성공!");
			// select();
			String sql = "insert into student(stu_no, stu_name, stu_eng, stu_mat) "
					+ "values (?, ?, ?, ?)";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, "23-003");
			psmt.setString(2, "박씨");
			psmt.setInt(3, 80);			
			psmt.setInt(4, 85);
			
			// 입력, 수정, 삭제 => executeUpdate();
			int r = psmt.executeUpdate();
			if(r == 1) {
				System.out.println("입력성공");
			}
				
		} catch (Exception e) {
			e.printStackTrace();
			// System.out.println("Driver 없음");
		}
	} // end of main
	
	public static void select() throws Exception {
		String sql = "select * from student";
		PreparedStatement psmt = conn.prepareStatement(sql);
		ResultSet rs = psmt.executeQuery();
		while(rs.next()) {
			System.out.println("번호:"
					+rs.getString("stu_no")
					+", 이름:"+rs.getString("stu_name")
					+", 영어:"+rs.getInt("stu_eng")+", 수학:"
					+rs.getInt("stu_mat")
			);
		}
	}
}
