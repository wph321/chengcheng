package com.icode.chengcheng.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.icode.chengcheng.biz.IAddFriendsBiz;
import com.icode.chengcheng.biz.impl.AddFriendsBizImpl;
import com.icode.chengcheng.po.Users;

/**
 * Servlet implementation class deleteFriendsServlet
 */
public class DeleteFriendsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteFriendsServlet() {
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
		System.out.println("werwerwer");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		Users user = (Users)session.getAttribute("user");
		System.out.println("1111111111");
		String uccid = user.getUccid();		
        String ufid = request.getParameter("uccid").trim();
        System.out.println("sdfsdfsdf");
        IAddFriendsBiz addFriendsBiz = new AddFriendsBizImpl();
        if(addFriendsBiz.deleteFriends(uccid, ufid))
        	response.sendRedirect("/chengcheng/FriendServlet");
        System.out.println("删除好友出错");
        	
	}

}
