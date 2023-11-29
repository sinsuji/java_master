package todo.p20231128;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Board {
	// 배열 : 
	// private Board[] boards;
		
	private int boNo;
	private String boTitle;
	private String boWriter;
	private String boText;
	private String boDate;

	public Board(int boNo, String boTitle, String boWriter, String boText) {
		Date today = new Date(); // 시스템시간을 기준으로 생성
		
		// Date -> String -> Date
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // HH:mm:ss 시분초
		
		
		this.boNo = boNo;
		this.boTitle = boTitle;
		this.boWriter = boWriter;
		this.boText = boText;
		this.boDate = sdf.format(today);
	}
	
	public Board(int boNo, String boTitle, String boWriter, String boText, String boDate){
		this.boNo = boNo;
		this.boTitle = boTitle;
		this.boWriter = boWriter;
		this.boText = boText;
		this.boDate = boDate;
		
	}
	
	String showInfo() {
		return boNo + " " + boTitle + " " + boWriter + " " + boDate;
	}
	
	String showDetailInfo() {
		String result = "번호: " + boNo + "/ 제목: " + boTitle;
		result += "\n작성자: " + boWriter;
		result += "\n내용: " + boText;
		result += "\n일시: " + boDate;
		return result;
	}
	
	int getBoNo(){
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

	public void setBoNo(int boNo) {
		this.boNo = boNo;
	}

	public void setBoTitle(String boTitle) {
		this.boTitle = boTitle;
	}

	public void setBoWriter(String boWriter) {
		this.boWriter = boWriter;
	}

	public void setBoText(String boText) {
		this.boText = boText;
	}

	public void setBoDate(String boDate) {
		this.boDate = boDate;
	}
	
}

