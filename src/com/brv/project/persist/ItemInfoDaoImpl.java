package com.brv.project.persist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import com.brv.system.domian.ItemInfo;
import com.brv.system.domian.Project;
import com.brv.system.exception.DataAccessException;
import com.brv.system.util.JdbcUtil;

public class ItemInfoDaoImpl implements ItemInfoDao
{

	@Override
	public void insertItemInfo(ItemInfo i)
	{
		// 添加项目信息
		try{
			Connection conn=JdbcUtil.getConnection();
			PreparedStatement ps=conn.prepareStatement("insert into brv_item_info(i_name,i_location,i_charge,i_phone) values(?,?,?,?)");
			ps.setString(1, i.getI_name());
			ps.setString(2, i.getI_location());
			ps.setString(3, i.getI_charge());
			ps.setString(4, i.getI_phone());
			
			ps.executeUpdate();
		}
		catch(Exception e)
		{
			throw new DataAccessException("添加项目信息失败",e);
		}
	}

	@Override
	public Project findItemByPId(Integer pId)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Project> findAllItem()
	{
		// TODO Auto-generated method stub
		return null;
	}

	

}
