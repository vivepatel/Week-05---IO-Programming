package com.ioprogramming.intermidiateproblems.filterrecordfromcsv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FilterRecordsfromCSV {
    public static void filterRecorder(String filepath)
    {

        try(BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line ;
            int index = 0;

            while((line= br.readLine())!=null)
            {
                String[] colouns = line.split(",");

                if(index==0)
                {
                    System.out.println(colouns[0] +", "+ colouns[1]+", "+ colouns[2] +", " + colouns[3]);
                    index++;


                }
                else {
                    int marks=Integer.parseInt(colouns[3].trim());
                    if(marks>=80) {
                        System.out.println(colouns[0] +", "+ colouns[1]+", "+ colouns[2] +", " + colouns[3]);

                    }
                    index++;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        String filepath = "C:\\Users\\Vivek Patel\\OneDrive\\Desktop\\Week-04\\Day-01\\src\\main\\java\\com\\ioprogramming\\intermidiateproblems\\filterrecordfromcsv\\record.csv";
        FilterRecordsfromCSV.filterRecorder(filepath);
   }
}
