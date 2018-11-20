package com.icode.chengcheng.dao;

import java.util.List;

import com.icode.chengcheng.vo.ShowUserFriend;

public interface IShowUserFriendDao {
	public abstract List<ShowUserFriend> selectByUser(final String uccid);
	public abstract List<ShowUserFriend> selectByKey(String uccid,final String keyword);
}
