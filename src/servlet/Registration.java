package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
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
		
		UserBean userbean = new UserBean();
		userbean.setUserId(userid);
		userbean.setNickname(nickname);
		userbean.setGender(gender);
		userbean.setBirthYear(birthyear);
		userbean.setBirthYear(birthmonth);
		userbean.setBirthYear(birthday);
		userbean.setPrefectures(plefectures);
		userbean.setQuestionId(questionId);
		userbean.setAnswer(answer);
		
		UserDao userdao = new UserDao();
		userdao.registrationUser(userbean);
		
		HashPassword hashPass = new HashPassword();
		String encryptPass = hashPass.encryptPass(pass);
		
		PassWordBean passBean = new PassWordBean();
		passBean.setUserid(userid);
		passBean.setPass(encryptPass);
		
		PassWordDao passDao = new PassWordDao();
		passDao.registrationPassword(passBean);
		
		request.getRequestDispatcher("Registration_Confirmation.jsp").forward(request, response);
		
	}

}
