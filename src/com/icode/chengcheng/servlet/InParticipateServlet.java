package com.icode.chengcheng.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.icode.chengcheng.biz.IParticipateBiz;
import com.icode.chengcheng.biz.impl.ParticipateBizImpl;
import com.icode.chengcheng.po.Users;

/**
 * Servlet implementation class InParticipateServlet
 */
public class InParticipateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InParticipateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		Users user = (Users)session.getAttribute("user");
		String uccid = user.getUccid();
	    int aid = Integer.parseInt(request.getParameter("aid"));
	    IParticipateBiz iParticipateBiz = new  ParticipateBizImpl();
		if(iParticipateBiz.cancelUser(uccid, aid)){

		response.sendRedirect("/chengcheng/ShowInIndexServlet");
		}else{
			System.out.println("出错");
		}
	}

}
