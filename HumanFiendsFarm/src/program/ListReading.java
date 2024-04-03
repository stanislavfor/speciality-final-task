package program;// program.ListReading.java

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ListReading {
    private static final String FRIENDS_FILE_PATH = "src/files/human_friends.txt";

    public static void main(String[] args) {
        ListReading.readAndPrintAnimalsList();
    }
    private static void readAndPrintAnimalsList() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FRIENDS_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", ");
                System.out.println(String.join(", ", parts));
            }
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла : " + e.getMessage());
        }
    }
}
