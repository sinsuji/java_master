package todo.p20231205;

import lombok.Data;

@Data
public class Book {
	private String bookCode;
	private String bookName;
	private String bookWriter;
	private String bookCompany;
	private int bookPrice;
	
	Book(){
		
	}
	
	public Book(String bookCode, String bookName, String bookWriter, String bookCompany, int bookPrice){
		this.bookCode = bookCode;
		this.bookName = bookName;
		this.bookWriter = bookWriter;
		this.bookCompany = bookCompany;
		this.bookPrice = bookPrice;
	}
	
	String showInfo() {
		String result = bookCode + " " + bookName + " " + bookWriter + " " + bookPrice;
		return result;
	}
}
