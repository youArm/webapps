package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
		String con_d_id=request.getParameter("con_d_id");
		String con_id=request.getParameter("con_id");
		String user_Id=request.getParameter("user_id");
		
		VoteDao Vote = new VoteDao();
		Vote.VoteAdd(con_id, con_d_id);
		
		Vote_HistoryDao VHD = new Vote_HistoryDao();
		VHD.Vote_History_add(user_Id, con_id, con_d_id);
		
		request.setAttribute("con_d_id", con_d_id);
		request.setAttribute("con_id", con_id);
	
		RequestDispatcher dispatcher = request.getRequestDispatcher("Vote_Result");
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
