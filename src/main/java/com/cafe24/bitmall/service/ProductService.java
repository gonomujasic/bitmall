package com.cafe24.bitmall.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.bitmall.repository.FIleRepository;
import com.cafe24.bitmall.repository.OptRepository;
import com.cafe24.bitmall.repository.ProductRepository;
import com.cafe24.bitmall.util.Pager;
import com.cafe24.bitmall.vo.ImageVo;
import com.cafe24.bitmall.vo.OptsVo;
import com.cafe24.bitmall.vo.ProductVo;

@Service
public class ProductService {

	@Autowired
	ProductRepository pRepository;
	
	@Autowired
	OptRepository optRepository;
	
	@Autowired
	FIleRepository fRepository;
	
	public Map<String, Object> getProductList(Map<String, Object> map){
		
		Pager pager = new Pager();
		int size = pager.getLIST_SIZE();
		int currentPage = (int) map.get("currentPage");
		String keyword = (String) map.get("keyword");
		
		map.put( "page", (currentPage-1) * size );
		map.put( "size", size );
		int totalCount = pRepository.getTotalCount(map);
		
		Map<String, Object> pageMap = pager.getMessageList(currentPage, totalCount, keyword);
		pageMap.put("pList", pRepository.getProductList(map));
		pageMap.put("cList", pRepository.getCategoryList());
		return pageMap;
	}
	
	public ProductVo loadNewProduct(){
		//Map<String, Object> map = new HashMap<>();
		ProductVo vo = new ProductVo();
		vo.setcList(pRepository.getCategoryList());
		vo.setOptList(optRepository.getOptList());
		//카테고리 리스트, 대옵션리스트
		/*map.put("cList", pRepository.getCategoryList());
		map.put("optList", optRepository.getOptList());
		System.out.println(map.get("cList"));
		System.out.println(map.get("optList"));*/
		return vo;
	}
	
	public ProductVo makeNewProduct(ProductVo vo) {
		
		return pRepository.makeNewProduct(vo);
		
	}
	
	public ProductVo getCListAndOpt(ProductVo vo) {
		
		vo.setcList(pRepository.getCategoryList());
		vo.setOptList(optRepository.getOptList());
		
		return vo;
		
	}
	
	public List<ProductVo> getNewProductList()	{
		
		return pRepository.getNewProductList();
	}
	
	public ProductVo getProductDetail(Long no) {
		ProductVo dataVo = pRepository.getProductDetail(no);
		System.out.println(dataVo.getOptNo());
		List<OptsVo> optsList = pRepository.getOptsList(dataVo.getOptNo());
		dataVo.setOptsList(optsList);
		List<ImageVo> imageList = fRepository.getImageList(no);
		dataVo.setImageList(imageList);
		
		return dataVo ;
	}
	
}
