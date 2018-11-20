package com.icode.chengcheng.biz.impl;

import java.util.List;

import com.icode.chengcheng.biz.IFriendBiz;
import com.icode.chengcheng.dao.IShowUserFriendDao;
import com.icode.chengcheng.dao.impl.ShowUserFriendDaoImpl;
import com.icode.chengcheng.vo.ShowUserFriend;

public class FriendBizImpl implements IFriendBiz {
      IShowUserFriendDao iShowUserFriendDao;
      
      public FriendBizImpl() {
		super();
		// TODO Auto-generated constructor stub
		 iShowUserFriendDao = new ShowUserFriendDaoImpl();
	}

	@Override
	public List<ShowUserFriend> showFriend(String uccid) {
		// TODO Auto-generated method stub
		return iShowUserFriendDao.selectByUser(uccid);
	}

	@Override
	public List<ShowUserFriend> searchFriend(String uccid,String keyword) {
		// TODO Auto-generated method stub
		return iShowUserFriendDao.selectByKey(uccid,keyword);
	}

}
