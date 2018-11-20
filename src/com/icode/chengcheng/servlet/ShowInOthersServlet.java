package com.icode.chengcheng.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.icode.chengcheng.biz.IShowActInPersonalBiz;
import com.icode.chengcheng.biz.impl.ShowActInPersonalBizImpl;
import com.icode.chengcheng.po.Users;
import com.icode.chengcheng.vo.ShowActInIndex;

/**
 * Servlet implementation class ShowInOthersServlet
 */
public class ShowInOthersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowInOthersServlet() {
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
	   String uccidb = user.getUccid();
       String uccid = request.getParameter("uccid");
       if(uccid.equals(uccidb)){
    	      response.sendRedirect("/chengcheng/ShowInPersonalServlet");
       }else{
		IShowActInPersonalBiz 	iShowActInPersonalBiz = new ShowActInPersonalBizImpl();
		List<ShowActInIndex>  lstAct = iShowActInPersonalBiz.selectAct(uccid);
		List<ShowActInIndex>  lstAct1 = iShowActInPersonalBiz.selectAct1(uccid);
		System.out.println(uccid);
		request.setAttribute("lstAct", lstAct);
		request.setAttribute("lstAct1", lstAct1);
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/others.jsp");
		dispatcher.forward(request, response);
	 }
	}
}
