import java.util.Scanner;

public class Consol {

    public static double readNumber(String prompt, double min, double max){
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println(prompt + ": ");
            double value = scanner.nextDouble();
            if (value > min && value <= max){
                return value;
            } else
                System.out.println("Enter a value between "+ min + " and " + max);
        }
    }
}
