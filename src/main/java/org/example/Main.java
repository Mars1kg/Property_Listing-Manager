import java.io.*;
import java.util.*;

class Property {
    String id;
    String title;
    String type;
    String address;
    double price;

    Property(String id, String title, String type, String address, double price) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.address = address;
        this.price = price;
    }
}

public class Main {
    static ArrayList<Property> properties = new ArrayList<>();
    static String fileName = "properties.txt";
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        loadProperties();
    }

    static void loadProperties() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                Property p = new Property(parts[0], parts[1], parts[2], parts[3], Double.parseDouble(parts[4]));
                properties.add(p);
            }
            reader.close();
        } catch(Exception e) {
            System.out.println("No existing properties found");
        }
    }

    static void addProperty() {
        System.out.print("Enter ID: ");
        String id = scanner.nextLine();

        System.out.print("Enter title: ");
        String title = scanner.nextLine();

        System.out.print("Sale or Rent: ");
        String type = scanner.nextLine();

        System.out.print("Address: ");
        String address = scanner.nextLine();

        System.out.print("Price: ");
        double price = Double.parseDouble(scanner.nextLine());

        Property newProp = new Property(id, title, type, address, price);
        properties.add(newProp);
        saveProperties();
        System.out.println("Property added!");
    }

    static void saveProperties() {
        try {
            PrintWriter writer = new PrintWriter(fileName);
            for(int i = 0; i < properties.size(); i++) {
                Property p = properties.get(i);
                writer.println(p.id + "," + p.title + "," + p.type + "," + p.address + "," + p.price);
            }
            writer.close();
        } catch(Exception e) {
            System.out.println("Error saving data");
        }
    }    static void showProperties() {
        if(properties.size() == 0) {
            System.out.println("No properties available");
            return;
        }

        for(int i = 0; i < properties.size(); i++) {
            Property p = properties.get(i);
            System.out.printf("\nID: %s\nTitle: %s\nType: %s\nAddress: %s\nPrice: %.2f\n",
                    p.id, p.title, p.type, p.address, p.price);
        }
    }

}
