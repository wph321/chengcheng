package com.icode.chengcheng.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icode.chengcheng.biz.IRegisterBiz;
import com.icode.chengcheng.biz.impl.RegisterBizImpl;
import com.icode.chengcheng.po.Users;

/**
 * Servlet implementation class IsDoubleServlet
 */
public class IsDoubleServlet  extends HttpServlet {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IsDoubleServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void service(HttpServletRequest request, HttpServletResponse response)
	   throws IOException, ServletException {

	  response.reset();
	  request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-type", "text/html;charset=UTF-8");
	 //业务根据uccid查询是否已经存在,以及原密码是否正确
	  IRegisterBiz registerBiz = new RegisterBizImpl();
	  String uccid=request.getParameter("uccid");
	  Users user=registerBiz.checkUser(uccid);
	   if(user!=null){
	      response.getWriter().print(false);  
	     }
	     else{
	      response.getWriter().print(true);
	     }
	  
	 }
	}
