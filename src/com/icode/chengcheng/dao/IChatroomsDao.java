package com.icode.chengcheng.dao;

import java.util.List;

import com.icode.chengcheng.po.Chatrooms;

public interface IChatroomsDao {
	public abstract int insert(final Chatrooms chatrooms);
	public abstract List<Chatrooms> selectAll();
	public abstract int deleteById(final int rid);
	public abstract Chatrooms selectById(final int rid);
	public abstract int update(final Chatrooms chatrooms);

}
