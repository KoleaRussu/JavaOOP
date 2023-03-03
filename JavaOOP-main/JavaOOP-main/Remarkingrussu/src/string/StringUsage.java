package string;

import javax.sound.midi.SysexMessage;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

import  java.io.IOException;

public class StringUsage {
    public static void main(String[] args) throws IOException {

        StringBuilder readResult = readFile();
        String phrase = String.valueOf(readResult);

        FileWriter file = new FileWriter( "Result.txt");


        convertUpperCase(phrase, file);


        int lenght = lineLength(phrase, file);
        System.out.println("Phrase Length: " + lenght);

        convertLowerCase(phrase, file);

        int max = maximumLength (phrase, file);
        System.out.println("Maximum Lenght: " + max);

        int numberWords = consAndVowels(phrase, file);
        System.out.println("Number of Words: " + numberWords);

//        int consonantsAndVowels =
    }

    private static StringBuilder readFile() throws IOException {
        String path = "C:/Users/User/Desktop/JavaOOP-main/Remarkingrussu/src/string/Text.txt";
        FileReader file = new FileReader(path);
        Scanner scan = new Scanner(file);
        StringBuilder phrase = new StringBuilder();

        while(scan.hasNextLine()) {
            phrase.append(scan.nextLine());
        }
        file.close();

        return phrase;
    }

    private static void convertUpperCase(String phrase, FileWriter file)  throws IOException{
        System.out.println("Phrase upercase: " + phrase.toUpperCase());
        file.write("\nPhrase in lowercase: " + phrase.toUpperCase());
    }


    private static void convertLowerCase(String phrase, FileWriter file) throws IOException {
        System.out.println("Phrase in lovercase: " + phrase.toLowerCase());
        file.write("\nPhrase in lowercase: " + phrase.toLowerCase());
    }

    private static int lineLength(String phrase, FileWriter file) throws IOException {
        file.write("\nPhrase in lowercase: " + phrase.length());
        return phrase.length();
    }

    private static int consAndVowels(String phrase , FileWriter file) throws IOException {
        file.write("\nPhrase in lowercase: " + phrase.length());
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

    private  static int maximumLength(String phrase, FileWriter file) throws IOException {
        return 0;
    }
}
