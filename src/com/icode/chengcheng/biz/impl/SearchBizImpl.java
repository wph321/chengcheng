package com.icode.chengcheng.biz.impl;

import java.util.List;

import com.icode.chengcheng.biz.ISearchBiz;
import com.icode.chengcheng.dao.IActivitiesDao;
import com.icode.chengcheng.dao.impl.ActivitiesDaoImpl;
import com.icode.chengcheng.po.Activities;

@SuppressWarnings("serial")
public class SearchBizImpl implements ISearchBiz {
	
	private IActivitiesDao activitiesDao;

	
	public SearchBizImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.activitiesDao = new ActivitiesDaoImpl();
	}


	@Override
	public List<Activities> search(String searchcont) {
		// TODO Auto-generated method stub
		return this.activitiesDao.searchAllByname(searchcont);
	}


	@Override
	public List<Activities> searchBytopic(String searchcont) {
		// TODO Auto-generated method stub
		return this.activitiesDao.searchAllBytopic(searchcont);
	}


	@Override
	public List<Activities> searchBycontent(String searchcont) {
		// TODO Auto-generated method stub
		return this.activitiesDao.searchAllBycontent(searchcont);
	}
	

}
