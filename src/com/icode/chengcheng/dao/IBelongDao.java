package com.icode.chengcheng.dao;

import java.util.List;

import com.icode.chengcheng.po.Belong;


public interface IBelongDao {
	public abstract int insert(final Belong belong);
	public abstract List<Belong> selectAll();
	public abstract int deleteById(final int bid);
	public abstract Belong selectById(final int bid);
	public abstract int update(final Belong belong);
	public abstract boolean deleteByAid(final int aid);
}
