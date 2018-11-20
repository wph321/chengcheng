package com.icode.chengcheng.dao;

import java.util.List;

import com.icode.chengcheng.po.Attend;


public interface IAttendDao {
	public abstract int insert(final Attend attend);
	public abstract List<Attend> selectAll();
	public abstract int deleteById(final int jid);
	public abstract Attend selectById(final int jid);
	public abstract int update(final Attend attend);
}
