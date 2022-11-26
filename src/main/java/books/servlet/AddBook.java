package books.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddBook
 */
@WebServlet("/AddBook")
public class AddBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String bookname = request.getParameter("bookname").trim();
		String bookgenre = request.getParameter("bookgenre").trim();
		
		Connection c = null;
		try {
			// SQL db connection details.
            String url = "";
            String username = "";
            String password = "";
			c = DriverManager.getConnection(url, username, password);
			
			String sql = "insert into books (bookname, bookgenre, bookvotes) values (?, ?, ?);";
			PreparedStatement stmt =c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, bookname);
			stmt.setString(2, bookgenre);
			stmt.setInt(3, 0);
			stmt.executeUpdate();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		} 
		finally {
			try {
				if (c != null)
					c.close();
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		response.sendRedirect("BookVotes");
	}
}
