package com.icode.chengcheng.biz;

import com.icode.chengcheng.po.Users;


public interface ILoginBiz {

	public abstract Users isLogin(final String account, final String password);
}
