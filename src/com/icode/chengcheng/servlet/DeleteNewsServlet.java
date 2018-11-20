package com.icode.chengcheng.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icode.chengcheng.biz.INewsBiz;
import com.icode.chengcheng.biz.impl.NewsBizImpl;

/**
 * Servlet implementation class DeleteNewsServlet
 */
public class DeleteNewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteNewsServlet() {
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
		int nid = Integer.parseInt(request.getParameter("nid"));
		INewsBiz newsBiz = new NewsBizImpl();
		if(newsBiz.delete(nid)>0)
			response.sendRedirect("/chengcheng/ShowInAboutMeServlet");
		System.out.println("出错");
		
	}

}
