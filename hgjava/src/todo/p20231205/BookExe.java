package todo.p20231205;

import java.util.ArrayList;

public class BookExe {
	private ArrayList<Book> books;

	BookExe() {
		books = new ArrayList<Book>();
		books.add(new Book("B001", "이것이자바다", "신용권", "한빛미디어", 25000));
	}

	boolean addBook(Book book) {
		return books.add(book);
	}

	ArrayList<Book> getBookList() {
		return books;
	}

	// 단건조회.
	Book getBook(String bookCode) {
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i) != null //
					&& books.get(i).getBookCode().equals(bookCode)) {
				return books.get(i);
			}
		}
		return null;
	}

	// 수정.
	boolean modifyBook(String no, int price) {
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i) != null //
					&& books.get(i).getBookCode().equals(no)) {
				books.get(i).setPrice(price);
				return true;
			}
		}
		return false;
	}

	// 삭제.
	boolean removeBook(String bookCode) {
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i) != null //
					&& books.get(i).getBookCode().equals(bookCode)) {
				books.remove(i);
				return true;
			}
		}
		return false;
	}
}
