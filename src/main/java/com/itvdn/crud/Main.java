package com.itvdn.crud;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        AnimalHelper animalHelper = new AnimalHelper();

//        Animal lion = new Animal("Lion", 10, true);
//        Animal monkey = new Animal("Monkey", 7, false);
//        Animal snake = new Animal("Pyton", 5, false);
//        Animal wolf = new Animal("Wolf", 9, true);

//        animalHelper.add(lion);
//        animalHelper.add(monkey);
//        animalHelper.add(snake);
//        animalHelper.add(wolf);

        List<Animal> animalList = animalHelper.getAll();
        for (Animal animal : animalList) {
            System.out.println(animal);
        }

        Animal fox = animalHelper.getById(4);
        fox.setName("Fox");
        animalHelper.add(fox);

        System.out.println(animalHelper.getById(4));

        Animal snake = animalHelper.getById(3);
        animalHelper.remove(snake);
    }
}
