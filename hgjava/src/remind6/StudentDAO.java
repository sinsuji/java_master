package remind6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// 저장공간 : Oracle DB

// 추가/수정/삭제/목록/단건조회
public class StudentDAO {
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
	
	void disconn() {
		try {
			if(conn != null)
				conn.close();
			if(rs != null)
				rs.close();
			if(psmt != null)
				psmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 목록
	Student[] getStudentList() {
		getConn();
		Student[] students = new Student[10];
		String sql = "select * from student order by 1";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				Student student = new Student();
				student.setStuNo(rs.getString("stu_no"));
				student.setStuName(rs.getString("stu_name"));
				student.setStuEng(rs.getInt("stu_eng"));
				student.setStuMat(rs.getInt("stu_mat"));
				// 배열의 빈곳에 한건 저장
				for(int i = 0; i < students.length; i++) {
					if(students[i] == null) {
						students[i] = student;
						break; // for 반복문 종료
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return students;
	}
	
// 추가
	boolean addStudent(Student std) {
		getConn();
		String sql = "insert into student values(?,?,?,?)";
		try {
			conn.setAutoCommit(false); // 자동커밋 실행 여부
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, std.getStuNo());
			psmt.setString(2, std.getStuName());
			psmt.setInt(3, std.getStuEng());
			psmt.setInt(4, std.getStuMat());
			
			int r = psmt.executeUpdate(); // 처리된 건수 반환
			if(r == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	} // end of addStudent()
	
	// 단건조회
	Student getStudent(String sno) {
		getConn();
		String sql = "select *from student "
				+ "where stu_no = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, sno);
			rs = psmt.executeQuery();
			if(rs.next()) {
				Student student = new Student();
				student.setStuNo(rs.getString("stu_no"));
				student.setStuName(rs.getString("stu_name"));
				student.setStuEng(rs.getInt("stu_eng"));
				student.setStuMat(rs.getInt("stu_mat"));
				return student;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null; // 조회된 값이 없으면 null 값 반환
	} // end of getStudent()
	
	// 수정
	boolean modifyStudent(String no, int eng, int mat) {
		getConn();
		String sql = "update student "
				+ "set stu_eng = ?, stu_mat = ? "
				+ "where stu_no = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, eng);
			psmt.setInt(2, mat);
			psmt.setString(3, no);
			int r = psmt.executeUpdate();
			if(r > 0) {
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;	
	} // end of modifyStudent
	
	// 삭제
	boolean removeStudent(String name) {
		getConn();
		String sql = "delete student "
				+ "where stu_name = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, name);
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
