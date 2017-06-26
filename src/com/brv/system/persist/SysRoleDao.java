package com.brv.system.persist;

import java.util.List;

import com.brv.system.domian.SysRole;
import com.brv.system.util.Page;

public interface SysRoleDao {
	
	public SysRole findRoleByRoleId(Integer roleId);
	
	public List<SysRole> findAllRoles();
	//分页查询角色信息
	public Page<SysRole> findRoleByPage(int currentPage);
	
	public void insertRole(SysRole role);
	
	public void updateRole(SysRole role);
	
	public void deleteRoleByRoleId(Integer roleId);
	
	public void deleteAllPermissionByRoleId(Integer roleId);
	
	public void insertAllPermissionByRoleId(Integer roleId,String[] ids);
	
}
