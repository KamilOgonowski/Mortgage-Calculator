import java.text.NumberFormat;

public class PrintResults {

    final static byte MONTHS_IN_YEAR = 12;
    final static byte PERCENT = 100;

    public static void printPaymentSchedule(
            int principle,
            float annualInterestRate,
            byte years) {

        float monthlyInterestRate = annualInterestRate/MONTHS_IN_YEAR/PERCENT;
        short numberOfPayments = (short) (years * MONTHS_IN_YEAR);

        System.out.println("\nPAYMENT SCHEDULE");
        System.out.println("----------------");

        for (short paymentsWeMade = 1; paymentsWeMade <= numberOfPayments; paymentsWeMade++){
            Calculations.calculateBalance(principle,monthlyInterestRate, numberOfPayments, paymentsWeMade);
        }
    }

    public static void printMortgage(int principle, float annualInterestRate, short years) {

        float monthlyInterestRate = annualInterestRate/MONTHS_IN_YEAR/PERCENT;
        short numberOfPayments = (short) (years * MONTHS_IN_YEAR);

        double mortgage = Calculations.calculateMortgage(principle, monthlyInterestRate, numberOfPayments);
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println("Monthly Payments: " + mortgageFormatted);
    }
}
