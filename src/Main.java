import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        float montlhyPayment;
        float principal;
        float annualInterestRate;
        float monthlyInterestRate;
        int numberOfPayments;


        System.out.println("Principal: ");
        principal = scanner.nextFloat();

        System.out.println("Annual InterestRate: ");
        annualInterestRate = scanner.nextFloat();

        System.out.println("Period (Years): ");
        numberOfPayments = scanner.nextInt();


        System.out.println(principal + " prinicpal/ " + annualInterestRate + " annualInterestRate/ " + numberOfPayments + " numberOfPayments/ ");
    }
}