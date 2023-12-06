package todo.p20231206;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Product {
	private String ProCode;
	private String ProName;
	private int ProPrice;
	
	Product(){
		
	}
	
	public Product(String ProCode, String ProName, int ProPrice) {
		this.ProCode = ProCode;
		this.ProName = ProName;
		this.ProPrice = ProPrice;
	}
	
	String showInfo() {
		String result = ProCode + " " + ProName + " " + ProPrice;
		return result;
	}
}
