
import dao.StudentDAO;
import model.Student;


public class AuthService {
    private Student currentStudent;
    private StudentDAO dao = new StudentDAO();
    
    public boolean login(String email) {
        Student s = dao.findByEmail(email);
        if (s != null) {
            currentStudent = s;
            return true;
        }
        return false;
    }

    public void logout() {
        currentStudent = null;
    }

    public Student getCurrentStudent() {
        return currentStudent;
    }
}
