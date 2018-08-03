package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.VOTE_MANAGEMENT_Dao;
import dao.VoteDao;
import dao.Vote_HistoryDao;
import model.UserBean;

/**
 * Servlet implementation class Voteadd
 */
@WebServlet("/Voteadd")
public class Voteadd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Voteadd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		UserBean userbean = new UserBean();
		userbean = (UserBean)session.getAttribute("userBean");
		
		String con_d_id=request.getParameter("con_d_id");
		String con_id=request.getParameter("con_id");
		String user_Id=request.getParameter("user_id");
		
		String message;
		
		boolean flg;
		RequestDispatcher dispatcher = null;
		
		VoteDao Vote = new VoteDao();
		VOTE_MANAGEMENT_Dao VMD = new VOTE_MANAGEMENT_Dao();
		flg=VMD.votecheck(userbean.getUserId(), con_id);
		if(flg==true){
		Vote.VoteAdd(con_id, con_d_id);
		
		Vote.totalVoteadd(con_id);
		
		VMD.vortcheck(userbean.getUserId(), con_id);
		
		Vote_HistoryDao VHD = new Vote_HistoryDao();
		
		VHD.Vote_History_add(userbean.getUserId(), con_id, con_d_id);
		
	
		message="投票完了しました";
		}else{
			//投票済みぺーじ　
			message="投票済みです";
		}
		request.setAttribute("con_d_id", con_d_id);
		request.setAttribute("con_id", con_id);
		dispatcher = request.getRequestDispatcher("Vote_Result");
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
