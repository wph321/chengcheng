package com.icode.chengcheng.biz;

import java.util.List;

import com.icode.chengcheng.vo.ShowActInIndex;

public interface IShowActInPersonalBiz {
    public abstract List<ShowActInIndex> selectAct(final String uccid);
    public abstract List<ShowActInIndex> selectAct1(final String uccid);
}
