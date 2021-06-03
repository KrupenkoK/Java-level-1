import java.util.Random;

public class main {

    public static final Random rd = new Random();
    public static int way = 0 + rd.nextInt(1002 - 501) ;


    public static void main(String[] args) {

        Animal[] listAnimals = {new Cats("Барсик"), new Dogs("Шарик"), new Cats("Молли"),
                new Dogs ("Бобик"), new Dogs ("Салли")} ;


        for (int i = 0; i < listAnimals.length; i++) {
            listAnimals[i].run(way);
            listAnimals[i].swim(way);
            System.out.println();
    }

        Animal.countInfo();
        Cats.countInfo();
        Dogs.countInfo();

    }
}
