/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ex_quanlysinhvien;

import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import ex_quanlysinhvien.Student;

public class StudentDAO {
    public static StudentDAO getInstance() {
		return new StudentDAO();
	}

    public List<Student> findAll() {
            List<Student> StudentList = new ArrayList<>();
            try {
                    Connection conn = (Connection) JDBCUtil.getConnection();
                    String sql = "SELECT *  FROM student";
                    PreparedStatement sta = conn.prepareStatement(sql);
                    ResultSet res = sta.executeQuery(sql);

                    while (res.next()) {
                            Student stu = new Student(
                                            res.getString("StudentID"),
                                            res.getString("name"), 
                                            res.getInt("age"), 
                                            res.getString("email"),
                                            res.getFloat("gpa"));
                            StudentList.add(stu);
                    }
            } catch (SQLException ex) {
                    ex.printStackTrace();				
            }
            return StudentList;
    }
    
    public static int addStudent(Student stu) {
		int rowAffected=0;
		try {
			Connection con= JDBCUtil.getConnection();

			String sql = "INSERT INTO student(StudentID, name, age, email, gpa) VALUES(?, ?, ?, ?, ?)";
			PreparedStatement sta = con.prepareStatement(sql);

			sta.setString(1, stu.getId());
			sta.setString(2, stu.getName());
                        sta.setInt(3, stu.getAge());
                        sta.setString(4, stu.getEmail());
                        sta.setFloat(5, stu.getGpa());

			rowAffected = sta.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		
		}
		return rowAffected;
	}

    public Student getStudentByEmail(String email) throws SQLException, IOException {
        Connection conn = (Connection) JDBCUtil.getConnection();
        String sql = "SELECT * FROM Student WHERE email = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, email);
        ResultSet rs = ps.executeQuery();
        Student student = null;
        if (rs.next()) {
            student = new Student(
                rs.getString("StudentID"),
                rs.getString("name"),
                rs.getInt("age"),
                rs.getString("email"),
                rs.getFloat("gpa")
            );
        }
        conn.close();
        return student;
    }

    public String generateEmail(String fullName) {
        String[] parts = fullName.trim().toLowerCase().split("\\s+");
        StringBuilder email = new StringBuilder();

        if (parts.length == 0) {
            return "";
        }

        // Thêm toàn bộ phần tên (phần cuối)
        email.append(parts[parts.length - 1]);

        // Thêm chữ cái đầu của các phần còn lại (họ và tên đệm)
        for (int i = 0; i < parts.length - 1; i++) {
            email.append(parts[i].charAt(0));
        }

        // Thêm domain
        email.append("@vku.udn.vn");
        return email.toString();
    }




    
    public void addStudentToClass(int studentId, String classId) throws SQLException {
        Connection conn = JDBCUtil.getConnection();
        String sql = "INSERT INTO Learn (StudentID, ClassID) VALUES (?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, studentId);
        ps.setString(2, classId);
        ps.executeUpdate();
        conn.close();
    }

    public List<Student> getStudentsByClass(String classId) throws SQLException {
        List<Student> list = new ArrayList<>();
        Connection conn = JDBCUtil.getConnection();
        String sql = "SELECT s.* FROM Student s JOIN Learn l ON s.StudentID = l.StudentID WHERE l.ClassID = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, classId);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            list.add(new Student(
                    rs.getString("StudentID"),
                    rs.getString("name"),
                    rs.getInt("age"),
                    rs.getString("email"),
                    rs.getFloat("gpa")
            ));
        }
        conn.close();
        return list;
    }
}
