package com.icode.chengcheng.biz;

import com.icode.chengcheng.po.Hobbies;

public interface IHobbiesBiz {

	public abstract boolean add(final Hobbies hobby);
	public abstract boolean premodify(final String uccid);
	public abstract boolean modify(final Hobbies hobby,final String uccid);
}
