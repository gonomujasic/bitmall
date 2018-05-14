package com.cafe24.bitmall.vo;

import java.util.List;

import org.apache.ibatis.type.Alias;

@Alias("optvo")
public class OptVo {

	private Long no;
	private String name;
	private Integer count;

	private List<OptsVo> optsList;

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

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public List<OptsVo> getOptsList() {
		return optsList;
	}

	public void setOptsList(List<OptsVo> optsList) {
		this.optsList = optsList;
	}

	@Override
	public String toString() {
		return name;
	}

}
