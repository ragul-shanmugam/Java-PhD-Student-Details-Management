package com.ragul.db1.webinterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RetrieveDetailsDAO {

	private static DBConnection db;
	public String Firstname, Lastname;
	public static String StudentId;
	public static String insFirstName;
	public static String insLastName;
	public static String StudentType;
	public static String gra, gta, scholarship, selfsupport, cname, passedate;

	public RetrieveDetailsDAO(DBConnection db) {
		this.db = db;
	}

	public static List<StudentDetails> studentDetailsList(String FirstName, String LastName) throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<StudentDetails> studentdetails = new ArrayList<StudentDetails>();
		String query = "select S.StudentId, I.FName, I.LName, G.Funding, GT.SectionId, SS.Type, SSP.StudentId, M.Mname, MP.PassDate\r\n"
				+ "from doctoral._phdstudent S\r\n"
				+ "left join doctoral._instructor I on S.Supervisor = I.InstructorId\r\n"
				+ "left join doctoral._gra G on S.StudentId = G.StudentId\r\n"
				+ "left join doctoral._gta GT on S.StudentId = GT.StudentId\r\n"
				+ "left join doctoral._scholarshipsupport SS on S.StudentId = SS.StudentId\r\n"
				+ "left join doctoral._selfsupport SSP on S.StudentId = SSP.StudentId\r\n"
				+ "left join doctoral._milestonespassed MP on S.StudentId = MP.StudentId\r\n"
				+ "left join doctoral._milestone M on MP.Mname = M.MID\r\n" + "where S.FName = '" + FirstName
				+ "' and S.LName = '" + LastName + "';";

		try {
			connection = db.getConnection();
			statement = connection.prepareStatement(query);
			//System.out.println("Printing query..." + query);
			resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				StudentId = resultSet.getString(1);
				insFirstName = resultSet.getString(2);
				insLastName = resultSet.getString(3);
				gra = resultSet.getString(4);
				gta = resultSet.getString(5);
				scholarship = resultSet.getString(6);
				selfsupport = resultSet.getString(7);
				cname = resultSet.getString(8);
				passedate = resultSet.getString(9);

				StudentDetails details = new StudentDetails();

				if (StudentId != null)
					details.setStudentId(StudentId);

				if (insFirstName != null && insLastName != null)
					details.setInsFirstName(insFirstName);
					details.setInsLastName(insLastName);

				if (gra != null && gta == null && scholarship == null && selfsupport == null)
					details.setStudentType("GRA");

				if (gra == null && gta != null && scholarship == null && selfsupport == null)
					details.setStudentType("GTA");

				if (gra == null && gta == null && scholarship != null && selfsupport == null)
					details.setStudentType("Scholarship Support");

				if (gra == null && gta == null && scholarship == null && selfsupport != null)
					details.setStudentType("Self Support");

				if (cname != null && passedate != null)
					details.setCname(cname);
					details.setPassdate(passedate);

				studentdetails.add(details);
			}
		} finally {
			if (resultSet != null)
				try {
					resultSet.close();
				} catch (SQLException logOrIgnore) {
				}
			if (statement != null)
				try {
					statement.close();
				} catch (SQLException logOrIgnore) {
				}
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException logOrIgnore) {
				}
		}
		return studentdetails;
	}
}
