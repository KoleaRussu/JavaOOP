package string;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class stringUsage {
    public static void main(String[] args) {
        String phrase = "";
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\dippe\\IdeaProjects\\OOP\\src\\resources\\input.txt"))) {
            String line;

            while ((line = br.readLine()) != null) {
                phrase = line;
            }
            Scanner scanner = new Scanner(System.in);
            Integer Command;
            do{
                System.out.print("Enter a Number from 0->8 (0 to close the command line \n" +
                        "1) Convert phrase to uppercase;\n" +
                        "2) Convert phrase to lowercase;\n" +
                        "3) Determine phrase length;\n" +
                        "4) Count the consonants and vowels in the phrase;\n" +
                        "5) Count the number of words in a phrase;\n" +
                        "6) Find the word having maximum length in the phrase;\n" +
                        "7) Find the word having minimum length in the phrase;\n" +
                        "8) Find all duplicate words in a phrase;\n" +
                        "Command ---");
                Command = scanner.nextInt();
                switch(Command){
                    case 1:
                        phraseToUppercase(phrase);
                        break;
                    case 2:
                        phraseToLowercase(phrase);
                        break;
                    case 3:
                        phraseLength(phrase);
                        break;
                    case 4:
                        ConsonantsAndVowels(phrase);
                        break;
                    case 5:
                        numberWords(phrase);
                        break;
                    case 6:
                        wordMaximLen(phrase);
                        break;
                    case 7:
                        wordMinimLen(phrase);
                        break;
                    case 8:
                        findDuplicates(phrase);
                        break;
                    default :
                        System.out.println("error");
                        break;
                }
            }while(Command != 0);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void phraseToUppercase(String args) {
        args = args.toUpperCase();
        try (FileWriter writer = new FileWriter("C:\\Users\\dippe\\IdeaProjects\\OOP\\src\\resources\\output.txt")) {
            writer.write(args);
            System.out.println("Well Done! Check the output.txt!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void phraseToLowercase(String args) {
        args = args.toLowerCase();
        try (FileWriter writer = new FileWriter("C:\\Users\\dippe\\IdeaProjects\\OOP\\src\\resources\\output.txt")) {
            writer.write(args);
            System.out.println("Well Done! Check the output.txt!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void phraseLength(String args) {
        Integer argsLength = args.length()+1;
        try (FileWriter writer = new FileWriter("C:\\Users\\dippe\\IdeaProjects\\OOP\\src\\resources\\output.txt")) {
            writer.write("the length of this( "+ args +" )phrase is --" + argsLength);
            System.out.println("Well Done! Check the output.txt!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void ConsonantsAndVowels(String args) {
        int vowelCount = 0;
        int consonantCount = 0;
        for (char c : args.toCharArray()) {
            if (Character.isLetter(c)) {
                if ("AEIOUaeiou".indexOf(c) != -1) {
                    vowelCount++;
                } else {
                    consonantCount++;
                }
            }
        }
        try (FileWriter writer = new FileWriter("C:\\Users\\dippe\\IdeaProjects\\OOP\\src\\resources\\output.txt")) {
            writer.write("In this phrase ( "+ args +" ) are " + vowelCount + " vowels and there are " + consonantCount + " Consonants" );
            System.out.println("Well Done! Check the output.txt!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void numberWords(String args) {
        String[] words = args.split(" ");
        int wordCount = words.length ;
        try (FileWriter writer = new FileWriter("C:\\Users\\dippe\\IdeaProjects\\OOP\\src\\resources\\output.txt")) {
            writer.write("In this phrase ( " + args +" ) the are "+ wordCount + " words!");
            System.out.println("Well Done! Check the output.txt!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void wordMaximLen(String args) {
        String[] words = args.split(" ");
        String longestWord = "";

        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }
        try (FileWriter writer = new FileWriter("C:\\Users\\dippe\\IdeaProjects\\OOP\\src\\resources\\output.txt")) {
            writer.write("In this phrase ( " + args +" ) the longest word is -- " + longestWord);
            System.out.println("Well Done! Check the output.txt!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void wordMinimLen(String args) {
        String[] words = args.split(" ");
        String shorterWord = "sdfhgdshfghdslfhdsfhdshkfhkdshfjdashkjfhdaskj";

        for (String word : words) {
            if (word.length() < shorterWord.length()) {
                shorterWord = word;
            }
        }
        try (FileWriter writer = new FileWriter("C:\\Users\\dippe\\IdeaProjects\\OOP\\src\\resources\\output.txt")) {
            writer.write("In this phrase ( " + args +" ) the shortest word is -- " + shorterWord);
            System.out.println("Well Done! Check the output.txt!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void findDuplicates(String args) {
        String[] words = args.split(" ");
        Set<String> uniqueWords = new HashSet<>();
        Set<String> duplicateWords = new HashSet<>();

        for (String word : words) {
            if (!uniqueWords.add(word)) {
                duplicateWords.add(word);
            }
        }
        try (FileWriter writer = new FileWriter("C:\\Users\\dippe\\IdeaProjects\\OOP\\src\\resources\\output.txt")) {
            if(duplicateWords.size()== 0){
                writer.write("In this phrase ( " + args +" ) there are not duplicates" );
            } else{
                writer.write("In this phrase ( " + args +" ) the duplicated words are -- " + duplicateWords);
            }
            System.out.println("Well Done! Check the output.txt!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
