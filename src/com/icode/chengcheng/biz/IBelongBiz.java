package com.icode.chengcheng.biz;

import com.icode.chengcheng.po.Belong;

public interface IBelongBiz {
	
	public abstract boolean add(final Belong belong);
	public abstract boolean delete(final int aid);

}
