package net.htlgkr.hove.pos3.hausuebung4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main mainClass = new Main();
        List<Integer> csvFile = mainClass.readCSVFile();
        List<Integer> dividedList = mainClass.divide(csvFile);
        mainClass.printNumbersList(dividedList);
    }

    public void seprateIntoChunks(List<Integer> integerList) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type in a divider:");
        int divider = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Type in, in how many chunks you want to split it:");
        int chunk = scanner.nextInt();
        scanner.nextLine();
        int listSize = integerList.size();
        int chunkSize = listSize/chunk;

    }

    public List<Integer> divide(List<Integer> numbersList) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type in a divider:");
        int divider = scanner.nextInt();
        List<Integer> dividedList = new ArrayList<>();
        scanner.nextLine();
        for (int i = 0; i < numbersList.size(); i++) {
            if (numbersList.get(i) % divider == 0) {
                int tmp = numbersList.get(i);
                dividedList.add(tmp);
            }
        }
        return dividedList;
    }

    public List<Integer> readCSVFile() {
        List<Integer> numbersList = null;
        try {
            Scanner scanner = new Scanner(new File("numbers.csv"));
            numbersList = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(":");
                for (int i = 0; i < parts.length; i++) {
                    if (parts[i] != null && !parts[i].equals("") && parts[i].matches("[+-]?\\d*(\\.\\d+)?")) {
                        numbersList.add(Integer.valueOf(parts[i]));
                    }
                }
            }
            scanner.close();
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }

        return numbersList;
    }

    public void printNumbersList(List<Integer> numbersList) {
        System.out.println("Numbers:");
        for (int i = 0; i < numbersList.size(); i++) {
            System.out.println(numbersList.get(i));
        }
    }
}
