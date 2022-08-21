package ua.hillel.homeworks.homework6;

public class Application {
    public static void main(String[] args) {
        Dog evaDog = new Dog("Eva");
        evaDog.run(501);
        evaDog.swim(5);

        Dog nikaDog = new Dog("Nika");
        nikaDog.run(356);
        nikaDog.swim(40);

        Cat thomasCat = new Cat("Thomas");
        thomasCat.run(150);
        thomasCat.swim(10);

        Cat kiraCat = new Cat("Kira");
        kiraCat.run(222);
        kiraCat.swim(1);

        System.out.println("Total cats: " + Cat.getCountCat());
        System.out.println("Total dogs: " + Dog.getCountDog());
        System.out.println("Total animals: " + Animal.getCountAnimal());
    }
}
