package com.example.demo.model;

public class ShopModel{
	private String member_id;
	private String member_pw;
	private String member_name;
	private int member_front_RRN;
	private int member_back_RRN;
	private String member_address;
	private int member_phone;
	private String member_join_date;
	
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	
	public String getMember_pw() {
		return member_pw;
	}
	public void setMember_pw(String member_pw) {
		this.member_pw = member_pw;
	}
	
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	
	public int getMember_front_RRN() {
		return member_front_RRN;
	}
	public void setMember_front_RRN(int member_front_RRN) {
		this.member_front_RRN = member_front_RRN;
	}
	
	public int getMember_back_RRN() {
		return member_back_RRN;
	}
	public void setMember_back_RRN(int member_back_RRN) {
		this.member_back_RRN = member_back_RRN;
	}
	
	public String getMember_address() {
		return member_address;
	}
	public void setMember_address(String member_address) {
		this.member_address = member_address;
	}
	
	public int getMember_phone() {
		return member_phone;
	}
	public void setMember_phone(int member_phone) {
		this.member_phone = member_phone;
	}
	
	public String getMember_join_date() {
		return member_join_date;
	}
	public void setMember_join_date(String member_join_date) {
		this.member_join_date = member_join_date;
	}
}