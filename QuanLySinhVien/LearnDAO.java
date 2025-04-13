import ex_quanlysinhvien.JDBCUtil;
import java.sql.*;
import java.util.*;

public class LearnDAO {
    public void addStudentToClass(String studentID, String classID) {
        try (Connection conn = JDBCUtil.getConnection()) {
            String sql = "INSERT INTO learn (StudentID, ClassID) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, studentID);
            stmt.setString(2, classID);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<String> getStudentsByClass(String classID) {
        List<String> list = new ArrayList<>();
        try (Connection conn = JDBCUtil.getConnection()) {
            String sql = "SELECT s.* FROM student s JOIN learn l ON s.StudentID = l.StudentID WHERE l.ClassID = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, classID);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                list.add(rs.getString("StudentID") + " | " + rs.getString("name") + " | " + rs.getInt("age") + " | " + rs.getString("email"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
