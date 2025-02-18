package com.ioprogramming.advancedproblems.csvvalidation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVValidatorMain {

    public static void main(String[] args) {
        String filePath = "C:\\Users\\yugap\\OneDrive\\Desktop\\cap\\Week_05\\Day01\\src\\employees.csv";
        processCSV(filePath);
    }

    public static void processCSV(String filePath) {
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String id = data[0];
                String name = data[1];
                String email = data[2];
                String phone = data[3];
                String department = data[4];
                String salary = data[5];

                boolean emailValid = CSVValidator.isValidEmail(email);
                boolean phoneValid = CSVValidator.isValidPhoneNumber(phone);

                if (!emailValid || !phoneValid) {
                    System.out.println("Invalid data in row: " + line);
                    if (!emailValid) {
                        System.out.println("Invalid Email: " + email);
                    }
                    if (!phoneValid) {
                        System.out.println("Invalid Phone Number: " + phone);
                    }
                } else {
                    // Process the valid row (e.g., print or store the data)
                    System.out.println("Valid data: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
