package com.brv.system.persist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.brv.system.domian.SysRole;
import com.brv.system.exception.DataAccessException;
import com.brv.system.util.JdbcUtil;
import com.brv.system.util.Page;

public class SysRoleDaoImpl implements SysRoleDao {

	@Override
	public SysRole findRoleByRoleId(Integer roleId) {
		SysRole role = null;
		try
		{
			Connection conn = JdbcUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from brv_role where role_id=?");
			ps.setInt(1, roleId);

			ResultSet rs = ps.executeQuery();
			while (rs.next())
			{
				role = new SysRole();
				role.setRole_id(roleId);
				role.setRole_name(rs.getString("role_name"));
				
			}
		} catch (Exception e)
		{
			throw new DataAccessException("查询角色信息失败", e);
		}
		return role;
	}

	@Override
	public List<SysRole> findAllRoles() {

		List<SysRole> list = new ArrayList<SysRole>();
		try
		{
			Connection conn = JdbcUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from brv_role");
			ResultSet rs = ps.executeQuery();
			
			while (rs.next())
			{
				SysRole role = new SysRole();
				role.setRole_id(rs.getInt("role_id"));
				role.setRole_name(rs.getString("role_name"));
				
				list.add(role);
			}
		} catch (Exception e)
		{
			throw new DataAccessException("查询所有角色信息失败", e);
		}
		return list;
	}

	@Override
	public Page<SysRole> findRoleByPage(int currentPage) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertRole(SysRole role) {
		try
		{
			Connection conn = JdbcUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement("insert into brv_role(role_name) values(?)");
			ps.setString(1, role.getRole_name());

			ps.executeUpdate();
		} catch (Exception e)
		{
			throw new DataAccessException("添加角色信息失败", e);
		}
		
	}

	@Override
	public void updateRole(SysRole role) {
		try
		{
			Connection conn = JdbcUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement("update brv_role set ROLE_NAME=? where ROLE_ID=?");
			ps.setString(1, role.getRole_name());
			ps.setInt(2, role.getRole_id());

			ps.executeUpdate();
		} catch (Exception e)
		{
			throw new DataAccessException("修改角色信息失败", e);
		}
		
	}

	@Override
	public void deleteRoleByRoleId(Integer roleId) {
		try
		{
			Connection conn = JdbcUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement("delete from brv_role where role_id=?");
			ps.setInt(1, roleId);

			ps.executeUpdate();
		} catch (Exception e)
		{
			throw new DataAccessException("删除角色信息失败", e);
		}
		
	}

	@Override
	public void deleteAllPermissionByRoleId(Integer roleId) {
		try
		{
			Connection conn = JdbcUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement("delete from brv_role_perm where ROLE_ID=?");
			ps.setInt(1, roleId);

			ps.executeUpdate();
		} catch (Exception e)
		{
			throw new DataAccessException("删除角色对应权限信息失败", e);
		}
		
	}

	@Override
	public void insertAllPermissionByRoleId(Integer roleId, String[] ids) {
		try
		{
			Connection conn = JdbcUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement("insert into brv_role_perm values(?,?)");
			ps.setInt(2, roleId);
			
			for(String id:ids)
			{
				ps.setInt(1, Integer.parseInt(id));
				ps.addBatch();
			}
			
			ps.executeBatch();
		} catch (Exception e)
		{
			throw new DataAccessException("为角色分配权限信息失败", e);
		}
		
	}

}
