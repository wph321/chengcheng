package com.icode.chengcheng.biz;

import java.util.List;

import com.icode.chengcheng.po.Users;

public interface IFindFriendsBiz {
	public abstract List<Users> findFriends(final String uccid);
}
