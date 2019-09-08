package com.xebia.jpaexcercises._07_id_gen;


import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;
import static javax.persistence.GenerationType.TABLE;

@Entity
@Table(name = "employees")
public class Employee {

   // @SequenceGenerator(name="empGen", sequenceName="ID_GEN", allocationSize=1)

   @TableGenerator(
            name="empGen",
            table="ID_GEN",
            pkColumnName="GEN_KEY",
            valueColumnName="GEN_VALUE",
            pkColumnValue="EMP_ID",
            allocationSize=1)
    @Id
    @GeneratedValue(strategy=TABLE, generator="empGen")
   // @GeneratedValue(strategy = SEQUENCE, generator="empGen")
    private long id;






    @Column(name = "full_name")
    private String name;

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
