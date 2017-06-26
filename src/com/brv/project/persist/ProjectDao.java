package com.brv.project.persist;

import java.util.List;

import com.brv.system.domian.Project;

public interface ProjectDao {
	
	public void insertProjectInfo(Project p);
	
	public Project findProjectByPId(Integer pId);
	
	public List<Project> findAllProject();
}
