package com.xebia.jpaexcercises._14_map;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "phone_numbers_id")
public class PhoneNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @ElementCollection
    @CollectionTable(
            name = "phone_numbers_id_to_phone_numbers",
            joinColumns = @JoinColumn(name = "phone_numbers_id"))
    @Column(name = "phone_numbers")
    private List<String> phoneNumbers;

    @Override
    public String toString() {
        return "PhoneNumber{" +
             //   "id=" + id +
                ", phoneNumbers=" + phoneNumbers +
                '}';
    }

    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }
}
