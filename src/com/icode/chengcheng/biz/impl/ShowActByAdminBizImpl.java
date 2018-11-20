package com.icode.chengcheng.biz.impl;

import java.util.List;

import com.icode.chengcheng.biz.IShowActByAdminBiz;
import com.icode.chengcheng.dao.IShowActInIndexDao;
import com.icode.chengcheng.dao.impl.ShowActInIndexDaoImpl;
import com.icode.chengcheng.vo.ShowActInIndex;

public class ShowActByAdminBizImpl implements IShowActByAdminBiz {
	
	IShowActInIndexDao iShowActInIndexDao;

	public ShowActByAdminBizImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.iShowActInIndexDao = new ShowActInIndexDaoImpl() ;
	}

	@Override
	public List<ShowActInIndex> selectAct(String uccid) {
		// TODO Auto-generated method stub
		return this.iShowActInIndexDao.selectById(uccid);
	}

}
