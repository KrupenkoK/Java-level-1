import java.util.Random;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        /* Первое задание */
        randomNumber();

        /* Второе задание */
        guessWord(new String[] {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
                "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
                "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"});

        /* Третье задание */
        remakePhrase("Предложение      один    Теперь     предложение два         Предложение            три");

    }

    /* Первое задание */
    static void randomNumber() {
        Scanner sc = new Scanner(System.in);

        Random random = new Random();
        int mightNumb = random.nextInt(10);
        boolean flag = false;

        for (int i = 1; i <= 3; i++) {
            System.out.println("Укажите загаданное число  от 0 до 9:");
            int guessNumb = sc.nextInt();
            if(guessNumb == mightNumb) {
                System.out.println("Правильно! Вы угадали число " + guessNumb);
                flag = true;
            }else if (guessNumb > mightNumb) {
                System.out.println("Указанное вами число " + guessNumb + " больше чем загаданное");
            }else if (guessNumb < mightNumb) {
                System.out.println("Указанное вами число " + guessNumb + " меньше чем загаданное");
            }if (i == 3 || flag == true) {
                System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
                flag = false;
                mightNumb = random.nextInt(10);
                int repeat = sc.nextInt();
                if (repeat == 1) {
                    i = 0;
                }else if (repeat == 0) {
                    break;
                }
            }
        }
    }

    /* Второе задание */
    static void guessWord(String[] words) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int smashWords = random.nextInt(words.length);

        String randomWord = words[smashWords];
        System.out.println(randomWord);
        boolean youGuess = false;

        while (youGuess == false) {
            System.out.println("Напишите загаданое слово:");
            String enterWord = sc.nextLine();
            if (enterWord.equals(words[smashWords])) {
                System.out.println("Вы угадали слово " + enterWord);
                youGuess = true;
            }else {
                StringBuilder prompt = new StringBuilder("###############");
                String randomWordV2 = randomWord + prompt;
                String enterWordV2 = enterWord + prompt;

                for (int i = 0; i < 15; i++) {
                    if (randomWordV2.charAt(i) == enterWordV2.charAt(i)) {
                        prompt.deleteCharAt(i);
                        prompt.insert(i, randomWordV2.charAt(i));
                    }
                }
                System.out.println(prompt);
                System.out.println("Напишите задуманное слово еще раз");
            }
        }
    }

    /* Третье задание */
    static void remakePhrase(String phrase) {

        StringBuilder newString = new StringBuilder(phrase);
        boolean flag = true;
        System.out.println(newString);

        for (int i = 1; i < newString.length(); i++) {
            while (flag) {
                if (newString.charAt(i) == ' ' && newString.charAt(i + 1) == ' ') {
                    newString.deleteCharAt(i);
                } else {
                    break;
                }
            }

            if ((newString.charAt(i) == ' ' && (newString.charAt(i + 1) >= 'А' && newString.charAt(i + 1) <= 'Я')
                    && newString.charAt(i - 1) != '.')) {
                newString.replace(i, i + 1, ". ");
            }

        }

        newString.append('.');
        System.out.println(newString);

    }
}
