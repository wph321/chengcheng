package com.icode.chengcheng.dao;

import java.util.List;

import com.icode.chengcheng.po.Comments;


public interface ICommentsDao {
	public abstract int insert(final Comments comments);
	public abstract int insertu(final Comments comments);
	public abstract List<Comments> selectAll();
	public abstract int deleteById(final int cid);
	public abstract Comments selectById(final int cid);
	public abstract boolean deleteByAid(final int aid);

}
