package todo.p20231206;

import lombok.Data;

@Data
public class InOut {
	private String ProCode;
	private String ProDate;
	private int ProNum;
	private String ProState;
	
	InOut(){
		
	}
	
	public InOut(String ProCode, String ProDate, int ProNum, String ProState) {
		this.ProCode = ProCode;
		this.ProDate = ProDate;
		this.ProNum = ProNum;
		this.ProState = ProState;
	}
}
