package com.xebia.jpaexcercises._00_driver;

import com.xebia.jpaexcercises._01_access.EmployeeWithFieldAccess;
import com.xebia.jpaexcercises._01_access.EmployeeWithMixedAccess;
import com.xebia.jpaexcercises._01_access.EmployeeWithPropertyAccess;
import com.xebia.jpaexcercises._04_lob.Employee;

import javax.imageio.ImageIO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class DbApp {

    public static void main(String[] args) throws IOException {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa-examples-pu");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        EmployeeWithFieldAccess employee = new EmployeeWithFieldAccess();
        employee.setId(1L);
        employee.setName("Test Employee");
        employee.setEmail("test@test.com");
        entityManager.persist(employee);


        EmployeeWithFieldAccess foundEmployee = entityManager.find(EmployeeWithFieldAccess.class, 1L);

        System.out.println("1->" + foundEmployee);

        EmployeeWithPropertyAccess employeeWithPropertyAccess = new EmployeeWithPropertyAccess();
        employeeWithPropertyAccess.setId(2L);
        employeeWithPropertyAccess.setName("Test Employee 2");
        employeeWithPropertyAccess.setEmail("test2@test.com");
        entityManager.persist(employeeWithPropertyAccess);


        EmployeeWithPropertyAccess foundEmployeeProperty = entityManager.find(EmployeeWithPropertyAccess.class, 2L);
        System.out.println("2->" + foundEmployeeProperty);

        EmployeeWithMixedAccess employeeWithMixedAccess = new EmployeeWithMixedAccess();
        employeeWithMixedAccess.setId(3L);
        employeeWithMixedAccess.setUsername("Test Employee 3");
        employeeWithMixedAccess.setEmailAddress("test3@test.com");
        entityManager.persist(employeeWithMixedAccess);


        EmployeeWithMixedAccess foundEmployeeMixed = entityManager.find(EmployeeWithMixedAccess.class, 3L);

        System.out.println("3->" + foundEmployeeMixed);


   /*     Employee emp = new Employee();
        emp.setName("abc");
        emp.setId(1L);
        emp.setBio("test bio");
        entityManager.persist(emp);

        Employee foundEmp = entityManager.find(Employee.class, 1L);
        System.out.println("4->"+foundEmp.getBio());*/


        Employee employeeLob = new Employee();
        employeeLob.setId(1L);
        employeeLob.setName("Test Employee");
        employeeLob.setBio("Test Bio");

        File file = new File("D:\\docs\\profile_pic.jpg");
     /*   byte[] bFile =
                new byte[(int) file.length()];

        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            //convert file into array of bytes
            fileInputStream.read(bFile);
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }*/


        BufferedImage image = ImageIO.read(file);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image, "png", baos);
        byte[] res = baos.toByteArray();




   /*     // get DataBufferBytes from Raster
        WritableRaster raster = image .getRaster();
        DataBufferByte data   = (DataBufferByte) raster.getDataBuffer();
        byte[] res= data.getData();*/

        // employeeLob.setPicture(bFile);
        employeeLob.setPicture(res);

        entityManager.persist(employeeLob);


        entityManager.getTransaction().commit();

        entityManager.close();
        entityManager = entityManagerFactory.createEntityManager();
        Employee fEmployeeMixed = entityManager.find(Employee.class, 1L);
        System.out.println(fEmployeeMixed);
        entityManager.close();
        entityManagerFactory.close();

    }
}
