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

        Scanner scanner = new Scanner(System.in);

        System.out.println("Principal: ");
        principal = scanner.nextFloat();

        System.out.println("Annual InterestRate: ");
        annualInterestRate = scanner.nextFloat();
        monthlyInterestRate = annualInterestRate/MONTHS_IN_YEAR/PERCENT;

        System.out.println("Period (Years): ");
        years = scanner.nextByte();
        int numberOfPayments = years * MONTHS_IN_YEAR;

        double mortgage = principal
                *(monthlyInterestRate*(Math.pow(1 + monthlyInterestRate, numberOfPayments)))
                /(Math.pow(1 + monthlyInterestRate, numberOfPayments)-1);

        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        String monthlyPaymentConverted = formatter.format(mortgage);
//        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);

        System.out.println("Monthly payment is equal to: " + monthlyPaymentConverted);

    }
}