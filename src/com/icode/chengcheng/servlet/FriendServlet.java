package com.icode.chengcheng.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.icode.chengcheng.biz.IFriendBiz;
import com.icode.chengcheng.biz.impl.FriendBizImpl;
import com.icode.chengcheng.po.Users;
import com.icode.chengcheng.vo.ShowUserFriend;

/**
 * Servlet implementation class FriendServlet
 */
public class FriendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FriendServlet() {
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
		IFriendBiz iFriendBiz = new FriendBizImpl();
		List<ShowUserFriend> lstFri = iFriendBiz.showFriend(uccid);
		request.setAttribute("lstFri", lstFri);
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/friends.jsp");
		dispatcher.forward(request, response);
		
	}

}
