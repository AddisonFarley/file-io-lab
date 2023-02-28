//Author: Addison Farley
//Class: SDEV 219
//Program: File manager program

package program;

import helpers.Console;

import java.io.*;
import java.util.Scanner;

public class FileIOProgram
{
    private Console console = new Console();

    public static void main(String[] args)
    {
        File fileDirectory = new File("files");

        if (!fileDirectory.exists())
        {
            fileDirectory.mkdir();

            System.out.println("Directory 'files' created");
        }

        FileIOProgram program = new FileIOProgram();

        program.welcome();

        program.runProgram();
    }

    private void welcome()
    {
        console.println("Welcome to File IO.");

        console.println("-------------------");

        console.newLine();
    }

    private void runProgram()
    {
        int input = 0;

        while (input != 4)
        {
            printMenu();

            input = console.getInt("Choose an option");

            if(input > 0 && input < 5)
            {
                switch (input)
                {
                    case 1 -> printAllFiles();
                    case 2 -> openFile();
                    case 3 -> printFile();
                }
            }
            else
            {
                console.println("Error: Invalid input. You may only input 1 - 4");

                console.newLine();

                printMenu();

                input = console.getInt("Choose an option");
            }
        }
    }

    private void printAllFiles()
    {
        File directory = new File("files");

        File[] allFiles = directory.listFiles();

        if (allFiles != null)
        {
            for (File file : allFiles)
            {
                if (file.isFile())
                {
                    console.println(file.getAbsolutePath());
                }
            }
        }

        console.newLine();
    }

    private void openFile()
    {
        String fileName = console.getString("Enter a file name");

        try (PrintWriter writer = new PrintWriter(new FileOutputStream("files/" + fileName)))
        {
            int linesInput = console.getInt("How many lines?");

            for (int i = 0; i < linesInput; i++)
            {
                String line = console.getString("Enter a line of text");

                writer.println(line);
            }
        }
        catch (FileNotFoundException ex)
        {
            console.println("Error opening file: " + ex.getMessage());
        }

        console.newLine();
    }

    private void printFile()
    {
        String fileName = console.getString("Enter a file name");

        try (Scanner reader = new Scanner(new FileInputStream("files/" + fileName)))
        {
            while (reader.hasNextLine())
            {
                System.out.println(reader.nextLine());
            }
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("Error opening file: " + ex.getMessage());
        }

        console.newLine();
    }

    private void printMenu()
    {
        console.println("1. print files directory");

        console.println("2. open file");

        console.println("3. print file");

        console.println("4. exit");
    }
}