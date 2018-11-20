package com.icode.chengcheng.biz.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.icode.chengcheng.biz.IShowActInIndexBiz;
import com.icode.chengcheng.dao.IFriendsDao;
import com.icode.chengcheng.dao.IShowActInIndexDao;
import com.icode.chengcheng.dao.impl.FriendsDaoImpl;
import com.icode.chengcheng.dao.impl.ShowActInIndexDaoImpl;
import com.icode.chengcheng.vo.ShowActInIndex;

public class ShowActInIndexBizImpl implements IShowActInIndexBiz {
    IShowActInIndexDao iShowActInIndexDao;
	IFriendsDao iFriendsDao;	


	public ShowActInIndexBizImpl() {
		super();
		// TODO Auto-generated constructor stub
		 iShowActInIndexDao = new ShowActInIndexDaoImpl() ;
		 iFriendsDao = new FriendsDaoImpl();
	}



	@Override
	public List<ShowActInIndex> selectAct(String uccid) {
		// TODO Auto-generated method stub
		List<ShowActInIndex>  lstAct =  iShowActInIndexDao.selectById(uccid);
		List<String> lstFri = iFriendsDao.selectByUccid(uccid);
		for(String fuerfri:lstFri){
			 lstAct.addAll(iShowActInIndexDao.selectById(fuerfri));
		}
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
	public List<ShowActInIndex> selectActByAid(int aid) {
		// TODO Auto-generated method stub
		List<ShowActInIndex>  lstAct =  iShowActInIndexDao.selectByAId(aid);
		Collections.sort(lstAct, new Comparator<ShowActInIndex>() {
			@Override
			public int compare(ShowActInIndex o1, ShowActInIndex o2) {
				// TODO Auto-generated method stub
				return o1.getPdate().compareTo(o2.getPdate());
			}
		});
		return lstAct;
	}

}
