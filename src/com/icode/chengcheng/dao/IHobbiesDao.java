package com.icode.chengcheng.dao;

import java.util.List;

import com.icode.chengcheng.po.Hobbies;

public interface IHobbiesDao {
	public abstract int insert(final Hobbies hobbies);
	public abstract List<Hobbies> selectAll();
	public abstract int deleteById(final int hid);
	public abstract Hobbies selectById(final int hid);
	public abstract int update(final Hobbies hobbies);
	public abstract List<Hobbies> selectById2(final String huser);
	public abstract int deleteByHuser(final String uccid);

}
