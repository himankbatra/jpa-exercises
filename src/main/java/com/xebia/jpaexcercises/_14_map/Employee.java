package com.xebia.jpaexcercises._14_map;

import javax.persistence.*;
import java.util.Map;

@Entity
@Table(name = "employees")
public class Employee {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;



    @ElementCollection
    @CollectionTable(
          // name = "phonetype_to_phone_number",
            name = "phone_numbers",
            joinColumns = @JoinColumn(name = "emp_id")
    )
    @MapKeyColumn(name = "phone_type")
    @Column(name = "phone_number")
    private Map<String, String> phoneNumbers;


    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumbers=" + phoneNumbers +
                '}';
    }

    Employee() {
    }

    public Employee(String name, Map<String, String> phoneNumbers) {
        this.name = name;
        this.phoneNumbers = phoneNumbers;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Map<String, String> getPhoneNumbers() {
        return phoneNumbers;
    }
}
