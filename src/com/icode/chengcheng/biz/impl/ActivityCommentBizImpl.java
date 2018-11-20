package com.icode.chengcheng.biz.impl;


import com.icode.chengcheng.biz.IActivityCommentBiz;
import com.icode.chengcheng.dao.IActivitiesDao;
import com.icode.chengcheng.dao.ICommentsDao;
import com.icode.chengcheng.dao.INewsDao;
import com.icode.chengcheng.dao.IUsersDao;
import com.icode.chengcheng.dao.impl.ActivitiesDaoImpl;
import com.icode.chengcheng.dao.impl.CommentsDaoImpl;
import com.icode.chengcheng.dao.impl.NewsDaoImpl;
import com.icode.chengcheng.dao.impl.UsersDaoImpl;
import com.icode.chengcheng.po.Activities;
import com.icode.chengcheng.po.Comments;
import com.icode.chengcheng.po.News;
import com.icode.chengcheng.po.Users;

public class ActivityCommentBizImpl implements IActivityCommentBiz {
     IActivitiesDao iActivitiesDao;
     IUsersDao usersDao;
     INewsDao newsDao ;
     ICommentsDao commentsDao;
     
	public ActivityCommentBizImpl() {
		super();
		// TODO Auto-generated constructor stub
		iActivitiesDao =new ActivitiesDaoImpl();
		this.usersDao = new UsersDaoImpl();
		this.newsDao = new NewsDaoImpl();
		this.commentsDao = new CommentsDaoImpl();
	}

	@Override
	public Activities toComment(int aid) {
		// TODO Auto-generated method stub
		return iActivitiesDao.selectById(aid);
	}

	@Override
	public boolean tozan(int aid) {
		// TODO Auto-generated method stub
		return this.iActivitiesDao.updatezan(aid)>0?true:false;
	}

	@Override
	public boolean tocom(int aid) {
		// TODO Auto-generated method stub
		return this.iActivitiesDao.updatecom_num(aid)>0?true:false;
	}

	@Override
	public boolean toYourActivity(int aid, String fromuccid) {
		// TODO Auto-generated method stub
		String owner_id = iActivitiesDao.findPub(aid);
		if(!owner_id.equals(fromuccid)){
		    Users user =  usersDao.selectById(fromuccid);
	     	Activities act = iActivitiesDao.selectById(aid);
		 
		     String ncontent = user.getUccid()+"/"+user.getUname()+"/"+user.getUphoto()+"/"+act.getAid()+"/"+act.getAname();
		     News news = new News();
		     news.setNfrom("小诚");
		     news.setNuser(owner_id);
		     news.setNtype(2);
		     news.setNcontent(ncontent);
		  
		   
		 if( newsDao.insert(news)>0)
			 return true;
		return false;}
		return true;
	}

	@Override
	public boolean toYou(int aid, String fromuccid, int touccid) {
		// TODO Auto-generated method stub
		 Comments com = commentsDao.selectById(touccid);
		    String uccid = com.getCuser_from();
		    System.out.println("sdfsgsethtdjj"+uccid);
			Users user =  usersDao.selectById(fromuccid);
			Activities act = iActivitiesDao.selectById(aid);
			 if(!uccid.equals(fromuccid)){  
			     String ncontent = user.getUccid()+"/"+user.getUname()+"/"+user.getUphoto()+"/"+act.getAid()+"/"+act.getAname();
			     News news = new News();
			     news.setNfrom("小诚");
			     news.setNuser(uccid);
			     news.setNtype(3);
			     news.setNcontent(ncontent);

		
			 if( newsDao.insert(news)>0)
				 return true;
			return false;}
			 return true;
		}
	}

