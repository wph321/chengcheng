package com.icode.chengcheng.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.icode.chengcheng.biz.IFindFriendsBiz;
import com.icode.chengcheng.biz.impl.FindFriendsBizImpl;
import com.icode.chengcheng.po.Users;

/**
 * Servlet implementation class FindFriendsServlet
 */
public class FindFriendsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindFriendsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
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
		IFindFriendsBiz findFriendBiz = new FindFriendsBizImpl();
		List<Users> lsts = findFriendBiz.findFriends(uccid);
		request.setAttribute("lsts", lsts);
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/FindFriends.jsp");

		dispatcher.forward(request, response);
	}

}
