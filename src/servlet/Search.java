package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ContentsDao;
import model.ContentsBean;

/**
 * Servlet implementation class Search
 */
@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cateid = request.getParameter("category");
		String keyword = request.getParameter("keyword");
		
		ArrayList<ContentsBean> arraySearch = new ArrayList<ContentsBean>();

		ContentsDao contentsdao = new ContentsDao();
		
		if(cateid.equals("0")){
			arraySearch = contentsdao.searchAllContents(keyword);
		}else{
			arraySearch = contentsdao.searchContents(keyword, cateid);
		}
		
		if(arraySearch.size() == 0){
			String notResult = "検索結果がありませんでした";
			request.setAttribute("notResult", notResult);
		}
		
		request.setAttribute("arraySearch", arraySearch);
		
		request.getRequestDispatcher("WEB-INF/Search_Result.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
