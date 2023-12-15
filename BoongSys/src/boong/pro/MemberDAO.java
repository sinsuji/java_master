package boong.pro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDAO {
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
	boolean addMember(Member member) {
		getConn();
		String sql = "insert into b_member values(?,?,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, member.getM_id());
			psmt.setString(2, member.getM_name());
			psmt.setString(3, member.getM_phone());
			psmt.setString(4, member.getM_best());
			psmt.setString(5, member.getM_worst());
			psmt.setString(5, member.getM_level());
			
			int r = psmt.executeUpdate(); // 처리된 건수 반환
			if(r == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	} // end of addMember()
	
	// 목록
	ArrayList<Member> getMemberList(){
		ArrayList<Member> members = new ArrayList<>();
		getConn();
		String sql = "select * from b_member order by 1";
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				Member member = new Member();
				member.setM_id(rs.getString("m_id"));
				member.setM_name(rs.getString("m_name"));
				member.setM_phone(rs.getString("m_phone"));
				member.setM_best(rs.getString("m_best"));
				member.setM_worst(rs.getString("m_worst"));
				members.add(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return members;
	} // end of getMemberList()
	
	// 수정
	
	// 삭제
	boolean removeMember(String m_id) {
		getConn();
		String sql = "delete b_member "
				+ "where m_id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, m_id);
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
