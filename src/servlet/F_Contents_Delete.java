package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ContentsDao;
import model.ContentsBean;

/**
 * Servlet implementation class F_Contents_Delete
 */

@WebServlet("/F_Contents_Delete")
public class F_Contents_Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public F_Contents_Delete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<ContentsBean> contentsArray = new ArrayList<ContentsBean>();
		ContentsDao contentsDao = new ContentsDao();
		contentsArray = contentsDao.getContentsList();
		
		request.setAttribute("contentsArray", contentsArray);
		
		request.getRequestDispatcher("WEB-INF/Admin_Contents_Delete.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
