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
import model.PassWordBean;
import model.UserBean;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = "";
		
		HttpSession session = request.getSession(false);
		
		if (session == null) {
			
			path = "WEB-INF/Registration.jsp";
		
		} else {
			PassWordBean passBean = (PassWordBean) session.getAttribute("passBean");
			UserBean userBean = (UserBean) session.getAttribute("userBean");
			
			// パスワードをSHA-256でハッシュ化
			HashPassword hashPass = new HashPassword();
			String encryptPass = hashPass.encryptPass(passBean.getPass());
			
			// passのsessionを破棄
			session.removeAttribute("passBean");

			// ユーザ情報をuserテーブルに格納
			UserDao userdao = new UserDao();
			userdao.registrationUser(userBean);
			// パスワードをauth_infoテーブルに格納
			PassWordDao passDao = new PassWordDao();
			passDao.registrationPassword(userBean.getUserId(), encryptPass);

			path = "WEB-INF/User_Registration_Complete.jsp";
		}

		request.getRequestDispatcher(path).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userid = request.getParameter("userid");
		String pass = request.getParameter("pass");
		String nickname = request.getParameter("nickname");
		String gender = request.getParameter("gender");
		int birthyear = Integer.parseInt(request.getParameter("birthyear"));
		int birthmonth = Integer.parseInt(request.getParameter("birthmonth"));
		int birthday  = Integer.parseInt(request.getParameter("birthday"));
		String plefectures = request.getParameter("plefectures");
		String questionId = request.getParameter("question");
		String answer = request.getParameter("answer");
		
		String path = "";
		
		UserDao userdao = new UserDao();
		boolean useridflg = userdao.userIDcheck(userid);
		
		if(useridflg == false){
			request.setAttribute("msgflg","1");
			path = "WEB-INF/User_Registration.jsp";
			
		}else if(useridflg = true){
			UserBean userBean = new UserBean();
			userBean.setUserId(userid);
			userBean.setNickname(nickname);
			userBean.setGender(gender);
			userBean.setBirthYear(birthyear);
			userBean.setBirthMonth(birthmonth);
			userBean.setBirthDay(birthday);
			userBean.setPrefectures(plefectures);
			userBean.setQuestionId(questionId);
			userBean.setAnswer(answer);
			
			PassWordBean passBean = new PassWordBean();
			passBean.setUserid(userid);
			passBean.setPass(pass);
			
			HttpSession session = request.getSession();
			session.setAttribute("userBean",userBean);
			session.setAttribute("passBean",passBean);
			
			path = "WEB-INF/User_Registration_Confirmation.jsp";

		}
		
		//HashPassword hashPass = new HashPassword();
		//String encryptPass = hashPass.encryptPass(pass);
		
		//PassWordDao passDao = new PassWordDao();
		//passDao.registrationPassword(passBean);
		
		request.getRequestDispatcher(path).forward(request, response);
		
	}

}
