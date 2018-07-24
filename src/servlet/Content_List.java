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
import model.ContentsBean;
import model.UserBean;

/**
 * Servlet implementation class Content_Change
 */
@WebServlet("/Content_List")
public class Content_List extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Content_List() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		HttpSession session = request.getSession();
		UserBean userbean = new UserBean();

		userbean = (UserBean)session.getAttribute("userBean");

		ArrayList<ContentsBean> contentsArray = new ArrayList<ContentsBean>();
		ContentsDao contentsDao = new ContentsDao();

		contentsArray = contentsDao.contentsHistory(userbean.getUserId());

		request.setAttribute("contentsHistory", contentsArray);

		request.getRequestDispatcher("Content_List.jsp").forward(request, response);

	}

}
