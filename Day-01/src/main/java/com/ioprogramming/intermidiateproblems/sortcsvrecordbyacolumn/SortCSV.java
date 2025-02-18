package com.ioprogramming.intermidiateproblems.sortcsvrecordbyacolumn;

import java.io.*;
import java.util.*;

class Employee {
    String name;
    double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
}

public class SortCSV {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\Vivek Patel\\OneDrive\\Desktop\\Week 05 - IO Programming\\Day-01\\src\\main\\java\\com\\ioprogramming\\intermidiateproblems\\modifyacsvfile\\original.csv";
        List<Employee> employees = readCSV(filePath);

        employees.sort((e1, e2) -> Double.compare(e2.salary, e1.salary));

        System.out.println("Top 5 highest-paid employees:");
        for (int i = 0; i < employees.size(); i++) {
            System.out.println(employees.get(i).name + " - " + employees.get(i).salary);
        }
    }

    public static List<Employee> readCSV(String filePath) {
        List<Employee> employees = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String name = data[1];
                double salary = Double.parseDouble(data[3]);
                employees.add(new Employee(name, salary));
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return employees;
    }
}
