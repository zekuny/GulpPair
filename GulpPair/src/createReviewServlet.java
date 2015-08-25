

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class createReviewServlet
 */
@WebServlet("/createReviewServlet")
public class createReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Connection conn = null;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public createReviewServlet() {
        super();
        // TODO Auto-generated constructor stub
        try {
			conn = DBConnection.connectDB();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("oooooooooooooooo");
		// TODO Auto-generated method stub
		String rid = request.getParameter("rid");
		String rating = request.getParameter("rating");
		String comments = request.getParameter("comments");
		String reviewdate = request.getParameter("reviewdate");
		HttpSession session = request.getSession();
		String userID = (String) session.getAttribute("userID");
		int uid = Integer.parseInt(userID);
		try {
			DBOperation.setReview(uid, Integer.parseInt(rid), Double.parseDouble(rating), comments, reviewdate, conn);
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("-----------------------------");
		/*String url = "/restaurants.jsp?rid=" + rid;
		getServletContext().getRequestDispatcher(url).forward(request, response);*/
		
		getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
