package com.brv.system.persist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.brv.system.domian.SysMenu;
import com.brv.system.exception.DataAccessException;
import com.brv.system.util.JdbcUtil;

public class SysMenuDaoImpl implements SysMenuDao {

	@Override
	public List<SysMenu> findFirstLevelMenuByRoleId(Integer roleId) {
		List<SysMenu> list = new ArrayList<SysMenu>();
		try
		{
			Connection conn = JdbcUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement("select distinct m.* from brv_role r,brv_role_perm brp,brv_permission p,brv_perm_menu bpm,brv_menu m where r.ROLE_ID=brp.ROLE_ID and brp.PERM_ID=p.PERM_ID and p.PERM_ID=bpm.PERM_ID and bpm.MENU_ID=m.MENU_ID and r.ROLE_ID=? and m.MENU_LEVEL=1 order by m.menu_order");
							
			ps.setInt(1, roleId);

			ResultSet rs = ps.executeQuery();
			while (rs.next())
			{
				SysMenu menu = new SysMenu();
				menu.setMenu_id(rs.getInt("menu_id"));
				menu.setMenu_name(rs.getString("menu_name"));
				menu.setMenu_url(rs.getString("menu_url"));
				menu.setMenu_level(rs.getInt("menu_level"));
				menu.setMenu_order(rs.getInt("menu_order"));
				menu.setBrv_menu_id(rs.getInt("brv_menu_id"));
				
				
				list.add(menu);
			}
		} catch (Exception e)
		{
			throw new DataAccessException("查询一级菜单信息失败", e);
		}
		return list;
	}

	@Override
	public List<SysMenu> findSecondLevelMenuByFirstLevelMenuIdAndRoleId(Integer menuId, Integer roleId) {
		
		List<SysMenu> list=new ArrayList<SysMenu>();
		try
		{
			Connection conn = JdbcUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement("select distinct m.* from brv_role r,brv_role_perm brp,brv_permission p,brv_perm_menu bpm,brv_menu m where r.ROLE_ID=brp.ROLE_ID and brp.PERM_ID=p.PERM_ID and p.PERM_ID=bpm.PERM_ID and bpm.MENU_ID=m.MENU_ID and r.ROLE_ID=? and m.MENU_LEVEL=2 and m.brv_menu_id=? order by m.menu_order");
			
			ps.setInt(1, roleId);
			ps.setInt(2, menuId);

			ResultSet rs = ps.executeQuery();
			while (rs.next())
			{
				SysMenu menu = new SysMenu();
				menu.setMenu_id(rs.getInt("menu_id"));
				menu.setMenu_name(rs.getString("menu_name"));
				menu.setMenu_url(rs.getString("menu_url"));
				menu.setMenu_level(rs.getInt("menu_level"));
				menu.setMenu_order(rs.getInt("menu_order"));
				menu.setBrv_menu_id(rs.getInt("brv_menu_id"));
				
				list.add(menu);
			}
		} catch (Exception e)
		{
			throw new DataAccessException("查询二级菜单信息失败", e);
		}
		return list;
	}

}
