package com.icode.chengcheng.biz.impl;

import com.icode.chengcheng.biz.IBelongBiz;
import com.icode.chengcheng.dao.IBelongDao;
import com.icode.chengcheng.dao.impl.BelongDaoImpl;
import com.icode.chengcheng.po.Belong;

public class BelongBizImpl implements IBelongBiz {
	
	private IBelongDao belongDao;

	public BelongBizImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.belongDao = new BelongDaoImpl();
	}

	@Override
	public boolean add(Belong belong) {
		// TODO Auto-generated method stub
		return this.belongDao.insert(belong)>0?true:false;
	}

	@Override
	public boolean delete(int aid) {
		// TODO Auto-generated method stub
		return this.belongDao.deleteByAid(aid);
	}

}
