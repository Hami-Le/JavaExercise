import java.io.*;
import java.util.Scanner;

public class IOStreamEx {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("\n========= MENU =========");
            System.out.println("1. Đọc và ghi dữ liệu từ file (input1 sang input2)");
            System.out.println("2. Đọc dữ liệu từ bàn phím và ghi vào file (input1)");
            System.out.println("3. Tính số dòng trong một (input1)");
            System.out.println("4. Ghi danh sách số nguyên (10, 20, 30, 40, 50) vào file và đọc lại");
            System.out.println("5. Liệt kê tất cả các file trong một thư mục (note)");
            System.out.println("6. Đọc nhiều file văn bản (trong thư mục note) bằng đa luồng");
            System.out.println("0. Thoát chương trình");

            System.out.print("Chọn chức năng: ");
            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số nguyên hợp lệ!");
                continue;
            }

            switch (choice) {
                case 1:
                    copyFile("D:\\note\\input1.txt", "D:\\note\\input2.txt");
                    break;
                case 2:
                    writeFromKeyboard("D:\\note\\input1.txt", scanner); // Truyền scanner vào hàm
                    break;
                case 3:
                    int lineCount = countLines("D:\\note\\input1.txt");
                    System.out.println("Số dòng trong file: " + lineCount);
                    break;
                case 4:
                    writeAndReadIntegers("D:\\note\\numbers.dat", scanner);
                    break;
                case 5:
                    listFilesInDirectory("D:\\note");
                    break;
                case 6:
                    String[] files = {"D:\\note\\input1.txt", "D:\\note\\input2.txt"};
                    for (String file : files) {
                        new FileReaderThread(file).start();
                    }
                    break;
                case 0:
                    System.out.println("Thoát chương trình...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ! Hãy nhập lại.");
            }
        } while (true);

    }

    // Câu 1: Sao chép nội dung từ file nguồn sang file đích
    public static void copyFile(String source, String destination) {
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

    // Câu 2: Đọc dữ liệu từ bàn phím và ghi vào file
    public static void writeFromKeyboard(String fileName, Scanner scanner) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            System.out.println("Nhập dữ liệu (gõ 'exit' để quay lại menu):");

            while (true) {
                String line = scanner.nextLine();
                if (line.equalsIgnoreCase("exit")) {
                    System.out.println("Quay lại menu...");
                    break; // Kết thúc nhập và quay lại menu
                }
                writer.write(line);
                writer.newLine();
                writer.flush();
            }

            System.out.println("Dữ liệu đã được ghi vào " + fileName);
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi file: " + e.getMessage());
        }
    }


    // Câu 3: Tính số dòng trong một file
    public static int countLines(String fileName) {
        int lines = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while (reader.readLine() != null) {
                lines++;
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file: " + e.getMessage());
        }
        return lines;
    }

    // Câu 4: Ghi danh sách số nguyên vào file và đọc lại
    public static void writeAndReadIntegers(String fileName, Scanner scanner) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
            int[] numbers = {10, 20, 30, 40, 50};
            for (int num : numbers) {
                dos.writeInt(num);
            }
            System.out.println("Đã ghi danh sách số nguyên vào " + fileName);
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi file: " + e.getMessage());
        }

        // Đọc số nguyên từ file
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

    // Câu 5: Liệt kê tất cả các file trong một thư mục
    public static void listFilesInDirectory(String directoryPath) {
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

    // Câu 6: Đọc nhiều file văn bản bằng đa luồng
    class FileReaderThread extends Thread {
        private final String fileName;

        public FileReaderThread(String fileName) {
            this.fileName = fileName;
        }

        public void run() {
            try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                System.out.println("Đọc file: " + fileName);
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(fileName + ": " + line);
                }
            } catch (IOException e) {
                System.out.println("Lỗi khi đọc file: " + fileName);
            }
        }
    }
