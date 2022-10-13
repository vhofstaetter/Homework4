package net.htlgkr.hove.pos3.hausuebung4;

import java.util.List;

public class Divider implements Runnable {
    List<Integer> toCheckIntegers;
    int teiler;

    public Divider(List<Integer> toCheckIntegers, int teiler) {
        this.toCheckIntegers = toCheckIntegers;
        this.teiler = teiler;
    }

    @Override
    public void run() {
        for (int i = 0; i < toCheckIntegers.size(); i++) {
            if (toCheckIntegers.get(i) % teiler == 0) {
                System.out.println(toCheckIntegers.get(i));
            }
        }
    }
}
