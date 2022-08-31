package ua.hillel.homeworks.homework8.phonebook;

import java.util.ArrayList;
import java.util.List;

public class Phonebook {
    private final List<Record> phonebook = new ArrayList<>();

    public void add(Record record) {
        phonebook.add(record);
    }

    public Record find(String name) {
        for (Record record : phonebook) {
            if (record.getName().equals(name)) {
                return record;
            }
        }
        return null;
    }

    public List<Record> findAll(String name) {
        List<Record> foundRecords = new ArrayList<>();

        for (Record record : phonebook) {
            if (record.getName().equals(name)) {
                foundRecords.add(record);
            }
        }
        return (foundRecords.isEmpty() ? null : foundRecords);
    }
}
