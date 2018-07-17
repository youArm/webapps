package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.VOTE_MANAGEMENT_Dao;
import dao.VoteDao;
import dao.Vote_HistoryDao;

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
		//String con_d_id=request.getParameter("con_d_id");
		//String con_id=request.getParameter("con_id");
		//String user_Id=request.getParameter("user_id");
		String con_d_id="1";
		String con_id="1";
		String user_Id="test";
		String message;
		
		boolean flg;
		RequestDispatcher dispatcher = null;
		
		VoteDao Vote = new VoteDao();
		VOTE_MANAGEMENT_Dao VMD = new VOTE_MANAGEMENT_Dao();
		flg=VMD.votecheck(user_Id, con_id);
		if(flg==true){
		Vote.VoteAdd(con_id, con_d_id);
		
		VMD.vortcheck(user_Id, con_id);
		
		Vote_HistoryDao VHD = new Vote_HistoryDao();
		
		VHD.Vote_History_add(user_Id, con_id, con_d_id);
		
	
		message="投票完了しました";
		}else{
			//投票済みぺーじ　
			message="投票済みです";
		}
		request.setAttribute("con_d_id", con_d_id);
		request.setAttribute("con_id", con_id);
		dispatcher = request.getRequestDispatcher("Vote_Result");
		dispatcher.forward(request, response);
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
