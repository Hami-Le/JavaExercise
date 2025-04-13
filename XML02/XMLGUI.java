package xmlcrud;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class XMLGUI extends JFrame {
    private JTextField txtId, txtName;
    private JTextArea textArea;

    public XMLGUI() {
        setTitle("XML CRUD App");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        txtId = new JTextField(10);
        txtName = new JTextField(10);
        JButton btnAdd = new JButton("Thêm");
        JButton btnUpdate = new JButton("Sửa");
        JButton btnDelete = new JButton("Xóa");
        JButton btnDisplay = new JButton("Hiển thị");
        JButton btnMerge = new JButton("Ghép XML");

        textArea = new JTextArea(20, 40);
        textArea.setEditable(false);

        add(new JLabel("ID:"));
        add(txtId);
        add(new JLabel("Tên:"));
        add(txtName);
        add(btnAdd);
        add(btnUpdate);
        add(btnDelete);
        add(btnDisplay);
        add(btnMerge);
        add(new JScrollPane(textArea));

        try {
            XMLHandler.createXMLFile();
        } catch (Exception e) {
            e.printStackTrace();
        }

        btnAdd.addActionListener(e -> {
            try {
                XMLHandler.addStudent(txtId.getText(), txtName.getText());
                textArea.append("Đã thêm.\n");
            } catch (Exception ex) {
                textArea.append("Lỗi khi thêm.\n");
            }
        });

        btnUpdate.addActionListener(e -> {
            try {
                XMLHandler.updateStudent(txtId.getText(), txtName.getText());
                textArea.append("Đã sửa.\n");
            } catch (Exception ex) {
                textArea.append("Lỗi khi sửa.\n");
            }
        });

        btnDelete.addActionListener(e -> {
            try {
                XMLHandler.deleteStudent(txtId.getText());
                textArea.append("Đã xóa.\n");
            } catch (Exception ex) {
                textArea.append("Lỗi khi xóa.\n");
            }
        });

        btnDisplay.addActionListener(e -> {
            try {
                textArea.setText("");
                XMLHandler.displayAll(); // hiển thị trong console
                textArea.append("Hiển thị trong console.\n");
            } catch (Exception ex) {
                textArea.append("Lỗi khi hiển thị.\n");
            }
        });

        btnMerge.addActionListener(e -> {
            try {
                String[] files = {"students.xml", "students2.xml"};
                XMLMerger.mergeXMLFiles(files, "merged.xml", false);
                textArea.append("Đã ghép XML (ngang cấp).\n");
            } catch (Exception ex) {
                textArea.append("Lỗi khi ghép.\n");
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new XMLGUI();
    }
}
