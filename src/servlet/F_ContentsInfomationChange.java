package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ContentsDao;
import model.ContentsDetailsBean;

/**
 * Servlet implementation class F_ContentsInfomationChange
 */
@WebServlet("/F_ContentsInfomationChange")
public class F_ContentsInfomationChange extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public F_ContentsInfomationChange() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String conid = request.getParameter("conId");
		
		ArrayList<ContentsDetailsBean> contentsArray = new ArrayList<ContentsDetailsBean>();
		ContentsDao contentsDao = new ContentsDao();
		
		contentsArray = contentsDao.getContentsDetails(conid);
		
		request.setAttribute("contentsArray", contentsArray);
		
		request.getRequestDispatcher("WEB-INF/Contents_Infomation_Change.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
