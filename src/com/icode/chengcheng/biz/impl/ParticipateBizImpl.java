package com.icode.chengcheng.biz.impl;


import java.util.List;

import com.icode.chengcheng.biz.IParticipateBiz;
import com.icode.chengcheng.dao.IActivitiesDao;
import com.icode.chengcheng.dao.INewsDao;
import com.icode.chengcheng.dao.IParticipateDao;
import com.icode.chengcheng.dao.IUsersDao;
import com.icode.chengcheng.dao.impl.ActivitiesDaoImpl;
import com.icode.chengcheng.dao.impl.NewsDaoImpl;
import com.icode.chengcheng.dao.impl.ParticipateDaoImpl;
import com.icode.chengcheng.dao.impl.UsersDaoImpl;
import com.icode.chengcheng.po.Activities;
import com.icode.chengcheng.po.News;
import com.icode.chengcheng.po.Participate;
import com.icode.chengcheng.po.Users;

public class ParticipateBizImpl implements IParticipateBiz {

	private IParticipateDao participateDao;
	private IActivitiesDao activityDao;
	private INewsDao  newsDao ;
	private IUsersDao usersDao;
	
	public ParticipateBizImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.participateDao = new ParticipateDaoImpl();
		this.activityDao= new ActivitiesDaoImpl();
		this.newsDao = new NewsDaoImpl();
		this.usersDao =new UsersDaoImpl();
	}



	@Override
	public boolean participate(Participate participate) {
		// TODO Auto-generated method stub
		
		return this.participateDao.insert(participate)>0?true:false;
	}



	@Override
	public int selectAid(Activities activity) {
		// TODO Auto-generated method stub
		return this.activityDao.selectAid(activity);
	}



	@Override
	public int participateIndex(Participate participate) {
		// TODO Auto-generated method stub
		int pact = participate.getPact();
		String puser = participate.getPuser();
		List<Participate> lstAct = participateDao.selectAct(pact);
		System.out.println(lstAct);
		for(Participate p:lstAct){
		if(p.getPuser().equals(puser)&&p.getPtype()!=2)
			return -1;
		}
	
		if(participateDao.insert(participate)>0){
			   Users user =  usersDao.selectById(puser);
			  Activities act = activityDao.selectById(pact);
			for(Participate p:lstAct){
				 if(p.getPtype()!=2){
			  
			     String ncontent = user.getUccid()+"/"+user.getUname()+"/"+user.getUphoto()+"/"+act.getAid()+"/"+act.getAname();
			     News news = new News();
			     news.setNfrom("小诚");
			     news.setNuser(p.getPuser());
			     news.setNtype(1);
			     news.setNcontent(ncontent);
			 
			     newsDao.insert(news);
				 }
			}
			activityDao.updateCurr(pact);
			return 1;
		}
		return 0;
	
	}



	@Override
	public boolean cancelActivity(int aid) {
		// TODO Auto-generated method stub
		
		return  this.participateDao.deleteByAid(aid)?true:false;
	}



	@Override
	public boolean cancelUser(String uccid, int aid) {
		// TODO Auto-generated method stub
		if(participateDao.deleteByOthers(uccid,aid)&&activityDao.minusCurr(aid)>0)
			return true;
		return false;
	}
	@Override
	public int toShare(Participate participate) {
		// TODO Auto-generated method stub
		
		int pact = participate.getPact();
		String puser = participate.getPuser();
		List<Participate> lstAct = participateDao.selectAct(pact);
		for(Participate p:lstAct){
		if(p.getPuser().equals(puser))
			return -1;
		}
		if(participateDao.insert(participate)>0){
			activityDao.updateShare(pact);
			return 1;
		}
		return 0;
	}
}
