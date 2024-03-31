// AnimalsIds.java

import extra.NumberToWordsConverter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AnimalsIds {
    private static final String FILE_PATH = "src/files/human_friends.txt";

    public static void main(String[] args) {
        AnimalsIds.AnimalsNumber();
    }

    public static void AnimalsNumber() {
        NumberToWordsConverter outer = new NumberToWordsConverter();

        try {
            int maxId = Integer.MIN_VALUE;

            try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(", ");
                    // Первый элемент - это farm_id, содержится в формате "id: %d"
                    String idPart = parts[0];
                    int id = Integer.parseInt(idPart.split(": ")[1]);
                    if (id > maxId) {
                        maxId = id;
                    }
                }
                System.out.print("Наибольшее farm_id = " + maxId + ", значит: ");
                System.out.println("в списке Фермы 'Human Friends' - " + outer.convert(maxId) + " записей animals. ");
            }
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла : " + e.getMessage());
        }


    }
}
