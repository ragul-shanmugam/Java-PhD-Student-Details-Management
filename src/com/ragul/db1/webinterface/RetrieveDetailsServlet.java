package com.ragul.db1.webinterface;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RetrieveDetails
 */
@WebServlet("/RetrieveDetailsServlet")
public class RetrieveDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public String firstName, lastName;
	private RetrieveDetailsDAO retrieveDAO;

	public void init() throws ServletException {
		String url = "jdbc:mysql://localhost:3306/doctoral";
		String username = "root";
		String password = "********";
		DBConnection database = new DBConnection(url, username, password);
		this.retrieveDAO = new RetrieveDetailsDAO(database);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		firstName = request.getParameter("firstname");
		lastName = request.getParameter("lastname");

		try {
			List<StudentDetails> studentdetails = RetrieveDetailsDAO.studentDetailsList(firstName, lastName);

			if (studentdetails == null || studentdetails.isEmpty()) {
				request.setAttribute("emptylist",
						"The details of the Student does't exist in the system! Please try another student!!");
				request.getRequestDispatcher("/errorPage.jsp").forward(request, response);
				return;
			}

			for (StudentDetails i : studentdetails) {
				System.out.println(i.getInsFirstName());
				System.out.println(i.getInsLastName());
				System.out.println(i.getStudentType());
				System.out.println(i.getCname());
				System.out.println(i.getPassdate());
			}

			request.setAttribute("lname", lastName);
			request.setAttribute("fname", firstName);
			request.setAttribute("studentdetails", studentdetails);
			request.getRequestDispatcher("/retrieveResult.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
