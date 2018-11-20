package com.icode.chengcheng.dao;

import java.util.List;

import com.icode.chengcheng.vo.ShowUsersAct;

public interface IShowUsersActDao {
	
	public abstract List<ShowUsersAct> selectByUccid(final String uccid);
	public abstract List<ShowUsersAct> selectByAid(final int aid);
}
