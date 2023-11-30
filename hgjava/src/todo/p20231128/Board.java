package todo.p20231128;

// 데이터를 담아놓기 위한 용도

import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Data;

@Data
public class Board {
	// 배열 : 
	// private Board[] boards;
		
	private int boNo;
	private String boTitle;
	private String boWriter;
	private String boText;
	private String boDate;

	public Board(){
		
	}
	
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
//		this(); // 기본 생성자
		this(boNo, boTitle, boWriter, boText); // 위에서 정의한 생성자를 가르킬 떄 this를 사용
		this.boDate = boDate;
		
	}
	
	public String showInfo() {
		return boNo + " " + boTitle + " " + boWriter + " " + boDate;
	}
	
	public String showDetailInfo() {
		String result = "번호: " + boNo + "/ 제목: " + boTitle;
		result += "\n작성자: " + boWriter;
		result += "\n내용: " + boText;
		result += "\n일시: " + boDate;
		return result;
	}
	
	
	
}

