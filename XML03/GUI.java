import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.List;

public class GUI extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JTextArea outputArea;

    private UserManager userManager;

    public GUI() {
        setTitle("User Manager");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);

        userManager = new UserManager();

        JPanel panel = new JPanel(new GridLayout(7, 1, 10, 10));

        usernameField = new JTextField();
        passwordField = new JPasswordField();
        JButton registerButton = new JButton("Đăng ký");
        JButton loginButton = new JButton("Đăng nhập");
        JButton exportButton = new JButton("Xuất XML");
        JButton importButton = new JButton("Nhập XML");
        outputArea = new JTextArea();
        outputArea.setEditable(false);

        panel.add(new JLabel("Tên đăng nhập:"));
        panel.add(usernameField);
        panel.add(new JLabel("Mật khẩu:"));
        panel.add(passwordField);
        panel.add(registerButton);
        panel.add(loginButton);
        panel.add(exportButton);
        panel.add(importButton);

        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);

        // Action: Đăng ký
        registerButton.addActionListener(e -> {
            String user = usernameField.getText();
            String pass = new String(passwordField.getPassword());

            if (user.isEmpty() || pass.isEmpty()) {
                showMessage("Vui lòng nhập đủ thông tin.");
                return;
            }

            boolean success = userManager.registerUser(user, pass);
            showMessage(success ? "Đăng ký thành công!" : "Tên đăng nhập đã tồn tại.");
        });

        // Action: Đăng nhập
        loginButton.addActionListener(e -> {
            String user = usernameField.getText();
            String pass = new String(passwordField.getPassword());

            boolean success = userManager.loginUser(user, pass);
            showMessage(success ? "Đăng nhập thành công!" : "Sai thông tin đăng nhập.");
        });

        // Action: Xuất XML
        exportButton.addActionListener(e -> {
            JFileChooser fc = new JFileChooser();
            if (fc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                XMLHandler.exportUsersToXML(userManager.getUserList(), file.getAbsolutePath());
                showMessage("Đã xuất user ra file XML.");
            }
        });

        // Action: Nhập XML
        importButton.addActionListener(e -> {
            JFileChooser fc = new JFileChooser();
            if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                try {
                    List<User> imported = XMLHandler.importUsersFromXML(file.getAbsolutePath());
                    userManager.setUserList(imported);
                    showMessage("Đã nhập file XML thành công!");
                    displayUserList(imported);
                } catch (Exception ex) {
                    showMessage("Lỗi: " + ex.getMessage());
                }
            }
        });
    }

    private void showMessage(String msg) {
        JOptionPane.showMessageDialog(this, msg);
    }

    private void displayUserList(List<User> users) {
        StringBuilder sb = new StringBuilder("Danh sách người dùng:\n");
        for (User u : users) {
            sb.append("- ").append(u.getUsername()).append("\n");
        }
        outputArea.setText(sb.toString());
    }

    public static void main(String[] args) {
        try {
             UIManager.setLookAndFeel(
                UIManager.getSystemLookAndFeelClassName());
        } catch(Exception e){
            
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }
}
