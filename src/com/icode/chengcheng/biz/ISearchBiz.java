package com.icode.chengcheng.biz;

import java.io.Serializable;
import java.util.List;

import com.icode.chengcheng.po.Activities;

public interface ISearchBiz extends Serializable {
	
	public abstract List<Activities> search(final String searchcont);
	public abstract List<Activities> searchBytopic(final String searchcont);
	public abstract List<Activities> searchBycontent(final String searchcont);
	

}
