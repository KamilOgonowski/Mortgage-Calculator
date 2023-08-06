import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int principle = (int) Consol.readNumber("Principle",1000, 1_000_000);
        float annualInterestRate = (float) Consol.readNumber("Annual Interest Rate",0, 30);
        byte years = (byte) Consol.readNumber("Years (Period)",0, 30);

        PrintResults.printMortgage(principle, annualInterestRate, years);
        PrintResults.printPaymentSchedule(principle,annualInterestRate,years);
    }







}