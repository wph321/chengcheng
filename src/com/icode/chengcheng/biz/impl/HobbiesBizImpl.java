package com.icode.chengcheng.biz.impl;

import com.icode.chengcheng.biz.IHobbiesBiz;
import com.icode.chengcheng.dao.IHobbiesDao;
import com.icode.chengcheng.dao.impl.HobbiesDaoImpl;
import com.icode.chengcheng.po.Hobbies;

public class HobbiesBizImpl implements IHobbiesBiz {
	
	private IHobbiesDao hobbiesDao;
	
	public HobbiesBizImpl() {	
		super();
		// TODO Auto-generated constructor stub
		this.hobbiesDao =new HobbiesDaoImpl();
	}

	@Override
	public boolean add(Hobbies hobby) {
		// TODO Auto-generated method stub
		return this.hobbiesDao.insert(hobby)>0?true:false;
	}
	
	@Override
	public boolean premodify(String uccid) {
		// TODO Auto-generated method stub
		return this.hobbiesDao.deleteByHuser(uccid)>0?true:false;
	}


	@Override
	public boolean modify(Hobbies hobby,String uccid) {
		// TODO Auto-generated method stub
		return this.hobbiesDao.insert(hobby)>0?true:false;
	}

	
}
