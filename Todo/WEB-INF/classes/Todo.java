import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
//import javax.servlet.RequestDispatcher;

import java.sql.*;

import java.util.*;

public class Todo extends HttpServlet {

	private static final long serialVersionUID = 1L;

	ResultSet rs;


	public void doPost(HttpServletRequest req, HttpServletResponse res) {

		res.setContentType("text/html");

		PrintWriter out = null;
		List<String> list = new ArrayList<>();
		//RequestDispatcher rd = null;

		rs = SaveTodo.getResultset();
		try {
			while (rs.next()) {
				list.add(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try{

			out = res.getWriter();

			out.println("<html><body>");
			out.println("<link rel='stylesheet' href='main.css'>");
			out.println("<form action='s2' id='form'>");
			out.println("<label>Add Something</label><input type='text' name='todo'><input type='submit' name='add' value='Add'><input type='reset' value='Clear'>");
			out.println("</form>");


			//List<String> list= TodoProcess.list;
			out.print("<table width='80%' align='center' border='2'");
			out.print("<tr><th>Todo List </th><th>Delete List</th></tr>");

			for(String s: list) {
				out.println("<tr><td><ul>"+ s +"</ul></td><td><a href='s3?id="+s+"'>Delete</a></td></tr>"); 
			}

			out.print("</table>");

			out.println("</html></body>");

			//list.clear();
			

		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void doGet(HttpServletRequest req, HttpServletResponse res) {
		doPost(req, res);
	}
}