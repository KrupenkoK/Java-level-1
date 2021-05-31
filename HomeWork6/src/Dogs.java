public class Dogs extends Animal {

    public final int RUNNING_RESTRICTION = 500;
    public final int SWIMMING_RESTRICTION = 10;

    private static int countDogs = 0;

    public Dogs(String name) {
        super(name);
        countDogs++;
    }

    @Override
    public void run(int lengthOfWay){
        if (lengthOfWay > RUNNING_RESTRICTION) {
            System.out.println("Собаки не могу пробежать больше " + RUNNING_RESTRICTION + "м");
        } else {
            System.out.println(getName() + " пробежал " + lengthOfWay + "м");
        }
    }

    @Override
    public void swim(int lengthOfWay){
        if (lengthOfWay > SWIMMING_RESTRICTION) {
            System.out.println("Собаки не могу проплыть больше " + SWIMMING_RESTRICTION + "м");
        } else {
            System.out.println(getName() + " проплыл " + lengthOfWay + "м");
        }
    }

    public static int getCountDogs() {
        return countDogs;
    }

    public void setCountDogs(int countDogs) {
        this.countDogs = countDogs;
    }

    public static void countInfo() {
        System.out.println("Общая сумма собак: " + getCountDogs());
    }
}
