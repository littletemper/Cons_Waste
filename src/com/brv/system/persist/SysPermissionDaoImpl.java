package com.brv.system.persist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.brv.system.domian.SysPermission;
import com.brv.system.exception.DataAccessException;
import com.brv.system.util.JdbcUtil;

public class SysPermissionDaoImpl implements SysPermisionDao {

	@Override
	public List<SysPermission> findPermissionByRoleId(Integer roleId) {
		List<SysPermission> list = new ArrayList<SysPermission>();
		try
		{
			Connection conn = JdbcUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(
			"select distinct p.* from brv_role r,brv_role_perm brp,brv_permission p where r.ROLE_ID=brp.ROLE_ID and brp.PERM_ID=p.PERM_ID and r.ROLE_ID=?");

			ps.setInt(1, roleId);

			ResultSet rs = ps.executeQuery();
			while (rs.next())
			{
				SysPermission p = new SysPermission();
				p.setPerm_id(rs.getInt("perm_id"));
				p.setPerm_name(rs.getString("perm_name"));
				p.setPerm_url(rs.getString("perm_url"));
				
				list.add(p);
			}
		} catch (Exception e)
		{
			throw new DataAccessException("查询权限信息失败", e);
		}
		return list;
	}

	@Override
	public List<SysPermission> findAllPermissions() {
		List<SysPermission> list = new ArrayList<SysPermission>();
		try
		{
			Connection conn = JdbcUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from brv_permission");

			ResultSet rs = ps.executeQuery();
			while (rs.next())
			{
				SysPermission p = new SysPermission();
				p.setPerm_id(rs.getInt("perm_id"));
				p.setPerm_name(rs.getString("perm_name"));
				p.setPerm_url(rs.getString("perm_url"));
				
				list.add(p);
			}
		} catch (Exception e)
		{
			throw new DataAccessException("查询全部权限信息失败", e);
		}
		return list;
	}

}
