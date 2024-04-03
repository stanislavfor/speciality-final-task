package program;// program.AnimalsFileUpdate.java

import java.io.*;
import java.util.*;

public class AnimalsFileUpdate {

    public static void main(String[] args){
        AnimalsFileUpdate.commandsAnimalsAdd();
    }

    private static final String FRIENDS_FILE_PATH = "src/files/human_friends.txt";
    private static final String COMMANDS_FILE_PATH = "src/files/animal_commands.txt";
    private static Random random = new Random();

    public static void commandsAnimalsAdd() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите id животного для добавления команды : ");
        int animalId = scanner.nextInt();
        scanner.nextLine();
        List<String> availableCommands = getCommandsFromFile();
        if (availableCommands.isEmpty()) {
            System.out.println("Файл команд пуст или не существует.");
            return;
        }
        System.out.println("Доступные команды : ");
        for (int i = 0; i < availableCommands.size(); i++) {
            System.out.println((i + 1) + ": " + availableCommands.get(i));
        }
//        for (String command : availableCommands) {
//            System.out.println(command);
//        }
        System.out.print("Введите номер команды для добавления : ");
        //String newCommand = scanner.nextLine();
        int commandIndex = scanner.nextInt() - 1;
        scanner.nextLine();
        if (commandIndex >= 0 && commandIndex < availableCommands.size()) {
            String selectedCommand = availableCommands.get(commandIndex);
            createNewFilePathWithRandomId();
            updateAnimalCommands(animalId, selectedCommand);
//        if (availableCommands.contains(newCommand)) {
//            updateAnimalCommands(animalId, newCommand);
        } else {
            System.out.println("Неверный выбор команды.");
        }
        // scanner.close();
    }

    private static List<String> getCommandsFromFile() {
        List<String> commands = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(COMMANDS_FILE_PATH))) {
            String command;
            while ((command = reader.readLine()) != null) {
                commands.add(command);
            }
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла команд : " + e.getMessage());
        }
        return commands;
    }

        private static void updateAnimalCommands(int animalId, String selectedCommand) {
        String originalFilePath = FRIENDS_FILE_PATH;
        String backupFilePath = createBackupFilePath(originalFilePath);
        // Создаем копию оригинального файла с уникальным расширением
        File originalFile = new File(originalFilePath);
        File backupFile = new File(backupFilePath);
        if (!originalFile.renameTo(backupFile)) {
            System.err.println("Ошибка при переименовании оригинального файла для создания резервной копии.");
            return;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(backupFile));
                BufferedWriter writer = new BufferedWriter(new FileWriter(originalFilePath))) {
            String line;
            boolean isUpdated = false;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("id: " + animalId + ",")) {
                    String[] parts = line.split(", commands: ");
                    if (parts.length == 2) {
                        String existingCommands = parts[1];
                        String updatedCommands = existingCommands.isEmpty() ? selectedCommand : existingCommands + ", " + selectedCommand;
                        line = parts[0] + ", commands: " + updatedCommands;
                        isUpdated = true;
                    }
                }
                writer.write(line + System.lineSeparator());
            }
            if (!isUpdated) {
                System.out.println("Животное с id '" + animalId + "' не найдено.");
            } else {
                System.out.println("Файл human_friends.txt обновлен.");
            }
        } catch (IOException e) {
            System.err.println("Ошибка при чтении/записи файла : " + e.getMessage());
        }
    }


    // Генерация четырехзначного числа
    private static String createNewFilePathWithRandomId() {
        int file_id = random.nextInt(9000) + 1000;
        return FRIENDS_FILE_PATH + "." + file_id;
    }
    // Генерация четырехзначного числа
    private static String createBackupFilePath(String originalFilePath) {
        Random random = new Random();
        int file_id = 1000 + random.nextInt(9000);
        return originalFilePath + "." + file_id;
    }



}