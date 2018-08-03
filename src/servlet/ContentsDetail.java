package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ContentsDao;
import dao.VOTE_MANAGEMENT_Dao;
import model.ContentsDetailsBean;
import model.UserBean;

/**
 * Servlet implementation class F_ContentsDetail
 */
@WebServlet("/ContentsDetail")
public class ContentsDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContentsDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String conId = request.getParameter("conId");
		String path = "";
		boolean flg = false;
		
		HttpSession session = request.getSession();
		UserBean userbean = new UserBean();
		userbean = (UserBean)session.getAttribute("userBean");
		
		VOTE_MANAGEMENT_Dao VoteManagemetDao = new VOTE_MANAGEMENT_Dao();
		flg = VoteManagemetDao.votecheck(userbean.getUserId(), conId);
		
		if(flg == true){
			
			ContentsDao contentsDao = new ContentsDao();
			
			ArrayList<ContentsDetailsBean> ArrayContentsDetails = new ArrayList<ContentsDetailsBean>();
			ArrayContentsDetails = contentsDao.getContentsDetails(conId);
			
			request.setAttribute("contentsDetails", ArrayContentsDetails);
			
			path = "WEB-INF/Contents_Details.jsp";
		}else{
			
			request.setAttribute("con_id", conId);
			
			path = "Vote_Result";
			
			
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
