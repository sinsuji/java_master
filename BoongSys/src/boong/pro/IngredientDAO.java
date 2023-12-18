package boong.pro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class IngredientDAO {
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	
	Connection getConn() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(url, "dev", "dev");
			System.out.println("연결성공!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	// 재료등록
	boolean addIngre(Ingredient ingre) {
		getConn();
		String sql = "insert into b_ingredient(i_code, i_name, i_price) "
				+ "values (?, ?, ?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, ingre.getI_code());
			psmt.setString(2, ingre.getI_name());
			psmt.setInt(3, ingre.getI_price());
			
			int r = psmt.executeUpdate(); // 처리된 건수 반환
			if(r == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	} // end of addIngre()
}
