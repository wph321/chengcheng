package com.icode.chengcheng.dao;

import java.util.List;

import com.icode.chengcheng.po.Tags;



public interface ITagsDao {
	public abstract int insert(final Tags tags);
	public abstract List<Tags> selectAll();
	public abstract int deleteById(final int tid);
	public abstract Tags selectById(final int tid);
	public abstract int update(final Tags tags);

}
