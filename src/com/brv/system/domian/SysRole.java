package com.brv.system.domian;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SysRole implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer role_id;
	private String role_name;
	private List<SysPermission> perms=new ArrayList<SysPermission>();
	private List<SysPermission> allperms=new ArrayList<SysPermission>();
	
	public Integer getRole_id() {
		return role_id;
	}
	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	public List<SysPermission> getPerms() {
		return perms;
	}
	public void setPerms(List<SysPermission> perms) {
		this.perms = perms;
	}
	public List<SysPermission> getAllperms() {
		return allperms;
	}
	public void setAllperms(List<SysPermission> allperms) {
		this.allperms = allperms;
	}
	
	
}
