package com.ioprogramming.advancedproblems.mergetwocsv;

public class CSVMergeMain {

    public static void main(String[] args) {
        String filePath1 = "C:\\Users\\yugap\\OneDrive\\Desktop\\cap\\Week_05\\Day01\\src\\student1.csv";
        String filePath2 = "C:\\Users\\yugap\\OneDrive\\Desktop\\cap\\Week_05\\Day01\\src\\student2.csv";
        String outputFilePath = "C:\\Users\\yugap\\OneDrive\\Desktop\\cap\\Week_05\\Day01\\src\\empty_students2.csv";

        CSVMerger merger = new CSVMerger();
        merger.mergeAndWriteCSV(filePath1, filePath2, outputFilePath);

        System.out.println("Merging completed! Merged file created at: " + outputFilePath);
    }
}
