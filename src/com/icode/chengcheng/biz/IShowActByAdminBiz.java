package com.icode.chengcheng.biz;

import java.util.List;

import com.icode.chengcheng.vo.ShowActInIndex;

public interface IShowActByAdminBiz {
	public abstract List<ShowActInIndex> selectAct(final String uccid);
}
