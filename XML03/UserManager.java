import java.util.ArrayList;
import java.util.List;
import org.mindrot.jbcrypt.BCrypt;

public class UserManager {
    private List<User> userList;

    public UserManager() {
        userList = new ArrayList<>();
    }

    public boolean registerUser(String username, String plainPassword) {
        if (findUserByUsername(username) != null) {
            return false; // Username đã tồn tại
        }
        String hashed = BCrypt.hashpw(plainPassword, BCrypt.gensalt());
        User user = new User(username, hashed);
        userList.add(user);
        return true;
    }

    public boolean loginUser(String username, String plainPassword) {
        User user = findUserByUsername(username);
        if (user == null) {
            return false;
        }
        return BCrypt.checkpw(plainPassword, user.getPasswordHash());
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> list) {
        this.userList = list;
    }

    private User findUserByUsername(String username) {
        for (User user : userList) {
            if (user.getUsername().equalsIgnoreCase(username)) {
                return user;
            }
        }
        return null;
    }
}
