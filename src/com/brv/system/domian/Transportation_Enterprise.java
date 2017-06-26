package com.brv.system.domian;

import java.io.Serializable;

public class Transportation_Enterprise implements Serializable {
	private Integer tran_id;
	private String tran_name;
	private String tran_location;
	private String contact;
	private String contact_tel;
	
	public Integer getTran_id() {
		return tran_id;
	}
	public void setTran_id(Integer tran_id) {
		this.tran_id = tran_id;
	}
	public String getTran_name() {
		return tran_name;
	}
	public void setTran_name(String tran_name) {
		this.tran_name = tran_name;
	}
	public String getTran_location() {
		return tran_location;
	}
	public void setTran_location(String tran_location) {
		this.tran_location = tran_location;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getContact_tel() {
		return contact_tel;
	}
	public void setContact_tel(String contact_tel) {
		this.contact_tel = contact_tel;
	}
	
	
}
