// FarmMenu.java

import java.util.*;

public class FarmMenu {
    private static final String FILE_PATH = "src/files/human_friends.txt";

    public static void main(String[] args){
        FarmMenu farmMenu = new FarmMenu();
        farmMenu.displayMenu();
    }

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.println(("Menu - Human Friends Farm").toUpperCase());
            System.out.println("1  - Вывести весь список Human Friends ");
            System.out.println("2  - Вывести список Human Friends по убывания birthdate ");
            System.out.println("3  - Вывести список Human Friends по значению type ");
            System.out.println("4  - Вывести количество записей Human Friends ");
            System.out.println("5  - Добавить новую запись в Human Friends ");
            System.out.println("6  - Вывести всех команды из списка ");
            System.out.println("7  - Добавить новую команду ");
            System.out.println("8  - Добавить команду в элемент поиска");
            System.out.println("9  - Заменить команду в элементе поиска");
            System.out.println("10 - Поиск в Human Friends ");
            System.out.println("0  - Выход ");
            System.out.print("Выберите действие : ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера сканера
            switch (choice) {
                case 1:
                    AllAnimalsClass();
                    break;
                case 2:
                    SortedByBirthdateClass();
                    break;
                case 3:
                    SortedByTypeClass();
                    break;
                case 4:
                    NumberOfAnimalsClass();
                    break;
                case 5:
                    addNewAnimalClass();
                    break;
                case 6:
                    printAllCommandsClass();
                    break;
                case 7:
                    addNewCommandClass();
                    break;
                case 8:
                    addCommandToAnimalClass();
                    break;
                case 9:
                    changeCommandToElementClass();
                    break;
                case 10:
                    searchElementsClass();
                    break;
                case 0:
                    ProgramsExit();
                    exit = true;
                    break;
                default:
                    System.out.println("Неверный ввод. Пожалуйста, введите число от 0 до 8. ");
            }
        }
        scanner.close();
    }

    private static void AllAnimalsClass() {
        // Реализация вывода всех животных из файла human_friends.txt
        AnimalsList.SortedAnimalsByList();
    }

    private static void SortedByBirthdateClass() {
        // Реализация вывода животных, отсортированных по birthdate
        AnimalsBirthdate.SortedAnimalsByBirthdate();
    }

    private static void SortedByTypeClass() {
        // Реализация вывода животных, отсортированных по type
        AnimalsType.SortedAnimalsByType();
    }

    private static void NumberOfAnimalsClass() {
        // Реализация вывода общего количества животных из файла human_friends.txt
        AnimalsIds.AnimalsNumber();
    }

    private static void addNewAnimalClass() {
        // Реализация добавления нового животного в файл human_friends.txt
        HumanFriends.addNewAnimal();
    }

    private static void printAllCommandsClass() {
        // Реализация вывода всех команд из файла animal_commands.txt
        AnimalsCommandOutput.CommandOutput();
    }

    private static void addNewCommandClass() {
        // Реализация добавления новой команды в файл animal_commands.txt
        AnimalsCommands.addNewCommand();
    }

    private static void addCommandToAnimalClass() {
        // Реализация добавления к записи животного новой команды в файл human_friends.txt
        AnimalsFileUpdate.commandsAnimalsAdd();
    }

    private static void changeCommandToElementClass() {
        // Реализация замены в записи животного команды в файле human_friends.txt

    }

    private static void searchElementsClass() {
        // Реализация поиска в файле human_friends.txt
        //AnimalsSearch.SearchMethode();
        AnimalsSearchLine.inputScanMethode();
    }

    private static void ProgramsExit() {
        System.out.println("До новых встреч на Ферме 'Human Friends' !");
    }


}


