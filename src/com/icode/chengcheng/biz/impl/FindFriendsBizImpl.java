package com.icode.chengcheng.biz.impl;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.icode.chengcheng.biz.IFindFriendsBiz;
import com.icode.chengcheng.dao.IFriendsDao;
import com.icode.chengcheng.dao.IUsersDao;
import com.icode.chengcheng.dao.impl.FriendsDaoImpl;
import com.icode.chengcheng.dao.impl.UsersDaoImpl;
import com.icode.chengcheng.po.Users;


public class FindFriendsBizImpl implements IFindFriendsBiz {
	
	IUsersDao usersDao;
	IFriendsDao friendsDao;
	
	public FindFriendsBizImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.usersDao = new UsersDaoImpl();
	   this.friendsDao = new FriendsDaoImpl();
	}
	
	@Override
	public List<Users> findFriends(String uccid) {
		// TODO Auto-generated method stub
		List<Users> lstu = usersDao.selectByUccid(uccid);//根据单位找好友
		List<String> lstf =  friendsDao.selectByUccid(uccid);//个人已有的好友
        for(String fuser:lstf){
        	List<String> fusers= friendsDao.selectByUccid(fuser);
        	for(String ff:fusers){
        		lstu.add(usersDao.selectById(ff));
        	}
        }
      
        Set<Users>  h = new HashSet<Users>(lstu);
        lstu.clear();
        lstu.addAll(h);

        Users br = usersDao.selectById(uccid);
        lstu.remove(br);
        for(String lst:lstf){
           Users ff = usersDao.selectById(lst);
           lstu.remove(ff);
       }

		return lstu;
	}

}
