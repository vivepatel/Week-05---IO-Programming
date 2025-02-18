package com.ioprogramming.basicproblems.writedatatocsvfile;

//import java.io.BufferedReader;
//import java.io.FileReader;
import  java.io.*;

public class WriteCsvFile {
    public static void writeCsvFile(String filepath)
    {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filepath))) {
            writer.write("ID,Name,Department,Salary\\n");
            writer.write("1,vivek , cs, 50000\\n");
            writer.write("1,vivek , cs, 50000\\n");
            writer.write("1,vivek , cs, 50000\\n");
            writer.write("1,vivek , cs, 50000\\n");
            System.out.println("Added data successfully ");
        }
        catch (IOException e)
        {
                e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        String filepath= "C:\\Users\\Vivek Patel\\OneDrive\\Desktop\\Week-04\\Day-01\\src\\main\\java\\com\\ioprogramming\\basicproblems\\writedatatocsvfile\\employee.csv";
        WriteCsvFile.writeCsvFile(filepath);
    }
}
