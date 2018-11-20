package com.icode.chengcheng.dao;

import java.util.List;

import com.icode.chengcheng.po.Resources;

public interface IResourcesDao {

	public abstract int insert(final Resources resourse);
	public abstract List<Resources> selectAll();
	public abstract int deleteById(final int resid);
	public abstract Resources selectById(final int resid);
}
