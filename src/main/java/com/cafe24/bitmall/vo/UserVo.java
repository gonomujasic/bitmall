package com.cafe24.bitmall.vo;

import org.apache.ibatis.type.Alias;

@Alias("uservo")
public class UserVo {

	private Long no;
	private String id;
	private String password;
	private String name;
	private Integer birday1;
	private Integer birday2;
	private Integer birday3;
	private Integer tel1;
	private Integer tel2;
	private Integer tel3;
	private Integer phone1;
	private Integer phone2;
	private Integer phone3;
	private Integer zip;
	private String address;
	private String email;

	private Long userClassNo;

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getBirday1() {
		return birday1;
	}

	public void setBirday1(Integer birday1) {
		this.birday1 = birday1;
	}

	public Integer getBirday2() {
		return birday2;
	}

	public void setBirday2(Integer birday2) {
		this.birday2 = birday2;
	}

	public Integer getBirday3() {
		return birday3;
	}

	public void setBirday3(Integer birday3) {
		this.birday3 = birday3;
	}

	public Integer getTel1() {
		return tel1;
	}

	public void setTel1(Integer tel1) {
		this.tel1 = tel1;
	}

	public Integer getTel2() {
		return tel2;
	}

	public void setTel2(Integer tel2) {
		this.tel2 = tel2;
	}

	public Integer getTel3() {
		return tel3;
	}

	public void setTel3(Integer tel3) {
		this.tel3 = tel3;
	}

	public Integer getPhone1() {
		return phone1;
	}

	public void setPhone1(Integer phone1) {
		this.phone1 = phone1;
	}

	public Integer getPhone2() {
		return phone2;
	}

	public void setPhone2(Integer phone2) {
		this.phone2 = phone2;
	}

	public Integer getPhone3() {
		return phone3;
	}

	public void setPhone3(Integer phone3) {
		this.phone3 = phone3;
	}

	public Integer getZip() {
		return zip;
	}

	public void setZip(Integer zip) {
		this.zip = zip;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getUserClassNo() {
		return userClassNo;
	}

	public void setUserClassNo (Long userClassNo) {
		this.userClassNo = userClassNo;
	}

	@Override
	public String toString() {
		return "UserVo [no=" + no + ", id=" + id + ", password=" + password + ", name=" + name + ", birday1=" + birday1
				+ ", birday2=" + birday2 + ", birday3=" + birday3 + ", tel1=" + tel1 + ", tel2=" + tel2 + ", tel3="
				+ tel3 + ", phone1=" + phone1 + ", phone2=" + phone2 + ", phone3=" + phone3 + ", zip=" + zip
				+ ", address=" + address + ", email=" + email + ", userClassNo=" + userClassNo + "]";
	}

}
