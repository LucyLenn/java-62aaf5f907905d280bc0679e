package ua.hillel.homeworks.homework21;

public record Order(int orderNumber, String name) {

    @Override
    public String toString() {
        return orderNumber + "\t\t|\t\t" + name;
    }
}
