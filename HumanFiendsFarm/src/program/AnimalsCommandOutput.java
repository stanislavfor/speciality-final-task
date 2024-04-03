package program;// program.AnimalsCommandOutput.java

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AnimalsCommandOutput {

    private static final String FILE_PATH = "src/files/animal_commands.txt";

    public static void main(String[] args) {
        AnimalsCommandOutput.CommandOutput();
    }

    public static void CommandOutput() {
        List<String> commands = getCommandsFromFile();
        for (String command : commands) {
            System.out.print(command + " ");
        }
        System.out.println();
    }

    private static List<String> getCommandsFromFile() {
        List<String> commands = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                commands.add(line);
            }
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла : " + e.getMessage());
        }
        return commands;
    }
}
