package com.ioprogramming.advancedproblems.mergetwocsv;

import java.io.*;
import java.util.*;

public class CSVMerger {

    public Map<Integer, Student> readStudents1(String filePath) {
        Map<Integer, Student> studentsMap = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                int age = Integer.parseInt(data[2]);

                Student student = new Student(id, name, age, 0, ""); // Set marks and grade as placeholders
                studentsMap.put(id, student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return studentsMap;
    }

    public void mergeAndWriteCSV(String filePath1, String filePath2, String outputFilePath) {
        Map<Integer, Student> studentsMap = readStudents1(filePath1);

        try (BufferedReader br = new BufferedReader(new FileReader(filePath2))) {
            String line;
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                int marks = Integer.parseInt(data[1]);
                String grade = data[2];

                if (studentsMap.containsKey(id)) {
                    Student student = studentsMap.get(id);
                    student.setMarks(marks);
                    student.setGrade(grade);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFilePath))) {
            bw.write("ID,Name,Age,Marks,Grade\n");
            for (Student student : studentsMap.values()) {
                bw.write(student.toString() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

