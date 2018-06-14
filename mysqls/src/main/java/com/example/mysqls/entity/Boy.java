package com.example.mysqls.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Boy {

    @Id
    @GeneratedValue
    private Integer boyId;

    private String boyName;

    private Integer boyAge;

    public Integer getBoyId() {
        return boyId;
    }

    public void setBoyId(Integer boyId) {
        this.boyId = boyId;
    }

    public String getBoyName() {
        return boyName;
    }

    public void setBoyName(String boyName) {
        this.boyName = boyName;
    }

    public Integer getBoyAge() {
        return boyAge;
    }

    public void setBoyAge(Integer boyAge) {
        this.boyAge = boyAge;
    }
}
