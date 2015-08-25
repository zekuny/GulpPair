

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
 * Servlet implementation class RestaurantServlet
 */           
@WebServlet("/RestaurantServlet")
public class RestaurantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Connection conn = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RestaurantServlet() {
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
		// TODO Auto-generated method stub
		int rid = Integer.parseInt(request.getParameter("rid"));
		ResultSet result = null;
		String table = "";
		String table2 = "";
		String table3 = "";
		
		// restaurant detail information
		try {
			result = DBOperation.getRestaurantDetailsByRID(rid, conn);
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			table += "<thead><tr><th>Name</th><th>Description</th><th>Address</th><th>Average Rating</th></tr></thead>";
			if(result.next()){
				table += "<tr><td>"+ result.getString("name")+"</td><td>"+result.getString("description")+"</td><td>" + result.getString("address") +
					    "</td><td>"+result.getString("AVG_RATING")+"</td></tr>\n";
				System.out.println("*********");
				System.out.println(result.getString("name") + result.getString("description"));
			}
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
		System.out.println(table);
		
		// get userID from session
		HttpSession session = request.getSession();
		String userID = (String) session.getAttribute("userID");
		int uid = Integer.parseInt(userID);
		try {
			result = DBOperation.getReviewByUserIDAndRID(uid, rid, conn);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		try {
			if(result.next()){
				table2 += "<h1>You have reviewed it before!!!</h1>";
				// a link
			}else{
				table2 += "<a href = \"addReview.jsp?rid=" + rid + "\">Add a new review</a>";
				
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
/*		else{
			try {	
				if(result.next()){
					// show user's review here
					table2 += "<thead><tr><th>User</th><th>Rating</th><th>Comments</th><th>Date</th></tr></thead>";
					table2 += "<tr><td>"+ result.getString("username")+"</td><td>"+ result.getString("rating")+"</td><td>"+result.getString("comments")+"</td><td>" + result.getString("reviewdate") +
						    "</td></tr>\n";
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
		
		
		// all reviews for this restaurant
		try {
			result = DBOperation.getRestaurantReviewsByRID(rid, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			table3 += "<thead><tr><th>User</th><th>Rating</th><th>Comments</th><th>Date</th></tr></thead>";
			while(result.next()){
				table3 += "<tr><td>"+ result.getString("username")+"</td><td>"+ result.getString("rating")+"</td><td>"+result.getString("comments")+"</td><td>" + result.getString("reviewdate") +
					    "</td></tr>\n";
			}
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		request.setAttribute("table", table); 
		request.setAttribute("table2", table2); 
		request.setAttribute("table3", table3); 
		getServletContext().getRequestDispatcher("/details.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
