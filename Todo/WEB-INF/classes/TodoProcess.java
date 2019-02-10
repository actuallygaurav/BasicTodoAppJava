import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;

public class TodoProcess extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public static List<String> list;

	public static ResultSet rs;

	public void doGet(HttpServletRequest req, HttpServletResponse res) {

		res.setContentType("text/html");

		PrintWriter out = null;
		RequestDispatcher rd = null;

		try{

			out = res.getWriter();

			String todoText = req.getParameter("todo").trim();

			// list = 

			if(todoText == null || todoText.equals("")) {
				rd = req.getRequestDispatcher("s1");
				out.println("Enter something");
				rd.include(req, res);
				
			}else {
				SaveTodo.insert(todoText);
				// new Todo().load();

				// rd = req.getRequestDispatcher("s1");
				// rd.forward(req, res);
				res.sendRedirect("s1");
				//new Todo().doPost(req, res);
			}
			

			//res.sendRedirect("s1");


			

		}catch(IOException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res) {
		doGet(req, res);
	}
}