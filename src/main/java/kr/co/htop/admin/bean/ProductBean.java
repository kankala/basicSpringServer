package kr.co.htop.admin.bean;

import java.sql.Timestamp;

public class ProductBean {
	
	
	private int idx;
	
	private int pageNum;
	private int total;
	private String code;
	private String name;
	private int price;
	private int custom;
	private Timestamp registerDate;
	private long registerDate_l;
	private Timestamp lastUpdate;
	private long lastUpdate_l;
	private String makingCompany;
	private String madeIn;
	private int isDisplay;
	private int hitCount;
	private int isDeleted;
	private String imgUrl;
	
	
	
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
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
	public Timestamp getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Timestamp registerDate) {
		this.registerDate = registerDate;
	}
	public long getRegisterDate_l() {
		registerDate_l = registerDate.getTime();
		return registerDate_l;
	}
	
	
	public void setRegisterDate_l(long registerDate_l) {
		this.registerDate_l = registerDate_l;
	}
	public Timestamp getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	public long getLastUpdate_l() {
		lastUpdate_l = lastUpdate.getTime();
		return lastUpdate_l;
	}
	public void setLastUpdate_l(long lastUpdate_l) {
		this.lastUpdate_l = lastUpdate_l;
	}
	
	public String getMadeIn() {
		return madeIn;
	}
	public void setMadeIn(String madeIn) {
		this.madeIn = madeIn;
	}
	public int getIsDisplay() {
		return isDisplay;
	}
	public void setIsDisplay(int isDisplay) {
		this.isDisplay = isDisplay;
	}
	public int getHitCount() {
		return hitCount;
	}
	public void setHitCount(int hitCount) {
		this.hitCount = hitCount;
	}
	public int getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}
	
	public String getMakingCompany() {
		return makingCompany;
	}
	public void setMakingCompany(String makingCompany) {
		this.makingCompany = makingCompany;
	}
	@Override
	public String toString() {
		return "ProductBean [idx=" + idx + ", code=" + code + ", name=" + name + ", price=" + price + ", custom="
				+ custom + ", registerDate=" + registerDate + ", registerDate_l=" + registerDate_l + ", lastUpdate="
				+ lastUpdate + ", lastUpdate_l=" + lastUpdate_l + ", makingCompany=" + makingCompany + ", madeIn="
				+ madeIn + ", isDisplay=" + isDisplay + ", hitCount=" + hitCount + ", isDeleted=" + isDeleted + "]";
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
}
