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
		
		ContentsDao contentsDao = new ContentsDao();
		
		ArrayList<ContentsDetailsBean> ArrayContentsDetails = new ArrayList<ContentsDetailsBean>();
		ArrayContentsDetails = contentsDao.getContentsDetails(conId);
		
		request.setAttribute("contentsDetails", ArrayContentsDetails);
		
		request.getRequestDispatcher("WEB-INF/Contents_Details.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
