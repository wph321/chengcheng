package com.icode.chengcheng.biz;

import com.icode.chengcheng.po.Comments;

public interface ICommentsBiz {
	public abstract boolean comments(final Comments comments);
	public abstract boolean deleteComments(final int aid);
}
