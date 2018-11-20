package com.icode.chengcheng.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.icode.chengcheng.biz.IActivityCommentBiz;
import com.icode.chengcheng.biz.ICommentsBiz;
import com.icode.chengcheng.biz.IShowActInIndexBiz;
import com.icode.chengcheng.biz.impl.ActivityCommentBizImpl;
import com.icode.chengcheng.biz.impl.CommentsBizImpl;
import com.icode.chengcheng.biz.impl.ShowActInIndexBizImpl;
import com.icode.chengcheng.po.Activities;
import com.icode.chengcheng.po.Comments;
import com.icode.chengcheng.po.Users;
import com.icode.chengcheng.vo.ShowActInIndex;

/**
 * Servlet implementation class CommentsServlet
 */
public class CommentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentsServlet() {
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
		response.setContentType("text/html");
		response.setHeader("Content-Type", "text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
	    int aid = Integer.parseInt(request.getParameter("aid"));
	    int cuser_to = Integer.parseInt(request.getParameter("cuser_to"));
	    
	    String content = request.getParameter("content").trim();
		HttpSession session = request.getSession();
		Users user = (Users) session.getAttribute("user");
		String cuser = user.getUccid();
		
		Date cdate = new Date();
		
		Comments comments = new Comments();
		comments.setCact(aid);
		comments.setCcontent(content);
		comments.setCuser_from(cuser);
		comments.setCuser_to(cuser_to);
		comments.setCdate(cdate);
		
		ICommentsBiz commentsBiz = new CommentsBizImpl();
		boolean flag = commentsBiz.comments(comments);
		if (flag) {
			
			IActivityCommentBiz  iActivityCommentBiz = new  ActivityCommentBizImpl();
			if(cuser_to!=0){
			  if(  !iActivityCommentBiz.toYou(aid, cuser, cuser_to))
			     System.out.println("出错");
			
			}else{
				 if(! iActivityCommentBiz.toYourActivity(aid, cuser))
				  System.out.println("出错");
			}
			iActivityCommentBiz.tocom(aid);
		    Activities act = iActivityCommentBiz.toComment(aid);
		    request.setAttribute("act", act);
		    IShowActInIndexBiz 	iShowActInIndexBiz = new ShowActInIndexBizImpl();
			List<ShowActInIndex>  lstp = iShowActInIndexBiz.selectActByAid(aid);
			request.setAttribute("lstp", lstp);
			RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/comments.jsp");
			dispatcher.forward(request, response);
		} else {
			System.out.println("回复失败！");
		}
	}
}
