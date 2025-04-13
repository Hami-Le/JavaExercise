/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iostreamex;

import org.jsoup.Jsoup;
import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Bai9 {
    private static final List<String> URLS = Arrays.asList(
            "https://example.com/page1",
            "https://example.com/page2",
            "https://example.com/page3",
            "https://example.com/page4",
            "https://example.com/page5"
    );
    
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < URLS.size(); i++) {
            final int index = i;
            executor.execute(() -> downloadAndSave(URLS.get(index), "file" + index + ".txt"));
        }
        executor.shutdown();
        while (!executor.isTerminated()) {}
        mergeFiles();
    }
    
    private static void downloadAndSave(String urlString, String fileName) {
        try {
            String content = Jsoup.connect(urlString).get().text();
            Files.write(Paths.get(fileName), content.getBytes());
            System.out.println("Downloaded: " + fileName);
        } catch (Exception e) {
            System.err.println("Error downloading " + urlString + ": " + e.getMessage());
        }
    }
    
    private static void mergeFiles() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("merged_output.txt"))) {
            for (int i = 0; i < URLS.size(); i++) {
                String fileName = "file" + i + ".txt";
                List<String> lines = Files.readAllLines(Paths.get(fileName));
                for (String line : lines) {
                    writer.write(line);
                    writer.newLine();
                }
            }
            System.out.println("Merged into merged_output.txt");
        } catch (IOException e) {
            System.err.println("Error merging files: " + e.getMessage());
        }
    }
}
