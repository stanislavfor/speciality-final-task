// AnimalsList.java

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AnimalsList {
    private static final String FILE_PATH = "src/files/human_friends.txt";

    public static void main(String[] args) {
        AnimalsList.SortedAnimalsByList();
    }

    public static void SortedAnimalsByList() {
        List<Animal> animals = new ArrayList<>();
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
                // Вывод списка в консоли всех элементов из файла human_friends.txt
                for (Animal animal : animals) {
                    System.out.println(animal);
                }

            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

    }

}
