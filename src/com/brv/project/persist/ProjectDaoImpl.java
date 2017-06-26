package com.brv.project.persist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.brv.system.domian.Project;

import com.brv.system.exception.DataAccessException;
import com.brv.system.util.JdbcUtil;

public class ProjectDaoImpl implements ProjectDao {

	@Override
	public void insertProjectInfo(Project p) {
		// 添加合约信息
		try{
			Connection conn=JdbcUtil.getConnection();
			PreparedStatement ps=conn.prepareStatement("insert into brv_project(p_id,p_name,p_location,resp_p,resp_p_tel,surflaes) values(?,?,?,?,?,?)");
			ps.setInt(1, p.getP_id());
			ps.setString(2, p.getP_name());
			ps.setString(3, p.getP_location());
			ps.setString(4, p.getResp_p());
			ps.setString(5, p.getResp_p_tel());
			ps.setString(6, p.getSurflaes());
			
			
			ps.executeUpdate();
		}
		catch(Exception e)
		{
			throw new DataAccessException("添加合约信息失败",e);
		}
	}

	@Override
	public Project findProjectByPId(Integer pId) {
		Project project = null;
		try
		{
			Connection conn = JdbcUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from brv_project where p_id=?");
			ps.setInt(1, pId);

			ResultSet rs = ps.executeQuery();
			while (rs.next())
			{
				project = new Project();
				project.setP_id(pId);
				project.setP_name(rs.getString("p_name"));
				project.setP_location(rs.getString("p_location"));
				project.setResp_p(rs.getString("resp_p"));
				project.setResp_p_tel(rs.getString("resp_p_tel"));
				project.setSurflaes(rs.getString("surflaes"));
			}
		} catch (Exception e)
		{
			throw new DataAccessException("查询项目信息失败", e);
		}
		return project;
	}

	@Override
	public List<Project> findAllProject() {
		// TODO Auto-generated method stub
		List<Project> list=new ArrayList<Project>();
				
		try
		{
			Connection conn = JdbcUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from brv_project ");
			

			ResultSet rs = ps.executeQuery();
			while (rs.next())
			{
				Project p= new Project();
				p.setP_id(rs.getInt("p_id"));
				p.setP_name(rs.getString("p_name"));
				p.setP_location(rs.getString("p_location"));
				p.setResp_p(rs.getString("resp_p"));
				p.setResp_p_tel(rs.getString("resp_p_tel"));
				p.setSurflaes(rs.getString("surflaes"));
			}
		} catch (Exception e)
		{
			throw new DataAccessException("查询项目信息失败", e);
		}
		return list;
	}

	

}
