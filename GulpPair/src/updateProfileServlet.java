

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
@WebServlet("/updateProfileServlet")
public class updateProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Connection conn = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateProfileServlet() {
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
		HttpSession session = request.getSession();
		String uid = (String) session.getAttribute("userID");
		int u_id = Integer.parseInt(uid);
		// TODO Auto-generated method stub
		if(request.getParameter("u_name") != null && !request.getParameter("u_name").isEmpty()){
			String u_name = request.getParameter("u_name");
			try {
				DBOperation.updateUserUsername(u_id, u_name, conn);
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
