public class main {
    public static void main(String[] args) {

        Cats cat1 = new Cats("Барсик");
        Dogs dog1 = new Dogs("Шарик");

        Cats cat2 = new Cats("Молли");
        Dogs dog2 = new Dogs("Бобик");

        cat1.run(201);
        cat1.swim(30);

        System.out.println();

        dog1.run(50);
        dog1.swim(9);

        System.out.println();

        cat2.run(15);
        cat2.swim(10);

        System.out.println();

        dog2.run(500);
        dog2.swim(12);

        System.out.println();

        Animal.countInfo();
        Cats.countInfo();
        Dogs.countInfo();

    }
}
