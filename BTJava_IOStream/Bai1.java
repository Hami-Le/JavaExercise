/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iostreamex;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Bai1 {
    public static void main(String[] args) {
        String source = "D:\\note\\input1.txt";
        String destination = "D:\\note\\input2.txt";
        
        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(destination)) {
            int data;
            while ((data = fis.read()) != -1) {
                fos.write(data);
            }
            System.out.println("Đã sao chép nội dung từ " + source + " sang " + destination);
        } catch (IOException e) {
            System.out.println("Lỗi khi sao chép file: " + e.getMessage());
        }
    }
}
