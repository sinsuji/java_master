package todo.p20231205;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
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
	boolean addBook(Book book) {
		getConn();
		String sql = "insert into book values(?,?,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, book.getBookCode());
			psmt.setString(2, book.getBookTitle());
			psmt.setString(3, book.getAuthor());
			psmt.setString(4, book.getPress());
			psmt.setInt(5, book.getPrice());
			
			int r = psmt.executeUpdate(); // 처리된 건수 반환
			if(r == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	} // end of addBook()
	
	// 목록
	ArrayList<Book> getBookList(){
		ArrayList<Book> books = new ArrayList<>();
		getConn();
		String sql = "select * from book order by 1";
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				Book book = new Book();
				book.setBookCode(rs.getString("bookCode"));
				book.setBookTitle(rs.getString("bookTitle"));
				book.setAuthor(rs.getString("author"));
				book.setPress(rs.getString("press"));
				book.setPrice(rs.getInt("price"));
				books.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return books;
	} // end of getBookList()
	
	// 단건조회	
	Book getBook(String code) {
		getConn();
		String sql = "select * "
				+ "from book "
				+ "where bookCode =? ";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, code);
			rs = psmt.executeQuery();
			if(rs.next()) {
				Book book = new Book();
				book.setBookCode(rs.getString("bookCode"));
				book.setBookTitle(rs.getString("bookTitle"));
				book.setAuthor(rs.getString("author"));
				book.setPress(rs.getString("press"));
				book.setPrice(rs.getInt("price"));
				return book;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return null; // 조회된 값이 없으면 null 값 반환
	} // end of getBook()
	
	// 수정
		boolean modifyBook(String no, int price) {
			getConn();
			String sql = "update book "
					+ "set price = ? "
					+ "where bookCode = ?";
			try {
				psmt = conn.prepareStatement(sql);
				psmt.setInt(1, price);
				psmt.setString(2, no);
				int r = psmt.executeUpdate();
				if(r > 0) {
					return true;
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return false;	
		} // end of modifyBook
		
		// 삭제
		boolean removeBook(String bookCode) {
			getConn();
			String sql = "delete book "
					+ "where bookCode = ?";
			try {
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, bookCode);
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
