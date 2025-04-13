/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iostreamex;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Bai3 {
    public static void main(String[] args) {
        String fileName = "D:\\note\\input1.txt";
        int lines = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while (reader.readLine() != null) {
                lines++;
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file: " + e.getMessage());
        }
        System.out.println("Số dòng trong file: " + lines);
    }
}
