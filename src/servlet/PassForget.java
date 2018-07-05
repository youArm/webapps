package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import model.UserBean;

/**
 * Servlet implementation class PassForget
 */
@WebServlet("/PassForget")
public class PassForget extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PassForget() {
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
		String questionNo = request.getParameter("question");
		String answer = request.getParameter("answer");
		
		String path="";
		
		UserDao userdao = new UserDao();
		UserBean userBean = new UserBean();
		userBean = userdao.getUser(userid);
		
		if(questionNo.equals(userBean.getQuestionId())){
			if(answer.equals(userBean.getAnswer())){
				request.setAttribute("userid", userid);
				path = "WEB-INF/RePass.jsp";
			}
			else{
				path="WEB-INF/Pass_Forget.jsp";
				request.setAttribute("msg", "質問か答えが一致しません");
			}
		}else{
			path="WEB-INF/Pass_Forget.jsp";
			request.setAttribute("msg", "質問か答えが一致しません");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
	}

}
