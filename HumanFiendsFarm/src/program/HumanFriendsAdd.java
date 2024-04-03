package program;// program.HumanFriendsAdd.java

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.*;
import java.util.*;

public class HumanFriendsAdd {

    private static final String FILE_PATH = "src/files/human_friends.txt";
    private static final String COMMANDS_FILE_PATH = "src/files/animal_commands.txt";

    public static void addNewAnimal() {
        Scanner scanner = new Scanner(System.in);
        try {
            // Определение следующего ID
            int nextId = getNextId();

            // Ввод данных о животном
            System.out.print("Введите class_type (Pets или Pack_animal) : ");
            String classType = scanner.nextLine();

            System.out.print("Введите name : ");
            String name = scanner.nextLine();

            if (classType.equals("Pets")) {
                System.out.print("Введите type (Dogs, Cats, Hamsters) : ");
            };
            if (classType.equals("Pack_animal")) {
                System.out.print("Введите type (Horses, Camels, Donkeys) : ");
            };
            String type = scanner.nextLine();

            System.out.print("Введите birthdate (YYYY-MM-DD) : ");
            String birthdate = scanner.nextLine();

            // Получение списка команд из файла
            List<String> commands = getCommandsFromFile();

            // Выбор команд для животного
            System.out.println("Введите команды из перечисленного через запятую \n" + String.join(", ", commands + " : "));
            String commandsInput = scanner.nextLine();
            List<String> selectedCommands = new ArrayList<>(Arrays.asList(commandsInput.split("\\s*,\\s*")));

            // Проверка наличия команд в списке доступных команд
            selectedCommands.retainAll(commands);

            // Запись в файл
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
                StringJoiner joiner = new StringJoiner(", ");
                for (String command : selectedCommands) {
                    joiner.add(command);
                }
                String animalRecord = String.format("id: %d, class_type: %s, name: %s, type: %s, birthdate: %s, commands: %s",
                        nextId, classType, name, type, birthdate, joiner.toString());
                writer.write(animalRecord);
                writer.newLine();
                System.out.println("Запись добавлена успешно.");
            }
        } catch (IOException e) {
            System.err.println("Ошибка при работе с файлом : " + e.getMessage());
        }
    }

    private static int getNextId() throws IOException {
        int nextId = 1;
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("id: ")) {
                    int id = Integer.parseInt(line.substring(4, line.indexOf(',')));
                    if (id >= nextId) {
                        nextId = id + 1;
                    }
                }
            }
        }
        return nextId;
    }

    private static List<String> getCommandsFromFile() throws IOException {
        List<String> commands = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(COMMANDS_FILE_PATH))) {
            String command;
            while ((command = reader.readLine()) != null) {
                commands.add(command.trim());
            }
        }
        return commands;
    }
}