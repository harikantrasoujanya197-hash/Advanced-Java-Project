package com.dao;

import java.sql.*;
import java.util.*;
import com.model.StudentMark;

public class MarkDAO {

    // ✅ CONNECTION METHOD (MISSING IN YOUR CODE)
	public Connection getConnection() throws Exception {

	    Class.forName("com.mysql.cj.jdbc.Driver");

	    System.out.println("DB CONNECT START");

	    Connection con = DriverManager.getConnection(
	        "jdbc:mysql://127.0.0.1:3306/markdb?useSSL=false&serverTimezone=UTC&connectTimeout=5000",
	        "root",
	        "Soujanya@@9029"
	    );

	    System.out.println("DB CONNECT DONE");

	    return con;
	}
    // ADD
    public void addMark(StudentMark sm) throws Exception {

        Connection con = getConnection();

        String sql = "INSERT INTO StudentMarks(studentName, subject, marks, examDate) VALUES (?, ?, ?, CURDATE())";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, sm.getStudentName());
        ps.setString(2, sm.getSubject());
        ps.setInt(3, sm.getMarks()); 
        

        ps.executeUpdate();

        ps.close();
        con.close();
    }

    // DISPLAY
    public List<StudentMark> getAllMarks() throws Exception {

        Connection con = getConnection();

        List<StudentMark> list = new ArrayList<>();

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM StudentMarks");

        while (rs.next()) {
            StudentMark sm = new StudentMark();
            sm.setStudentID(rs.getInt(1));
            sm.setStudentName(rs.getString(2));
            sm.setSubject(rs.getString(3));
            sm.setMarks(rs.getInt(4));
            sm.setExamDate(rs.getDate(5));

            list.add(sm);
        }

        rs.close();
        st.close();
        con.close();

        return list;
    }

    // DELETE
    public void deleteMark(int id) throws Exception {

        Connection con = getConnection();

        PreparedStatement ps = con.prepareStatement(
            "DELETE FROM StudentMarks WHERE StudentID=?"
        );

        ps.setInt(1, id);

        ps.executeUpdate();

        ps.close();
        con.close();
    }

    // UPDATE
    public int updateMark(int studentId, int marks) {

        int status = 0;

        try {
            Connection con = getConnection();

            String sql = "UPDATE StudentMarks SET Marks=? WHERE StudentID=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, marks);
            ps.setInt(2, studentId);

            status = ps.executeUpdate();

            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    // TEST METHOD (OPTIONAL)
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/markdb",
                "root",
                "Soujanya@@9029"
            );

            System.out.println("DATABASE CONNECTED SUCCESS");

        } catch (Exception e) {
            e.printStackTrace();
        
        }
        
    }
        public List<StudentMark> getStudentsAboveMarks(int marks) {

        List<StudentMark> list = new ArrayList<>();

        try {
            Connection con = getConnection();

            String sql = "SELECT * FROM StudentMarks WHERE Marks > ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, marks);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                StudentMark sm = new StudentMark();
                sm.setStudentID(rs.getInt(1));
                sm.setStudentName(rs.getString(2));
                sm.setSubject(rs.getString(3));
                sm.setMarks(rs.getInt(4));
                sm.setExamDate(rs.getDate(5));

                list.add(sm);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
    public List<StudentMark> getStudentsBySubject(String subject) {

        List<StudentMark> list = new ArrayList<>();

        try {
            Connection con = getConnection();

            String sql = "SELECT * FROM StudentMarks WHERE Subject=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, subject);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                StudentMark sm = new StudentMark();
                sm.setStudentID(rs.getInt(1));
                sm.setStudentName(rs.getString(2));
                sm.setSubject(rs.getString(3));
                sm.setMarks(rs.getInt(4));
                sm.setExamDate(rs.getDate(5));

                list.add(sm);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
    public List<StudentMark> getTopNStudents(int n) {

        List<StudentMark> list = new ArrayList<>();

        try {
            Connection con = getConnection();

            String sql = "SELECT * FROM StudentMarks ORDER BY Marks DESC LIMIT ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, n);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                StudentMark sm = new StudentMark();
                sm.setStudentID(rs.getInt(1));
                sm.setStudentName(rs.getString(2));
                sm.setSubject(rs.getString(3));
                sm.setMarks(rs.getInt(4));
                sm.setExamDate(rs.getDate(5));

                list.add(sm);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
