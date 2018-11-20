package com.icode.chengcheng.biz;

public interface IWantFriendBiz {
	public abstract boolean wantToMakeFriend(final String from,final String to);
    public abstract boolean agreeToMakeFriend(final String from,final String to);
    public abstract boolean refuseToMakeFriend(final String from,final String to);
}
