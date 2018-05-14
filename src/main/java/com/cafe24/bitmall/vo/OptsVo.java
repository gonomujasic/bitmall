package com.cafe24.bitmall.vo;

import org.apache.ibatis.type.Alias;

@Alias("optsvo")
public class OptsVo {

	private Long no;
	private String name;

	private Long optNo;

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

	public Long getOptNo() {
		return optNo;
	}

	public void setOptNo(Long optNo) {
		this.optNo = optNo;
	}

	@Override
	public String toString() {
		return "OptsVo [no=" + no + ", name=" + name + ", optNo=" + optNo + "]";
	}

}
