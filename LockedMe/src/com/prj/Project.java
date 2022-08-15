package com.prj;

import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Scanner;

public class Project {
	public static File prj = new File("project");

    public static void main(String[] args) {
        System.out.println("******************************************************************");
        System.out.println("LockedMe functions");
        System.out.println("1. Retrieve Files.");
        System.out.println("2. Business Operations.");
        System.out.println("3. Exit the Application.");

        Scanner inp = new Scanner(System.in);

        int selected = inp.nextInt();
        char char1 = 'Y';

        do {
            switch (selected) {
                case 1:
                    retrieveFiles();
                    char1 = 'N';
                    System.exit(0);
                    break;
                case 2:
                    bussinessOperation();
                    char1 = 'N';
                    break;
                case 3:
                    char1 = 'N';
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please choose again from 1 to 3.");
                    selected = inp.nextInt();
            }
        } while (char1 == 'Y');
    }

    

    public static void bussinessOperation() {

        System.out.println("=================================\n");
        System.out.println("LockedMe functions");
        System.out.println("1. Add File.");
        System.out.println("2. Delete File");
        System.out.println("3. Search File.");
        System.out.println("4. Close Application");

        Scanner inp = new Scanner(System.in);

        int selected = inp.nextInt();
        char opr = 'Y';

        do {
            switch (selected) {
                case 1:
                    addFile();
                    bussinessOperation();
                    break;
                case 2:
                    deleteFile();
                    bussinessOperation();
                    break;
                case 3:
                    searchFile();
                    bussinessOperation();
                    break;
                case 4:
                    opr = 'Y';
                    main(null);
                    break;
                case 5:
                    opr = 'N';
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please choose 1 to 5.");
                    selected = inp.nextInt();
            }
        } while (opr == 'Y');
    }

    public static void retrieveFiles() {
        System.out.println("List of Files: ");
        try {
            String folderPath = prj.getAbsolutePath();
            File filesFolder = new File(folderPath);
            String[] files = filesFolder.list();
            if (files.length > 0) {
                Arrays.sort(files);
                for (String file : files) {
                    System.out.println(file);
                }
            } else {
                System.out.println(" - No Files Found! - ");
            }
         main(null);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public static void addFile() {
        System.out.println("Enter File Name ");
        Scanner inp = new Scanner(System.in);
        String fileName = inp.next();
        try {
            FileWriter addedFile = new FileWriter(prj.getAbsolutePath() + "\\" + fileName);
            addedFile.write(fileName + " file created by LockedMe");
            addedFile.close();
            System.out.println(fileName + " file created");
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public static void deleteFile() {
        System.out.println("Enter File Name ");
        Scanner inp = new Scanner(System.in);
        String fileName = inp.next();
        try {
            String folderPath = prj.getAbsolutePath();
            File folderToCheck = new File(folderPath);
            File[] fileFound = folderToCheck.listFiles(new CheckFile(fileName));
            if (fileFound.length == 1) {
                File file = new File(folderPath + "\\" + fileName);
                file.delete();
                System.out.println(fileName +" deleted successfully");
            } else {
                System.out.println("File Not Found!");
            }

        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public static void searchFile() {
        System.out.println("Enter File Name ");
        Scanner inp = new Scanner(System.in);
        String name = inp.next();

        try {
            String folderPath = prj.getAbsolutePath();
            File folderToCheck = new File(folderPath);
            File[] fileFound = folderToCheck.listFiles(new CheckFile(name));
            if (fileFound.length == 1) {
                System.out.println("File Exist on "+prj.getAbsolutePath() );
            } else {
                System.out.println("File Not Found!");
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}


