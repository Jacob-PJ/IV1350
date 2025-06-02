package src.se.kth.iv1350.sem3.util;

import java.util.Random;

public class RandomCompositor {
    private Random random;

    public RandomCompositor() {
        this.random = new Random();
    }

    public int nextEvenInt(int max) {
        int evenInt = random.nextInt(max / 2) * 2;

        String printout = "\nCompositance: \n";
        printout += "1. nextEvenInt(): \n";
        printout += "2. int evenInt = random.nextInt(max / 2) * 2;\n";
        printout += "3. Calls random.nextInt() from java.util.Random which we modify within our nextEvenInt() method to guaratne its even. In this case we need to import the random class to use it.\n";
        printout += "4. Result: ";
        System.out.println(printout + evenInt);
        return evenInt;
    }
}
