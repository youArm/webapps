package servlet;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import dao.ContentsDao;
import dao.ContentsDetailsDao;
import model.UserBean;

/**
 * Servlet implementation class Content_Registration
 */
@WebServlet("/Content_Registration")
@MultipartConfig(maxFileSize = 2097152)
public class Content_Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Content_Registration() {
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
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		UserBean user = (UserBean)session.getAttribute("userBean");


		/**
		 * コンテンツの件数をとってくるcount*　contentsdaoに書く
		 * 件数＋１→コンテンツIDとして登録
		 *
		 */

		String conname = request.getParameter("conname");
		String ans1 = request.getParameter("ans1");
		Part ansImage1 = request.getPart("ansImage1");
		String ans2 = request.getParameter("ans2");
		Part ansImage2 = request.getPart("ansImage2");
		String ans3 = request.getParameter("ans3");
		Part ansImage3 = request.getPart("ansImage3");
		String ans4 = request.getParameter("ans4");
		Part ansImage4 = request.getPart("ansImage4");
		String catename = request.getParameter("catename");

		String date = request.getParameter("date");

		String path = "";

		SimpleDateFormat cd = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = new Date();
		String createDate = cd.format(date1);

		ArrayList<Part> arrayImage = new ArrayList<Part>();
		arrayImage.add(ansImage1);
		arrayImage.add(ansImage2);
		arrayImage.add(ansImage3);
		arrayImage.add(ansImage4);

		ArrayList<String> detailsName = new ArrayList<String>();
		detailsName.add(ans1);
		detailsName.add(ans2);
		detailsName.add(ans3);
		detailsName.add(ans4);

		ContentsDao contentsdao = new ContentsDao();
		ContentsDetailsDao contentsdetailsdao = new ContentsDetailsDao();

		//コンテンツの件数に＋１する。
		//contents登録
		int contentsCount = contentsdao.countContents() + 1;
		String contentsId = String.valueOf(contentsCount);

		contentsdao.registrationContents(user.getUserId(), catename,conname, date, contentsId, createDate);

		//details登録
		for (int i = 0; i < 4; i++) {
			String detailName = detailsName.get(i);
			Part image = arrayImage.get(i);

			if (detailName != null && !detailName.equals("")) {
				String serialNumber = String.valueOf(i+1);

				String imagePathURL = null;
				if (image != null) {
					String imageName = contentsId+"_"+serialNumber+".png";
					String imagePathReal = request.getServletContext().getRealPath("/media")+File.separator+imageName;
					image.write(imagePathReal);
					
					imagePathURL  = "/media/"+imageName;
				}

				contentsdetailsdao.contentsDetails(contentsId, serialNumber, detailName, imagePathURL);
			}
		}

		path = "WEB-INF/Content_Registration_Complete.jsp";

		request.getRequestDispatcher(path).forward(request, response);

	}

}
