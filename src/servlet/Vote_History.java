package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Vote_HistoryDao;
import model.Vote_History_Bean;
import model.Vote_Info_Bean;
import model.Vote_result_bean;

/**
 * Servlet implementation class Vote_History
 */
@WebServlet("/Vote_History")
public class Vote_History extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Vote_History() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user_id="test";
		Vote_HistoryDao VH = new Vote_HistoryDao();
		Vote_Info_Bean VIB = new Vote_Info_Bean();
		
		ArrayList<Vote_History_Bean> list=new ArrayList<Vote_History_Bean>();
		
		VIB=VH.History(user_id);
		
		list=VIB.getvoteArray();
		request.setAttribute("vort", list);
        request.setAttribute("itemList", VIB);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/Vote_History.jsp");
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
