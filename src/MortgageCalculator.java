public class MortgageCalculator {
    private final static byte MONTHS_IN_YEAR = 12;
    private final static byte PERCENT = 100;

    private int principal;
    private float annualInterestRate;
    private short years;


    public MortgageCalculator(int principal, float annualInterestRate, short years) {
        this.principal = principal;
        this.annualInterestRate = annualInterestRate;
        this.years = years;
    }

    public double calculateMortgage(){

        float monthlyInterestRate = getMonthlyInterestRate();
        float numberOfPayments = getNumberOfPayments();

        double mortgage = principal *
                (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments))
                /(Math.pow(1 + monthlyInterestRate, numberOfPayments)-1);
        return mortgage;
    }

    public double calculateBalance(short numberOfPaymentMade) {

        float monthlyInterestRate = getMonthlyInterestRate();
        float numberOfPayments = getNumberOfPayments();

        double remainingLoanBalance = principal
                *((Math.pow(1 + monthlyInterestRate, numberOfPayments))
                -(Math.pow(1 + monthlyInterestRate, numberOfPaymentMade)))
                /(Math.pow(1 + monthlyInterestRate, numberOfPayments)-1);
    return remainingLoanBalance;
    }

    public double[] getRemainingBalances() {
        var balances = new double[getNumberOfPayments()];
        for (short paymentsWeMade = 1; paymentsWeMade <= balances.length; paymentsWeMade++)
            balances[paymentsWeMade - 1] = calculateBalance(paymentsWeMade);
        return balances;
    }
    private int getNumberOfPayments() {
        return years * MONTHS_IN_YEAR;
    }

    private float getMonthlyInterestRate() {
        return annualInterestRate / MONTHS_IN_YEAR / PERCENT;
    }


}
