package com.cafe24.bitmall.vo;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.apache.ibatis.type.Alias;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import org.springframework.web.multipart.MultipartFile;

@Alias("productvo")
public class ProductVo {

	private Long no;
	@Length(min = 5, max = 10)
	@NotEmpty
	private String code;

	@Length(min = 5, max = 30)
	@NotEmpty
	private String name;

	@Length(min = 1, max = 10)
	@NotEmpty
	private String coname;

	@Range(min = 1)
	@NotNull
	private Long price;

	@NotEmpty
	private String content;

	private Integer iconNew;
	private Integer iconHit;
	private Integer iconSale;

	@Range(min = 1, max = 99)
	@NotNull
	private Long discount;

	private List<ImageVo> imageList;
	private List<MultipartFile> fileList;
	private List<CategoryVo> cList;
	private List<OptVo> optList;
	private List<OptsVo> optsList;

	private Long categoryNo;

	@NotEmpty
	private String categoryName;
	private Long optNo;

	@NotEmpty
	private String optName;
	private Long optsNo;
	private String optsName;
	private Long productStatusNo;
	private String productStatusName;

	private String path;
	private Long saledPrice;

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getConame() {
		return coname;
	}

	public void setConame(String coname) {
		this.coname = coname;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getIconNew() {
		return iconNew;
	}

	public void setIconNew(Integer iconNew) {
		if (iconNew == null) {
			this.iconNew = 0;
			return;
		}
		this.iconNew = iconNew;
	}

	public Integer getIconHit() {
		return iconHit;
	}

	public void setIconHit(Integer iconHit) {
		if (iconHit == null) {
			this.iconHit = 0;
			return;
		}
		this.iconHit = iconHit;
	}

	public Integer getIconSale() {
		return iconSale;
	}

	public void setIconSale(Integer iconSale) {
		if (iconSale == null) {
			this.iconSale = 0;
			return;
		}
		this.iconSale = iconSale;
	}

	public Long getDiscount() {
		return discount;
	}

	public void setDiscount(Long discount) {
		this.discount = discount;
	}

	public List<ImageVo> getImageList() {
		return imageList;
	}

	public void setImageList(List<ImageVo> imageList) {
		this.imageList = imageList;
	}

	public List<CategoryVo> getcList() {
		return cList;
	}

	public void setcList(List<CategoryVo> cList) {
		this.cList = cList;
	}

	public List<OptVo> getOptList() {
		return optList;
	}

	public void setOptList(List<OptVo> optList) {
		this.optList = optList;
	}

	public List<OptsVo> getOptsList() {
		return optsList;
	}

	public void setOptsList(List<OptsVo> optsList) {
		this.optsList = optsList;
	}

	public Long getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(Long categoryNo) {
		this.categoryNo = categoryNo;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Long getOptNo() {
		return optNo;
	}

	public void setOptNo(Long optNo) {
		this.optNo = optNo;
	}

	public String getOptName() {
		return optName;
	}

	public void setOptName(String optName) {
		this.optName = optName;
	}

	public Long getOptsNo() {
		return optsNo;
	}

	public void setOptsNo(Long optsNo) {
		this.optsNo = optsNo;
	}

	public String getOptsName() {
		return optsName;
	}

	public void setOptsName(String optsName) {
		this.optsName = optsName;
	}

	public Long getProductStatusNo() {
		return productStatusNo;
	}

	public void setProductStatusNo(Long productStatusNo) {
		this.productStatusNo = productStatusNo;
	}

	public String getProductStatusName() {
		return productStatusName;
	}

	public void setProductStatusName(String productStatusName) {
		this.productStatusName = productStatusName;
	}

	public List<MultipartFile> getFileList() {
		return fileList;
	}

	public void setFileList(List<MultipartFile> fileList) {
		this.fileList = fileList;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Long getSaledPrice() {
		return saledPrice;
	}

	public void setSaledPrice(Long saledPrice) {
		this.saledPrice = saledPrice;
	}

	@Override
	public String toString() {
		return "ProductVo [no=" + no + ", code=" + code + ", name=" + name + ", coname=" + coname + ", price=" + price
				+ ", content=" + content + ", iconNew=" + iconNew + ", iconHit=" + iconHit + ", iconSale=" + iconSale
				+ ", discount=" + discount + ", imageList=" + imageList + ", fileList=" + fileList + ", cList=" + cList
				+ ", optList=" + optList + ", optsList=" + optsList + ", categoryNo=" + categoryNo + ", categoryName="
				+ categoryName + ", optNo=" + optNo + ", optName=" + optName + ", optsNo=" + optsNo + ", optsName="
				+ optsName + ", productStatusNo=" + productStatusNo + ", productStatusName=" + productStatusName
				+ ", path=" + path + ", saledPrice=" + saledPrice + "]";
	}

}
