package com.icode.chengcheng.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;








import com.icode.chengcheng.biz.IActivitiesBiz;
import com.icode.chengcheng.biz.IBelongBiz;
import com.icode.chengcheng.biz.ICommentsBiz;
import com.icode.chengcheng.biz.IParticipateBiz;
import com.icode.chengcheng.biz.impl.ActivitiesBizImpl;
import com.icode.chengcheng.biz.impl.BelongBizImpl;
import com.icode.chengcheng.biz.impl.CommentsBizImpl;
import com.icode.chengcheng.biz.impl.ParticipateBizImpl;



/**
 * Servlet implementation class CancelServlet
 */
public class CancelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancelServlet() {
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
	    int aid = Integer.parseInt(request.getParameter("aid"));
	    String url= request.getHeader("Referer");
	    //System.out.println("url");
	    IParticipateBiz iParticipateBiz = new  ParticipateBizImpl();
		iParticipateBiz.cancelActivity(aid);
		IActivitiesBiz activitiesBiz =new ActivitiesBizImpl();
	    IBelongBiz belongBiz = new BelongBizImpl();
	    ICommentsBiz commentsBiz = new CommentsBizImpl();
	    if(belongBiz.delete(aid)&& commentsBiz.deleteComments(aid)){
		if(activitiesBiz.deleteActivities(aid)>0){
	        response.sendRedirect(url);
		}else{
			System.out.println("出错");
		}
	    }
	}

}
