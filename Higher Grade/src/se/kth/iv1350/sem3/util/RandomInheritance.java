package src.se.kth.iv1350.sem3.util;

import java.util.Random;

public class RandomInheritance extends Random {

    @Override
    public int nextInt(int max) {
        int evenInt = super.nextInt(max / 2) * 2;

        String printout = "\nInheritance: \n";
        printout += "1. super.nextInt(max / 2) * 2: \n";
        printout += "2. This time the class ingerits the random.nextInt() from java.util.Random which we can directly run by writing 'super' ahead of the method call. Passing an arguments to make sure our value turns out even\n";
        printout += "3. Result: ";
        System.out.println(printout + evenInt);
        return evenInt;
    }
}
