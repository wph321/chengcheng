package com.icode.chengcheng.biz;

import java.util.List;

import com.icode.chengcheng.po.News;

public interface IShowInMeBiz {
       public abstract List<News> showInMe(final String uccid);
}
