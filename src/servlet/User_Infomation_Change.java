package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.UserBean;

/**
 * Servlet implementation class User_Infomation_Change
 */
@WebServlet("/User_Infomation_Change")
public class User_Infomation_Change extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public User_Infomation_Change() {
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
		
		String nickname = request.getParameter("nickname");
		String gender = request.getParameter("gender");
		int birthyear = Integer.parseInt(request.getParameter("birthyear"));
		int birthmonth = Integer.parseInt(request.getParameter("birthmonth"));
		int birthday  = Integer.parseInt(request.getParameter("birthday"));
		String plefectures = request.getParameter("plefectures");
		String questionId = request.getParameter("question");
		String answer = request.getParameter("answer");
		
		String path = "";
		
		UserBean userBean = new UserBean();
		userBean.setNickname(nickname);
		userBean.setGender(gender);
		userBean.setBirthYear(birthyear);
		userBean.setBirthYear(birthmonth);
		userBean.setBirthYear(birthday);
		userBean.setPrefectures(plefectures);
		userBean.setQuestionId(questionId);
		userBean.setAnswer(answer);
		
		HttpSession session = request.getSession();
		session.setAttribute("userBean",userBean);
		
		path = "User_Change_Confirmation.jsp";
	
		}
		
	}

