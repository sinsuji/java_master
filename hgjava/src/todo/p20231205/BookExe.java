package todo.p20231205;

import java.util.ArrayList;
import java.util.List;

import chap6.Student;

public class BookExe {
	// 도서코드입력
	
//	private Book[] books;
//	BookExe(){
//		books = new Book[10];
//		books[0] = new Book("B001", "이것이자바다", "", "", 1000);
//	}
	
	private ArrayList<Book> books;	
	// private List<Book> books = new ArrayList<>();	
	
	BookExe(){
		books = new ArrayList<Book>();
		books.add(new Book("B001", "이것이자바다", "신용권", "한빛미디어", 25000));
	}
	
	
	boolean addBook(Book book) {
//		for(int i = 0; i < books.length; i++) {
//		if(books[i] == null) {
//			books[i] = book;
//			return true;
//		}
//		return false;
		return books.add(book);
	}
	
	// 조회
	ArrayList<Book> getBookList() {
		return books;
	}
	
	// 단건조회
	Book getBook(String code){
		for(int i = 0; i < books.size(); i++) {
			if(books.get(i) != null && books.get(i).getBookCode().equals(code)) {
				return books.get(i);
			}
		}
		return null;
	}
	
	// 수정
	boolean modifyBook(String code, int price) {
		for(int i = 0; i < books.size(); i++) {
			if(books.get(i).getBookCode().indexOf(code) != -1) {
				books.get(i).setBookPrice(price);
				return true;
			}
		}
		return false;
	}
	
	// 삭제 
	boolean removeBook(String code) {
		for(int i = 0; i < books.size(); i++) {
			if(books.get(i).getBookCode().indexOf(code) != -1) {
				books.remove(i);
				return true;
			}
		}
		return false;
	}
}
