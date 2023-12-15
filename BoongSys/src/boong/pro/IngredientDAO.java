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
		String sql = "insert into b_ingredient values(?,?,?)";
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
	} // end of addBoong()
	
	// 재료구매
		boolean registerIngre(Ingredient ingre) {
			getConn();
			String sql = "insert into b_ingredient values(?,?,?)";
			try {
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, ingre.getI_code());
				psmt.setInt(2, ingre.getI_num());
				psmt.setString(3, ingre.getI_date());
				
				int r = psmt.executeUpdate(); // 처리된 건수 반환
				if(r == 1) {
					return true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return false;
		} // end of addBoong()
	
	// 목록
	ArrayList<Ingredient> getIngreList(){
		ArrayList<Ingredient> ingres = new ArrayList<>();
		getConn();
		String sql = "select * from b_ingredient order by 1";
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				Ingredient ingre = new Ingredient();
				ingre.setI_code(rs.getString("i_code"));
				ingre.setI_name(rs.getString("i_name"));
				ingre.setI_num(rs.getInt("i_num"));
				ingres.add(ingre);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ingres;
	} // end of getBoongList()
}
