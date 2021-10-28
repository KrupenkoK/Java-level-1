public class Employee {

    private String lastNameFirstNamePatronymic;
    private String position;
    private String email;
    private String phoneNumber;
    private int salary;
    private int age;

    public Employee(String lastNameFirstNamePatronymic, String position, String email, String phoneNumber, int salary, int age){
        this.lastNameFirstNamePatronymic = lastNameFirstNamePatronymic;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public String getLastNameFirstNamePatronymic() {
        return lastNameFirstNamePatronymic;
    }

    public void setLastNameFirstNamePatronymic(String lastNameFirstNamePatronymic) {
        this.lastNameFirstNamePatronymic = lastNameFirstNamePatronymic;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void info() {
        System.out.printf("ФИО сотрудника: %s, должность: %s, email: %s, телефон: %s, зарплата: %s, возраст: %s", lastNameFirstNamePatronymic,
                position, email, phoneNumber, salary, age);
    }
}


