package todo.p20231205;

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
			String sql = "insert into book(bookCode, bookTitle, author, press, price) "
					+ "values (?, ?, ?, ?, ?)";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, "B004");
			psmt.setString(2, "이것이OS다");
			psmt.setString(3, "홍길동");			
			psmt.setString(4, "홍홍미디어");
			psmt.setInt(5, 22000);
			
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
		String sql = "select * from book";
		PreparedStatement psmt = conn.prepareStatement(sql);
		ResultSet rs = psmt.executeQuery();
		while(rs.next()) {
			System.out.println("번호:"
					+rs.getString("bookCode")
					+", 제목:"+rs.getString("bookTitle")
					+", 저자:"+rs.getString("author")
					+", 출판사:"+rs.getString("press") 
					+", 가격:"+rs.getInt("price")
			);
		}
	}
}
