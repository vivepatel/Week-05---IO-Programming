package com.ioprogramming.intermidiateproblems.modifyacsvfile;

import javax.imageio.IIOException;
import java.io.*;

public class CSVFile {
    public static void update(String filepath, String Modifiead)
    {
        try(BufferedReader br =new BufferedReader( new FileReader(filepath));
            BufferedWriter bs = new BufferedWriter(new FileWriter(Modifiead))) {
            String line;
            while ((line = br.readLine())!=null)
            {
               String[] coloumn = line.split(",");
                String dept  = coloumn[2].trim();

                String name = "IT";
                if(dept.equals(name))
                {
                    int  updatesalary = (int) (Integer.parseInt(coloumn[3].trim())*10);
                    bs.write(coloumn[0] + ", "+coloumn[1] +", "+coloumn[2] + updatesalary);
                }
                else
                {
                    bs.write(coloumn[0] + ", "+coloumn[1] +", "+coloumn[2] + ","+coloumn[3]);
                }
                bs.newLine();

            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        String filepath="src/main/java/com/ioprogramming/intermidiateproblems/modifyacsvfile/original.csv";
        String newfilepath="src/main/java/com/ioprogramming/intermidiateproblems/modifyacsvfile/Modifiead.csv";
        CSVFile.update(filepath,newfilepath);
    }
}
