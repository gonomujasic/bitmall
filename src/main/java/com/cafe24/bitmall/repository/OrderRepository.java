package com.cafe24.bitmall.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.bitmall.vo.CartVo;

@Repository
public class OrderRepository {

	@Autowired
	SqlSession session;
	
	public boolean insertIntoCart(CartVo vo) {
		int count = session.insert("order.insertIntoCart", vo);
		return count == 1;
	}
	
	public List<CartVo> getCartList(Long no) {
		return session.selectList("order.getCartList", no);
	}
}
