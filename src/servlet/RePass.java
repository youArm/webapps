package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PassWordDao;
import model.HashPassword;

/**
 * Servlet implementation class RePass
 */
@WebServlet("/RePass")
public class RePass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RePass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pass = request.getParameter("pass");
		String userid = request.getParameter("userid");
		
		// パスワードをSHA-256でハッシュ化
		HashPassword hashPass = new HashPassword();
		String encryptPass = hashPass.encryptPass(pass);
		
		// パスワードをauth_infoテーブルに格納
		PassWordDao passDao = new PassWordDao();
		passDao.UpdatePass(userid, encryptPass);
		
		request.getRequestDispatcher("WEB-INF/RePassComplete.jsp").forward(request, response);
	}

}
