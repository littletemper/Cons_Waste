package com.brv.system.domian;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SysMenu implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer menu_id;
	private String menu_name;
	private String menu_url;
	private Integer menu_order;
	private Integer menu_level;
	private Integer brv_menu_id;
	private List<SysMenu> secondLevelMenu=new ArrayList<SysMenu>();
	
	public Integer getMenu_id() {
		return menu_id;
	}
	public void setMenu_id(Integer menu_id) {
		this.menu_id = menu_id;
	}
	public String getMenu_name() {
		return menu_name;
	}
	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}
	public String getMenu_url() {
		return menu_url;
	}
	public void setMenu_url(String menu_url) {
		this.menu_url = menu_url;
	}
	public Integer getMenu_order() {
		return menu_order;
	}
	public void setMenu_order(Integer menu_order) {
		this.menu_order = menu_order;
	}
	public Integer getMenu_level() {
		return menu_level;
	}
	public void setMenu_level(Integer menu_level) {
		this.menu_level = menu_level;
	}
	public Integer getBrv_menu_id() {
		return brv_menu_id;
	}
	public void setBrv_menu_id(Integer brv_menu_id) {
		this.brv_menu_id = brv_menu_id;
	}
	public List<SysMenu> getSecondLevelMenu() {
		return secondLevelMenu;
	}
	public void setSecondLevelMenu(List<SysMenu> secondLevelMenu) {
		this.secondLevelMenu = secondLevelMenu;
	}
	
	
}
