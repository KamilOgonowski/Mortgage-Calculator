import java.text.NumberFormat;

public class Calculations {

    public static double calculateMortgage(
            int principle,
            float monthlyInterestRate,
            short numberOfPayments) {

        double mortgage = principle*
                (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments))
                /(Math.pow(1 + monthlyInterestRate, numberOfPayments)-1);
        return mortgage;
    }

    public static void calculateBalance(
            int principle,
            float monthlyInterestRate,
            short numberOfPayments,
            short numberOfPaymentMade) {

        double remainingLoanBalance = principle
                *((Math.pow(1 + monthlyInterestRate, numberOfPayments))
                -(Math.pow(1 + monthlyInterestRate, numberOfPaymentMade)))
                /(Math.pow(1 + monthlyInterestRate, numberOfPayments)-1);
        String remainingAmount = NumberFormat.getCurrencyInstance().format(remainingLoanBalance);
        System.out.println(remainingAmount);
    }
}
