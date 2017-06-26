package com.brv.system.domian;

import java.io.Serializable;

public class Digestion_Save_Enterprise implements Serializable {
	private Integer dig_id;
	private String dig_name;
	private String dig_location;
	private String contact;
	private String cont_tel;
	private String garbagre_type;
	private String absorption;
	private String subordination;
	
	public Integer getDig_id() {
		return dig_id;
	}
	public void setDig_id(Integer dig_id) {
		this.dig_id = dig_id;
	}
	public String getDig_name() {
		return dig_name;
	}
	public void setDig_name(String dig_name) {
		this.dig_name = dig_name;
	}
	public String getDig_location() {
		return dig_location;
	}
	public void setDig_location(String dig_location) {
		this.dig_location = dig_location;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getCont_tel() {
		return cont_tel;
	}
	public void setCont_tel(String cont_tel) {
		this.cont_tel = cont_tel;
	}
	public String getGarbagre_type() {
		return garbagre_type;
	}
	public void setGarbagre_type(String garbagre_type) {
		this.garbagre_type = garbagre_type;
	}
	public String getAbsorption() {
		return absorption;
	}
	public void setAbsorption(String absorption) {
		this.absorption = absorption;
	}
	public String getSubordination() {
		return subordination;
	}
	public void setSubordination(String subordination) {
		this.subordination = subordination;
	}
	
	
}
