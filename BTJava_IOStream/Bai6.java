/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iostreamex;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;

public class Bai6 extends Thread {
    private final String fileName;
    private static final String OUTPUT_FILE = "D:\\note\\output.txt";
    private static final Object lock = new Object(); // Đối tượng khóa để đồng bộ hóa

    public Bai6(String fileName) {
        this.fileName = fileName;
    }

    public void run() {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            System.out.println("Đọc file: " + fileName);
            StringBuilder content = new StringBuilder();

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(fileName + ": " + line);
                content.append(line).append("\n");
            }

            // Ghi vào output.txt (đồng bộ hóa để tránh xung đột)
            synchronized (lock) {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_FILE, true))) {
                    writer.write(content.toString());
                    writer.write("\n"); // Xuống dòng giữa các file
                }
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file: " + fileName);
        }
    }

    public static void main(String[] args) {
//        // Xóa nội dung cũ của output.txt trước khi chạy
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_FILE))) {
//            writer.write(""); // Ghi chuỗi rỗng để xóa file
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        // Khởi chạy các luồng để đọc file
        new Bai6("D:\\note\\input1.txt").start();
        new Bai6("D:\\note\\input2.txt").start();
    }
}

