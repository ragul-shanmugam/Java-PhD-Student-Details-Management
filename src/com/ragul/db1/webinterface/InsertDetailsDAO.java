package com.ragul.db1.webinterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InsertDetailsDAO {

	private static DBConnection db;
	public static String stuid = null;

	public InsertDetailsDAO(DBConnection db) {
		this.db = db;
	}

	public static List<StudentDetails> studentDetailsList(String SFirstName, String SLastName, String SID, String SType,
			String Funding, String Section, String Scholarship, String StSem, String StYear, String InsID,
			String IFirstName, String ILastName, String IType) throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<StudentDetails> studentdetails = new ArrayList<StudentDetails>();
		StudentDetails details = new StudentDetails();
		String stu_selectquery = "SELECT StudentId FROM doctoral._phdstudent WHERE StudentId = '" + SID + "';";
		String stu_insertquery = "INSERT INTO `doctoral`.`_phdstudent` (`StudentId`, `FName`, `LName`, `StSem`, `StYear`, `Supervisor`)\r\n"
				+ "VALUES ('" + SID + "','" + SFirstName + "','" + SLastName + "','" + StSem + "','" + StYear + "','"
				+ InsID + "');";
		String sTypeGRA_insertquery = "INSERT INTO `doctoral`.`_gra` (`StudentId`,`Funding`,`MonthlyPay`) VALUES('"
				+ SID + "','" + Funding.toUpperCase() + "', 0);";
		String sTypeGTA_insertquery = "INSERT INTO `doctoral`.`_gta` (`SectionId`, `MonthlyPay`, `StudentId`) VALUES('"
				+ Section + "', 0,'" + SID + "');";
		String sTypeScholarship_insertquery = "INSERT INTO `doctoral`.`_scholarshipsupport` (`StudentId`, `Type`, `Source`) VALUES  ('"
				+ SID + "','" + Scholarship + "',' ');";
		String sTypeSelf_insertquery = "INSERT INTO `doctoral`.`_selfsupport` (`StudentId`) VALUES ('" + SID + "');";
		String ins_selectquery = "SELECT InstructorId FROM doctoral._instructor WHERE InstructorId = '" + InsID + "';";
		String ins_insertquery = "INSERT INTO `doctoral`.`_instructor` (`InstructorId`, `FName`, `LName`, `StartDate`, `Degree`, `Rank`, `Type`) VALUES ('"
				+ InsID + "','" + IFirstName + "','" + ILastName + "',' ',' ',' ','" + IType + "');";

		try {
			connection = db.getConnection();
			statement = connection.prepareStatement(stu_selectquery);
			// System.out.println("Printing Student Select query..." + stu_selectquery);
			resultSet = statement.executeQuery(stu_selectquery);
			if (resultSet.next() == false) {
				// System.out.println("Printing Instructor Select query..." + ins_selectquery);
				resultSet = statement.executeQuery(ins_selectquery);
				if (resultSet.next() == false) {
					// System.out.println("Printing Student Select query..." + ins_insertquery);
					int resultSet1 = statement.executeUpdate(ins_insertquery);
				}
				// System.out.println("Printing Insert Query..." + stu_insertquery);
				int resultSet2 = statement.executeUpdate(stu_insertquery);
				if (SType.equalsIgnoreCase("GRA")) {
					// System.out.println("Printing GRA Insert Query..." + sTypeGRA_insertquery);
					int resultSet3 = statement.executeUpdate(sTypeGRA_insertquery);
				}
				if (SType.equalsIgnoreCase("GTA")) {
					// System.out.println("Printing GTA Insert Query..." + sTypeGTA_insertquery);
					int resultSet4 = statement.executeUpdate(sTypeGTA_insertquery);
				}
				if (SType.equalsIgnoreCase("scholarship")) {
					// System.out.println("Printing Scholarship Insert Query..." +
					// sTypeScholarship_insertquery);
					int resultSet5 = statement.executeUpdate(sTypeScholarship_insertquery);
				}
				if (SType.equalsIgnoreCase("Self")) {
					// System.out.println("Printing Self Insert Query..." + sTypeSelf_insertquery);
					int resultSet6 = statement.executeUpdate(sTypeSelf_insertquery);
				}
				/*
				 * for (StudentDetails s : studentdetails) {
				 * System.out.println("Printing Student Details inside if...." +
				 * s.getStudentId()); }
				 */
				return studentdetails;
			} else {
				stuid = resultSet.getString(1);
				details.setStudentId(stuid);
				studentdetails.add(details);
				/*
				 * for (StudentDetails st : studentdetails) {
				 * System.out.println("Printing Student Details inside else....." +
				 * st.getStudentId()); }
				 */
				return studentdetails;
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

	}
}
