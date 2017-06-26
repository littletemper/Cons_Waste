package com.brv.system.service;

import java.util.List;

import com.brv.system.domian.SysMenu;
import com.brv.system.domian.SysPermission;
import com.brv.system.domian.SysRole;
import com.brv.system.domian.SysUser;
import com.brv.system.exception.LoginException;
import com.brv.system.persist.SysMenuDao;
import com.brv.system.persist.SysMenuDaoImpl;
import com.brv.system.persist.SysPermisionDao;
import com.brv.system.persist.SysPermissionDaoImpl;
import com.brv.system.persist.SysRoleDao;
import com.brv.system.persist.SysRoleDaoImpl;
import com.brv.system.persist.SysUserDao;
import com.brv.system.persist.SysUserDaoImpl;
import com.brv.system.util.Page;

public class SysServiceImpl implements SysService {

	private SysUserDao sud=new SysUserDaoImpl();
	private SysRoleDao srd=new SysRoleDaoImpl();
	private SysMenuDao smd=new SysMenuDaoImpl();
	private SysPermisionDao spd=new SysPermissionDaoImpl();
	
	@Override
	public SysUser login(String userName, String userPwd)
	{
		// 根据用户名查询用户信息
		// 找到了，有该用户，继续判断填写的密码和查询到的密码是否相同，如果相同，验证成功，否则，密码错误
		// 用户未找到，用户不存在
		SysUser user = sud.findUserByLoginName(userName);
		
			if (user == null)
			{
				// 用户名错误
				System.out.println("用戶名錯了");
				throw new LoginException("300");
			
			} else
			{
				if(!userPwd.equals(user.getUser_pwd()))
				{
					//密码错误
					System.out.println("密碼名錯了");
					throw new LoginException("300");
				}else{
					System.out.println("用戶密碼都對了");
					//可以登录,记录日志
					SysRole role = srd.findRoleByRoleId(user.getRole().getRole_id());
					user.setRole(role);
					
//					List<Menu> list = sysMenuDao.findFirstLevelMenuByRoleId(user.getRole().getRoleId());
//					
//					if(list != null && list.size()>0)
//					{
//						for(Menu menu:list)
//						{
//							List<Menu> second = sysMenuDao.findSecondLevelMenuByFirstLevelMenuIdAndRoleId(menu.getMenu_id(), user.getRole().getRoleId());
//							menu.setSecondMenu(second);
//						}
//					}
//					
//					user.setMenus(list);
//					
//					List<SysPermission> ps  = sysPermissonDao.findPermissonByRoleId(user.getRole().getRoleId());
//					user.setPermissions(ps);
					System.out.println("應該成功了吧");
				}
				
			}
			
			return user;
		}
//	@Override
//	public SysUser login(String userName, String userPwd) {
//		// 登录功能
//		SysUser user=sud.findUserByUserName(userName);
//		if(user==null)
//		{	//用户名有误
//			throw new LoginException("401");
//		}
//		else
//		{
//			if(!userPwd.equals(user.getUser_pwd()))
//			{
//				//密码有误
//				throw new LoginException("402");
//			}
//			else
//			{
//				//正常登录
//				SysRole role=srd.findRoleByRoleId(user.getRole().getRole_id());
//				user.setRole(role);
//				
//				List<SysMenu> list=smd.findFirstLevelMenuByRoleId(user.getRole().getRole_id());
//				if(list!=null&&list.size()>0)
//				{
//					for(SysMenu menu:list)
//					{
//						List<SysMenu> secondLevelMenu=smd.findSecondLevelMenuByFirstLevelMenuIdAndRoleId(menu.getMenu_id(), user.getRole().getRole_id());
//						menu.setSecondLevelMenu(secondLevelMenu);		
//					}
//				}
//				user.setMenus(list);
//				
//				List<SysPermission> p=spd.findPermissionByRoleId(user.getRole().getRole_id());
//				user.setPerms(p);
//			}
//		}
//		return user;
//	}
	@Override
	public List<SysPermission> getAllPermissions() {
		// TODO Auto-generated method stub
		return spd.findAllPermissions();
	}
	@Override
	public Page<SysUser> findUserByPage(Integer currentPage) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Page<SysRole> findRoleByPage(Integer currentPage) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public SysUser findUserByUserName(String userName) {
		// TODO Auto-generated method stub
		return sud.findUserByUserName(userName);
	}
	@Override
	public void updateUser(SysUser user) {
		// TODO Auto-generated method stub
		sud.updateUser(user);
	}
	@Override
	public void deleteUserByUserName(String userName) {
		// TODO Auto-generated method stub
		sud.deleteUserByUserName(userName);
	}
	@Override
	public List<SysRole> findAllRoles() {
		// TODO Auto-generated method stub
		return srd.findAllRoles();
	}
	@Override
	public void addRoleForUser(SysUser user) {
		// TODO Auto-generated method stub
		sud.updateRoleIdForUser(user);
	}
	@Override
	public void addRole(SysRole role) {
		// TODO Auto-generated method stub
		srd.insertRole(role);
	}
	@Override
	public void updateRole(SysRole role) {
		// TODO Auto-generated method stub
		srd.updateRole(role);
	}
	@Override
	public void deleteRoleByRoleId(Integer roleId) {
		// TODO Auto-generated method stub
		srd.deleteRoleByRoleId(roleId);
	}
	@Override
	public SysRole findRoleInfoByRoleId(Integer roleId) {
		// TODO Auto-generated method stub
		SysRole role = srd.findRoleByRoleId(roleId);
		List<SysPermission> allPerms = spd.findAllPermissions();
		List<SysPermission> perms = spd.findPermissionByRoleId(roleId);
		
		role.setAllperms(allPerms);
		role.setPerms(perms);
		
		return role;
	}
	@Override
	public void addPermissionsForRole(Integer roleId, String[] ids) {
		// 为角色分配权限
		//先删除，再插入
		srd.deleteAllPermissionByRoleId(roleId);
		srd.insertAllPermissionByRoleId(roleId, ids);
		
		
	}
	@Override
	public void addUser(String userName,String userPwd)
	{
		
		//取到用户名和密码传给持久层
		sud.insertUser(userName,userPwd);
		
		// TODO Auto-generated method stub
		
	}
}
