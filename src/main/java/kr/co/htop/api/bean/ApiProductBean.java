package kr.co.htop.api.bean;

import java.sql.Timestamp;

public class ApiProductBean {
	
	private int productIdx;
	private int imgIdx;
	private String code;
	private String name;
	private int price;
	private int custom;
	private String makingCompany;
	private String madeIn;
	private String imgUrl;
	
	
	
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCustom() {
		return custom;
	}
	public void setCustom(int custom) {
		this.custom = custom;
	}
	
	public String getMakingCompany() {
		return makingCompany;
	}
	public void setMakingCompany(String makingCompany) {
		this.makingCompany = makingCompany;
	}
	public String getMadeIn() {
		return madeIn;
	}
	public void setMadeIn(String madeIn) {
		this.madeIn = madeIn;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	@Override
	public String toString() {
		return "ApiProductBean [code=" + code + ", name=" + name + ", price=" + price + ", custom=" + custom
				+ ", makingCompany=" + makingCompany + ", madeIn=" + madeIn + ", imgUrl=" + imgUrl + "]";
	}
	public int getProductIdx() {
		return productIdx;
	}
	public void setProductIdx(int productIdx) {
		this.productIdx = productIdx;
	}
	public int getImgIdx() {
		return imgIdx;
	}
	public void setImgIdx(int imgIdx) {
		this.imgIdx = imgIdx;
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	

	
}
