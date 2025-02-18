package com.ioprogramming.advancedproblems.readlargecsv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LargeCSVReader {

    public void readCSVInChunks(String filePath) {
        int linesProcessed = 0;
        int chunkSize = 100;
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while ((line = br.readLine()) != null) {
                linesProcessed++;
                if (linesProcessed % chunkSize == 0) {
                    System.out.println("Processed " + linesProcessed + " records.");
                }
            }
            System.out.println("Total records processed: " + linesProcessed);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String filePath = "C:\\Users\\yugap\\OneDrive\\Desktop\\cap\\Week_05\\Day01\\src\\employees.csv";
        LargeCSVReader reader = new LargeCSVReader();
        reader.readCSVInChunks(filePath);
    }
}
