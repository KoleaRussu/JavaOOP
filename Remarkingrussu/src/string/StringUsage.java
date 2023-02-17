package string;

import javax.sound.midi.SysexMessage;
import java.util.Scanner;

public class StringUsage {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a phrase: ");
        String phrase = scan.nextLine();

        convertUpperCase(phrase);

        int lenght = lineLength(phrase);
        System.out.println("Phrase Length: " + lenght);

        convertLowerCase(phrase);

        int max = maximumLength (phrase);
        System.out.println("Maximum Lenght: " + max);

        int numberWords = consAndVowels(phrase);
        System.out.println("Number of Words: " + numberWords);
    }

    private static void convertUpperCase(String phrase) {
        System.out.println("Pherse upercase: " + phrase.toUpperCase());
    }


    private static void convertLowerCase(String phrase) {
        System.out.println("Pherse in lovercase: " + phrase.toLowerCase());
    }

    private static int lineLength(String phrase) {
        return phrase.length();
    }

    private static int consAndVowels(String phrase) {
        int numberWords = 0;
        if (phrase.length() != 0) {
            numberWords++;
            for (int i = 0; i < phrase.length(); i++) {
                if (phrase.charAt(i) == ' ') {
                    numberWords++;
                }
            }
        }
        return numberWords;
    }

    private  static int maximumLength(String phrase){
        return 0;
    }
}
