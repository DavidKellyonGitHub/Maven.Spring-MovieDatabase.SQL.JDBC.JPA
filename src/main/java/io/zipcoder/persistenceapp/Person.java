package io.zipcoder.persistenceapp;

import javax.persistence.Entity;
import java.util.Date;


public class Person {
    private Long id;
    private String first_name;
    private String last_name;
    private String birthdate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String  birthdate) {
        this.birthdate = birthdate;
    }
}
