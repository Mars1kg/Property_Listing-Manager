import java.io.*;
import java.util.*;

class Property {
    String id;
    String title;
    String type;
    String address;
    double price;
}

public class Main {
    static ArrayList<Property> properties = new ArrayList<Property>();
    static String file = "properties.txt";
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        loadFromFile();

        while(true) {
            System.out.println("\n1. Добавить");
            System.out.println("2. Показать все");
            System.out.println("3. Изменить");
            System.out.println("4. Удалить");
            System.out.println("5. Статистика");
            System.out.println("6. Выйти");
            System.out.print("Ваш выбор: ");

            String input = sc.nextLine();

            if(input.equals("1")) {
                addNew();
            }
            else if(input.equals("2")) {
                showAll();
            }
            else if(input.equals("3")) {
                change();
            }
            else if(input.equals("4")) {
                delete();
            }
            else if(input.equals("5")) {
                stats();
            }
            else if(input.equals("6")) {
                saveToFile();
                break;
            }
            else {
                System.out.println("Неправильный ввод!");
            }
        }
    }

    static void loadFromFile() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                Property p = new Property();
                p.id = parts[0];
                p.title = parts[1];
                p.type = parts[2];
                p.address = parts[3];
                p.price = Double.parseDouble(parts[4]);
                properties.add(p);
            }
            br.close();
        } catch(Exception e) {
            System.out.println("Файл не найден, начнем с чистого листа");
        }
    }

    static void saveToFile() {
        try {
            PrintWriter pw = new PrintWriter(file);
            for(int i = 0; i < properties.size(); i++) {
                Property p = properties.get(i);
                pw.println(p.id + "," + p.title + "," + p.type + "," + p.address + "," + p.price);
            }
            pw.close();
        } catch(Exception e) {
            System.out.println("Ошибка при сохранении");
        }
    }

    static void addNew() {
        Property p = new Property();

        while(true) {
            System.out.print("ID: ");
            p.id = sc.nextLine();

            boolean exists = false;
            for(int i = 0; i < properties.size(); i++) {
                if(properties.get(i).id.equals(p.id)) {
                    System.out.println("Ошибка: ID уже существует!");
                    exists = true;
                    break;
                }
            }
            if(!exists) break;
        }

        System.out.print("Название: ");
        p.title = sc.nextLine();

        System.out.print("Тип (продажа/аренда): ");
        p.type = sc.nextLine();

        System.out.print("Адрес: ");
        p.address = sc.nextLine();

        System.out.print("Цена: ");
        while(true) {
            try {
                p.price = sc.nextDouble();
                if(p.price > 0) break;
                System.out.print("Цена должна быть больше 0. Введите снова: ");
            } catch(Exception e) {
                System.out.print("Ошибка! Введите число: ");
                sc.next();
            }
        }
        sc.nextLine();

        properties.add(p);
        saveToFile();
        System.out.println("Успешно добавлено!");
    }

    static void showAll() {
        if(properties.size() == 0) {
            System.out.println("Список пуст");
            return;
        }

        for(int i = 0; i < properties.size(); i++) {
            Property p = properties.get(i);
            System.out.println("\nID: " + p.id);
            System.out.println("Название: " + p.title);
            System.out.println("Тип: " + p.type);
            System.out.println("Адрес: " + p.address);
            System.out.println("Цена: " + p.price);
        }
    }

    static void change() {
        System.out.print("Введите ID для изменения: ");
        String id = sc.nextLine();
        boolean found = false;

        for(int i = 0; i < properties.size(); i++) {
            if(properties.get(i).id.equals(id)) {
                Property p = properties.get(i);

                System.out.print("Новое название (Enter - оставить): ");
                String title = sc.nextLine();
                if(title.length() > 0) p.title = title;

                System.out.print("Новый тип (Enter - оставить): ");
                String type = sc.nextLine();
                if(type.length() > 0) p.type = type;

                System.out.print("Новый адрес (Enter - оставить): ");
                String address = sc.nextLine();
                if(address.length() > 0) p.address = address;

                System.out.print("Новая цена (Enter - оставить): ");
                String priceStr = sc.nextLine();
                if(priceStr.length() > 0) {
                    try {
                        p.price = Double.parseDouble(priceStr);
                    } catch(Exception e) {
                        System.out.println("Ошибка ввода цены!");
                    }
                }

                saveToFile();
                System.out.println("Изменения сохранены");
                found = true;
                break;
            }
        }

        if(!found) {
            System.out.println("ID не найден");
        }
    }

    static void delete() {
        System.out.print("Введите ID для удаления: ");
        String id = sc.nextLine();
        boolean found = false;

        for(int i = 0; i < properties.size(); i++) {
            if(properties.get(i).id.equals(id)) {
                properties.remove(i);
                saveToFile();
                System.out.println("Удалено");
                found = true;
                break;
            }
        }

        if(!found) {
            System.out.println("ID не найден");
        }
    }

    static void stats() {
        int saleCount = 0;
        int rentCount = 0;

        for(int i = 0; i < properties.size(); i++) {
            if(properties.get(i).type.equals("sale")) {
                saleCount++;
            } else if(properties.get(i).type.equals("rent")) {
                rentCount++;
            }
        }

        System.out.println("\nВсего объектов: " + properties.size());5
        System.out.println("На продажу: " + saleCount);
        System.out.println("В аренду: " + rentCount);
    }
}