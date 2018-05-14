package com.cafe24.bitmall.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.bitmall.vo.CategoryVo;
import com.cafe24.bitmall.vo.OptsVo;
import com.cafe24.bitmall.vo.ProductVo;

@Repository
public class ProductRepository {

	@Autowired
	SqlSession session;
	
	public int getTotalCount(Map<String, Object> map) {
		return session.selectOne("product.getTotalCount", map);
	}
	
	public List<ProductVo> getProductList(Map<String, Object> map){
		return session.selectList("product.getProductList", map);
	}
	
	public List<CategoryVo> getCategoryList(){
		return session.selectList("product.getCategoryList");
	}
	
	public ProductVo makeNewProduct(ProductVo vo) {
		session.insert("product.makeNewProduct", vo);
		return vo;
	}
	
	public List<ProductVo> getNewProductList()	{
		return session.selectList("product.getNewProductList");
	}
	
	public ProductVo getProductDetail(Long no)	{
		return session.selectOne("product.getProductDetail", no);
	}
	
	public List<OptsVo> getOptsList(Long no){
		return session.selectList("opt.getOptsList", no);
	}
}
