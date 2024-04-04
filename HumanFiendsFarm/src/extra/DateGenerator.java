package extra; //DateGenerator.java

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateGenerator {

    public static void main(String[] args) {

        String file_id = createNewDateMethode();
        System.out.println("Generated 'file_id' : " + file_id);
    }

    public static String createNewDateMethode() {
        // Объект SimpleDateFormat с форматом 10 чисел без пробела
        SimpleDateFormat sdf = new SimpleDateFormat("MMddHHmmss");
        // Текущие дата и время до секунды
        Date now = new Date();
        // Форматирование дату и время в строку
        String file_id = sdf.format(now);
        return file_id;

    }


}
