

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
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
@WebServlet("/commentReviewServlet")
public class commentReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Connection conn = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public commentReviewServlet() {
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
		String rid = request.getParameter("rid");
		String reid = request.getParameter("reid");
		int re_id = Integer.parseInt(reid);
		String table = "<table class=\"table table-striped\">";
		ResultSet result = null;
		// restaurant detail information
		try {
			result = DBOperation.getAllCommentsByREID(re_id, conn);
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			table += "<thead><tr><th>Comment</th></tr></thead>";
			while(result.next()){
				table += "<tr><td>"+ result.getString("comments")+"</td></tr>\n";
				//System.out.println("*********");
			}
			System.out.println(table);
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
		table += "</table><br><form class=\"form-horizontal\" role=\"form\" action=\"addCommentServlet\" method=\"post\">" +
			"<div class=\"form-group\">" +
				"<label class=\"control-label col-sm-5\" for=\"class\">Comments:</label>" +
				"<div class=\"col-sm-5\">" +
					"<input type=\"text\" class=\"form-control\" id=\"comments\" name=\"comments\">" +
					"<input type=\"hidden\" class=\"form-control\" id=\"reid\" name=\"reid\" value=\"" + re_id + "\">" +
					"<input type=\"hidden\" class=\"form-control\" id=\"rid\" name=\"rid\" value=\"" + rid + "\">" +
				"</div>" +
			"</div>" +

			"<div class=\"form-group\">" +
				"<div class=\"col-sm-offset-2 col-sm-5\">" +
					"<center>" +
						"<button type=\"submit\" class=\"btn btn-primary btn-lg btn-block\" value=\"addView\">Comment on this one now!!!</button>" +
					"</center>" +
				"</div>" +
			"</div>" +
		"</form>";
		
		table += "<h2><a href = \"RestaurantServlet?rid=" + rid + "\">Return</a></h2>";
		request.setAttribute("table", table); 
		getServletContext().getRequestDispatcher("/commentReview.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
