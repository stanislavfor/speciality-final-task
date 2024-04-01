// AnimalsSearch.java

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class AnimalsSearch {

    public static void main(String[] args){
        AnimalsSearch.SearchMethode();
    }

    //private static final String FILE_PATH = "src/files/human_friends.txt";
    //private static final String CLASS_TYPE_TO_SEARCH = "Pets";

    public static void SearchMethode() {
        String FILE_PATH = "src/files/human_friends.txt";
        Scanner scanner = new Scanner(System.in);
        try{
            boolean validInput = false;
            System.out.print("Выберите вариант поиска (id, class_type, name, type) : ");
            String STRING_TO_SEARCH = scanner.nextLine();
            System.out.print("Введите строку для поиска : ");
            String INPUT_TO_SEARCH = scanner.nextLine();
            // String INPUT_TO_SEARCH = "Pets";
            try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
                String line;
                while ((line = reader.readLine()) != null && !validInput) {
                    if (line.contains(STRING_TO_SEARCH + ": " + INPUT_TO_SEARCH)) {
                        System.out.println(line);
                    }
                }
                System.out.println("Неверный ввод");
            }
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла : " + e.getMessage());
        }
    }
}
