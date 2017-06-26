package com.brv.system.persist;

import com.brv.system.domian.SysUser;
import com.brv.system.util.Page;

public interface SysUserDao {
	
	public SysUser findUserByUserName(String userName);
	//分页查询用户信息
	public Page<SysUser> findUserByPage(int currentPage);
	
	public void insertUser(String userName,String userPwd);
	
	public void updateUser(SysUser user);
	
	public void updateRoleIdForUser(SysUser user);
	
	public void deleteUserByUserName(String userName);
	
	public SysUser findUserByLoginName(String loginName);
}
