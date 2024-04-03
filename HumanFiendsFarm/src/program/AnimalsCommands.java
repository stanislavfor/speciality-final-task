package program;// program.AnimalsCommands.java

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AnimalsCommands {
    private static final String COMMANDS_FILE_PATH = "src/files/animal_commands.txt";
    public static void main(String[] args) {
        AnimalsCommands.addNewCommand();
    }

    public static void addNewCommand(){
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Введите название команды : ");
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(COMMANDS_FILE_PATH, true))) {
                String command = scanner.nextLine();
                writer.write(command);
                writer.newLine();
                System.out.println("Запись добавлена успешно.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
