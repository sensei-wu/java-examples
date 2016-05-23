package io;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by zcheruveettil on 23.05.2016.
 * 
 * To demonstrate file reading, lines and word counting using different standard methods
 */
public class LineCounter {

    public static void main(String[] args) {
        classic();
        scanner();
        filesMethod();
    }

    private static void classic() {
        System.out.println("Using classic BufferedReader and FileReader");
        File file = getFile();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file)) ){
            String line;
            int lineCount = 0;
            int wordCount = 0;
            while ((line = bufferedReader.readLine()) != null) {
                lineCount++;
                StringTokenizer st = new StringTokenizer(line);
                wordCount += st.countTokens();
            }

            System.out.println(String.format("Total Lines %d, Number of Words %d", lineCount, wordCount));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void scanner() {
        System.out.println("Using scanner");
        File file = getFile();
        try {
            Scanner scanner = new Scanner(file);
            int lineCount = 0;
            int wordCount = 0;
            while (scanner.hasNext()) {
                StringTokenizer stringTokenizer = new StringTokenizer(scanner.nextLine());
                lineCount++;
                wordCount += stringTokenizer.countTokens();
            }
            System.out.println(String.format("Total Lines %d, Number of Words %d", lineCount, wordCount));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void filesMethod() {
        System.out.println("Using filesMethod");
        try {
            String text = new String(Files.readAllBytes(getFile().toPath()));
            StringTokenizer stringTokenizer = new StringTokenizer(text, "\r\n");
            int lines = stringTokenizer.countTokens();
            int words = 0;
            while(stringTokenizer.hasMoreElements()) {
                StringTokenizer wordTokenizer = new StringTokenizer(stringTokenizer.nextToken());
                words += wordTokenizer.countTokens();
            }
            System.out.println(String.format("Total Lines %d, Number of Words %d", lines, words));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static File getFile() {
        URL url = LineCounter.class.getResource("input.txt");
        return new File(url.getPath());
    }
}
