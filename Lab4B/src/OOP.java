import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Entity {
    private int nr;
    private String address;
    private String firstName;
    private String lastName;
    private double amount;

    public Entity(int nr, String address, String firstName, String lastName, double amount) {
        this.nr = nr;
        this.address = address;
        this.firstName = firstName;
        this.lastName = lastName;
        this.amount = amount;
    }

    public int getNr() {
        return nr;
    }

    public void setNr(int nr) {
        this.nr = nr;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public static class Entity {
        private int nr;
        private String address;
        private String firstName;
        private String lastName;
        private double amount;

        public Entity(int nr, String address, String firstName, String lastName, double amount) {
            this.nr = nr;
            this.address = address;
            this.firstName = firstName;
            this.lastName = lastName;
            this.amount = amount;
        }

        public int getNr() {
            return nr;
        }

        public void setNr(int nr) {
            this.nr = nr;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }
    }
}

class EntityList {
    private List<Entity.Entity> entityList;

    public EntityList() {
        entityList = new ArrayList<Entity.Entity>();
    }

    public void readFromFile(String filename) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(filename));
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split("\\|");
            int nr = Integer.parseInt(parts[0]);
            String address = parts[1];
            String firstName = parts[2];
            String lastName = parts[3];
            double amount = Double.parseDouble(parts[4]);
            Entity.Entity entity = new Entity.Entity(nr, address, firstName, lastName, amount);
            entityList.add(entity);
        }
        scanner.close();
    }

    public void sortByFirstName() {
        Collections.sort(entityList, (Entity.Entity e1, Entity.Entity e2) -> e1.getFirstName().compareTo(e2.getFirstName()));
    }

    public double getTotalAmount() {
        double totalAmount = 0.0;
        for (Entity.Entity entity : entityList) {
            totalAmount += entity.getAmount();
        }
        return totalAmount;
    }

    public void printAll() {
        for (Entity.Entity entity : entityList) {
            System.out.println(entity.getNr() + " " + entity.getAddress() + " " + entity.getFirstName() + " " + entity.getLastName() + " " + entity.getAmount());
        }
    }

    public Entity.Entity findByAttribute(String attribute) {
        for (Entity.Entity entity : entityList) {
            if (entity.getNr() == Integer.parseInt(attribute) || entity.getAddress().equals(attribute) || entity.getFirstName().equals(attribute) || entity.getLastName().equals(attribute)) {
                return entity;
            }
        }
        return null;
    }
}

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        EntityList entityList = new EntityList();
        entityList.readFromFile("data.txt");
        entityList.sortByFirstName();
        entityList.printAll();
        System.out.println("Total amount: " + entityList.getTotalAmount());
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter attribute: ");
        String attribute = scanner.nextLine();
        Entity.Entity entity = entityList.findByAttribute(attribute);
        if (entity != null) {
            System.out.println(entity.getNr() + " " + entity.getAddress() + " " + entity

                    .getFirstName() + " " + entity.getLastName() + " " + entity.getAmount());
        } else {
            System.out.println("No entity found with the specified attribute.");
        }
        scanner.close();
    }
}