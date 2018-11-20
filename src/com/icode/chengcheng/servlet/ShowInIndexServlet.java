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
import com.icode.chengcheng.biz.IShowActByAdminBiz;
import com.icode.chengcheng.biz.IShowActInIndexBiz;
import com.icode.chengcheng.biz.IShowActInPersonalBiz;
import com.icode.chengcheng.biz.impl.FindFriendsBizImpl;
import com.icode.chengcheng.biz.impl.ShowActByAdminBizImpl;
import com.icode.chengcheng.biz.impl.ShowActInIndexBizImpl;
import com.icode.chengcheng.biz.impl.ShowActInPersonalBizImpl;
import com.icode.chengcheng.po.Users;
import com.icode.chengcheng.vo.ShowActInIndex;

/**
 * Servlet implementation class ShowInIndex
 */
public class ShowInIndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowInIndexServlet() {
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
		IShowActInIndexBiz 	iShowActInIndexBiz = new ShowActInIndexBizImpl();
		List<ShowActInIndex>  lstAct = iShowActInIndexBiz.selectAct(uccid);
		request.setAttribute("lstAct", lstAct);
		IFindFriendsBiz findFriendBiz = new FindFriendsBizImpl();
		List<Users> lsts = findFriendBiz.findFriends(uccid);
		session.setAttribute("lsts", lsts);
		String uccid1 = "小诚";
		IShowActByAdminBiz 	iShowActByAdminBiz = new ShowActByAdminBizImpl();
		List<ShowActInIndex>  lstAct1 = iShowActByAdminBiz.selectAct(uccid1);
		session.setAttribute("lstAct1", lstAct1);
		IShowActInPersonalBiz 	iShowActInPersonalBiz = new ShowActInPersonalBizImpl();
		List<ShowActInIndex>  lstmyAct = iShowActInPersonalBiz.selectAct1(uccid);
		session.setAttribute("lstmyAct", lstmyAct);
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/index.jsp");
		dispatcher.forward(request, response);
	}

}
