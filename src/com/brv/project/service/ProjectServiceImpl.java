package com.brv.project.service;

import java.util.List;

import com.brv.project.persist.ProjectDao;
import com.brv.project.persist.ProjectDaoImpl;
import com.brv.system.domian.Project;

public class ProjectServiceImpl implements ProjectService {

	private ProjectDao pd=new ProjectDaoImpl();
	@Override
	public Project findProjectByPId(Integer pId) {
		// TODO Auto-generated method stub
		return pd.findProjectByPId(pId);
	}

	@Override
	public List<Project> findAllProjects() {
		// TODO Auto-generated method stub
		return pd.findAllProject();
	}

	@Override
	public void addProjectInfo(Project p) {
		// TODO Auto-generated method stub
		pd.insertProjectInfo(p);
	}

}
