

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
 * Servlet implementation class ProfileServlet
 */
@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet { 
	private static final long serialVersionUID = 1L;
	private static Connection conn = null;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileServlet() {
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
		System.out.println("Hello World");
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String userID = (String) session.getAttribute("userID");
		ResultSet result = null;
		String table = "";
		String table2 = "";
		String tableEdit = "";
		table += "<thead><tr><th>UserID</th><th>Username</th><th>Zipcode</th><th>Email</th><th>Password</th><th>Edit</th></tr></thead>";
		try {
			result = DBOperation.getProfile(userID, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while(result.next()){
				
				table += "<tr><td>"+result.getString("USERID")+"</td><td>"+result.getString("USERNAME")+"</td><td>"+result.getString("ZIPCODE")+"</td><td>"+result.getString("EMAIL")+"</td><td>"+result.getString("password")+"</td><td><a href = \"EditProfile.jsp?uid=" + userID + "\"><button>Edit</button></a></td></tr>\n";
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//tableEdit += "<a href = \"EditProfile.jsp?uid=" + userID + "\">Update Profile</a>";
		
		
		
		
		// all reviews by userID
		try {
			result = DBOperation.getReviewsByUserID(userID, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(result != null){
			table2 += "<thead><tr><th>Restaurant Name:</th><th>Rating</th><th>Review</th><th>Edit</th></tr></thead>";
			try {
				while(result.next()){
					int rid = Integer.parseInt(result.getString("r_id"));
					table2 += "<tr><td>"+result.getString("name")+"</td><td>"+result.getString("RATING")+"</td><td>"+result.getString("COMMENTS")+"</td><td><a href = \"EditReview.jsp?rid=" + rid + "\"><button>Edit</button></a></td></tr>\n";
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			table2 += "<h2>You don't have any review!</2>";
		}
		request.setAttribute("table", table); 
		request.setAttribute("table2", table2); 
		//request.setAttribute("tableEdit", tableEdit);
		getServletContext().getRequestDispatcher("/profile.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
