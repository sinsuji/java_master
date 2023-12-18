package boong.pro;

import lombok.Data;

@Data
public class InOut {
	/* 구매정보 */
	private int p_sq;
	private String p_code;
	private String p_date;
	private int p_num;
	private int p_price;
	private String p_name;
	private String p_buy;
	private String p_sale;
	private String p_id;
	
	InOut(){
		
	}
	
	InOut(String p_code, int p_num, String p_date){
		this.p_code = p_code;
		this.p_num = p_num;
		this.p_date = p_date;
	}
	
	InOut(String p_code, String p_name, int p_num){
		this.p_code = p_code;
		this.p_name = p_name;
		this.p_num = p_num;
	}
	
	InOut(int p_sq, String p_code, String p_name, int p_num, String p_date){
		this.p_sq = p_sq;
		this.p_code = p_code;
		this.p_name = p_name;
		this.p_num = p_num;
		this.p_date = p_date;		
	}
	
	void showInfo() {
		System.out.println(p_sq + " " + p_code + " " + p_name + " " + p_num + " " + p_date);
	}
	
	void showDateInfo() {
		System.out.println(p_sq + " " + p_code + " " + p_name + " " + p_num + " " + p_date);
	}
	
}
