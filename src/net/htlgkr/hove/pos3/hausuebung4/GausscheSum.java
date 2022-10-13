package net.htlgkr.hove.pos3.hausuebung4;

import java.util.concurrent.Callable;

public class GausscheSum implements Callable<Integer> {
    public int minimumNumber;
    public int maximumNumber;

    public GausscheSum(int minimumNumber, int maximumNumber) {
        this.minimumNumber = minimumNumber;
        this.maximumNumber = maximumNumber;
    }

    @Override
    public Integer call() throws Exception {
        return (((maximumNumber * maximumNumber) + maximumNumber) / 2) - ((((minimumNumber - 1) * (minimumNumber - 1)) + minimumNumber - 1) / 2);
    }
}
