import java.text.NumberFormat;



public class MortgageReport {

    private static MortgageCalculator calculator;

    public static void printMortgage(int principle, float annualInterestRate, short years) {
        calculator = new MortgageCalculator(principle, annualInterestRate, years);
        double mortgage = calculator.calculateMortgage();
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println("Monthly Payments: " + mortgageFormatted);
    }
    public static void printPaymentSchedule(int principle, float annualInterestRate, short years){
        System.out.println("\nPAYMENT SCHEDULE");
        System.out.println("----------------");
        for (short paymentsWeMade = 1; paymentsWeMade <= years * MortgageCalculator.MONTHS_IN_YEAR; paymentsWeMade++){
            double balance = MortgageCalculator.calculateBalance(paymentsWeMade);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        }
    }


}
