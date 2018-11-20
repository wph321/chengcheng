package com.icode.chengcheng.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.icode.chengcheng.biz.IRegisterBiz;
import com.icode.chengcheng.biz.impl.RegisterBizImpl;
import com.icode.chengcheng.po.Users;

/**
 * Servlet implementation class IsDoubleServlet
 */
public class IsSamePwdServlet  extends HttpServlet {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IsSamePwdServlet() {
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
	  HttpSession session = request.getSession();
		Users user=(Users) session.getAttribute("user");
		String uccid = user.getUccid();
		System.out.println(uccid);
	  String upwdformer=request.getParameter("upwdformer");
	  System.out.println(upwdformer);
	  if(registerBiz.checkUpwd(uccid, upwdformer))
    	  response.getWriter().print(true);
      else response.getWriter().print(false);
	 }
	}
