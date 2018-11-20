package com.icode.chengcheng.dao;

import java.util.List;

import com.icode.chengcheng.vo.ShowActInIndex;

public interface IShowActInIndexDao {
         public abstract List<ShowActInIndex> selectById(final String uccid);
         public abstract List<ShowActInIndex> selectByAId(final int aid);
}
