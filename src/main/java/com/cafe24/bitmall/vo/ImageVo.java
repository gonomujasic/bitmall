package com.cafe24.bitmall.vo;

import org.apache.ibatis.type.Alias;

@Alias("imagevo")
public class ImageVo {

	private Long no;
	private String originName;
	private String name;
	private String ext;
	private String path;
	private Long size;

	private Long productNo;
	
	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getOriginName() {
		return originName;
	}

	public void setOriginName(String originName) {
		this.originName = originName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getExt() {
		return ext;
	}

	public void setExt(String ext) {
		this.ext = ext;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	public Long getProductNo() {
		return productNo;
	}

	public void setProductNo(Long productNo) {
		this.productNo = productNo;
	}

	@Override
	public String toString() {
		return "ImageVo [no=" + no + ", originName=" + originName + ", name=" + name + ", ext=" + ext + ", path=" + path
				+ ", size=" + size + "]";
	}

}
