package com.icode.chengcheng.dao;

import java.util.List;

import com.icode.chengcheng.po.Friends;

public interface IFriendsDao {
	public abstract int insert(final Friends friends);
	public abstract int insertById(final String uccid,final String uccidfri);
	public abstract List<Friends> selectAll();
	public abstract int deleteById(final int relid);
	public abstract Friends selectById(final int relid);
	public abstract int update(final Friends friends);
	public abstract List<String> selectByUccid(final String fuser);
	public abstract boolean  selectByUfid(final String fuser,final String fuserfri);
	public abstract boolean deleteByUfid(final String fuser,final String fuserfri);
}
