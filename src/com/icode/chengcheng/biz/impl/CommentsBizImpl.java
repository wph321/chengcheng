package com.icode.chengcheng.biz.impl;

import com.icode.chengcheng.biz.ICommentsBiz;
import com.icode.chengcheng.dao.ICommentsDao;
import com.icode.chengcheng.dao.impl.CommentsDaoImpl;
import com.icode.chengcheng.po.Comments;

public class CommentsBizImpl implements ICommentsBiz {
	
	private ICommentsDao commentsDao;
	
	public CommentsBizImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.commentsDao = new CommentsDaoImpl();
	}

	@Override
	public boolean comments(Comments comments) {
		// TODO Auto-generated method stub
		return this.commentsDao.insert(comments)>0?true:false;
	}

	@Override
	public boolean deleteComments(final int aid) {
		// TODO Auto-generated method stub
		return this.commentsDao.deleteByAid(aid);
	}

}
