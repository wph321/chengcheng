package com.icode.chengcheng.biz;

import com.icode.chengcheng.po.Activities;
import com.icode.chengcheng.po.Participate;

public interface IParticipateBiz {
	
	public abstract boolean participate(final Participate participate); 
	public abstract int selectAid(final Activities activity);
	public abstract int participateIndex(final Participate participate);
	public abstract boolean cancelActivity(final int aid);
	public abstract boolean cancelUser(final String uccid,final int aid);
    public abstract int  toShare(final Participate participate);
}
