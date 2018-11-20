package com.icode.chengcheng.biz.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.icode.chengcheng.biz.IShowActInPersonalBiz;
import com.icode.chengcheng.dao.IShowActInIndexDao;
import com.icode.chengcheng.dao.impl.ShowActInIndexDaoImpl;
import com.icode.chengcheng.vo.ShowActInIndex;

public class ShowActInPersonalBizImpl implements IShowActInPersonalBiz {
    IShowActInIndexDao iShowActInIndexDao;
    
	public ShowActInPersonalBizImpl() {
		super();
		// TODO Auto-generated constructor stub
		 iShowActInIndexDao = new ShowActInIndexDaoImpl() ;
	}

	@Override
	public List<ShowActInIndex> selectAct(String uccid) {
		// TODO Auto-generated method stub
		List<ShowActInIndex>  lstAct =  iShowActInIndexDao.selectById(uccid);
		
		Collections.sort(lstAct, new Comparator<ShowActInIndex>() {

			@Override
			public int compare(ShowActInIndex o1, ShowActInIndex o2) {
				// TODO Auto-generated method stub
				return o2.getPdate().compareTo(o1.getPdate());
			}
			
		});
		return lstAct;
	}

	@Override
	public List<ShowActInIndex> selectAct1(String uccid) {
		// TODO Auto-generated method stub
		List<ShowActInIndex>  lstAct =  iShowActInIndexDao.selectById(uccid);
		
		Collections.sort(lstAct, new Comparator<ShowActInIndex>() {

			@Override
			public int compare(ShowActInIndex o1, ShowActInIndex o2) {
				// TODO Auto-generated method stub
				return o1.getAdate().compareTo(o2.getAdate());
			}
			
		});
		return lstAct;
	}

}
