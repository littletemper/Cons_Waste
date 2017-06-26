package com.brv.system.service;

import java.util.List;

import com.brv.system.domian.SysPermission;
import com.brv.system.domian.SysRole;
import com.brv.system.domian.SysUser;
import com.brv.system.util.Page;

public interface SysService {
	public SysUser login(String userName,String userPwd);
	
	public List<SysPermission> getAllPermissions();
	//分页查用户
	public Page<SysUser> findUserByPage(Integer currentPage);
	//分页查角色
	public Page<SysRole> findRoleByPage(Integer currentPage);
	
	//public void addUserInfo(SysUser user);
	
	public SysUser findUserByUserName(String userName);
	
	public void updateUser(SysUser user);
	
	public void deleteUserByUserName(String userName);
	
	public List<SysRole> findAllRoles();
	
	public void addRoleForUser(SysUser user);
	
	public void addRole(SysRole role);
	
	public void updateRole(SysRole role);
	
	public void deleteRoleByRoleId(Integer roleId);
	
	public SysRole findRoleInfoByRoleId(Integer roleId);
	
	public void addPermissionsForRole(Integer roleId,String[] ids);
	
	public void addUser(String userName,String userPwd);
	
}
