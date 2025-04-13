/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iostreamex;

import java.io.File;

public class Bai5 {
    public static void main(String[] args) {
        String directoryPath = "D:\\note";
        
        File folder = new File(directoryPath);
        if (!folder.exists() || !folder.isDirectory()) {
            System.out.println("Thư mục không tồn tại hoặc không hợp lệ: " + directoryPath);
            return;
        }

        File[] listOfFiles = folder.listFiles();
        if (listOfFiles != null) {
            System.out.println("Danh sách file trong thư mục '" + directoryPath + "':");
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    System.out.println("[FILE] " + file.getName());
                } else if (file.isDirectory()) {
                    System.out.println("[DIR]  " + file.getName());
                }
            }
        } else {
            System.out.println("Không thể liệt kê nội dung thư mục.");
        }
    }
}
