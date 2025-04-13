import model.Student;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import ex_quanlysinhvien.JDBCUtil;

public class StudentDAO {

    public void addStudent(Student s) {
        try (Connection conn = JDBCUtil.getConnection()) {
            String sql = "INSERT INTO student (StudentID, name, age, email) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, s.getStudentID());
            stmt.setString(2, s.getName());
            stmt.setInt(3, s.getAge());
            stmt.setString(4, s.getEmail());
            stmt.executeUpdate();
            System.out.println("✅ Thêm sinh viên thành công!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Student> getAllStudents() {
        List<Student> list = new ArrayList<>();
        try (Connection conn = JDBCUtil.getConnection()) {
            String sql = "SELECT * FROM student";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Student s = new Student(
                    rs.getString("StudentID"),
                    rs.getString("name"),
                    rs.getInt("age")
                );
                list.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void updateStudent(Student s) {
        try (Connection conn = JDBCUtil.getConnection()) {
            String sql = "UPDATE student SET name = ?, age = ?, email = ? WHERE StudentID = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, s.getName());
            stmt.setInt(2, s.getAge());
            stmt.setString(3, s.getEmail());
            stmt.setString(4, s.getStudentID());
            stmt.executeUpdate();
            System.out.println("✅ Cập nhật sinh viên thành công!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent(String studentID) {
        try (Connection conn = JDBCUtil.getConnection()) {
            String sql = "DELETE FROM student WHERE StudentID = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, studentID);
            stmt.executeUpdate();
            System.out.println("✅ Xóa sinh viên thành công!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Student findByEmail(String email) {
        try (Connection conn = JDBCUtil.getConnection()) {
            String sql = "SELECT * FROM student WHERE email = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Student(
                    rs.getString("StudentID"),
                    rs.getString("name"),
                    rs.getInt("age")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
