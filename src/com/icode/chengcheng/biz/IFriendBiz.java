package com.icode.chengcheng.biz;

import java.util.List;

import com.icode.chengcheng.vo.ShowUserFriend;

public interface IFriendBiz {
	public abstract List<ShowUserFriend> showFriend(final String uccid);
	public abstract List<ShowUserFriend> searchFriend(final String uccid,final String keyword);
}
