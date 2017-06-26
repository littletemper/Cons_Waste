package com.brv.system.persist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.brv.system.domian.SysRole;
import com.brv.system.domian.SysUser;
import com.brv.system.exception.DataAccessException;
import com.brv.system.util.JdbcUtil;
import com.brv.system.util.Page;

public class SysUserDaoImpl implements SysUserDao {

	@Override
	public SysUser findUserByUserName(String userName) {
		SysUser user=null;
		try
		{
			Connection conn=JdbcUtil.getConnection();
			PreparedStatement ps=conn.prepareStatement("select * from brv_user_personal where user_name=?");
			ps.setString(1, userName);
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				user=new SysUser();
				user.setUser_name(rs.getString(userName));
				user.setUser_pwd(rs.getString("user_pwd"));
				user.setSex(rs.getString("sex"));
				user.setPhone(rs.getString("phone"));
				user.setContact_email(rs.getString("contact_email"));
				user.setLocation(rs.getString("location"));
				user.setUser_img_id(rs.getString("user_img_id"));
				
			}
		}
		catch(Exception e)
		{
			throw new DataAccessException("查询用户信息失败",e);
		}
		return user;
	}

	@Override
	public Page<SysUser> findUserByPage(int currentPage) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertUser(String userName,String userPwd) {
		try
		{
			Connection conn = JdbcUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement("insert into brv_user_personal(user_name,user_pwd) values(?,?)");
			ps.setString(1, userName);
			ps.setString(2, userPwd);
			ps.executeUpdate();
			
		} catch (Exception e)
		{
			e.printStackTrace();
		}

	}

	@Override
	public void updateUser(SysUser user) {
		try{
			Connection conn=JdbcUtil.getConnection();
			PreparedStatement ps=conn.prepareStatement("update brv_user_personal set user_pwd=?,sex=?,phone=?,contact_email=?,location=?,user_img_id=? where user_name=?");
			
			ps.setString(1, user.getUser_pwd());
			ps.setString(2, user.getSex());
			ps.setString(3, user.getPhone());
			ps.setString(4, user.getContact_email());
			ps.setString(5, user.getLocation());
			ps.setString(6, user.getUser_img_id());
			ps.setString(7, user.getUser_name());
			
			ps.executeUpdate();
		}
		catch(Exception e)
		{
			throw new DataAccessException("修改用户信息失败",e);
		}

	}

	@Override
	public void updateRoleIdForUser(SysUser user) {
		try
		{
			Connection conn = JdbcUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement("update brv_user_personal set role_id=? where user_name=?");
			ps.setInt(1, user.getRole().getRole_id());
			ps.setString(2, user.getUser_name());

			ps.executeUpdate();
		} catch (Exception e)
		{
			throw new DataAccessException("修改用户的角色id信息失败", e);
		}

	}

	@Override
	public void deleteUserByUserName(String userName) {
		try
		{
			Connection conn = JdbcUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement("delete from brv_user_personal where user_name=?");
			ps.setString(1, userName);
			
			ps.executeUpdate();
		} catch (Exception e)
		{
			throw new DataAccessException("删除用户信息失败", e);
		}

	}

	@Override
	public SysUser findUserByLoginName(String loginName)
	{
		SysUser user = null;
		try
		{
			Connection conn = JdbcUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from brv_user_personal  where user_name=?");
			ps.setString(1, loginName);

			ResultSet rs = ps.executeQuery();
			while (rs.next())
			{
				user = new SysUser();
				user.setUser_name(loginName);
				user.setUser_pwd(rs.getString("USER_PWD"));
				user.setSex(rs.getString("SEX"));

				SysRole role = new SysRole();
				role.setRole_id(rs.getInt("ROLE_ID"));
				user.setRole(role);

//				SysDept dept = new SysDept();
//				dept.setDeptId(rs.getInt("DEPT_ID"));
//				user.setDept(dept);
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return user;
	}
}
