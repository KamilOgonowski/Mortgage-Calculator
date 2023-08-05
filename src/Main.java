import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int principal = (int) readNumber("Principal",1000, 1_000_000);
        float annualInterestRate = (float) readNumber("Annual Interest Rate",0, 30);
        byte years = (byte) readNumber("Years (Period)",0, 30);

        double mortgage = calculateMortgage(principal, annualInterestRate, years);

        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        String monthlyPaymentConverted = formatter.format(mortgage);
//        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Monthly payment is equal to: " + monthlyPaymentConverted);
    }

    private static double calculateMortgage(
            int principal,
            float annualInterestRate,
            byte years) {

        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        float monthlyInterestRate = annualInterestRate/MONTHS_IN_YEAR/PERCENT;
        int numberOfPayments = years * MONTHS_IN_YEAR;

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
            if (value > min && value < max){
                return value;
            } else
                System.out.println("Enter a value between "+ min + " and " + max);
        }
    }
}