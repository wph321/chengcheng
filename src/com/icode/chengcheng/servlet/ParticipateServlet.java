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
 * Servlet implementation class ParticipateServlet
 */
public class ParticipateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ParticipateServlet() {
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
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		Users user = (Users)session.getAttribute("user");
		Participate participate = new Participate();
		participate.setPuser(user.getUccid()); 
		participate.setPact(Integer.parseInt(request.getParameter("aid"))); 
		participate.setPtype(1);
		IParticipateBiz iParticipateBiz = new  ParticipateBizImpl();
		int msgcode =  iParticipateBiz.participateIndex(participate);
		if(msgcode==1){
				response.sendRedirect("/chengcheng/ShowInIndexServlet");
		}else if(msgcode==-1){
			   PrintWriter out = response.getWriter();
			   out.println("<script>alert('您已经参加过该活动了！请去挑选些别的活动吧！')</script>");
			   out.println("<script>location='/chengcheng/ShowInIndexServlet'</script>");
			   out.flush();
			   out.close();
		}else{
			System.out.println("出错");
		}

	
	}

}
