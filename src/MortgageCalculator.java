import java.text.NumberFormat;

public class MortgageCalculator {
    final static byte MONTHS_IN_YEAR = 12;
    final static byte PERCENT = 100;

    private int principle;
    private float annualInterestRate;
    private short years;


    public MortgageCalculator(int principle, float annualInterestRate, short years) {
        this.principle = principle;
        this.annualInterestRate = annualInterestRate;
        this.years = years;
    }

    public double calculateMortgage(){
        double mortgage = principle*
                (annualInterestRate * Math.pow(1 + annualInterestRate, years))
                /(Math.pow(1 + annualInterestRate, years)-1);
        return mortgage;
    }

    public void calculateBalance(short numberOfPaymentMade) {

        float monthlyInterestRate = annualInterestRate/ MortgageCalculator.MONTHS_IN_YEAR/ MortgageCalculator.PERCENT;
        short numberOfPayments = (short) (years * MortgageCalculator.MONTHS_IN_YEAR);

        double remainingLoanBalance = principle
                *((Math.pow(1 + monthlyInterestRate, numberOfPayments))
                -(Math.pow(1 + monthlyInterestRate, numberOfPaymentMade)))
                /(Math.pow(1 + monthlyInterestRate, numberOfPayments)-1);
     }
}
