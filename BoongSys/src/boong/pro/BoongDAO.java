package boong.pro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BoongDAO {
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
	
	// 추가
	boolean addBoong(Boong boong) {
		getConn();
		String sql = "insert into b_bread values(?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, boong.getB_code());
			psmt.setString(2, boong.getB_name());
			psmt.setInt(3, boong.getB_price());
			
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
	ArrayList<Boong> getBoongList(){
		ArrayList<Boong> boongs = new ArrayList<>();
		getConn();
		String sql = "select * from b_bread order by 1";
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				Boong boong = new Boong();
				boong.setB_code(rs.getString("b_code"));
				boong.setB_name(rs.getString("b_name"));
				boong.setB_price(rs.getInt("b_price"));
				boongs.add(boong);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return boongs;
	} // end of getBoongList()
	
	// 수정
	boolean modifyBoong(String b_code, int b_price) {
		getConn();
		String sql = "update b_bread "
				+ "set b_price = ? "
				+ "where b_code = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, b_price);
			psmt.setString(2, b_code);
			int r = psmt.executeUpdate();
			if(r > 0) {
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;	
	} // end of modifyBoong
	
	// 삭제
	boolean removeBoong(String b_code) {
		getConn();
		String sql = "delete b_bread "
				+ "where b_code = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, b_code);
			int r = psmt.executeUpdate();
			if(r > 0) {
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}	
}
