package program;// program.AnimalsSorted.java

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.*;


public class AnimalsSorted {
    private static final String FILE_PATH = "src/files/human_friends.txt";

    public static void main(String[] args) {
        AnimalsSorted.SortedAnimalsBy();
    }

    public static void SortedAnimalsBy() {
        Scanner scanner = new Scanner(System.in);
        List<Animal> animals = new ArrayList<>();
        System.out.print("Выберите вариант поиска (id, class_type, name, type) : ");
        String choceString = scanner.nextLine();
        Comparator<Animal> comparator = null;
        switch (choceString.toLowerCase()) {
            case "id":
                comparator = Comparator.comparingInt(Animal::getFarmId);
                break;
            case "class_type":
                comparator = Comparator.comparing(Animal::getClassType);
                break;
            case "name":
                comparator = Comparator.comparing(Animal::getName);
                break;
            case "type":
                comparator = Comparator.comparing(Animal::getType);
                break;
            default:
                System.out.println("Неверное поле для сортировки.");
                return;
        }
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(", ");
                    int farm_id = Integer.parseInt(parts[0].split(": ")[1]);
                    String classType = parts[1].split(": ")[1];
                    String name = parts[2].split(": ")[1];
                    String type = parts[3].split(": ")[1];
                    Date birthdate = simpleDateFormat.parse(parts[4].split(": ")[1]);
                    String commands = parts[5].split(": ")[1];
                    animals.add(new Animal(farm_id, classType, name, type, birthdate, commands));
                }
                Collections.sort(animals, comparator);
                for (Animal animal : animals) {
                    System.out.println(animal);
                }

            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

    }


}

// Другая часть кода
//                for (int i = 0; i < parts.length; i++) {
//                    if (parts[i].startsWith("birthdate: ")) {
//                        String dateString = parts[i].substring("birthdate: ".length());
////                        Date date = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy").parse(dateString);
////                        String formattedDate = new SimpleDateFormat("yyyy-MM-dd").format(date);
////                        parts[i] = "birthdate: " + formattedDate;
//                        parts[i] = "birthdate: " + dateString;
//                    }
//                }
