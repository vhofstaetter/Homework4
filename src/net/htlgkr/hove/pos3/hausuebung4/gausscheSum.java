package net.htlgkr.hove.pos3.hausuebung4;

import java.util.concurrent.Callable;

public class gausscheSum implements Callable<Integer> {
    public int maximumNumber;
    public int minimumNumber;

    public gausscheSum(int maximumNumber, int minimumNumber) {
        this.maximumNumber = maximumNumber;
        this.minimumNumber = minimumNumber;
    }

    @Override
    public Integer call() throws Exception {
        return (((maximumNumber * maximumNumber) + maximumNumber) / 2) - ((((minimumNumber - 1) * (minimumNumber - 1)) + minimumNumber - 1) / 2);
    }
}
