package tutorial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MainClass {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/books", "root", "mlodasuka");
			PreparedStatement statement = con.prepareStatement("select name, title from book, authors where book.authorid = authors.authorid and authors.authorid = 1");
			ResultSet result = statement.executeQuery();
			while(result.next()){
				System.out.println(result.getString(1) + " " + result.getString(2));
//				System.out.println(result.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	

	}

}
