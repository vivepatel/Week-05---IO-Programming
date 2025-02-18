package com.ioprogramming.advancedproblems.csvdatahandling;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CSVToStudentConverter {

    public List<Student> convertCSVToStudents(String filePath) {
        List<Student> students = new ArrayList<>();
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                String email = data[2];
                double grade = Double.parseDouble(data[3]);

                students.add(new Student(id, name, email, grade));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return students;
    }
}
