package sortassignment;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class GenerateDataSets {

    public enum DataSetTypes {
        RANDOM,
        PI,
        BINARY,
        FIBONACCI,
        EVEN,
        SORTEDNESS_ASCENDING,
        SORTEDNESS_DESCENDING,
        SORTEDNESS_ASCENDING_DESCENDING,
        SORTEDNESS_DESCENDING_ASCENDING
    }

    public void generateDateSets(DataSetTypes dataSetType, String fileName, int weight) throws IOException {

        switch (dataSetType) {
            case RANDOM:
                generateRandom(fileName, weight);
                break;
            case PI:
                generatePI(fileName, weight);
                break;
            case BINARY:
                generateBinary(fileName, weight);
                break;
            case FIBONACCI:
                generateFibonacci(fileName, weight);
                break;
            case EVEN:
                generateEven(fileName, weight);
                break;
            case SORTEDNESS_ASCENDING:
                generateSortedNessAscending(fileName, weight);
                break;
            case SORTEDNESS_DESCENDING:
                generateSortedNessDescending(fileName, weight);
                break;
            case SORTEDNESS_ASCENDING_DESCENDING:
                generateSortedNessAscendingDescending(fileName, weight);
                break;
            case SORTEDNESS_DESCENDING_ASCENDING:
                generateSortedDescendingAscending(fileName, weight);
                break;
        }
    }

    private void generateRandom(String fileName, int weight) throws IOException {
        PrintWriter printWriter = new PrintWriter(fileName, "UTF-8");
        Random random = new Random();
        for (int i=0; i < weight; i++) {
            for (int j=0; j < weight; j++) {
                printWriter.println(random.nextInt(600));
            }
        }

        printWriter.close();
    }

    private void generatePI(String fileName, int weight) throws IOException {
        PI pi = new PI();
        pi.calcPiDigits(fileName, weight);
    }

    private void generateBinary(String fileName, int weight) throws IOException {
        PrintWriter printWriter = new PrintWriter(fileName, "UTF-8");
        for (int i=0; i < weight; i++) {
            for (int j=0; j < weight; j++) {
                if (i%2 == 0) {
                    printWriter.println(0);
                } else {
                    printWriter.println(1) ;
                }
            }
        }

        printWriter.close();

    }

    private void generateEven(String fileName, int weight) throws IOException {
        PrintWriter printWriter = new PrintWriter(fileName, "UTF-8");
        for (int i=0; i < weight * weight; i++) {
                if (i%2 == 0) {
                    printWriter.println(i);
                }
        }

        printWriter.close();

    }

    private void generateSortedNessDescending(String fileName, int weight) throws IOException {
        PrintWriter printWriter = new PrintWriter(fileName, "UTF-8");
        for (int i= weight * weight; i >= 0 ; i--) {
                printWriter.println(i);
        }

        printWriter.close();

    }

    private void generateSortedNessAscendingDescending(String fileName, int weight) throws IOException {
        PrintWriter printWriter = new PrintWriter(fileName, "UTF-8");
        for (int i=0; i < (weight * weight)/2; i++) {
                printWriter.println(i);
        }

        for (int j= (weight * weight)/2; j >= 0 ; j--) {
            printWriter.println(j);
        }
        printWriter.close();
    }

    private void generateSortedDescendingAscending(String fileName, int weight) throws IOException {
        PrintWriter printWriter = new PrintWriter(fileName, "UTF-8");
        for (int i=0; i < (weight * weight)/4; i++) {
            printWriter.println(i);
        }

        for (int j= 3*(weight * weight)/4; j >= 0 ; j--) {
            printWriter.println(j);
        }
        printWriter.close();
    }


    private void generateSortedNessAscending(String fileName, int weight) throws IOException {
        PrintWriter printWriter = new PrintWriter(fileName, "UTF-8");
        for (int i=0; i < weight * weight; i++) {
            printWriter.println(i);
        }

        printWriter.close();
    }

    private void generateFibonacci(String fileName, int weight) throws IOException {
        PrintWriter printWriter = new PrintWriter(fileName, "UTF-8");
        int index = 0;

        for (int i =0; i < weight * weight; i++)
        {
            printWriter.println(fibonacci(index));
            index++;
        }
        printWriter.close();

    }

    public static long fibonacci (int i)
    {
        if (i == 0) return 0;
        if (i<= 2) return 1;

        long fibTerm = fibonacci(i - 1) + fibonacci(i - 2);
        return fibTerm;
    }
}
