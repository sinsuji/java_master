package todo.p20231127;

public class Board {
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
		System.out.println(boNo + "\t" + boTitle + "\t" + boWriter);
	}
	
	String showAllInfo() {
		String result = "번호:" + boNo + "\t제목:" + boTitle + "\t작성자:" + boWriter + "\t내용:" + boText + "\t일시:" + boDate;
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
	
	// memberNo의 값을 지정하는 메소드
		void setBoNo(String boNo) {
			this.boNo = boNo;
		}
}

