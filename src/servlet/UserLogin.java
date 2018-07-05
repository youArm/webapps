package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PassWordDao;
import dao.UserDao;
import model.HashPassword;
import model.UserBean;
/**
 * Servlet implementation class UserLogin
 */
@WebServlet("/UserLogin")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ログアウト処理
				HttpSession session = request.getSession();
				session.invalidate();
				request.getRequestDispatcher("Login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		//ログイン処理
				HttpSession session = request.getSession();
				String path ="";
				boolean flg = false;

				String userid = request.getParameter("id");
				String password = request.getParameter("pass");
				PassWordDao PasswordDao = new PassWordDao();

				HashPassword  hash = new HashPassword();
				String pass = hash.encryptPass(password);
				
				flg = PasswordDao.LoginUser(userid, pass);
				if(flg == true){//ログイン成功時

					path = "WEB-INF/Top.jsp";

					UserBean user = new UserBean();
					UserDao udao = new UserDao();
					user = udao.getUser(userid);
					session.setAttribute("userBean",user);
				}else{//ログイン失敗時

					session.setAttribute("login", "IDとパスワードを正しく入力してください");
					path="Login.jsp";
				}

				request.getRequestDispatcher(path).forward(request, response);
	}

}
