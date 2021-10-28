public abstract class Animal {

    private int lengthOfWay;
    private String name;
    private static int count = 0;

    public Animal(String name) {
        this.name = name;
        count++;
    }


    public void run(int lengthOfWay) {
        System.out.println(name + " пробежал " + lengthOfWay + "м");
    }

    public void swim(int lengthOfWay) {
        System.out.println(name + " проплыл " + lengthOfWay + "м");
    }

    public int getLengthOfWay() {
        return lengthOfWay;
    }

    public void setLengthOfWay(int lengthOfWay) {
        this.lengthOfWay = lengthOfWay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static int getCount() {
        return count++;
    }

    public static void setCount(int count) {
        Animal.count = count;
    }


    public static void countInfo() {
        System.out.println("Общая сумма животных: " + getCount());
    }
}
