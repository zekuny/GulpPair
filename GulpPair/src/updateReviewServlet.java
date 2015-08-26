

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
 * Servlet implementation class updateServlet
 */
@WebServlet("/updateReviewServlet")
public class updateReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Connection conn = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateReviewServlet() {
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
		int rid = 0;
		System.out.println("I'm here");
		// TODO Auto-generated method stub
		if(request.getParameter("rating") != null && !request.getParameter("rating").isEmpty() && request.getParameter("comment") != null && !request.getParameter("comment").isEmpty()){
			String rating = request.getParameter("rating");
			String comment = request.getParameter("comment");
			double rating_d = Double.parseDouble(rating);
			rid = Integer.parseInt(request.getParameter("rid"));
			HttpSession session = request.getSession();
			String userID = (String) session.getAttribute("userID");
			int uid = Integer.parseInt(userID);
			try {
				DBOperation.updateReviews(uid, rid, rating_d, comment, conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

		getServletContext().getRequestDispatcher("/ProfileServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
