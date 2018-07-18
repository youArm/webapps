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
 * Servlet implementation class UserDelete
 */
@WebServlet("/UserDelete")
public class UserDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDelete() {
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
		
		String path = "";
		boolean flg = false;
		HttpSession session = request.getSession(false);
		
		if (session == null) {
			
			path = "WEB-INF/Login.jsp";
		
		} else {
			
			UserBean userBean = (UserBean) session.getAttribute("userBean");
			
			String pass = request.getParameter("pass");
			
			HashPassword hashPass = new HashPassword();
			String encryptPass = hashPass.encryptPass(pass);
			
			PassWordDao passDao = new PassWordDao();
			flg = passDao.LoginUser(userBean.getUserId(), encryptPass);
			
			if(flg == true){
				UserDao userDao = new UserDao();
				userDao.deleteUser(userBean.getUserId());
				
				path = "WEB-INF/User_Delete_Complete.jsp";
			}else{
				session.setAttribute("error", "パスワードを正しく入力してください");
				path="WEB-INF/User_Delete.jsp";
			}
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
	}

}
