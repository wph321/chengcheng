package com.icode.chengcheng.biz;

import java.util.List;

import com.icode.chengcheng.po.Users;

public interface ISearchNewFriendBiz {
      public abstract List<Users> addNew(String uccid,String keyword);
}
