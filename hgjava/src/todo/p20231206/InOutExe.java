package todo.p20231206;

import java.util.ArrayList;
import java.util.List;

public class InOutExe {
	private List<InOut> inouts;
	
	InOutExe(){
		inouts = new ArrayList<>(); 
		inouts.add(new InOut("P001", "2023-12-06", 10, "구매"));
		inouts.add(new InOut("P001", "2023-12-06", 2, "판매"));
		inouts.add(new InOut("P001", "2023-12-06", 3, "판매"));
	}
	
	// 판매
	boolean addOut(InOut inout) {
		return inouts.add(inout);
	}
	
	// 재고
	void stockList() {
		ProductExe proexe = new ProductExe();
		List<Product> list = proexe.getList();
		
		for(int i = 0; i < list.size(); i++) {
			Product product = list.get(i);
			int qty = 0;
			for(int j = 0; j < inouts.size(); j++) {
				InOut inout = inouts.get(j);
				if(product.getProCode().equals(inout.getProCode())) {
					qty += (inout.getProState().equals("구매")) ? inout.getProNum() : inout.getProNum() * -1;

				}
			}
			System.out.println(product.getProCode() + " : " + qty);
		}
		
		
	}
}
