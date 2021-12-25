package com.itvdn.crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class AnimalHelper {
    EntityManagerFactory managerFactory;
    EntityManager manager;

    public AnimalHelper() {
        managerFactory = Persistence.createEntityManagerFactory("abcd");
        manager = managerFactory.createEntityManager();
    }

    public Animal getById(int id) {
        manager.getTransaction().begin();
        Animal animal = manager.find(Animal.class, id);
        manager.getTransaction().commit();
        return animal;
    }

    public void add(Animal animal) {
        manager.getTransaction().begin();
        manager.merge(animal);
        manager.getTransaction().commit();
    }

    public void remove(Animal c) {
        manager.getTransaction().begin();
        manager.remove(c);
        manager.getTransaction().commit();
    }

    @SuppressWarnings("unchecked")
    public List<Animal> getAll() {
        manager.getTransaction().begin();
        Query query = manager.createQuery("SELECT animals FROM Animal animals");
        List<Animal> animals = query.getResultList();
        manager.getTransaction().commit();
        return animals;
    }
}
