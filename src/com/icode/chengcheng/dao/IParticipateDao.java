package com.icode.chengcheng.dao;

import java.util.List;

import com.icode.chengcheng.po.Participate;

public interface IParticipateDao {
	public abstract int insert(final Participate participate);
	public abstract List<Participate> selectAll();
	public abstract int deleteById(final int pid);
	public abstract Participate selectById(final int pid);
	public abstract List<Participate> selectAct(final int pact);
	public abstract boolean deleteByAid(final int aid);
	public abstract boolean deleteByOthers(final String uccid,final int aid);
}
