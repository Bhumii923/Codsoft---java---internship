import java.util.Scanner;

public class CurrencyConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Fixed exchange rates (example values)
        double usdToInr = 83.5;
        double eurToInr = 91.2;

        System.out.println("--- Currency Converter ---");
        System.out.println("1. USD to INR");
        System.out.println("2. EUR to INR");
        System.out.println("3. INR to USD");
        System.out.println("4. INR to EUR");
        System.out.print("Choose option: ");
        int choice = sc.nextInt();

        System.out.print("Enter amount: ");
        double amount = sc.nextDouble();
        double result = 0;

        switch (choice) {
            case 1:
                result = amount * usdToInr;
                System.out.println(amount + " USD = " + result + " INR");
                break;
            case 2:
                result = amount * eurToInr;
                System.out.println(amount + " EUR = " + result + " INR");
                break;
            case 3:
                result = amount / usdToInr;
                System.out.println(amount + " INR = " + result + " USD");
                break;
            case 4:
                result = amount / eurToInr;
                System.out.println(amount + " INR = " + result + " EUR");
                break;
            default:
                System.out.println("❌ Invalid choice.");
        }

        sc.close();
    }
}
