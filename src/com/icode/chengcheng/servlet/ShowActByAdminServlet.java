package com.icode.chengcheng.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icode.chengcheng.biz.IShowActByAdminBiz;
import com.icode.chengcheng.biz.impl.ShowActByAdminBizImpl;
import com.icode.chengcheng.vo.ShowActInIndex;

/**
 * Servlet implementation class ShowActByAdminServlet
 */
public class ShowActByAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowActByAdminServlet() {
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
//		HttpSession session = request.getSession();
//		Users user = (Users)session.getAttribute("user");
		String uccid = "小诚";
		IShowActByAdminBiz 	iShowActByAdminBiz = new ShowActByAdminBizImpl();
		List<ShowActInIndex>  lstAct = iShowActByAdminBiz.selectAct(uccid);
		request.setAttribute("lstAct", lstAct);
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/activity.jsp");
		dispatcher.forward(request, response);
	}

}
