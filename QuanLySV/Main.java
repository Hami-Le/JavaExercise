/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ex_quanlysinhvien;

import ex_quanlysinhvien.StudentDAO;
import ex_quanlysinhvien.Student;
import java.io.IOException;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
  
    public static void main(String[] args) throws SQLException, IOException {
        Scanner sc = new Scanner(System.in);
        StudentDAO studentDAO = new StudentDAO();
        Student loggedInStudent = null;

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Thêm sinh viên");
            System.out.println("2. Đăng nhập (theo email)");
            System.out.println("3. Đăng xuất");
            System.out.println("4. Thêm sinh viên vào lớp và hiển thị danh sách lớp");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Nhập ID: ");
                    String id = sc.nextLine();
                    System.out.print("Nhập tên: ");
                    String name = sc.nextLine();
                    System.out.print("Nhập tuổi: ");
                    int age = sc.nextInt();
                    System.out.print("Nhập GPA: ");
                    float gpa = sc.nextFloat();
                    sc.nextLine();
                    String email = studentDAO.generateEmail(name);
                    Student s = new Student(id, name, age, email, gpa);
                    studentDAO.addStudent(s);
                    System.out.println("Thêm sinh viên thành công. Email: " + email);
                    break;

                case 2:
                    System.out.print("Nhập email: ");
                    String loginEmail = sc.nextLine();
                    Student found = studentDAO.getStudentByEmail(loginEmail);
                    if (found != null) {
                        loggedInStudent = found;
                        System.out.println("Đăng nhập thành công. Xin chào " + found.getName());
                    } else {
                        System.out.println("Email không tồn tại.");
                    }
                    break;
                case 3:
                    if (loggedInStudent != null) {
                        System.out.println("Đăng xuất thành công! ");
                        loggedInStudent = null;
                    } else {
                        System.out.println("Không có ai đang đăng nhập.");
                    }
                    break;
                case 4:
                    System.out.println("Class: \n"
                            + "IT101. Lập trình Java \n"
                            + "IT101. Cấu trúc dữ liệu và giải thuật \n"
                            + "IT103. Thiết kế Web");
                    System.out.print("Nhập StudentID: ");
                    int sid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nhập ClassID: ");
                    String cid = sc.nextLine();
                    studentDAO.addStudentToClass(sid, cid);
                    System.out.println("Đã thêm sinh viên vào lớp.");
                    List<Student> classStudents = studentDAO.getStudentsByClass(cid);
                    System.out.println("Danh sách sinh viên trong lớp " + cid + ":");
                    for (Student stu : classStudents) {
                        System.out.println(stu);
                    }
                    break;
                case 0:
                    System.out.println("Thoát chương trình.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }
}
