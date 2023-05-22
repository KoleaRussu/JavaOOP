package oop;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Person {
    private String name;
    private String address;
    private String phoneNumber;
    private double revenue;
    private double expenses;
    private double profits;

    public Person(String name, String address, String phoneNumber, double revenue, double expenses, double profits) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.revenue = revenue;
        this.expenses = expenses;
        this.profits = profits;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    public double getExpenses() {
        return expenses;
    }

    public void setExpenses(double expenses) {
        this.expenses = expenses;
    }

    public double getProfits() {
        return profits;
    }

    public void setProfits(double profits) {
        this.profits = profits;
    }

    public String getType() {
        return "Person";
    }
}


class PersonReader {
    public static List<Person> readEntitiesFromFile(String filePath) throws FileNotFoundException {
        List<Person> entities = new ArrayList<>();
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] tokens = line.split("\\|");

            String name = tokens[0];
            String address = tokens[1];
            String phoneNumber = tokens[2];
            double revenue = Double.parseDouble(tokens[3]);
            double expenses = Double.parseDouble(tokens[4]);
            double profits = Double.parseDouble(tokens[5]);
            Person person = new Person(name, address, phoneNumber, revenue, expenses, profits);
            entities.add(person);

        }

        scanner.close();
        return entities;
    }
}

class PersonManager {
    private List<Person> entities;

    public PersonManager(String filePath) throws FileNotFoundException {
        this.entities = PersonReader.readEntitiesFromFile(filePath);
    }

    public void printAllEntities() {
        for (Person Person : entities) {
            System.out.println(Person.getName() + " (" + Person.getType() + ")");
            System.out.println("Address: " + Person.getAddress());
            System.out.println("Phone number: " + Person.getPhoneNumber());
            System.out.println("Revenue: " + Person.getRevenue());
            System.out.println("Expenses: " + Person.getExpenses());
            System.out.println("Profits: " + Person.getProfits());
            System.out.println();
        }
    }

    public double getTotalManagementCosts() {
        double total = 0;
        for (Person Person : entities) {
            total += Person.getExpenses();
        }
        return total;
    }

    public void changePersonData(String name, String attribute, String value) {
        for (Person Person : entities) {
            if (Person.getName().equals(name)) {
                switch (attribute) {
                    case "address":
                        Person.setAddress(value);
                        break;
                    case "phone number":
                        Person.setPhoneNumber(value);
                        break;
                    case "revenue":
                        Person.setRevenue(Double.parseDouble(value));
                        break;
                    case "expenses":
                        Person.setExpenses(Double.parseDouble(value));
                        break;
                    case "profits":
                        Person.setProfits(Double.parseDouble(value));
                        break;
                    default:
                        System.out.println("Invalid attribute specified");
                        return;
                }
                System.out.println("Data changed successfully");
                return;
            }
        }
        System.out.println("Person not found");
    }

    public void printPersonDetails(String name) {
        for (Person Person : entities) {
            if (Person.getName().equals(name)) {
                System.out.println(Person.getName() + " (" + Person.getType() + ")");
                System.out.println("Address: " + Person.getAddress());
                System.out.println("Phone number: " + Person.getPhoneNumber());
                System.out.println("Revenue: " + Person.getRevenue());
                System.out.println("Expenses: " + Person.getExpenses());
                System.out.println("Profits: " + Person.getProfits());
                System.out.println();
                return;
            }
        }
        System.out.println("Person not found");
    }

    public void sortEntitiesByName() {
        Collections.sort(entities, (e1, e2) -> e1.getName().compareTo(e2.getName()));
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            PersonManager PersonManager = new PersonManager("C:\\Users\\dippe\\OneDrive\\Рабочий стол\\USARB\\is21z-2sem\\OOPJAVA\\OOP\\src\\resources\\Person.txt");
            PersonManager.printAllEntities();
            System.out.println("Total management costs: " + PersonManager.getTotalManagementCosts());

            PersonManager.changePersonData("denis", "address", "123 Main St");
            PersonManager.changePersonData("denis", "phone number", "555-555-1234");
            PersonManager.changePersonData("mimh", "revenue", "50000");
            PersonManager.changePersonData("mimh", "expenses", "40000");
            PersonManager.changePersonData("mimh", "profits", "10000");
            System.out.println("changed data");
            PersonManager.printPersonDetails("denis");
            PersonManager.printPersonDetails("mimh");
            System.out.println("sorted list");
            PersonManager.sortEntitiesByName();
            PersonManager.printAllEntities();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (NullPointerException e) {
            System.out.println("One or both entered numbers are null");
        } catch (NumberFormatException e) {
            System.out.println("One or both entered numbers is String, not number");
        } catch (ArithmeticException e) {
            System.out.println("Can’t divide by 0");
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Invalid input");
        }
    }
}
