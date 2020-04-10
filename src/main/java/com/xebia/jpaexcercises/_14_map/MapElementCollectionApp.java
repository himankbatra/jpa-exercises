package com.xebia.jpaexcercises._14_map;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapElementCollectionApp {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("jpa-examples-pu");
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();


            PhoneNumber homePhoneNumber=new PhoneNumber();
            List<String> homeNumbers=Arrays.asList("12345","678910");
            homePhoneNumber.setPhoneNumbers(homeNumbers);

            PhoneNumber officePhoneNumber=new PhoneNumber();
            List<String> officeNumbers=Arrays.asList("98987");
            officePhoneNumber.setPhoneNumbers(officeNumbers);

            entityManager.persist(homePhoneNumber);
            entityManager.persist(officePhoneNumber);

            entityManager.getTransaction().commit();
            entityManager.close();

            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();

            Map<String, PhoneNumber> phoneNumbers = new HashMap<>();

            phoneNumbers.put("home", homePhoneNumber);
            phoneNumbers.put("office", officePhoneNumber);

            Employee employee = new Employee("Test Employee", phoneNumbers);
            entityManager.persist(employee);
            entityManager.getTransaction().commit();
            entityManager.close();

            entityManager = entityManagerFactory.createEntityManager();
            Employee foundEmployee = entityManager.find(Employee.class, employee.getId());
            System.out.println(foundEmployee);


        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);

        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }

    }
}
