package org.example;
import java.io.*;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class ReadFile {

    public static String readFile(String filePath)
    {
        StringBuilder builder = new StringBuilder();

        try{
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;

            while ((line = reader.readLine()) != null) {
                builder.append(line).append("\n");
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException("An error occurred. Could not find the file.");
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

        return builder.toString();
    }

    public static void DateCountry(String date){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please choose a county specific Date format!! Only between Russia 'Ru' and Germany 'Deu'");


        if(scanner.hasNext("Ru"))
        {
            Date dateRu = new Date(date);

            Locale locRussian = new Locale("ru", "ch");

            DateFormat dr = DateFormat.getDateInstance(
                    DateFormat.FULL, locRussian);

            System.out.println("Russian Format: "
                    + dr.format(dateRu));

        }
        else if (scanner.hasNext("Deu")) {
            Date dateDeu = new Date(date);

            Locale locRussian = new Locale("De", "ch");

            DateFormat dr = DateFormat.getDateInstance(
                    DateFormat.FULL, locRussian);

            System.out.println("Russian Format: "
                    + dr.format(dateDeu));

        }
        scanner.close();
    }
}

