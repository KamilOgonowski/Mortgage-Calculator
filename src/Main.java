
public class Main {
    public static void main(String[] args) {
        int principle = (int) Console.readNumber("Principle",1000, 1_000_000);
        float annualInterestRate = (float) Console.readNumber("Annual Interest Rate",0, 30);
        byte years = (byte) Console.readNumber("Years (Period)",0, 30);
//
//        MortgageCalculator mortgage = new MortgageCalculator(principle,annualInterestRate, years);

        var calcuator = new MortgageCalculator(principle,annualInterestRate,years);
        var report = new MortgageReport(calcuator);
        report.printMortgage();
        report.printPaymentSchedule();
    }
}