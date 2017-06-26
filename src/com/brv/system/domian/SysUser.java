package com.brv.system.domian;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SysUser implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String user_name;
	private String user_pwd;
	private String sex;
	private String phone;
	private String contact_email;
	private String location;
	private String user_img_id;
	private SysRole role;
	private List<SysMenu> menus=new ArrayList<SysMenu>();
	private List<SysPermission> perms=new ArrayList<SysPermission>();
	
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_pwd() {
		return user_pwd;
	}
	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getContact_email() {
		return contact_email;
	}
	public void setContact_email(String contact_email) {
		this.contact_email = contact_email;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getUser_img_id() {
		return user_img_id;
	}
	public void setUser_img_id(String user_img_id) {
		this.user_img_id = user_img_id;
	}
	public SysRole getRole() {
		return role;
	}
	public void setRole(SysRole role) {
		this.role = role;
	}
	public List<SysMenu> getMenus() {
		return menus;
	}
	public void setMenus(List<SysMenu> menus) {
		this.menus = menus;
	}
	public List<SysPermission> getPerms() {
		return perms;
	}
	public void setPerms(List<SysPermission> perms) {
		this.perms = perms;
	}
	
	
}
