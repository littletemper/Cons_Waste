package com.brv.system.domian;

import java.io.Serializable;

public class Construction_Enterprise implements Serializable {
	private Integer con_id;
	private String con_name;
	public Integer getCon_id() {
		return con_id;
	}
	public void setCon_id(Integer con_id) {
		this.con_id = con_id;
	}
	public String getCon_name() {
		return con_name;
	}
	public void setCon_name(String con_name) {
		this.con_name = con_name;
	}
	
	
}
