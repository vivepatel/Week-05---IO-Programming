package com.ioprogramming.advancedproblems.jsoncsvconversion;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVWriter;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class JSONCSVConverter {

    public void jsonToCsv(String jsonFilePath, String csvFilePath) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            List<Student> students = Arrays.asList(objectMapper.readValue(new File(jsonFilePath), Student[].class));

            try (CSVWriter writer = new CSVWriter(new FileWriter(csvFilePath))) {
                String[] header = {"ID", "Name", "Age", "Grade"};
                writer.writeNext(header);
                for (Student student : students) {
                    String[] record = {String.valueOf(student.getId()), student.getName(), String.valueOf(student.getAge()), student.getGrade()};
                    writer.writeNext(record);
                }
            }

            System.out.println("CSV file generated from JSON successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void csvToJson(String csvFilePath, String jsonFilePath) {
        try (CSVReader csvReader = new CSVReader(new FileReader(csvFilePath))) {
            List<String[]> records = csvReader.readAll();
            List<Student> students = new ArrayList<>();

            // Skipping the header row
            for (int i = 1; i < records.size(); i++) {
                String[] row = records.get(i);
                Student student = new Student(
                        Integer.parseInt(row[0]),
                        row[1],
                        Integer.parseInt(row[2]),
                        row[3]
                );
                students.add(student);
            }

            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(new File(jsonFilePath), students);

            System.out.println("JSON file generated from CSV successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        JSONCSVConverter converter = new JSONCSVConverter();

        String jsonFilePath = "C:\\Users\\Vivek Patel\\OneDrive\\Desktop\\Week 05 - IO Programming\\Day-01\\src\\student1.json";
        String csvFilePath = "C:\\Users\\Vivek Patel\\OneDrive\\Desktop\\Week 05 - IO Programming\\Day-01\\src\\studenttojson.csv";

        String csvFilePathForJson = "C:\\Users\\Vivek Patel\\OneDrive\\Desktop\\Week 05 - IO Programming\\Day-01\\src\\studenttojson (2).csv";
        String jsonFilePathForCsv = "C:\\Users\\Vivek Patel\\OneDrive\\Desktop\\Week 05 - IO Programming\\Day-01\\src\\student2.json";

        converter.jsonToCsv(jsonFilePath, csvFilePath);

        converter.csvToJson(csvFilePathForJson, jsonFilePathForCsv);
    }

    static class Student {
        private int id;
        private String name;
        private int age;
        private String grade;

        public Student() {
        }

        public Student(int id, String name, int age, String grade) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.grade = grade;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public String getGrade() {
            return grade;
        }
    }
}


