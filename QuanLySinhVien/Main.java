import dao.*;
import model.*;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentDAO studentDAO = new StudentDAO();
        LearnDAO learnDAO = new LearnDAO();
        AuthService auth = new AuthService();

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Thêm sinh viên");
            System.out.println("2. Hiển thị tất cả sinh viên");
            System.out.println("3. Đăng nhập bằng email");
            System.out.println("4. Thêm sinh viên vào lớp");
            System.out.println("5. Hiển thị sinh viên theo lớp");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");
            int choice = sc.nextInt(); sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Nhập ID: ");
                    String id = sc.nextLine();
                    System.out.print("Tên: ");
                    String name = sc.nextLine();
                    System.out.print("Tuổi: ");
                    int age = sc.nextInt(); sc.nextLine();
                    Student s = new Student(id, name, age);
                    studentDAO.addStudent(s);
                    break;
                case 2:
                    for (Student stu : studentDAO.getAllStudents()) {
                        System.out.println(stu);
                    }
                    break;
                case 3:
                    System.out.print("Nhập email: ");
                    String email = sc.nextLine();
                    if (auth.login(email)) {
                        System.out.println("✅ Đăng nhập thành công: " + auth.getCurrentStudent().getName());
                    } else {
                        System.out.println("❌ Email không tồn tại!");
                    }
                    break;
                case 4:
                    System.out.print("ID sinh viên: ");
                    String sid = sc.nextLine();
                    System.out.print("ID lớp: ");
                    String cid = sc.nextLine();
                    learnDAO.addStudentToClass(sid, cid);
                    break;
                case 5:
                    System.out.print("Nhập mã lớp: ");
                    String classId = sc.nextLine();
                    List<String> list = learnDAO.getStudentsByClass(classId);
                    if (list.isEmpty()) 
                        System.out.println("Không có sinh viên.");
                    else list.forEach(System.out::println);
                    break;
                case 0:
                    System.out.println("Tạm biệt!");
                    return;
                default:
                    System.out.println("Sai lựa chọn!");
            }
        }
    }
}