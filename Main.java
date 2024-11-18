import java.util.ArrayList;
import java.util.Scanner;

class Donor {
    String name;
    String bloodGroup;
    int age;
    String contact;

    Donor(String name, String bloodGroup, int age, String contact) {
        this.name = name;
        this.bloodGroup = bloodGroup;
        this.age = age;
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Blood Group: " + bloodGroup + ", Age: " + age + ", Contact: " + contact;
    }
}

public class Main {
    static ArrayList<Donor> donors = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\nBlood Bank Management System");
            System.out.println("1. Add Donor");
            System.out.println("2. View Donors");
            System.out.println("3. Search Donor by Blood Group");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addDonor();
                    break;
        
                case 2:
                    viewDonors();
                    break;
                case 3:
                    searchDonor();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 4);
    }

    static void addDonor() {
        scanner.nextLine(); // Consume the newline
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter blood group(eg: O+ve): ");
        String bloodGroup = scanner.nextLine();
        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume the newline
        System.out.print("Enter contact number: ");
        String contact = scanner.nextLine();

        donors.add(new Donor(name, bloodGroup, age, contact));
        System.out.println("Donor added successfully!");
    }

    static void viewDonors() {
        if (donors.isEmpty()) {
            System.out.println("No donors available.");
        } else {
            System.out.println("\nList of Donors:");
            for (Donor donor : donors) {
                System.out.println(donor);
            }
        }
    }

    static void searchDonor() {
        scanner.nextLine(); // Consume the newline
        System.out.print("Enter blood group to search: ");
        String bloodGroup = scanner.nextLine();

        boolean found = false;
        for (Donor donor : donors) {
            if (donor.bloodGroup.equalsIgnoreCase(bloodGroup)) {
                System.out.println("Donor found");
                System.out.println(donor);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No donors found with blood group " + bloodGroup);
        }
    }
}
