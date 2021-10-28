public class Cats extends Animal{

    public final int RUNNING_RESTRICTION = 200;
    private static int countCats = 0;

    public Cats(String name) {
        super(name);
        countCats++;
    }

    @Override
    public void run(int lengthOfWay){
        if (lengthOfWay > RUNNING_RESTRICTION) {
            System.out.println("Коты не могу пробежать больше " + RUNNING_RESTRICTION + "м");
        } else {
            System.out.println(getName() + " пробежал " + lengthOfWay + "м");
        }
    }

    @Override
    public void swim(int lengthOfWay){
        System.out.println("Коты не умеют плавать");
    }

    public static int getCountCats() {
        return countCats;
    }

    public void setCountCats(int countCats) {
        this.countCats = countCats;
    }

    public static void countInfo() {
        System.out.println("Общая сумма котов: " + getCountCats());
    }

}
