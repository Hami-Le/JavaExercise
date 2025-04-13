import ex_quanlysinhvien.JDBCUtil;
import java.sql.*;
import java.util.*;

public class ClassDAO {
    public List<Class> getAllClasses() {
        List<Class> list = new ArrayList<>();
        try (Connection conn = JDBCUtil.getConnection()) {
            String sql = "SELECT * FROM class";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                list.add(new Class(
                    rs.getString("ClassID"),
                    rs.getString("description"),
                    rs.getInt("numberOfCredits")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}