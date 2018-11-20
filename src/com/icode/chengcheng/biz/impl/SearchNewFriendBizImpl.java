package com.icode.chengcheng.biz.impl;

import java.util.ArrayList;
import java.util.List;

import com.icode.chengcheng.biz.ISearchNewFriendBiz;
import com.icode.chengcheng.dao.IFriendsDao;
import com.icode.chengcheng.dao.IUsersDao;
import com.icode.chengcheng.dao.impl.FriendsDaoImpl;
import com.icode.chengcheng.dao.impl.UsersDaoImpl;
import com.icode.chengcheng.po.Users;

public class SearchNewFriendBizImpl implements ISearchNewFriendBiz {
    IUsersDao usersDao;
    IFriendsDao friendsDao;
    
	public SearchNewFriendBizImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.usersDao = new UsersDaoImpl();
		this.friendsDao = new FriendsDaoImpl();
	}

	@Override
	public List<Users> addNew(String uccid,String keyword) {
		// TODO Auto-generated method stub
		List<Users> lstUser = usersDao.selectByKey(keyword);
		List<String> lstFri = friendsDao.selectByUccid(uccid);
		List<Users> lstRem = new ArrayList<>();
		for(String fccid:lstFri){
			lstRem.add( usersDao.selectById(fccid));
		}
		lstUser.removeAll(lstRem);
		return lstUser;
 	}

}
