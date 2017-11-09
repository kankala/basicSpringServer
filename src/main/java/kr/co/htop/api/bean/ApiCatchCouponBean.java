package kr.co.htop.api.bean;

import java.sql.Timestamp;

public class ApiCatchCouponBean {
	
	private int userIdx;
	private double lat;
	private double lon;
	private int storeIdx;
	
	
	
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLon() {
		return lon;
	}
	public void setLon(double lon) {
		this.lon = lon;
	}
	public int getStoreIdx() {
		return storeIdx;
	}
	public void setStoreIdx(int storeIdx) {
		this.storeIdx = storeIdx;
	}
	
	@Override
	public String toString() {
		return "ApiCatchCouponBean [lat=" + lat + ", lon=" + lon + ", storeIdx=" + storeIdx
				+ "]";
	}
	public int getUserIdx() {
		return userIdx;
	}
	public void setUserIdx(int userIdx) {
		this.userIdx = userIdx;
	}
	
	

	
}
