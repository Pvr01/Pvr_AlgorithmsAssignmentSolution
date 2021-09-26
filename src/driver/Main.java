package driver;

import service.StockAnalysis;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        StockAnalysis stockAnalysis = new StockAnalysis();
        Scanner scanner = new Scanner(System.in);

        System.out.println("enter the no of companies");
        int numberOfCompanies = scanner.nextInt();
        int loopValue = 1, a = 0, b = 0;
        double[] stockPrices = new double[numberOfCompanies];
        boolean[] isPriceRiseFall = new boolean[numberOfCompanies];

        do {
            System.out.println("Enter current stock price of the company " + loopValue);
            stockPrices[loopValue - 1] = scanner.nextDouble();
            System.out.println("Whether company's stock price rose today compare to yesterday?\n");
            isPriceRiseFall[loopValue - 1] = scanner.nextBoolean();
            if (isPriceRiseFall[loopValue - 1]) a++;
            else b++;
            loopValue++;
        } while (loopValue <= numberOfCompanies);

        int option;
        do {
            System.out.println("\n -------------------------------\n" +
                    "Enter the operation that you want to perform");
            System.out.println(" 1. Display the companies stock prices in ascending order\n" +
                    " 2. Display the companies stock prices in descending order\n" +
                    " 3. Display the total no of companies for which stock prices rose today\n" +
                    " 4. Display the total no of companies for which stock prices declined today\n" +
                    " 5. Search a specific stock price\n" +
                    " 6. press 0 to exit\n---------------------");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    stockAnalysis.sharePriceAscendingOrder(stockPrices);
                    break;
                case 2:
                    stockAnalysis.sharePriceDescendingOrder(stockAnalysis.sharePrice(stockPrices));
                    break;
                case 3:
                    System.out.println("Total no of companies whose stock price rose today : " + a);
                    break;
                case 4:
                    System.out.println("Total no of companies whose stock price declined today : " + b);
                    break;
                case 5:
                    System.out.println("enter the key value\n");
                    double searchKey = scanner.nextDouble();
                    stockAnalysis.searchElement(stockAnalysis.sharePrice(stockPrices), searchKey);
                    break;
                case 0:
                    System.out.println("Exited successfully");
                    break;
                default:
                    throw new IllegalStateException("Enter valid input");
            }
        } while (option != 0);
        scanner.close();
    }
}
