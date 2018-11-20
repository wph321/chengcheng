package com.icode.chengcheng.biz;

import java.util.List;

import com.icode.chengcheng.po.Users;


public interface IRegisterBiz {

	public abstract boolean register(final Users user); 
	public abstract List<Users> showUsers();
	public abstract Users checkUser(String uccid);
	public abstract boolean checkUpwd(String uccid,String upwd);
	public abstract boolean modify(final Users user);
}
