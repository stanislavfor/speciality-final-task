package program;// program.AnimalsList.java

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class AnimalsList {
    private static final String FILE_PATH = "src/files/human_friends.txt";

    public static void main(String[] args) {

        AnimalsList.readingMenuMethode();
    }

    public static void readingMenuMethode(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Выберите формат вывода Гостевой - 1 или Рабочий - 2 : ");
        int choiceRead = scanner.nextInt();
        scanner.nextLine();
        switch (choiceRead) {
            case 1:
                AnimalsListReading.readAndPrintAnimalsList();
                break;
            case 2:
                AnimalsList.printAnimalsList();
                break;
            default:
                System.out.println("Неверный ввод.");
        }
    }

    public static void printAnimalsList() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла : " + e.getMessage());
        }
    }
//    public static void SortedAnimalsByList() {
//        List<program.Animal> animals = new ArrayList<>();
//        try {
//            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//            try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
//                String line;
//                while ((line = reader.readLine()) != null) {
//                    String[] parts = line.split(", ");
//                    int farm_id = Integer.parseInt(parts[0].split(": ")[1]);
//                    String classType = parts[1].split(": ")[1];
//                    String name = parts[2].split(": ")[1];
//                    String type = parts[3].split(": ")[1];
//                    Date birthdate = simpleDateFormat.parse(parts[4].split(": ")[1]);
//                    String commands = parts[5].split(": ")[1];
//                    animals.add(new program.Animal(farm_id, classType, name, type, birthdate, commands));
//                }
//                // Вывод списка в консоли всех элементов из файла human_friends.txt
//                for (program.Animal animal : animals) {
//                    System.out.println(animal);
//                }
//            }
//        } catch (IOException | ParseException e) {
//            e.printStackTrace();
//        }
//
//    }

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
