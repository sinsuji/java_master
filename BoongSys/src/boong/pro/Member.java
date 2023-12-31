package boong.pro;

import lombok.Data;

@Data
public class Member {
	/* 회원 */
	private String m_id;
	private String m_name;
	private String m_phone;
	private String m_best;
	private String m_worst;
	private int m_price;
	private String m_level;
	
	Member(){
		
	}
	
	Member(String m_id, String m_best, String m_worst){
		this.m_id = m_id;
		this.m_best = m_best;
		this.m_worst = m_worst;
	}
	
	Member(String m_id, String m_name, String m_phone, String m_best, String m_worst, String m_level){
		this.m_id = m_id;
		this.m_name = m_name;
		this.m_phone = m_phone;
		this.m_best = m_best;
		this.m_worst = m_worst;
		this.m_level = m_level;
	}
	
	void showInfo() {
		System.out.println(m_id + " " + m_name + " " + m_phone + " " + m_best + " " + m_worst + " " + m_level);
	}
	
	void showLevelInfo() {
		System.out.println(m_price + " " + m_level);
	}
}
