package program;// program.FarmMenu.java

import java.util.*;

public class FarmMenu {

    public static void main(String[] args) {
        FarmMenu farmMenu = new FarmMenu();
        boolean showTitleIndex = false;
        farmMenu.displayMenu(showTitleIndex);
    }

    public static void menuTitleMethode(boolean showTitleIndex){
        if (!showTitleIndex) {
            System.out.println(("Menu - Human Friends Farm").toUpperCase()
                    + " (Ферма 'Друзья человека') ");
        } else {
            System.out.println(("Menu").toUpperCase());
        };
    }

    public void displayMenu(boolean showTitleIndex) {
        System.out.println("Добро пожаловать на Ферму 'Human Friends' !");
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            menuTitleMethode(showTitleIndex);
            System.out.println("1  - Вывести весь список Human Friends ");
            System.out.println("2  - Сортировать список ");
            System.out.println("3  - Сортировать список по дате рождения ");
            System.out.println("4  - Вывести общее количество Human Friends ");
            System.out.println("5  - Добавить в список Human Friends ");
            System.out.println("6  - Вывести все команды ");
            System.out.println("7  - Добавить новую команду ");
            System.out.println("8  - Добавить команду к элементу ");
            System.out.println("9  - Удалить команду в элементе ");
            System.out.println("10 - Поиск в Human Friends ");
            System.out.println("0  - Выход ");
            System.out.print("Выберите действие : ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            showTitleIndex = true;
            switch (choice) {
                case 1:
                    AllAnimalsClass();
                    break;
                case 2:
                    SortedByClass();
                    break;
                case 3:
                    SortedByBirthdateClass();
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
                    changeElementCommandsClass();
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
        //program.AnimalsList.SortedAnimalsByList();
//        program.AnimalsList.printAnimalsList();
        AnimalsList.readingMenuMethode();
    }

    private static void SortedByBirthdateClass() {
        // Реализация вывода животных, отсортированных по birthdate
        AnimalsBirthdate.SortedAnimalsByBirthdate();
    }

    private static void SortedByClass() {
        // Реализация вывода животных, отсортированных по выбранному значению
        AnimalsSorted.SortedAnimalsBy();
    }

    private static void NumberOfAnimalsClass() {
        // Реализация вывода общего количества животных из файла human_friends.txt
        AnimalsNumbers.AnimalsNumber();
    }

    private static void addNewAnimalClass() {
        // Реализация добавления нового животного в файл human_friends.txt
        HumanFriendsAdd.addNewAnimal();
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

    private static void changeElementCommandsClass() {
        // Реализация удаления в записи животного команды в файле human_friends.txt
        AnimalsCommandRemove.commandToRemove();
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


