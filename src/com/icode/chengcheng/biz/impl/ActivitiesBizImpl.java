package com.icode.chengcheng.biz.impl;

import com.icode.chengcheng.biz.IActivitiesBiz;
import com.icode.chengcheng.dao.IActivitiesDao;
import com.icode.chengcheng.dao.impl.ActivitiesDaoImpl;


public class ActivitiesBizImpl implements IActivitiesBiz {
     IActivitiesDao activitiesDao;
     
	public ActivitiesBizImpl() {
		super();
		// TODO Auto-generated constructor stub
		activitiesDao = new ActivitiesDaoImpl();
	}

	@Override
	public int deleteActivities(int aid) {
		// TODO Auto-generated method stub
		return activitiesDao.deleteById(aid);
	}

}
