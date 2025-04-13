import javax.swing.*;

public class XMLGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("XML Student Manager");
        frame.setSize(400, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel idLabel = new JLabel("ID:");
        idLabel.setBounds(30, 30, 50, 25);
        frame.add(idLabel);

        JTextField idField = new JTextField();
        idField.setBounds(100, 30, 200, 25);
        frame.add(idField);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(30, 70, 50, 25);
        frame.add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(100, 70, 200, 25);
        frame.add(nameField);

        JButton addButton = new JButton("Add");
        addButton.setBounds(30, 110, 80, 30);
        frame.add(addButton);

        JButton deleteButton = new JButton("Delete");
        deleteButton.setBounds(120, 110, 80, 30);
        frame.add(deleteButton);

        JButton viewButton = new JButton("View");
        viewButton.setBounds(210, 110, 80, 30);
        frame.add(viewButton);

        JTextArea output = new JTextArea();
        output.setBounds(30, 150, 320, 50);
        frame.add(output);

        addButton.addActionListener(e -> {
            try {
                XMLHandler.writeXML(idField.getText(), nameField.getText());
                output.setText("Added!");
            } catch (Exception ex) {
                output.setText("Error adding!");
            }
        });

        deleteButton.addActionListener(e -> {
            try {
                XMLHandler.deleteStudentById(idField.getText());
                output.setText("Deleted!");
            } catch (Exception ex) {
                output.setText("Error deleting!");
            }
        });

        viewButton.addActionListener(e -> {
            try {
                output.setText("Reading XML...\n");
                XMLHandler.readXML();
            } catch (Exception ex) {
                output.setText("Error reading!");
            }
        });

        frame.setVisible(true);
    }
}
