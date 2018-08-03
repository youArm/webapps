package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ContentsDao;

/**
 * Servlet implementation class ContentsInfomationChange
 */
@WebServlet("/ContentsInfomationChange")
public class ContentsInfomationChange extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContentsInfomationChange() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String conid = request.getParameter("conid");
		String conname = request.getParameter("conname");
		String cateid = request.getParameter("catename");
		String date = request.getParameter("date");
		
		ContentsDao contentsDao = new ContentsDao();
		contentsDao.updaContents(conid, conname, date, cateid);
		
		request.getRequestDispatcher("WEB-INF/Contents_Infomation_Change_Complete.jsp").forward(request, response);
		
	
	}

}
