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
		String url = "jdbc:oracle:thin:@192.168.0.31:1521:xe";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(url, "dev", "dev");
			// System.out.println("연결성공!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	// 재료등록
	boolean addIngre(Ingredient ingre) {
		getConn();
		String sql = "insert into b_ingredient(i_code, i_name, i_price) " + "values (?, ?, ?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, ingre.getI_code());
			psmt.setString(2, ingre.getI_name());
			psmt.setInt(3, ingre.getI_price());

			int r = psmt.executeUpdate(); // 처리된 건수 반환
			if (r == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	} // end of addIngre()

	// 소요량.
	public RequiredAmount calRequiredAmount(String iCode) {
		getConn();
		String sql = "select * "
				+ "from required_amount "
				+ "WHERE bread = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, iCode);
			rs = psmt.executeQuery();
			if (rs.next()) {
				RequiredAmount ra = new RequiredAmount();
				ra.setBread(rs.getString("bread"));
				ra.setIngredient(rs.getString("ingredient"));
				ra.setIQty(rs.getInt("i_qty"));
				ra.setIngredient2(rs.getString("ingredient2"));
				ra.setBQty(rs.getInt("b_qty"));
				ra.setIngredient3(rs.getString("ingredient3"));
				ra.setHQty(rs.getInt("h_qty"));
				ra.setIngredient4(rs.getString("ingredient4"));
				ra.setCQty(rs.getInt("c_qty"));

				return ra;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// 수량차감.
	public boolean outQty(String code, int qty) {
		getConn();
		String sql = "insert into b_purchase(p_sq,p_code,p_num) values(ex_sq.nextval, ?,?) ";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, code);
			psmt.setInt(2, qty*-1);
			int r = psmt.executeUpdate();
			if (r > 0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	

}
