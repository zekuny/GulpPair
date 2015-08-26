

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class updateServlet
 */
@WebServlet("/updateRestaurantServlet")
public class updateRestaurantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Connection conn = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateRestaurantServlet() {
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
		// TODO Auto-generated method stub
		if(request.getParameter("r_name") != null && !request.getParameter("r_name").isEmpty()){
			String r_name = request.getParameter("r_name");
			rid = Integer.parseInt(request.getParameter("rid"));
			try {
				DBOperation.updateRestaurantName(rid, r_name, conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		if(request.getParameter("address") != null && !request.getParameter("address").isEmpty()){
			String address = request.getParameter("address");
			rid = Integer.parseInt(request.getParameter("rid"));
			try {
				DBOperation.updateRestaurantAddress(rid, address, conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		String url = "/RestaurantServlet?rid=" + rid;
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
