package com.ioprogramming.basicproblems.readcsvfile;


import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadCSVfFile {
    public static void readCsv( String filepath)
    {
        try(BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line ;
            while ((line = br.readLine())!=null)
            {
                String[] columns =  line.split(",");
                System.out.println("ID "+ columns[0] + ", Name "+ columns[1] +", Age " +columns[2]+", Marks" + columns[3]);
            }
        }
        catch (IIOException | FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public static void main(String[] args) {


        String filepath = "C:\\Users\\Vivek Patel\\OneDrive\\Desktop\\Week-04\\Day-01\\src\\main\\java\\com\\ioprogramming\\basicproblems\\readcsvfile\\data.csv";
        ReadCSVfFile.readCsv(filepath);
    }
}
