package com.cafe24.bitmall.vo;

import org.apache.ibatis.type.Alias;

@Alias("categoryvo")
public class CategoryVo {

	private Long no;
	private String name;

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

}
