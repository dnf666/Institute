package com.im.project.model;

/**
 * Created by demo on 2017/5/7.
 */
public class ExtraMessage {
    private Integer personId;

    public Integer getPersonId() {
        return personId;
    }
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    private String email;
    private String phone;



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
