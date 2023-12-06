package todo.p20231206;

import java.util.ArrayList;
import java.util.List;

public class ProductExe {
	List<Product> products;
	
	ProductExe(){
		products = new ArrayList<>();
		products.add(new Product("P001", "볼펜", 1000));
		products.add(new Product("P002", "연필", 1200));
		products.add(new Product("N001", "노트100", 1000));
		products.add(new Product("N002", "다이어리", 3000));
	}
	
	boolean addPro(Product product) { // 등록
		return products.add(product);
	}
	
	boolean modifyPro(String code, int price) { // 수정
		for(int i = 0; i < products.size(); i++) {
			if(products.get(i).getProCode().equals(code)) {
				products.get(i).setProPrice(price);
				return true;
			}
		}
		return false;
	}
	
	List<Product> getList(){
		return products;
	}
}
