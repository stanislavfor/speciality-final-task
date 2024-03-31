// Animal.java

import java.util.Date;
import java.util.Comparator;

public class Animal {
    private int farm_id;
    private String classType;
    private String name;
    private String type;
    private Date birthdate;
    private String commands;

    // Конструктор
    public Animal(int farm_id, String classType, String name, String type, Date birthdate, String commands) {
        this.farm_id = farm_id;
        this.classType = classType;
        this.name = name;
        this.type = type;
        this.birthdate = birthdate;
        this.commands = commands;
    }

    // Геттеры и Сеттеры

    // Статические компараторы для разных критериев сравнения
    public static Comparator<Animal> ClassTypeComparator = new Comparator<Animal>() {
        @Override
        public int compare(Animal a1, Animal a2) {
            return a2.classType.compareTo(a1.classType);
        }
    };

    public static Comparator<Animal> BirthdateComparator = new Comparator<Animal>() {
        @Override
        public int compare(Animal a1, Animal a2) {
            return a1.birthdate.compareTo(a2.birthdate);
        }
    };

    // Метод toString для вывода информации о животном
    @Override
    public String toString() {
        return String.format("id: %d, class_type: %s, name: %s, type: %s, birthdate: %s, commands: %s",
                farm_id, classType, name, type, birthdate.toString(), commands);
    }
}
