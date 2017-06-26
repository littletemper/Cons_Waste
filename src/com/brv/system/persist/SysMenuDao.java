package com.brv.system.persist;

import java.util.List;

import com.brv.system.domian.SysMenu;

public interface SysMenuDao {
	public List<SysMenu> findFirstLevelMenuByRoleId(Integer roleId);
	public List<SysMenu> findSecondLevelMenuByFirstLevelMenuIdAndRoleId(Integer menuId,Integer roleId);
}
