package org.example;

import java.io.*;
import java.nio.channels.ReadPendingException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                Please provide exactly two arguments: the file name and the date: \
                
                Example; \
                
                 Date: yyyy-mm-dd \
                
                 FileName: SavedDateToFile.txt""");

        System.out.println("Enter the file name:");
        String fileName = scanner.nextLine();

        System.out.println("Enter the date (yyyy-MM-dd):");
        String dateInput = scanner.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate parsedDate;

        // Validate the date input
        try {
            parsedDate = LocalDate.parse(dateInput, formatter);
            System.out.println("Success: The date '" + dateInput + "' has been validated.");
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Please use yyyy-MM-dd.");
            return;
        }

        File file = new File(fileName);

        try {
            if (file.exists()) {
                file.createNewFile();
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException ioe) {
            System.out.println("An error occurred.");
            ioe.printStackTrace();
        }

        String filePath = file.getAbsolutePath();

        try {
            FileWriter fileWriter = new FileWriter(filePath);
            fileWriter.write(parsedDate.format(formatter));
            fileWriter.close();

            if (file.exists())
                System.out.println("Error: The file at '" + filePath + "' could not be created. Since it already exists");
            else
                System.out.println("Success: The file at '" + filePath + "' has been created.");

        } catch (WriteAbortedException wabe) {
            System.out.println("An error occurred. Could not write to the file.");
            wabe.printStackTrace();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred. Could not find the file.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } finally {
            scanner.close();
        }

        ReadFile.DateCountry(ReadFile.readFile(filePath));


    }
}