package com.icode.chengcheng.biz.impl;

import com.icode.chengcheng.biz.INewsBiz;
import com.icode.chengcheng.dao.INewsDao;
import com.icode.chengcheng.dao.impl.NewsDaoImpl;

public class NewsBizImpl implements INewsBiz {
     INewsDao newsDao;
     
	public NewsBizImpl() {
		super();
		// TODO Auto-generated constructor stub
		newsDao = new NewsDaoImpl();
	}

	@Override
	public int delete(int nid) {
		// TODO Auto-generated method stub
		return newsDao.deleteById(nid);
	}

	@Override
	public int deleteFri(String uccid) {
		// TODO Auto-generated method stub
         return newsDao.deleteByUccid(uccid);
	}

}
