package boong.pro;

import lombok.Data;

@Data
public class Ingredient {
	/* 재료 */
	private String i_code;
	private String i_name;
	private int i_price;
	private int i_num;
	private String i_date;
	
	Ingredient(){
		
	}
	
	Ingredient(String i_code, String i_name, int i_price){
		this.i_code = i_code;
		this.i_name = i_name;
		this.i_price = i_price;
	}
	Ingredient(String i_code, int i_num, String i_date){
		this.i_code = i_code;
		this.i_num = i_num;
		this.i_date = i_date;
	}
	void showInfo() {
		System.out.println(i_code + "" + i_name + "" + i_price);
	}
}
