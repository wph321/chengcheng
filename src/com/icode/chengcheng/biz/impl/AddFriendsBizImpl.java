package com.icode.chengcheng.biz.impl;

import com.icode.chengcheng.biz.IAddFriendsBiz;
import com.icode.chengcheng.dao.IFriendsDao;
import com.icode.chengcheng.dao.impl.FriendsDaoImpl;

public class AddFriendsBizImpl implements IAddFriendsBiz {
	
	private IFriendsDao friendsDao;
	
	public AddFriendsBizImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.friendsDao = new FriendsDaoImpl();
	}


	@Override
	public int addFriends(String uccid,String uccidfri) {
		// TODO Auto-generated method stub
		if(!friendsDao.selectByUfid(uccid, uccidfri)){
			if(friendsDao.insertById(uccid,uccidfri)>0)
				return 1;
			return 0;
		}
       return -1;
	}


	@Override
	public boolean deleteFriends(String uccid, String uccidfri) {
		// TODO Auto-generated method stub
		return friendsDao.deleteByUfid(uccid, uccidfri);
	}

}
