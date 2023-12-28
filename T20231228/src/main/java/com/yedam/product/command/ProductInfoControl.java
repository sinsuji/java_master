package com.yedam.product.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.product.service.ProductService;
import com.yedam.product.serviceImpl.ProductServiceImpl;
import com.yedam.product.vo.ProductVO;

public class ProductInfoControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		String pno = req.getParameter("pno");
		ProductService svc = new ProductServiceImpl();
		ProductVO vo = svc.getProduct(pno);
		
		req.setAttribute("vo", vo);
		
		
		// 페이지 이동(forward) 
		// RequestDispatcher -> 요청을 재지정 해주는 기능
		RequestDispatcher rd = req.getRequestDispatcher("product/productInfo.tiles");
		try {
			rd.forward(req, resp);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

}
