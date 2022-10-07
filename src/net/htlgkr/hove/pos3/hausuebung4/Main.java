package net.htlgkr.hove.pos3.hausuebung4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main mainClass = new Main();
        mainClass.readCSVFile();
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
                    if (parts[i] != null && parts[i].equals("") && parts[i].matches("[+-]?\\d*(\\.\\d+)?")) {
                        int tmp = Integer.parseInt(parts[i]);
                        numbersList.add(tmp);
                    }
                }
            }
            scanner.close();
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
        System.out.println("Numbers:");
        for (int i = 0; i < numbersList.size(); i++) {
            System.out.println(numbersList.get(i));
        }
    }
}
