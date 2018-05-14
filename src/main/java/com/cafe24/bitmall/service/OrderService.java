package com.cafe24.bitmall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.bitmall.repository.OrderRepository;
import com.cafe24.bitmall.vo.CartVo;

@Service
public class OrderService {

	@Autowired
	OrderRepository oRepository;
	
	public boolean insertIntoCart(CartVo vo) {
		return oRepository.insertIntoCart(vo);
	}
	
	public List<CartVo> getCartList(Long no) {
		return oRepository.getCartList(no);
	}
	
}
