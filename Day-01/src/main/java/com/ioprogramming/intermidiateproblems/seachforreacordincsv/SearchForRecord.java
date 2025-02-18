package com.ioprogramming.intermidiateproblems.seachforreacordincsv;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SearchForRecord {
  public static  void  Str(String filepath ,String name)
  {
      try(BufferedReader br = new BufferedReader( new FileReader(filepath))) {
          String line;
          while((line=br.readLine())!=null)
          {
              String[] column = line.split(",");
              String name2 = column[1].trim();

              if(name2.equals(name))
              {
                  System.out.println(column[0]+", "+column[1]+", "+column[2]+", "+ column[3]);

              }
          }

      }
      catch (IIOException e)
      {
          e.printStackTrace();
      } catch (IOException e) {
          throw new RuntimeException(e);
      }
  }
    public static void main(String[] args) {
        String filepath="C:\\Users\\Vivek Patel\\OneDrive\\Desktop\\Week-04\\Day-01\\src\\main\\java\\com\\ioprogramming\\intermidiateproblems\\seachforreacordincsv\\record1.csv";
        String user = "Vivek";
        SearchForRecord.Str(filepath,user);

    }
}
