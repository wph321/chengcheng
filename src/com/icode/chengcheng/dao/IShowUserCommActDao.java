package com.icode.chengcheng.dao;

import java.util.List;

import com.icode.chengcheng.vo.ShowUserCommAct;

public interface IShowUserCommActDao {

	public abstract List<ShowUserCommAct> selectByAname(final String aname);
	public abstract List<ShowUserCommAct> selectByAid(final int aid);
	
}
