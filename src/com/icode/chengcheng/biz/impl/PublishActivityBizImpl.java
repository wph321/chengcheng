package com.icode.chengcheng.biz.impl;

import com.icode.chengcheng.biz.IPublishActivityBiz;
import com.icode.chengcheng.dao.IActivitiesDao;
import com.icode.chengcheng.dao.impl.ActivitiesDaoImpl;
import com.icode.chengcheng.po.Activities;

public class PublishActivityBizImpl implements IPublishActivityBiz {

	private IActivitiesDao activitiesDao;
	
	public PublishActivityBizImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.activitiesDao=new ActivitiesDaoImpl();
	}

	@Override
	public boolean publish(Activities activity) {
		
		
		// TODO Auto-generated method stub
		return this.activitiesDao.insert(activity)>0?true:false;
	}

}
