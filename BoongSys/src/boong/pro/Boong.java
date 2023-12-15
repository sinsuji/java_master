package boong.pro;

import lombok.Data;

@Data
public class Boong {
	/* 붕어빵 */
	private String b_code;
	private String b_name;
	private int b_price;
	
	Boong(){
		
	}
	
	Boong(String b_code, String b_name, int b_price){
		this.b_code = b_code;
		this.b_name = b_name;
		this.b_price = b_price;
	}
	
	void showInfo() {
		System.out.println(b_code + "" + b_name + "" + b_price);
	}
	
	
}
