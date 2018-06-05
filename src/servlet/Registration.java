package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
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
		
		boolean useridflg = true;
		String path = "";
		
		UserDao userdao = new UserDao();
		useridflg = userdao.userIDcheck(userid);
		
		if(useridflg == false){
			request.setAttribute("msgflg","1");
			path = "Registration.jsp";
			
		}else if(useridflg = true){
			UserBean userBean = new UserBean();
			userBean.setUserId(userid);
			userBean.setNickname(nickname);
			userBean.setGender(gender);
			userBean.setBirthYear(birthyear);
			userBean.setBirthYear(birthmonth);
			userBean.setBirthYear(birthday);
			userBean.setPrefectures(plefectures);
			userBean.setQuestionId(questionId);
			userBean.setAnswer(answer);
			
			PassWordBean passBean = new PassWordBean();
			passBean.setUserid(userid);
			passBean.setPass(pass);
			
			request.setAttribute("userbean",userBean);
			request.setAttribute("passbean",passBean);
			
			path = "Registration_Confirmation.jsp";

		}
		
		//HashPassword hashPass = new HashPassword();
		//String encryptPass = hashPass.encryptPass(pass);
		
		//PassWordDao passDao = new PassWordDao();
		//passDao.registrationPassword(passBean);
		
		request.getRequestDispatcher(path).forward(request, response);
		
	}

}
