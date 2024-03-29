package string;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.Scanner;

import  java.io.IOException;

public class StringUsage {
    public static void main(String[] args) throws IOException {

        StringBuilder readResult = readFile();
        String phrase = String.valueOf(readResult);

        FileWriter file = new FileWriter( "Result.txt");


        convertUpperCase(phrase, file);

        consonantsVowels(phrase);

        duplicateWords(phrase);

        maxLenght(phrase);
        minLenghtt(phrase);

        int lenght = lineLength(phrase, file);
        System.out.println("Phrase Length: " + lenght);

        convertLowerCase(phrase, file);

        int max = maximumLength (phrase, file);
        System.out.println("Maximum Lenght: " + max);

        int numberWords = consAndVowels(phrase, file);
        System.out.println("Number of Words: " + numberWords);

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

    private static void consonantsVowels(String phrase) throws IOException {
        int vowels = 0, consonants = 0;

        phrase = phrase.toLowerCase();

        for(int i = 0; i < phrase.length(); i++) {
            char ch = phrase.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                vowels++;
            } else if (ch >= 'a' && ch <= 'z') {
                consonants++;
            }
        }
        System.out.println("Volwes: " + vowels);
        System.out.println("Consonants: " + consonants);
    }
    private static void maxLenght(String phrase) throws IOException {

        String[] words = phrase.split("\\s+");
                String longestWord = "";
        for(String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }
        System.out.println("Maximum Length: " + longestWord);
    }
    private static void minLenghtt(String phrase) throws IOException {

        String[] words = phrase.split("\\s+");
        String shortestWord = words[0];
        for(int i = 1; i < words.length; i++) {
            if (words[i].length() < shortestWord.length()) {
                shortestWord = words[i];
            }
        }
        System.out.println("MixLength: " + shortestWord);
    }
    private static void duplicateWords(String phrase) throws IOException {
        String[] words = phrase.split("\\s+");
        Set<String> repeatWods = new  HashSet<>();
        Set<String> uniqeWods = new  HashSet<>();
        for(String word : words) {
            if(words[])
        }
    }
}
