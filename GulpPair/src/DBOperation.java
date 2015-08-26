import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBOperation {
	// check if the user is already in the database 
	public static String[] checkUser(String email, String password, Connection conn) throws SQLException{
		String sql = "select username, userid from users where email = '" + email + "' and \"password\" = '" + password + "'";
		PreparedStatement preStatement = conn.prepareStatement(sql);
		ResultSet result = preStatement.executeQuery();
		String[] strs = new String[2];
		if(result.next()){
			strs[0] = result.getString("username");
			strs[1] = result.getString("userid");
		}
		return strs;
	}
	
	public static String getUserID(String email, String password, Connection conn) throws SQLException{
		String sql = "select userid from users where email = '" + email + "' and \"password\" = '" + password + "'";
		PreparedStatement preStatement = conn.prepareStatement(sql);
		ResultSet result = preStatement.executeQuery();
		if(result.next()){
			return result.getString("userid");
		}else{
			return null;
		}
	}
	

	
	public static ResultSet getProfile(String userID, Connection conn) throws SQLException{
		int uid = Integer.parseInt(userID);
		String sql = "select * from users where userid = " + uid;
		PreparedStatement preStatement = conn.prepareStatement(sql);
		ResultSet result = preStatement.executeQuery();
		return result;
	}
	
	public static void addUser(String username, String email, String password, String zipcode, Connection conn) throws SQLException{
		String sql = "insert into users (username, email, \"password\", zipcode) values ('" + username + "', '" + email + "', '" + password + "', '" + zipcode + "')";
		System.out.println(sql);
		PreparedStatement preStatement = conn.prepareStatement(sql);
		preStatement.executeQuery();
	}
	
	public static ResultSet getReviewsByUserID(String userID, Connection conn) throws SQLException{
		int uid = Integer.parseInt(userID);
		String sql = "select rs.r_id, re.rating, re.comments, rs.\"name\" from reviews re, restaurants rs where re.r_id = rs.r_id and userID = " + uid;
		System.out.println(sql);
		PreparedStatement preStatement = conn.prepareStatement(sql);
		ResultSet result = preStatement.executeQuery();
		return result;
	}
	
	public static ResultSet getAllRestaurants(Connection conn) throws SQLException{
		String sql = "select * from restaurants";
		System.out.println(sql);
		PreparedStatement preStatement = conn.prepareStatement(sql);
		ResultSet result = preStatement.executeQuery();
		return result;
	}
	
	public static ResultSet getRestaurantReviewsByRID(int rid, Connection conn) throws SQLException{
		String sql = "select rating, comments, reviewdate, username from reviews" + 
						" left outer join users" + 
						" on users.userID = reviews.userID" +
						" where r_id = " + rid;
		System.out.println(sql);
		PreparedStatement preStatement = conn.prepareStatement(sql);
		ResultSet result = preStatement.executeQuery();
		return result;
	}
	
	public static ResultSet getRestaurantDetailsByRID(int rid, Connection conn) throws SQLException{
		String sql = "select * from restaurants where r_id = " + rid;
		System.out.println(sql);
		PreparedStatement preStatement = conn.prepareStatement(sql);
		ResultSet result = preStatement.executeQuery();
		return result;
	}
	
	public static ResultSet getReviewByUserIDAndRID(int uid, int rid, Connection conn) throws SQLException{
		String sql = "select * from reviews where r_id = " + rid + " and userID = " + uid;
		System.out.println(sql);
		PreparedStatement preStatement = conn.prepareStatement(sql);
		ResultSet result = preStatement.executeQuery();
		return result;
	}

	public static void setReview(int uid, int rid, double rating, String comments, String date, Connection conn) throws SQLException{
		String sql = "insert into reviews values (" + uid + ", " + rid + ", " + rating + ", '" + comments + "', '" + date + "')";
		System.out.println(sql);
		PreparedStatement preStatement = conn.prepareStatement(sql);
		preStatement.executeQuery();
		updateAVGRating(rid, conn);
	}	
	

	
	public static void updateAVGRating(int rid, Connection conn) throws SQLException{
		String sql = "select rating from reviews where r_id= " + rid;
		System.out.println(sql);
		PreparedStatement preStatement = conn.prepareStatement(sql);
		ResultSet result = preStatement.executeQuery();
		double newAVG = 0.0;
		int count = 0;
		while(result.next()){
			newAVG += Double.parseDouble(result.getString("rating"));
			count++;
		}
		double avg = newAVG / count;
		sql = "update restaurants set AVG_Rating = " + avg + " where r_id = " + rid;
		preStatement = conn.prepareStatement(sql);
		preStatement.executeQuery();
	}
	
	public static void updateRestaurantName(int rid, String r_name, Connection conn) throws SQLException{
		String sql = "update restaurants set \"name\" = '" + r_name + "' where r_id = " + rid;
		System.out.println(sql);
		PreparedStatement preStatement = conn.prepareStatement(sql);
		preStatement.executeQuery();
	}
	
	public static void updateRestaurantAddress(int rid, String address, Connection conn) throws SQLException{
		String sql = "update restaurants set address = '" + address + "' where r_id = " + rid;
		System.out.println(sql);
		PreparedStatement preStatement = conn.prepareStatement(sql);
		preStatement.executeQuery();
	}
	
	public static void updateUserUsername(int uid, String username, Connection conn) throws SQLException{
		String sql = "update users set username = '" + username + "' where userID = " + uid;
		System.out.println(sql);
		PreparedStatement preStatement = conn.prepareStatement(sql);
		preStatement.executeQuery();
	}
	
	public static void updateReviews(int uid, int rid, double rating, String review, Connection conn) throws SQLException{
		String sql = "update reviews set rating = " + rating + ", comments = '" + review + "' where userID = " + uid + " and r_id = " + rid;
		System.out.println(sql);
		PreparedStatement preStatement = conn.prepareStatement(sql);
		preStatement.executeQuery();
	}
	
	
}
