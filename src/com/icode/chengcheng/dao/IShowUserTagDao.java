package com.icode.chengcheng.dao;

import java.util.List;

import com.icode.chengcheng.vo.ShowUserTag;

public interface IShowUserTagDao {
	public abstract List<ShowUserTag> selectByTname(final String tname);
	public abstract List<ShowUserTag> selectById(final String uccid);
}
