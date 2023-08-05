import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        float principal;
        float annualInterestRate;
        float monthlyInterestRate;
        byte years;

        principal = (float) readNumber("Principal",1000, 1_000_000);
        annualInterestRate = (float) readNumber("Annual Interest Rate",0, 30);
        years = (byte) readNumber("Years (Period)",0, 30);
        monthlyInterestRate = annualInterestRate/MONTHS_IN_YEAR/PERCENT;
        int numberOfPayments = years * MONTHS_IN_YEAR;

        double mortgage = principal
                *(monthlyInterestRate*(Math.pow(1 + monthlyInterestRate, numberOfPayments)))
                /(Math.pow(1 + monthlyInterestRate, numberOfPayments)-1);

        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        String monthlyPaymentConverted = formatter.format(mortgage);
//        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);

        System.out.println("Monthly payment is equal to: " + monthlyPaymentConverted);

    }


    public static double readNumber(String prompt, int min, int max){
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println(prompt + ": ");
            double value = scanner.nextDouble();
            if (value > min && value < max){
                return value;
            } else
                System.out.println("Enter a number between "+ min + " and " + max);
        }
    }

}