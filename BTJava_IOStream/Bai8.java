/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iostreamex;
import java.io.*;
import java.util.concurrent.*;

class KeywordSearchTask implements Callable<Integer> {
    private final String fileName;
    private final String keyword;

    public KeywordSearchTask(String fileName, String keyword) {
        this.fileName = fileName;
        this.keyword = keyword;
    }

    @Override
    public Integer call() {
        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                count += countOccurrences(line, keyword);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Từ khóa xuất hiện " + count + " lần trong " + fileName);
        return count;
    }

    private int countOccurrences(String line, String keyword) {
        int count = 0, index = 0;
        while ((index = line.indexOf(keyword, index)) != -1) {
            count++;
            index += keyword.length();
        }
        return count;
    }
}

public class Bai8 {
    public static void main(String[] args) {
        String[] files = {"D:\\note\\input1.txt", "D:\\note\\input2.txt", "D:\\note\\input3.txt"};
        String keyword = "java";

        ExecutorService executor = Executors.newFixedThreadPool(files.length);
        Future<Integer>[] results = new Future[files.length];

        for (int i = 0; i < files.length; i++) {
            results[i] = executor.submit(new KeywordSearchTask(files[i], keyword));
        }

        executor.shutdown();

        int totalOccurrences = 0;
        try {
            for (Future<Integer> result : results) {
                totalOccurrences += result.get();
            }
            System.out.println("Số lần xuất hiện của từ khóa \"" + keyword + "\": " + totalOccurrences);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
