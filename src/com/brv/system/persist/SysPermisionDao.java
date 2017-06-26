package com.brv.system.persist;

import java.util.List;

import com.brv.system.domian.SysPermission;

public interface SysPermisionDao {
	public List<SysPermission> findPermissionByRoleId(Integer roleId);
	
	public List<SysPermission> findAllPermissions();
}
