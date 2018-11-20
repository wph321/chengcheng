package com.icode.chengcheng.biz;


import com.icode.chengcheng.po.Activities;

public interface IActivityCommentBiz {
     public abstract Activities toComment(final int aid);
     public abstract boolean tozan(final int aid);
     public abstract boolean tocom(final int aid);
     public abstract boolean toYourActivity(final int aid,final String fromuccid);
     public abstract boolean toYou(final int aid,final String fromuccid,final int touccid);
}
