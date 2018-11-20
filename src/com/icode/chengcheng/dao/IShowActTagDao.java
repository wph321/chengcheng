package com.icode.chengcheng.dao;

import java.util.List;

import com.icode.chengcheng.vo.ShowActTag;

public interface IShowActTagDao {
	public abstract List<ShowActTag> selectByTname(final int tname);
	public abstract List<ShowActTag> selectAll();
	public abstract List<ShowActTag> selectById(int aid);
	public abstract  List<ShowActTag> selectByTag(int tid);
}
