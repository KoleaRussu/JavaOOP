package collections;

import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;

class CollectionsUsage {

    public static void main(String[] args) {
        List<String> clients = readClientsFromFile("Client.txt");
        System.out.println("Original list of clients:");
        clients.forEach(System.out::println);

        Collections.sort(clients);
        System.out.println("\nSorted list of clients:");
        clients.forEach(System.out::println);

        Set<String> distinctFirstNames = extractDistinctFirstNames(clients);
        System.out.println("\nDistinct first names:");
        distinctFirstNames.forEach(System.out::println);

        appendBirthdateAndAge("Client.txt", "ClientFinally.txt");
        try {
            // Read products-input.txt file and store data in HashMap
            Map<String, String> products = readProducts("products-input.txt");

            // Add new products
            Scanner scanner = new Scanner(System.in);

            int command;
            do {
                System.out.print("Введите 1 если хотите ввести элемент или другое значение для выхода:");
                command = scanner.nextInt();
                scanner.nextLine();
                if(command == 1){
                    System.out.print("Введите ключ: ");
                    String key = scanner.nextLine();
                    System.out.print("Введите элемент: ");
                    String element = scanner.nextLine();
                    addElement(products, key, element);
                }
            } while (command == 1);


            // Write updated products to products-output.txt file
            writeProducts(products, "products-output.txt");

            System.out.println("Products:");
            System.out.println(products);
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
    private static void addElement(Map<String, String> products, String key, String element){
        products.put(key,element);
    }

    private static List<String> readClientsFromFile(String filename) {
        List<String> clients = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                clients.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return clients;
    }

    private static Set<String> extractDistinctFirstNames(List<String> clients) {
        Set<String> distinctFirstNames = new HashSet<>();
        for (String client : clients) {
            String firstName = client.split("\\|")[0].trim();
            if (!distinctFirstNames.contains(firstName)) {
                distinctFirstNames.add(firstName);
            }
        }
        return distinctFirstNames;
    }

    private static void appendBirthdateAndAge(String inputFilename, String outputFilename) {
        SimpleDateFormat inputDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat outputDateFormat = new SimpleDateFormat("dd/MM/yyyy|yyyy-MM-dd|yyyy");
        LocalDate currentDate = LocalDate.now();
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilename));
             FileWriter writer = new FileWriter(outputFilename)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                String firstName = parts[0].trim();
                String lastName = parts[1].trim();
                String birthdateString = "01/01/1970";
                int age = 0;
                if (parts.length > 2) {
                    try {
                        inputDateFormat.parse(parts[2].trim());
                        birthdateString = parts[2].trim();
                        LocalDate birthdate = LocalDate.parse(outputDateFormat.format(inputDateFormat.parse(birthdateString)).split("\\|")[1]);
                        age = Period.between(birthdate, currentDate).getYears();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                String outputLine = String.format("%s|%d\n", line, age);
                writer.write(outputLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static Map<String, String> readProducts(String filePath) throws IOException {
        Map<String, String> products = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                String code = parts[0].trim();
                String name = parts[1].trim();
                products.put(code, name);
            }
        }

        return products;
    }

    private static void writeProducts(Map<String, String> products, String filePath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Map.Entry<String, String> entry : products.entrySet()) {
                String code = entry.getKey();
                String name = entry.getValue();
                writer.write(code + " | " + name);
                writer.newLine();
            }
        }
    }
}
