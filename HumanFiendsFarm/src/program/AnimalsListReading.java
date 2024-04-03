package program;// program.AnimalsListReading.java

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AnimalsListReading {

    private static final String FRIENDS_FILE_PATH = "src/files/human_friends.txt";

    public static void main(String[] args) {

        AnimalsListReading.readAndPrintAnimalsList();
    }

    public static void readAndPrintAnimalsList() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FRIENDS_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Форматирование вывода
                line = line.replace("id: ", "")
                        .replace(", class_type: ", ". ")
                        .replace(", name: ", ": ")
                        .replace(", type: ", " (")
                        .replace(", birthdate: ", "), bd: ")
                        .replace("commands: ", "comd: ");
                // Вывод отформатированной строки
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }
}

