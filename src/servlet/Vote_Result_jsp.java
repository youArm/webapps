package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.VoteDao;
import model.Vote_result_Info_Bean;
import model.Vote_result_bean;

/**
 * Servlet implementation class Vote_Result_jsp
 */
@WebServlet("/Vote_Result_jsp")
public class Vote_Result_jsp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Vote_Result_jsp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String con_id=request.getParameter("con_id");
		
		System.out.println(con_id);
		
		Vote_result_Info_Bean VriB=new Vote_result_Info_Bean();
		RequestDispatcher dispatcher = null;
		ArrayList<Vote_result_bean> list=new ArrayList<Vote_result_bean>();
		
		VoteDao Vote = new VoteDao();
		VriB=Vote.result1(con_id);
		list=VriB.getvoteArray();
		request.setAttribute("vort", list);
        request.setAttribute("itemList", VriB);
        
        dispatcher = request.getRequestDispatcher("WEB-INF/Vote_Result.jsp");
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
