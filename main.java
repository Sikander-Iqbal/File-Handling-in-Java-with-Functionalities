/*
 * File Handling in Java with functionalities
 * Developer: Muhammad Sikander Iqbal
 * Contact: taimoorahamed95959@gmail.com , www.fiverr.com/phoenixhub947
 * CopyRight @ Phoenix Hub You are not allowed to use any section of this program. This code is just for learning purpose.
 * Version: 1.0.1
 * Updated on 28-03-2021 @ 10:35 PM PKT
 */

package Java_File_Handling;

import java.io.*;
import java.util.Scanner;


public class main {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Welcome. Before you start it is to tell you that \n" +
                "for writing file path the correct way is to write it \n" +
                "like 'C:\\Users\\user name\\Desktop\\'  \nThanks\n");

        while (true) {
            menu();
            System.out.print("Choose: ");
            int opt = input.nextInt();

            switch (opt) {
                case 1:
                    seeFiles();
                    break;
                case 2:
                    createFile();
                    break;
                case 3:
                    removeFiles();
                    break;
                case 4:
                    readFile();
                    break;
                case 5:
                    writeFile();
                    break;
                case 6:
                    searchFilesWithFileType();
                    break;
                case 7:
                    getFileInfo();
                    break;
                case 8:
                    createDirectory();
                    break;
                case 9:
                    System.out.println("Thanks for using.");
                    System.exit(1);
                default:
                    System.out.println("Error occurred!!\t Try Again\n");
                    break;
            }
        }
    }

    public static void menu() {
        System.out.println("Choose from the following menu:\n");
        System.out.println(" 1. See files and folders in a directory \n " +
                "2. Create File \n 3. Remove file \n 4. Read File \n " +
                "5. Write File \n 6. Search files with file type \n " +
                "7. Get file Information \n 8. Create a Directory \n 9. Exit\n");
    }

    public static void createFile() {
        input.nextLine();

        System.out.print("Enter the file path: ");
        String path = input.nextLine();

        System.out.print("Enter file name along with file type: ");
        String fileName = input.nextLine();

        File first = new File(path + fileName);

        try{
            if (first.createNewFile()) {
                System.out.println(fileName + " Created at " + first.getAbsolutePath());
            } else {
                System.out.println(fileName + " already exists at " + first.getAbsolutePath());
            }
        } catch (IOException ex) {
            System.out.println("Error occurred!!\t Try Again.\n");
            ex.printStackTrace();
        }
    }

    public static void seeFiles() {

        input.nextLine();

        System.out.print("Enter the file path: ");
        String path = input.nextLine();

        String[] pathNames;

        File f = new File(path);

        pathNames = f.list();

        for (String pathName : pathNames) {
            System.out.println(pathName);
        }
    }

    public static void removeFiles() {

        input.nextLine();

        System.out.print("Enter the file path: ");
        String path = input.nextLine();

        System.out.print("\nEnter the file name along with its file type \nto remove: ");
        String fileName = input.nextLine();

        File f = new File(path + fileName);
        boolean hasFile = false;

        if (path.contains(fileName)){
            if (f.delete()) {
                System.out.println("\n" + fileName + " is deleted");
            }
        }   else {
            System.out.println("\nFile not found!\n");
        }
    }

    public static void readFile() {
        try {
            input.nextLine();

            System.out.print("Enter the file path: ");
            String path = input.nextLine();

            System.out.print("Enter file name along with file type: ");
            String fileName = input.nextLine();

            File myObj = new File(path + fileName);

            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println("\n" + data + "\n");
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void writeFile() {
        input.nextLine();

        System.out.print("Enter the file path: ");
        String path = input.nextLine();

        System.out.print("Enter file name along with file type: ");
        String fileName = input.nextLine();

        System.out.print("Type what you want to write in this file: ");
        String data = input.nextLine();

        try {
            FileWriter myWriter = new FileWriter(path + fileName);

            myWriter.write(data);
            myWriter.close();

            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void searchFilesWithFileType() {
        input.nextLine();

        System.out.print("Enter the file path: ");
        String path = input.nextLine();

        System.out.print("Enter file type i.e .txt: ");
        String fType = input.nextLine();

        String[] pathNames;

        File f = new File(path);

        boolean check = false;

        FilenameFilter filter = new FilenameFilter() {
            @Override
            public boolean accept(File f, String name) {
                return name.endsWith(fType);
            }
        };

        pathNames = f.list(filter);

        if (pathNames.length < 1) {
            System.out.println("\nRequired file not found!!\n");
        } else {
            for (String pathName : pathNames) {
                System.out.println(pathName);
            }
        }
    }

    public static void getFileInfo() {
        input.nextLine();

        System.out.print("Enter the file path: ");
        String path = input.nextLine();

        System.out.print("Enter file name along with file type: ");
        String fileName = input.nextLine();

        File myObj = new File(path + fileName);

        if (myObj.exists()) {
            System.out.println("\nFile name: " + myObj.getName());
            System.out.println("Absolute path: " + myObj.getAbsolutePath());
            System.out.println("Writeable: " + myObj.canWrite());
            System.out.println("Readable: " + myObj.canRead());
            System.out.println("File size in bytes: " + myObj.length() + "\n");
        } else {
            System.out.println("\n The file does not exist. \n");
        }
    }

    public static void createDirectory() {
        input.nextLine();

        System.out.print("Enter the file path: ");
        String path = input.nextLine();

        System.out.print("Enter directory name: ");
        String directoryName = input.nextLine();

        File first = new File(path + directoryName);

        if (first.mkdir()) {
            System.out.println("Directory " + directoryName + " created.\n");
        } else {
            System.out.println("Failed to created a directory. Try again.");
        }
    }
}