package com.icode.chengcheng.dao;

import java.util.List;

import com.icode.chengcheng.po.News;

public interface INewsDao {
	public abstract int insert(final News news);
	public abstract List<News> selectAll();
	public abstract int deleteById(final int nid);
	public abstract News selectById(final int nid);
	public abstract List<News> selectByUccid(final String uccid);
	public abstract int deleteByUccid(final String uccid);
}
