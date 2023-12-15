package boong.pro;

import lombok.Data;

@Data
public class InOut {
	/* 구매정보 */
	private String p_code;
	private String p_date;
	private int p_num;
	private String p_buy;
	private String p_sale;
	
	InOut(){
		
	}
	
}
