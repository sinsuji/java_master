package todo.p20231127;



public class Board {
	// 배열 : 
	// private Board[] boards;
		
	private String boNo;
	private String boTitle;
	private String boWriter;
	private String boText;
	private String boDate;

	public Board(String boNo, String boTitle, String boWriter, String boText, String boDate){
		this.boNo = boNo;
		this.boTitle = boTitle;
		this.boWriter = boWriter;
		this.boText = boText;
		this.boDate = boDate;
		
	}
	
	void showInfo() {
		System.out.println(boNo + " " + boTitle + " " + boWriter);
	}
	
	String showAllInfo() {
		String result = "번호:" + boNo + " 제목:" + boTitle + "\n 작성자:" + boWriter + "\n 내용:" + boText + "\n 일시:" + boDate;
		return result;
	}
	
	String getBoNo(){
		return boNo;
	}
	String getBoTitle(){
		return boTitle;
	}
	String getBoWriter(){
		return boWriter;
	}
	String getBoText(){
		return boText;
	}
	String getBoDate(){
		return boDate;
	}
}

