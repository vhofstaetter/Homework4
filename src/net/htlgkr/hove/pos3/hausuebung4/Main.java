package net.htlgkr.hove.pos3.hausuebung4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
    }

    public void readCSVFile() {
        List<Integer> numbersList = null;
        try {
            Scanner scanner = new Scanner(new File("numbers.csv"));
            scanner.nextLine();
            numbersList = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(":");
                for (int i = 0; i < parts.length; i++) {

                    try {
                        numbersList.add(Integer.parseInt(parts[i]));
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                }
            }
            scanner.close();
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
    }
}
