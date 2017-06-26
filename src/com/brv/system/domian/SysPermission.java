package com.brv.system.domian;

import java.io.Serializable;

public class SysPermission implements Serializable {
	private Integer perm_id;
	private String perm_name;
	private String perm_url;
	public Integer getPerm_id() {
		return perm_id;
	}
	public void setPerm_id(Integer perm_id) {
		this.perm_id = perm_id;
	}
	public String getPerm_name() {
		return perm_name;
	}
	public void setPerm_name(String perm_name) {
		this.perm_name = perm_name;
	}
	public String getPerm_url() {
		return perm_url;
	}
	public void setPerm_url(String perm_url) {
		this.perm_url = perm_url;
	}
	
	
}
