package com.example.mysqls.entity2;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Girl {
    @Id
    @GeneratedValue
    private Integer girlId;

    private String girlName;

    private Integer girlAge;

    public Integer getGirlId() {
        return girlId;
    }

    public void setGirlId(Integer girlId) {
        this.girlId = girlId;
    }

    public String getGirlName() {
        return girlName;
    }

    public void setGirlName(String girlName) {
        this.girlName = girlName;
    }

    public Integer getGirlAge() {
        return girlAge;
    }

    public void setGirlAge(Integer girlAge) {
        this.girlAge = girlAge;
    }
}
