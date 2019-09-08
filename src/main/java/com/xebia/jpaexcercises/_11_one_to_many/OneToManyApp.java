package com.xebia.jpaexcercises._11_one_to_many;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class OneToManyApp {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("jpa-examples-pu");
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();

            Department department = new Department("IT");
            entityManager.persist(department);
            entityManager.getTransaction().commit();
            entityManager.close();

            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();

            Employee employee = new Employee();
            employee.setName("Test Employee");
            employee.setSalary(100_000);
            employee.setDepartment(department.addEmployee(employee));
            entityManager.persist(employee);
            entityManager.getTransaction().commit();

            entityManager.close();
            entityManager = entityManagerFactory.createEntityManager();
            System.out.println("Finding Employee");
            Employee foundEmployee = entityManager.find(Employee.class, employee.getId());
            System.out.println(foundEmployee);
            System.out.println("Found Employee");
            entityManager.close();
            entityManager = entityManagerFactory.createEntityManager();
            System.out.println("Finding Department");
            Department foundDepartment = entityManager.find(Department.class, department.getId());
            System.out.println(foundDepartment);
            System.out.println("Found Department");

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);

        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }

    }
}
