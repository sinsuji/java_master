package boong.pro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class InOutDAO {
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	
	Connection getConn() {
		String url = "jdbc:oracle:thin:@192.168.0.31:1521:xe"; // @localhost
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(url, "dev", "dev");
			System.out.println("연결성공!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	/* 재료관리 */
	// 재료구매
	boolean addIn(InOut register) {
		getConn();
		String sql = "insert into b_purchase(p_sq, p_code, p_num, p_date) "
				+ "values (ex_sq.nextval, ?, ?, nvl(?, sysdate))";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, register.getP_code());
			psmt.setInt(2, register.getP_num());
			psmt.setString(3, register.getP_date());
			
			int r = psmt.executeUpdate(); // 처리된 건수 반환
			if(r == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	} // end of addIn()
	
	// 목록(상품별)
	ArrayList<InOut> getRegisterList(){
		ArrayList<InOut> registers = new ArrayList<>();
		getConn();
		String sql = "select p.p_sq, i.i_code, i.i_name, p.p_num, p.p_date "
				+ "from b_ingredient i, b_purchase p "
				+ "where i.i_code = p.p_code "
				+ "and p.p_num > 0 "
				+ "order by p.p_date desc, i.i_code";
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				InOut register = new InOut();
				register.setP_sq(rs.getInt("p_sq"));
				register.setP_code(rs.getString("i_code"));
				register.setP_name(rs.getString("i_name"));
				register.setP_num(rs.getInt("p_num"));
				register.setP_date(rs.getString("p_date").substring(0, 10));
				registers.add(register);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return registers;
	} // end of getRegisterList()
	
	// 목록(날짜별)
	ArrayList<InOut> getIngreDateList(){
		ArrayList<InOut> registers = new ArrayList<>();
		getConn();
		String sql = "select p.p_sq, i.i_code, i.i_name, p.p_num, p.p_date "
				+ "from b_ingredient i, b_purchase p "
				+ "where i.i_code = p.p_code "
				+ "and p.p_num < 0 "
				+ "order by p.p_date desc, i.i_code";
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				InOut register = new InOut();
				register.setP_sq(rs.getInt("p_sq"));
				register.setP_code(rs.getString("i_code"));
				register.setP_name(rs.getString("i_name"));
				register.setP_num(rs.getInt("p_num"));
				register.setP_date(rs.getString("p_date").substring(0, 10));
				registers.add(register);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return registers;
	} // end of getIngreDateList()
	
	// 삭제
	boolean removeIngre(String i_code) {
		getConn();
		String sql = "delete b_purchase "
				+ "where p_sq = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, i_code);
			int r = psmt.executeUpdate();
			if(r > 0) {
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}	
	
	
	/* 판매관리 */
	// 판매등록
	boolean addSale(InOut sale) {
		getConn();
		String sql = "insert into b_purchase(p_sq, p_code, p_num, p_id) "
				+ "values (ex_sq.nextval, ?, ?, ?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, sale.getP_code());
			psmt.setInt(2, sale.getP_num());
			psmt.setString(3, sale.getP_id());
			
			int r = psmt.executeUpdate(); // 처리된 건수 반환
			if(r == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	} // end of addIn()
	
	// 목록(상품별)
		ArrayList<InOut> getSaleList(){
			ArrayList<InOut> registers = new ArrayList<>();
			getConn();
			String sql = "select p.p_sq, b.b_code, b.b_name, p.p_num, p.p_date "
					+ "from b_bread b, b_purchase p "
					+ "where b.b_code = p.p_code "
					+ "order by b.b_code";
//			String sql = "select p.p_sq, b.b_code, b.b_name, p.p_num, p.p_date "
//					+ "from b_bread b, b_purchase p "
//					+ "where b.b_code = p.p_code "
//					+ "order by b.b_code";
			
			try {
				psmt = conn.prepareStatement(sql);
				rs = psmt.executeQuery();
				while(rs.next()) {
					InOut register = new InOut();
					register.setP_sq(rs.getInt("p_sq"));
					register.setP_code(rs.getString("b_code"));
					register.setP_name(rs.getString("b_name"));
					register.setP_num(rs.getInt("p_num"));
					register.setP_date(rs.getString("p_date").substring(0, 10));
					registers.add(register);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return registers;
		} // end of getSaleList()
		
		// 목록(상품별)
		ArrayList<InOut> getSaleDateList(){
			ArrayList<InOut> registers = new ArrayList<>();
			getConn();
			String sql = "select p.p_sq, b.b_code, b.b_name, p.p_num, p.p_date "
					+ "from b_bread b, b_purchase p "
					+ "where b.b_code = p.p_code "
					+ "order by p.p_date desc, b.b_code";
			
			try {
				psmt = conn.prepareStatement(sql);
				rs = psmt.executeQuery();
				while(rs.next()) {
					InOut register = new InOut();
					register.setP_sq(rs.getInt("p_sq"));
					register.setP_code(rs.getString("b_code"));
					register.setP_name(rs.getString("b_name"));
					register.setP_num(rs.getInt("p_num"));
					register.setP_date(rs.getString("p_date").substring(0, 10));
					registers.add(register);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return registers;
		} // end of getSaleDateList()
		
		// 재료 재고목록
		ArrayList<InOut> getInventoryList(){
			ArrayList<InOut> inventorys = new ArrayList<>();
			getConn();
			String sql = "select p.p_code, i.i_name, sum(p_num) "
					+ "from b_purchase p, b_ingredient i "
					+ "where p.p_code = i.i_code "
					+ "group by p_code, i_name "
					+ "order by p.p_code";
			
			try {
				psmt = conn.prepareStatement(sql);
				rs = psmt.executeQuery();
				while(rs.next()) {
					InOut inventory = new InOut();
					inventory.setP_code(rs.getString("p_code"));
					inventory.setP_name(rs.getString("i_name"));
					inventory.setP_num(rs.getInt("sum(p_num)"));
					inventorys.add(inventory);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return inventorys;
		} // end of getInventoryList()
		
		// 붕어빵 재고목록
		ArrayList<InOut> getBreadList(){
			ArrayList<InOut> inventorys = new ArrayList<>();
			getConn();
			String sql = "select p.p_code, b.b_name, count(*) "
					+ "from b_purchase p, b_bread b "
					+ "where p.p_code = b.b_code "
					+ "group by p_code, b_name "
					+ "order by p.p_code";
			
			try {
				psmt = conn.prepareStatement(sql);
				rs = psmt.executeQuery();
				while(rs.next()) {
					InOut inventory = new InOut();
					inventory.setP_code(rs.getString("p_code"));
					inventory.setP_name(rs.getString("b_name"));
					inventory.setP_num(rs.getInt("count(*)"));
					inventorys.add(inventory);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return inventorys;
		} // end of getInventoryList()
	
}
