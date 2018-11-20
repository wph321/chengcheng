package com.icode.chengcheng.dao;

import java.util.List;

import com.icode.chengcheng.po.Activities;

public interface IActivitiesDao {

	public abstract int insert(final Activities activity);
	public abstract List<Activities> selectAll();
	public abstract int deleteById(final int cusid);
	public abstract Activities selectById(final int cusid);
	public abstract int update(final Activities activity);
	public abstract int selectAid(final Activities activity);
	public abstract int updatezan(final int aid);
	public abstract int updatecom_num(final int aid);
	public abstract int updateShare(final int aid);
	public abstract int updateCurr(final int aid);
	public abstract List<Activities> searchAllByname(String searchcont);
	public abstract List<Activities> searchAllBytopic(String searchcont);
	public abstract List<Activities> searchAllBycontent(String searchcont);
	public abstract int minusCurr(final int aid);
	public abstract String findPub(final int aid);
}
