package com.yedam.product.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.product.service.ProductService;
import com.yedam.product.serviceImpl.ProductServiceImpl;
import com.yedam.product.vo.ProductVO;

public class ProductListControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		ProductService svc = new ProductServiceImpl();
		List<ProductVO> list = svc.productList();
		req.setAttribute("productList", list);
		
		
		// 페이지 이동(forward) 
		// RequestDispatcher -> 요청을 재지정 해주는 기능
		RequestDispatcher rd = req.getRequestDispatcher("product/productList.tiles");
		try {
			rd.forward(req, resp);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

}
