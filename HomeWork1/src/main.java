public class main {

    public static void main(String[] args) {

        /* Второе задание */
        byte by = 127;
        short sh = 32767;
        int in = 2147483647;
        long l = 9223372036854775807l;
        float fl = 12.5f;
        double dbl = 12.6;
        char ch = 'k';
        boolean bool = true;
        String str = "Hi!";

        /* Третье задание */
        int a = 10;
        int b = 2;
        int c = 30;
        int d = -40;

        System.out.println(calc1(a, b, c, d));

        /* Четвортое задание */
        System.out.println(calc2(a, b));

        /* Пятое задание */
        calc3(d);

        /* Шестое задание */
        System.out.println(falseValidator(d));

        /* Седьмое задание */
        String name = "Константин";
        greetings(name);

        /* Восьмое задание */
        int year = 2100;
        leapYear(year);

    }

    /* Третье задание */
    static int calc1(int a, int b, int c, int d){
        int res = a * (b + (c / d));
        return res;
    }

    /* Четвортое задание */
    static boolean calc2(int a, int b) {
        if ((a + b) >= 10 && (a + b) <= 20) {
            return true;
        } else {
            return false;
        }
    }

    /* Пятое задание */
    static void calc3(int a) {
        if (a >= 0) {
            System.out.println("Положительное число");
        } else {
            System.out.println("Отрицательное число");
        }
    }

    /* Шестое задание */
    static boolean falseValidator(int a) {
        if (a < 0) {
            return true;
        } else {
            return false;
        }
    }

    /* Седьмое задание */
    static void greetings(String name) {
        System.out.println("Привет, " + name + "!");
    }

    /* Восьмое задание */
    static void leapYear(int year) {
        if (year % 4 != 0) {
            System.out.println("Невысокосный год");
        } else if (year % 100 == 0) {
            if (year % 400 == 0) {
                System.out.println("Высокосный год");
            } else {
                System.out.println("Невысокосный год");
            }
        }
    }
}
