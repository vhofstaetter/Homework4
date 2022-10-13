package net.htlgkr.hove.pos3.hausuebung4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class GausscheSumMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many number do you want to have added?");
        int totalNumbers = scanner.nextInt();
        int chunks = 0;
        ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(1);
        List<GausscheSum> gausscheSumList = new ArrayList<>();
        gausscheSumList.add(new GausscheSum(1, 100));
        chunks++;
        boolean chunking = true;
        while (chunking) {
            int og = 100 * (chunks + 1);
            if (og > totalNumbers) {
                og = totalNumbers;
                chunking = false;
            }
            gausscheSumList.add(new GausscheSum((100 * (chunks)) + 1, og));
            chunks++;
        }

        List<Future<Integer>> futuresList;
        try {
            futuresList = executorService.invokeAll(gausscheSumList);
        } catch (InterruptedException exception) {
            throw new RuntimeException(exception);
        }
        List<Boolean> booleanList;
        do {
            booleanList = futuresList.stream().map(Future::isDone).toList();
        } while ((booleanList.contains(false)));

        System.out.println(futuresList.stream().map(integerFuture -> {
            try {
                return integerFuture.get();
            } catch (InterruptedException | ExecutionException exception) {
                throw new RuntimeException(exception);
            }
        }).reduce(0, Integer::sum));
    }
}
