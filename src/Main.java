import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    final static byte MONTHS_IN_YEAR = 12;
    final static byte PERCENT = 100;

    public static void main(String[] args) {

        int principal = (int) readNumber("Principal",1000, 1_000_000);
        float annualInterestRate = (float) readNumber("Annual Interest Rate",0, 30);
        byte years = (byte) readNumber("Years (Period)",0, 30);
        float monthlyInterestRate = annualInterestRate/MONTHS_IN_YEAR/PERCENT;
        byte numberOfPayments = (byte) (years * MONTHS_IN_YEAR);

        printAmounts(principal,monthlyInterestRate,numberOfPayments);
    }

    private static double calculateMortgage(
            int principal,
            float monthlyInterestRate,
            int numberOfPayments) {

        double mortgage = principal
                *(monthlyInterestRate *(Math.pow(1 + monthlyInterestRate, numberOfPayments)))
                /(Math.pow(1 + monthlyInterestRate, numberOfPayments)-1);
        return mortgage;
    }


    public static double readNumber(String prompt, double min, double max){
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println(prompt + ": ");
            double value = scanner.nextDouble();
            if (value > min && value <= max){
                return value;
            } else
                System.out.println("Enter a value between "+ min + " and " + max);
        }
    }
    public static void paymentSchedule(
            int principal,
            float monthlyInterestRate,
            byte numberOfPayments,
            byte numberOfPaymentMade) {

        double remainingLoanBalance = principal
                *((Math.pow(1 + monthlyInterestRate, numberOfPayments))
                -(Math.pow(1 + monthlyInterestRate, numberOfPaymentMade)))
                /(Math.pow(1 + monthlyInterestRate, numberOfPayments)-1);
                String remainingAmount = NumberFormat.getCurrencyInstance().format(remainingLoanBalance);
        System.out.println(remainingAmount);
    }

    public static void printAmounts(
            int principal,
            float monthlyInterestRate,
            byte numberOfPayments) {

        System.out.println("MORTGAGE");
        System.out.println("--------");
        double mortgage = calculateMortgage(principal, monthlyInterestRate, numberOfPayments);
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Monthly Payments: " + mortgageFormatted);
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");

        for (byte paymentsWeMade = 1; paymentsWeMade <= numberOfPayments; paymentsWeMade++){
            paymentSchedule(principal,monthlyInterestRate, numberOfPayments, paymentsWeMade);
        }
    }
}