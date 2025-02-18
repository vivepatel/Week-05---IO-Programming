package com.ioprogramming.advancedproblems.csvdatahandling;

import java.util.List;

public class CSVConverterMain {

    public static void main(String[] args) {
        String filePath = "C:\\Users\\yugap\\OneDrive\\Desktop\\cap\\Week_05\\Day01\\src\\students_detail.csv";
        CSVToStudentConverter converter = new CSVToStudentConverter();
        List<Student> students = converter.convertCSVToStudents(filePath);

        students.forEach(System.out::println);
    }
}
