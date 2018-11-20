package com.icode.chengcheng.dao;

import java.util.List;

import com.icode.chengcheng.vo.ShowUsersNews;

public interface IShowUsersNewsDao {
	
	public abstract List<ShowUsersNews> selectById(final String uccid);
}
