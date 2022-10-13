package net.htlgkr.hove.pos3.hausuebung4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DividerMain {

    public static void main(String[] args) {
        DividerMain dividerMainClass = new DividerMain();
        List<Integer> csvFile = dividerMainClass.readCSVFile();
        //List<Integer> dividedList = dividerMainClass.divide(csvFile);
        List<Divider> dividedList = dividerMainClass.divideWithThread(csvFile);
        dividerMainClass.printDividersList(dividedList);

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
        int chunkSize = listSize / chunk;

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

    public List<Divider> divideWithThread(List<Integer> numbersList) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type in a divider:");
        int toDevideThrough = scanner.nextInt();

        System.out.println("Type in in how big should a chunk be:");
        int chunkSize = scanner.nextInt();

        List<Divider> dividerList = new ArrayList<>();
        int counter = 0;
        Divider divider = new Divider(numbersList.subList(0, chunkSize), toDevideThrough);
        dividerList.add(divider);
        counter++;
        boolean stillChunksLeft = true;
        while (stillChunksLeft) {
            int startingPosition = chunkSize * counter + 1;
            int endingPosition = startingPosition + chunkSize;
            if (endingPosition > numbersList.size()) {
                endingPosition = numbersList.size();
                stillChunksLeft = false;
            }
            Divider divider1 = new Divider(numbersList.subList(startingPosition, endingPosition), toDevideThrough);
            dividerList.add(divider1);
        }
        return dividerList;
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

    public void printDividersList(List<Divider> dividerList) {
        System.out.println("Numbers:");
        for (int i = 0; i < dividerList.size(); i++) {
            System.out.println(dividerList.get(i));
        }
    }
}
