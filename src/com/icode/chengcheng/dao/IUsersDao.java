package com.icode.chengcheng.dao;

import java.util.List;

import com.icode.chengcheng.po.Users;

public interface IUsersDao {
	
	public abstract int insert(final Users users);
	public abstract List<Users> selectAll();
	public abstract int deleteById(final int uccid);
	public abstract Users selectById(final String uccid);
	public abstract int update(final Users users);
	public abstract Users selectByObject(final String uccid, final String upwd);
	public abstract List<Users> selectByUccid(final String uccid);
	public abstract List<Users> selectByKey(final String uname);
}
