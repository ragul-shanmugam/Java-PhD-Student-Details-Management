package com.ragul.db1.webinterface;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InsertDetailsServlet
 */
@WebServlet("/InsertDetailsServlet")
public class InsertDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public String sID, sfirstName, slastName, sType, stSem, stYear, funding, section, scholarship;
	public String iID, iFName, iLName, iType;
	public InsertDetailsDAO insertDAO;

	public void init() throws ServletException {
		String url = "jdbc:mysql://localhost:3306/doctoral";
		String username = "root";
		String password = "******";
		DBConnection database = new DBConnection(url, username, password);
		this.insertDAO = new InsertDetailsDAO(database);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		sfirstName = request.getParameter("firstname");
		slastName = request.getParameter("lastname");
		sID = request.getParameter("sid");
		sType = request.getParameter("stype");
		funding = request.getParameter("ftype");
		section = request.getParameter("sectype");
		scholarship = request.getParameter("schtype");
		stSem = request.getParameter("stsem");
		stYear = request.getParameter("styear");

		iFName = request.getParameter("ifirstname");
		iLName = request.getParameter("ilastname");
		iID = request.getParameter("iid");
		iType = request.getParameter("itype");

		System.out.println(sfirstName);
		System.out.println(slastName);
		System.out.println(sID);
		System.out.println(sType);
		System.out.println(funding);
		System.out.println(section);
		System.out.println(scholarship);
		System.out.println(stSem);
		System.out.println(stYear);
		System.out.println(iFName);
		System.out.println(iLName);
		System.out.println(iID);
		System.out.println(iType);

		try {
			List<StudentDetails> studentdetails = InsertDetailsDAO.studentDetailsList(sfirstName, slastName, sID, sType,
					funding, section, scholarship, stSem, stYear, iID, iFName, iLName, iType);

			if (!studentdetails.isEmpty()) {
				request.setAttribute("studentexists", "Entered Student ID already exists in the System!" + "\n"
						+ "Please try again with different ID!!");
				request.getRequestDispatcher("/insert.jsp").forward(request, response);
			}
			request.setAttribute("success", "Hooray! You successfully inserted the student details!!");
			request.getRequestDispatcher("/successPage.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
