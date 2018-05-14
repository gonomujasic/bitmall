package com.cafe24.bitmall.vo;

import org.springframework.stereotype.Component;

@Component
public class CartVo {

	private Long userNo;
	private Long productNo;
	private String productName;
	private Long price;
	private Long count;
	private String optName;
	private String optsName;
	private String path;

	public Long getUserNo() {
		return userNo;
	}

	public void setUserNo(Long userNo) {
		this.userNo = userNo;
	}

	public Long getProductNo() {
		return productNo;
	}

	public void setProductNo(Long productNo) {
		this.productNo = productNo;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public String getOptName() {
		return optName;
	}

	public void setOptName(String optName) {
		this.optName = optName;
	}

	public String getOptsName() {
		return optsName;
	}

	public void setOptsName(String optsName) {
		this.optsName = optsName;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public String toString() {
		return "CartVo [UserNo=" + userNo + ", productNo=" + productNo + ", price=" + price + ", count=" + count
				+ ", optName=" + optName + ", optsName=" + optsName + ", path=" + path + "]";
	}

	
	
}
