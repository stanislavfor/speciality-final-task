import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class AnimalsSearchLine {
    private static final String FILE_PATH = "src/files/human_friends.txt";

    public static void main(String[] args) {
        AnimalsSearchLine.inputScanMethode();
    }

    public static void inputScanMethode(){
        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Выберите вариант поиска (id, class_type, name, type) : ");
            String input_scan = scanner.nextLine();
            System.out.print("Введите строку для поиска : ");
            String INPUT_SEARCH = scanner.nextLine();
            if (!input_scan.isEmpty()) {
                validInput = true;
                searchAndPrintAnimals(input_scan, INPUT_SEARCH);
            } else {
                System.out.println("Неправильный ввод. Пожалуйста, попробуйте еще раз.");
            }
        }
        //scanner.close();
    }
    private static void searchAndPrintAnimals(String input_scan, String INPUT_SEARCH) {
        System.out.println("Ваш выбор поиска " + input_scan + ": " + INPUT_SEARCH);
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            boolean found = false;
            while ((line = reader.readLine()) != null) {
                if (line.contains(input_scan + ": " + INPUT_SEARCH)) {
                    System.out.println(line);
                    found = true;
                }
            }
            if (!found) {
                System.out.println("Записи с '" + input_scan + "' или с '" + INPUT_SEARCH + "' не найдены.");
            }
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла : " + e.getMessage());
        }
    }
}
