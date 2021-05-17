public class Main {

    public static void main(String[] args) {

        /* Первое задание */
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
            } else {
                arr[i] = 0;
            }
            System.out.print(arr[i] + " ");
        }
        System.out.println();


        /* Второе задание */
        int[] mass = new int[8];

        for (int i = 0; i < mass.length; i++) {
            mass[i] = i * 3;
            System.out.print(mass[i] + " ");
        }
        System.out.println();


        /* Третье задание */
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i]*=6;
            }
            System.out.print(array[i] + " ");
        }
        System.out.println();


        /* Четвертое задание */
        int[][] twoDimeMass = new int[6][6];

        for (int i = 0; i < twoDimeMass.length; i++) {
            for (int j = 0; j < twoDimeMass.length; j++) {
                if (i == j || twoDimeMass.length - i == j + 1) {
                    twoDimeMass[i][j] = 1;
                } else {
                    twoDimeMass[i][j] = 0;
                }
                System.out.print(twoDimeMass[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();


        /* Пятое задание */
        int[] elements = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 0, 1};
        int min = elements[1];
        int max = elements[1];

        for (int i = 0; i < elements.length; i++) {
            if (max < elements[i]) {
                max = elements[i];
            } else if (min > elements[i]) {
                min = elements[i];
            }
        }
        System.out.println(max + " " + min);
        System.out.println();

        /* Шестое задание */
        countingHalves(new int[]{1, 1, 1, 2, 1});

    }

    /* Шестое задание */
    static void countingHalves(int[] arr) {
        int sum1 = 0;
        int sum2 = 0;

        for (int i = 0; i <= arr.length - 1; i++) {
            sum1 += arr[i];
            for (int j = arr.length - 1; j >= 0; j--) {
                sum2 += arr[j];
                if (sum1 == sum2) {
                    break;
                }
            }
            if (sum1 == sum2) {
                System.out.println("true");
                break;
            } else if (i == arr.length - 1) {
                System.out.println("false");
            }
        }
    }
}
