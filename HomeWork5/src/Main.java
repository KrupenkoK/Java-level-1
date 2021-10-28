public class Main {

    public static void main(String[] args) {

        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Петренко Петр Пертрович", "бухгалтер", "petrenkoPetr@mailbox.com", "0630000001", 15000, 30);
        employees[1] = new Employee("Романенко Роман Романович", "охраник", "romanenkoRoman@mailbox.com", "0630000002", 6000, 50);
        employees[2] = new Employee("Иванов Иван Иванович", "директор", "ivanovIvan@mailbox.com", "0630000003", 30000, 40);
        employees[3] = new Employee("Семенов Семен семенович", "инженер", "semenovSemen@mailbox.com", "0630000004", 10000, 25);
        employees[4] = new Employee("Василенко Василий Васильевич", "оператор", "vasilenkoVasiliy@mailbox.com", "0630000005", 10000, 20);

        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getAge() >= 40) {
                employees[i].info();
                System.out.println();
            }
        }
    }



}
