package books.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.BookEntry;

/**
 * Servlet implementation class BookVotes
 */
@WebServlet("/BookVotes")
public class BookVotes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookVotes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<BookEntry> bkEntries = new ArrayList<BookEntry>();
		
		Connection c = null;
		try {
			// SQL db connection details.
            String url = "";
            String username = "";
            String password = "";
			
			c = DriverManager.getConnection(url, username, password);
			Statement stmt = c.createStatement();
			ResultSet bk = stmt.executeQuery("select * from books order by BookVotes DESC;");

			while (bk.next()) {
				bkEntries.add(new BookEntry(bk.getInt("bookid"), bk.getString("bookname"), bk.getString("bookgenre"), bk.getInt("bookvotes")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (c != null)
					c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		request.setAttribute("bkEntries", bkEntries);
		request.getRequestDispatcher("BookVotes.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
