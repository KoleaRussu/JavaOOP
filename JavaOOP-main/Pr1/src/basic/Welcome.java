package basic;

import java.util.Scanner;

public class Welcome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
                System.out.print("Introdeceti text");
        String msg = scanner.nextLine();
        System.out.println("Your message:" +msg);

        System.out.print("Number 1: ");
        int num1 = scanner.nextInt();
        System.out.print("Number 2: ");
        int num2 = scanner.nextInt();
        System.out.print("Operator 1: ");
        char oper = scanner.next().charAt(0);
        double result = 0.0;
        switch (oper){
            case '+' -> result = num1 + num2;
            case '-' -> result = num1 - num2;
            case '/' -> result = (double)num1 / num2;
            case '*' -> result = num1 * num2;
        }
        System.out.println("Result: " + result);




    }
}
