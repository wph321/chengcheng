package com.icode.chengcheng.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.icode.chengcheng.biz.ILoginBiz;
import com.icode.chengcheng.biz.impl.LoginBizImpl;
import com.icode.chengcheng.po.Users;
import com.icode.chengcheng.tools.MD5;


/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings({ "unchecked" })
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try { 
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		// 鑾峰彇瀹㈡埛绔紶鍏ョ殑鏁版嵁
		String uccid = request.getParameter("uccid").trim();                                                                                                                
		String upwd = MD5.EncoderByMD5(request.getParameter("upwd").trim());
		
		HttpSession session = request.getSession();
		String rand = (String)session.getAttribute("rand"); 
		String input = request.getParameter("rand"); 
		if(rand.equals(input)){
		// 鍗曠偣鐧诲綍楠岃瘉
		// 鑾峰彇鍏ㄥ眬Application绾у埆鐨勭敤鎴峰湪绾垮垪琛�
		List<String> usersOnLineList = (List<String>) this.getServletContext().getAttribute("usersOnLineList");
		if(usersOnLineList == null){
			usersOnLineList = new ArrayList<String>();
		}
		// 鍒ゆ柇褰撳墠鐧诲綍鐢ㄦ埛鏄惁瀛樺湪浜庤鍦ㄧ嚎鍒楄〃涓�
		boolean singleLoginFlag;
		if(usersOnLineList.contains(uccid)){
			singleLoginFlag = true;
		}else{
			singleLoginFlag = false;			
		}
		
		if(!singleLoginFlag){
			// 璋冪敤Biz灞傚疄鐜版暟鎹簱楠岃瘉
			ILoginBiz loginBiz = new LoginBizImpl();
			Users user = loginBiz.isLogin(uccid, upwd);
			// 鍝嶅簲瀹㈡埛绔�		
			int msgcode = user == null ? 101 : 102;
			String url = "";
			switch (msgcode) {
			case 101:
				url = "jsp/login.jsp";
				request.setAttribute("msgcode", msgcode);
				break;
			case 102:
				url = "ShowInIndexServlet";
			
				// 灏嗙櫥褰曠殑鐢ㄦ埛娣诲姞鍒板湪绾垮垪琛ㄤ腑
				usersOnLineList.add(user.getUccid());
				// 鍒锋柊鍦ㄧ嚎鐢ㄦ埛鍒楄〃
				this.getServletContext().setAttribute("usersOnLineList", usersOnLineList);
				session.setAttribute("user", user);
				break;
			default:
				break;
			}
			
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
		}else{
			int msgcode = 103;
			request.setAttribute("msgcode", msgcode);
			RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/login.jsp");
			dispatcher.forward(request, response);
		}
		}else{ 
			PrintWriter out = response.getWriter();
			out.print("<script>alert('璇疯緭鍏ユ纭殑楠岃瘉鐮侊紒');location='/chengcheng/jsp/login.jsp';</script>"); 
		} 
		
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
