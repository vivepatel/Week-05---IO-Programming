package com.ioprogramming.basicproblems.readrowsincsv;

import com.ioprogramming.basicproblems.readcsvfile.ReadCSVfFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadAndCountRowsinjava {
    public static void readAndCount(String filepath)
    {
        int count = 0;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filepath))) {
            String input;

            while((input = bufferedReader.readLine()) != null)
            {
                count++;
            }

            System.out.println("Count : "+count);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        String filepath="C:\\Users\\Vivek Patel\\OneDrive\\Desktop\\Week-04\\Day-01\\src\\main\\java\\com\\ioprogramming\\basicproblems\\readrowsincsv\\count.csv";
        ReadAndCountRowsinjava.readAndCount(filepath);
    }
}
