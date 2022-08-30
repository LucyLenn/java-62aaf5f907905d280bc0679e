package ua.hillel.homeworks.homework8.phonebook;

public class ApplicationPhonebook {

    public static void main(String[] args) {
        Phonebook phonebook = new Phonebook();

        Record record1 = new Record("Bunny", "+551111111111");
        Record record2 = new Record("Honey", "+662222222222");
        Record record3 = new Record("Sunny", "+773333333333");
        Record record4 = new Record("Honey", "+884444444444");

        phonebook.add(record1);
        phonebook.add(record2);
        phonebook.add(record3);
        phonebook.add(record4);

        System.out.println(phonebook.find("Honey"));
        System.out.println(phonebook.find("Honey1"));
        System.out.println(phonebook.findAll("Honey"));
        System.out.println(phonebook.findAll("Honey1"));
    }
}
