// NumberToWordsConverter.java

package extra;

public class NumberToWordsConverter {
    private static final String[] units = {
            "", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять"
    };
    private static final String[] teens = {
            "десять", "одиннадцать", "двенадцать", "тринадцать", "четырнадцать", "пятнадцать",
            "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать"
    };
    private static final String[] tens = {
            "", "десять", "двадцать", "тридцать", "сорок", "пятьдесят", "шестьдесят",
            "семьдесят", "восемьдесят", "девяносто"
    };
    private static final String[] hundreds = {
            "", "сто", "двести", "триста", "четыреста", "пятьсот", "шестьсот",
            "семьсот", "восемьсот", "девятьсот"
    };
    private static final String[] thousand = {
            "", "одна тысяча", "две тысячи", "три тысячи", "четыре тысячи", "пять тысяч", "шесть тысяч",
            "семь тысяч", "восемь тысяч", "девять тысяч", "десять тысяч"
    };

    public static String convert(final int number) {
        if (number < 0) {
            return "минус " + convert(-number);
        }
        if (number < 10) {
            return units[number];
        }
        if (number < 20) {
            return teens[number - 10];
        }
        if (number < 100) {
            return tens[number / 10] + ((number % 10 != 0) ? " " : "") + units[number % 10];
        }
        if (number < 1000) {
            return hundreds[number / 100] + ((number % 100 != 0) ? " " : "") + convert(number % 100);
        }
        if (number < 11000) {
            return thousand[number / 1000] + ((number % 1000 != 0) ? " " : "") + convert(number % 1000);
        }
        return "число вне диапазона";
    }

    public static void main(String[] args) {
        // Проверяем на примере
        System.out.println(convert(9));    // девять
        System.out.println(convert(90));   // девяносто
        System.out.println(convert(120));  // сто двадцать
        System.out.println(convert(305));  // триста пять
        System.out.println(convert(3050)); // три тысячи пятьдесят
        System.out.println(convert(10150)); // десять тысяч сто пятьдесят
        System.out.println(convert(11150)); // число вне диапазона
    }
}
