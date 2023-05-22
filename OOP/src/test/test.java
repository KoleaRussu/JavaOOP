package test;

import java.util.ArrayList;
import java.util.Scanner;

public class test {
    public final static void main(String... arguments) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество чисел: ");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Введите число " + (i + 1) + ": ");
            int number = scanner.nextInt();

            boolean containsSeven = false;
            while (number > 0) {
                int digit = number % 10;
                if (digit == 7) {
                    containsSeven = true;
                    break;
                }
                number /= 10;
            }

            if (containsSeven) {
                System.out.println("Число " + number + " содержит цифру 7");
            }
        }
    }
}





