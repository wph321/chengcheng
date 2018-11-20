package com.icode.chengcheng.biz;

import java.util.List;

import com.icode.chengcheng.po.Tags;
import com.icode.chengcheng.vo.ShowActTag;

public interface IShowActTagBiz {

	 public abstract List<ShowActTag> selectAct(final String uccid);
	 public abstract List<Tags> selectHobby(final String uccid);
	 public abstract List<ShowActTag> selectActByheat(final String uccid);
	 public abstract List<ShowActTag> selectActBycomm(final String uccid);
	 public abstract List<ShowActTag> selectActBycurr(final String uccid);
	 public abstract List<ShowActTag> selectActByhobby(final List<Integer> lstTid);
	 public abstract List<ShowActTag> selectActByaid(final List<Integer> lstAid);
}
