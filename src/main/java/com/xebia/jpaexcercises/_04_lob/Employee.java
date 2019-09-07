package com.xebia.jpaexcercises._04_lob;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    private Long id;

    @Column(name = "full_name")
    private String name;

    @Basic(fetch = FetchType.LAZY)
    @Column(name = "long_bio")
    private String bio;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", bio='" + bio + '\'' +
                ", picture=" + Arrays.toString(picture) +
                '}';
    }

    @Basic(fetch = FetchType.LAZY)
    @Lob
    @Column(name = "pic")
    private byte[] picture;

    public Long getId() {
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

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }
}
