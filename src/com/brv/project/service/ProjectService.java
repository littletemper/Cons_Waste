package com.brv.project.service;

import java.util.List;

import com.brv.system.domian.Project;

public interface ProjectService {
	
	public Project findProjectByPId(Integer pId);
	
	public List<Project> findAllProjects();
	
	public void addProjectInfo(Project p);
	
}
