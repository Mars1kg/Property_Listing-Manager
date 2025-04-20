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
}
