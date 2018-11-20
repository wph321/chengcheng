package com.icode.chengcheng.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.icode.chengcheng.biz.IParticipateBiz;
import com.icode.chengcheng.biz.impl.ParticipateBizImpl;
import com.icode.chengcheng.po.Participate;
import com.icode.chengcheng.po.Users;

/**
 * Servlet implementation class ShareServlet
 */
public class ShareServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShareServlet() {
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
		response.setContentType("text/html");
		response.setHeader("Content-Type", "text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		Participate participate =new Participate();
	    int aid = Integer.parseInt(request.getParameter("aid"));
		HttpSession session = request.getSession();
		Users user = (Users)session.getAttribute("user");
		String uccid = user.getUccid();
		int ptype = 2;
		participate.setPact(aid);
		participate.setPuser(uccid);
		participate.setPtype(ptype);
		IParticipateBiz iParticipateBiz = new  ParticipateBizImpl();
		int msgcode =  iParticipateBiz.toShare(participate);
		if(msgcode==1){
				response.sendRedirect("/chengcheng/ShowInIndexServlet");
		}else if(msgcode==-1){
			   PrintWriter out = response.getWriter();
			   out.println("<script>alert('您是活动中的一员了！不需要再分享这个活动了！')</script>");
			   out.println("<script>location='/chengcheng/ShowInIndexServlet'</script>");
			   out.flush();
			   out.close();
		}else{
			System.out.println("出错");
		}
	}

}
