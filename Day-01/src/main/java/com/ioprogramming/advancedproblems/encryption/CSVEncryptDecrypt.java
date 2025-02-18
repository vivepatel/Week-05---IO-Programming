package com.ioprogramming.advancedproblems.encryption;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.util.*;

public class CSVEncryptDecrypt {

    private static final String ALGORITHM = "AES";
    private static final String ENCRYPTION_KEY = "1234567890123456";  // 16-byte key for AES-128

    public void encryptAndWriteCSV(String inputFilePath, String outputFilePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath));
             CSVWriter writer = new CSVWriter(new FileWriter(outputFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                fields[2] = encrypt(fields[2]);  // Encrypt Email
                fields[3] = encrypt(fields[3]);  // Encrypt Salary
                writer.writeNext(fields);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void readAndDecryptCSV(String inputFilePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                fields[2] = decrypt(fields[2]);  // Decrypt Email
                fields[3] = decrypt(fields[3]);  // Decrypt Salary
                System.out.println("ID: " + fields[0] + ", Name: " + fields[1] + ", Email: " + fields[2] + ", Salary: " + fields[3]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String encrypt(String data) {
        try {
            SecretKeySpec key = new SecretKeySpec(ENCRYPTION_KEY.getBytes(), ALGORITHM);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] encryptedBytes = cipher.doFinal(data.getBytes());
            return Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private String decrypt(String encryptedData) {
        try {
            SecretKeySpec key = new SecretKeySpec(ENCRYPTION_KEY.getBytes(), ALGORITHM);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] decodedBytes = Base64.getDecoder().decode(encryptedData);
            byte[] decryptedBytes = cipher.doFinal(decodedBytes);
            return new String(decryptedBytes);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        CSVEncryptDecrypt encryptDecrypt = new CSVEncryptDecrypt();
        String inputFilePath = "C:\\Users\\Vivek Patel\\OneDrive\\Desktop\\Week 05 - IO Programming\\Day-01\\src\\employees.csv";
        String outputFilePath = "C:\\Users\\Vivek Patel\\OneDrive\\Desktop\\Week 05 - IO Programming\\Day-01\\src\\employee_data.csv";

        encryptDecrypt.encryptAndWriteCSV(inputFilePath, outputFilePath);

        encryptDecrypt.readAndDecryptCSV(outputFilePath);
    }

    static class CSVWriter implements AutoCloseable {
        private BufferedWriter writer;

        public CSVWriter(FileWriter fileWriter) {
            this.writer = new BufferedWriter(fileWriter);
        }

        public void writeNext(String[] fields) throws IOException {
            writer.write(String.join(",", fields));
            writer.newLine();
        }

        @Override
        public void close() throws IOException {
            writer.close();
        }
    }
}
