/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iostreamex;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Bai4 {
    public static void main(String[] args) {
        String fileName = "D:\\note\\numbers.dat";
        
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
            int[] numbers = {10, 20, 30, 40, 50};
            for (int num : numbers) {
                dos.writeInt(num);
            }
            System.out.println("Đã ghi danh sách số nguyên vào " + fileName);
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi file: " + e.getMessage());
        }

        try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
            System.out.print("Các số nguyên trong " + fileName + ": ");
            while (dis.available() > 0) {
                System.out.print(dis.readInt() + " ");
            }
            System.out.println();
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file: " + e.getMessage());
        }
    }
}
