package ua.hillel.homeworks.homework8.phonebook;

public class Record {
    private final String name;
    private final String phoneNumber;

    public Record(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", phone: " + phoneNumber;
    }
}
