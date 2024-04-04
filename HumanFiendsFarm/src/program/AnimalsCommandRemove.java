package program;// program.AnimalsCommandRemove.java

import extra.DateGenerator;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.*;

public class AnimalsCommandRemove {
    private static final String FRIENDS_FILE_PATH = "src/files/human_friends.txt";

    public static void main(String[] args){
        AnimalsCommandRemove.commandToRemove();
    }
    public static void commandToRemove() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите id животного для удаления команды : ");
        int animalId = scanner.nextInt();
        scanner.nextLine();
        String backupFilePath = createBackupFileMethode();
        String animalData = readAnimalData(animalId, backupFilePath);
        if (animalData != null) {
            System.out.println("Найдена запись : " + animalData);
            System.out.print("Введите команду для удаления : ");
            String commandToRemove = scanner.nextLine();
            updateAnimalCommands(animalId, commandToRemove, backupFilePath);
        } else {
            System.out.println("Животное с id '" + animalId + "' не найдено.");
        }
        //scanner.close();
    }

    private static String readAnimalData(int animalId, String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("id: " + animalId + ",")) {
                    return line;
                }
            }
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла : " + e.getMessage());
        }
        return filePath;
    }

    private static void updateAnimalCommands(int animalId, String commandToRemove, String backupFilePath) {
        File inputFile = new File(FRIENDS_FILE_PATH);
        File tempFile = new File(backupFilePath);
        try (BufferedReader reader = new BufferedReader(new FileReader(tempFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(inputFile))) {
            String line;
            boolean isUpdated = false;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("id: " + animalId + ",")) {
//                    line = line.replace(commandToRemove, "").replace(",,", ",");
                    String[] commands = line.split(", commands: ");
                    if (commands.length == 2) {
                        String[] commandList = commands[1].split(", ");
                        List<String> commandArrayList = new ArrayList<>(Arrays.asList(commandList));
                        commandArrayList.remove(commandToRemove);
                        String updatedCommands = String.join(", ", commandArrayList);
                        line = commands[0] + ", commands: " + updatedCommands;
                    }
                    isUpdated = true;
                }
                writer.write(line + System.lineSeparator());
            }
            if (isUpdated) {
                System.out.println("Команда успешно удалена.");
            } else {
                System.out.println("Команда для удаления не найдена.");
            }
        } catch (IOException e) {
            System.err.println("Ошибка при чтении/записи файла : " + e.getMessage());
        }
    }

    private static String createBackupFileMethode() {
        String backupFilePath = FRIENDS_FILE_PATH + "." + getRandomFileName();
        File originalFile = new File(FRIENDS_FILE_PATH);
        File backupFile = new File(backupFilePath);
        try {
            Files.copy(originalFile.toPath(), backupFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Резервная копия файла создана: " + backupFilePath);
        } catch (IOException e) {
            System.err.println("Ошибка при создании резервной копии файла: " + e.getMessage());
        }
        return backupFilePath;
    }

    private static String getRandomFileName() {
//        Random random = new Random();
//        return String.format("%04d", random.nextInt(10000));
        String rand = DateGenerator.createNewDateMethode();
        return String.format(rand);
    }
}
