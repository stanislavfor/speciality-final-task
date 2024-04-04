package program;// program.Animal.java

import java.util.Date;
import java.util.Comparator;

public class Animal {
    // I. Переменные
    private int farm_id;
    private String classType;
    private String name;
    private String type;
    private Date birthdate;
    private String commands;
    private String choceString;


    // II. Конструктор
    public Animal(int farm_id, String classType, String name, String type, Date birthdate, String commands) {
        this.farm_id = farm_id;
        this.classType = classType;
        this.name = name;
        this.type = type;
        this.birthdate = birthdate;
        this.commands = commands;
    }

    public Animal(String choceString) {
        this.choceString = choceString;
    }

    // III. Геттеры и Сеттеры

    public int getFarmId() {
        return farm_id;
    }

    public String getClassType() {
        return classType;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getChoceString() {
        return choceString;
    }

    // IV. Статические компараторы

    public static Comparator<Animal> ChoceComparator = new Comparator<Animal>() {
        @Override
        // Компаратор для сравнения животных по choceString
        public int compare(Animal a1, Animal a2) {
            return a2.getChoceString().compareTo(a1.getChoceString());
        }
    };

    public static Comparator<Animal> BirthdateComparator = new Comparator<Animal>() {
        @Override
        public int compare(Animal a1, Animal a2) {
            return a1.birthdate.compareTo(a2.birthdate);
        }
    };

    // V. Метод toString для вывода информации о животном
    @Override
    public String toString() {
        return String.format("id: %d, class_type: %s, name: %s, type: %s, birthdate: %s, commands: %s",
                farm_id, classType, name, type, birthdate, commands);
    }

//    @Override
//    public String toString() {
//        return String.format("id: %d, class_type: %s, name: %s, type: %s, birthdate: %s, commands: %s",
//                farm_id, classType, name, type, birthdate.toString(), commands);
//    }


}
