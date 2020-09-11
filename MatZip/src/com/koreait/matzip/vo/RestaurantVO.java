package com.koreait.matzip.vo;

public class RestaurantVO {
	private int i_rest;
	private String nm;
	private String addr;
	private double lat;
	private double lng;
	private String cd_category;
	private int i_user;
	private String r_dr;
	private String m_dt;
	public int getI_rest() {
		return i_rest;
	}
	public void setI_rest(int i_rest) {
		this.i_rest = i_rest;
	}
	public String getNm() {
		return nm;
	}
	public void setNm(String nm) {
		this.nm = nm;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLng() {
		return lng;
	}
	public void setLng(double lng) {
		this.lng = lng;
	}
	public String getCd_category() {
		return cd_category;
	}
	public void setCd_category(String cd_category) {
		this.cd_category = cd_category;
	}
	public String getR_dr() {
		return r_dr;
	}
	public void setR_dr(String r_dr) {
		this.r_dr = r_dr;
	}
	public String getM_dt() {
		return m_dt;
	}
	public void setM_dt(String m_dt) {
		this.m_dt = m_dt;
	}
	public int getI_user() {
		return i_user;
	}
	public void setI_user(int i_user) {
		this.i_user = i_user;
	}
	
}
