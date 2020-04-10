package com.xebia.jpaexcercises._08_many_to_one;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ManyToOneApp {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("jpa-examples-pu");
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();

          /*    Department department = new Department("IT");
            entityManager.persist(department);




          Employee employee = new Employee();
            employee.setName("Test Employee");
            employee.setSalary(1_00_000);
            employee.setDepartment(department);
            entityManager.persist(employee);
            entityManager.getTransaction().commit();

            Employee foundEmployee = entityManager.find(Employee.class, employee.getId());
            System.out.println(foundEmployee);*/

            Department department = new Department("IT");
            entityManager.persist(department);

            entityManager.getTransaction().commit();

            entityManager.close();

            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();

            Employee employee1 = new Employee();
            employee1.setName("John");
            employee1.setSalary(1_00_000);

            employee1.setDepartment(department);
            entityManager.persist(employee1);
            Employee employee2 = new Employee();
            employee2.setName("Tom");
            employee2.setSalary(50_000);
            employee2.setDepartment(department);
            entityManager.persist(employee2);

            entityManager.getTransaction().commit();

            Employee foundEmployee1 = entityManager.find(Employee.class, employee1.getId());
            Employee foundEmployee2 = entityManager.find(Employee.class, employee2.getId());
            System.out.println(foundEmployee1);
            System.out.println(foundEmployee2);

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);

        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }

    }
}
