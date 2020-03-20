package com.luis.test.domain;

import lombok.Data;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Account {

    @Id
    private Integer idNumber;
    private String name;
    private Integer value;

    public Account(Integer idNumber, String name, Integer value) {
        this.idNumber = idNumber;
        this.name = name;
        this.value = value;
    }
    public Account(){}

    public Integer getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(Integer idNumber) {
        this.idNumber = idNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
