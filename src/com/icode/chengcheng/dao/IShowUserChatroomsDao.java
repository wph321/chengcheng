package com.icode.chengcheng.dao;

import java.util.List;

import com.icode.chengcheng.vo.ShowUserChatrooms;

public interface IShowUserChatroomsDao {

	public abstract List<ShowUserChatrooms> selectById(final String uccid);
	
}
