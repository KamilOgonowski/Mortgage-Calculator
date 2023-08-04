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
        System.out.println("Principal ($1K - $1M): ");
        while (true){
            principal = scanner.nextFloat();
            if (principal > 1_000 && principal < 1_000_000){
                break;
            } else
                System.out.println("Enter a number between 1,000 and 1,000,000.");
        }

        System.out.println("Annual InterestRate: ");
        while (true){
            annualInterestRate = scanner.nextFloat();
            if (annualInterestRate > 0 && annualInterestRate <= 30){
                break;
            } else
                System.out.println("Enter a value greater than 0 and less than or equal to 30.");
        }
        monthlyInterestRate = annualInterestRate/MONTHS_IN_YEAR/PERCENT;

        System.out.println("Period (Years): ");
        while (true){
            years = scanner.nextByte();
            if (years > 0 && years <= 30){
                break;
            } else
                System.out.println("Enter a value between 1 and 30.");
        }
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