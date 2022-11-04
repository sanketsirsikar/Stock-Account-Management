package com.bridgelabz;

import java.util.ArrayList;
import java.util.Scanner;

public class StockPortfolio {
    ArrayList<Stock> listofStocks = new ArrayList<>();
    private static int balance = 10000;

    static Scanner sc = new Scanner(System.in);


    public StockPortfolio(ArrayList<Stock>listofStocks) {
        this.listofStocks=listofStocks;
    }
    public StockPortfolio(){
        super();
    }

    @Override
    public String toString() {
        return "StockPortfolio{" +
                "listofStocks=" + listofStocks +
                '}';
    }
    public void addToPortfolio(Stock stock) {
        this.listofStocks.add(stock);
    }
    public void displayportfilio() {
        System.out.println("\nDisplaying Stock Portfolio...\n");
        System.out.println("STOCK\tVALUE\tSHARES\tPRICE");
        for (Stock stockToPrint : this.listofStocks) {
            System.out.println(stockToPrint.getName() + "\t" + stockToPrint.getValue() + "\t" + stockToPrint.getNumberOfShares() + "\t" + stockToPrint.getSharePrice());
        }
    }
    public void displayStockReport() {
        System.out.println("\n\nSTOCK REPORT");
        displayportfilio();
        System.out.println("\n\nTotal Stock Value : " + calculateTotalValue());
        }
    public int calculateTotalValue() {
        int totalValue = 0;
        for(Stock stock :this.listofStocks) {
            totalValue += stock.getValue();
        }
        return totalValue;
    }

    public void debit() {
        System.out.println("\nBalance amount :$" + balance);
        System.out.println("\"\\nBalance amount :$\" + balance");
        int debit = sc.nextInt();
        if (balance - debit > 0) {
            balance = balance - debit;
            System.out.println("\nDebit Successful!");
            System.out.println("Balance amount :$" + balance);
        } else
            System.out.println("\nInsufficient funds.\nDebit amount exceeded account balance.\nDebit Failure.");
    }
    public int getActivityChoice(){
        int input =0;
        do {
            System.out.println("\nSelect the activity you would like to perform.");
            System.out.println("1. Add stocks");
            System.out.println("2. Display stock report");
            System.out.println("3. Debit from Account");
            System.out.println("4. Exit");
            System.out.print("\nEnter your choice : ");
            input = sc.nextInt();

            if (!(input >=1 && input <= 4))
                System.out.println("\nInvalid choice!\nPlease try again.\n");
        } while (!(input >=1 && input <= 4));

            return input;
        }

        public void selectActivity() {
            int choice = 0;
            while (choice != 4) {
                choice = getActivityChoice();

                switch (choice) {
                    case 1:
                        Stock stockObj = new Stock();
                        stockObj.addStocks(new StockPortfolio(listofStocks));
                        break;

                    case 2:
                        displayStockReport();
                        break;

                    case 3:
                        debit();
                        break;

                    case 4:
                        System.out.println("\nExiting Stock Account Management Program.");
                        break;
                }
            }
        }
    }






