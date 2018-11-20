package com.icode.chengcheng.biz;

import java.util.List;

import com.icode.chengcheng.vo.ShowActInIndex;

public interface IShowActInIndexBiz {
    public abstract List<ShowActInIndex> selectAct(final String uccid);
    public abstract List<ShowActInIndex> selectActByAid(final int aid);
}
