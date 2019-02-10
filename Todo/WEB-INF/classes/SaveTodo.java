import java.sql.*;


public class SaveTodo {

	private static Connection con;
	public static ResultSet rs;

	static {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "admin");

		} catch(Exception e) {
			e.printStackTrace();
		}

	}

	public static void insert(String s){

		try{
			Statement st2 = con.createStatement();
			st2.executeUpdate("insert into todo1 values  ('"+ s +"')");
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}


	public static ResultSet getResultset() {
		try {
			Statement st1 = con.createStatement();
			rs = st1.executeQuery("select * from todo1");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return rs;

	}

	public static void delete(String s) {
		try {
			Statement st = con.createStatement();
			st.executeUpdate("delete from todo1 where TODO_TEXT = '"+s+"'");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}