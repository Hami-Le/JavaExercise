/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iostreamex;

import java.io.*;
import java.util.concurrent.*;

class FileReadTask implements Callable<byte[]> {
    private final String fileName;
    private final long start;
    private final int size;

    public FileReadTask(String fileName, long start, int size) {
        this.fileName = fileName;
        this.start = start;
        this.size = size;
    }

    @Override
    public byte[] call() {
        byte[] buffer = new byte[size];
        try (RandomAccessFile file = new RandomAccessFile(fileName, "r")) {
            file.seek(start); // Di chuyển con trỏ đến vị trí cần đọc
            file.readFully(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer;
    }
}

public class Bai7_FileRead {
    private static final int CHUNK_SIZE = 1024 * 1024; // 1MB mỗi đoạn

    public static void main(String[] args) {
        String inputFile = "D:\\abc\\input.txt";
        String outputFile = "D:\\abc\\output.txt";

        try (RandomAccessFile file = new RandomAccessFile(inputFile, "r")) {
            long fileSize = file.length();
            int numChunks = (int) Math.ceil((double) fileSize / CHUNK_SIZE);

            ExecutorService executor = Executors.newFixedThreadPool(4); // Sử dụng 4 luồng
            Future<byte[]>[] results = new Future[numChunks];

            for (int i = 0; i < numChunks; i++) {
                long start = i * CHUNK_SIZE;
                int size = (int) Math.min(CHUNK_SIZE, fileSize - start);
                results[i] = executor.submit(new FileReadTask(inputFile, start, size));
            }

            executor.shutdown();

            try (BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(outputFile))) {
                for (Future<byte[]> result : results) {
                    outputStream.write(result.get());
                }
            }

            System.out.println("Ghi dữ liệu vào " + outputFile + " thành công!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

